package com.agvahealthcare.ventilator_ext.domain.support.service;



import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.DELIMITER_BATTERY;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.DELIMITER_THERAPY;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.KNOB_LENGTH;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.PREFIX_ACK;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.PREFIX_AND;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.PREFIX_BATTERY;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.PREFIX_HANDSHAKE_CALIBRATE;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.PREFIX_MINUS;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.PREFIX_PLUS;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.PREFIX_THERAPY;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.VENTILATOR_ACK;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.VENTILATOR_BATTERY_LEVEL;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.VENTILATOR_CONTROL_KNOB;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.VENTILATOR_DATA;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.VENTILATOR_HANDSHAKE_CALIBRATION;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.VENTILATOR_N2O_PRESSURE;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.VENTILATOR_O2_PRESSURE;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.VENTILATOR_O2_THERAPY;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.VENTILATOR_n2o_THERAPY;
import static com.agvahealthcare.ventilator_ext.presentation.utils.Constants.VENTILATOR_time_THERAPY;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.Handler;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.agvahealthcare.ventilator_ext.presentation.utils.Constants;
import com.agvahealthcare.ventilator_ext.presentation.utils.IntentFactory;
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager;
import com.hoho.android.usbserial.driver.FtdiSerialDriver;
import com.hoho.android.usbserial.driver.ProbeTable;
import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import com.hoho.android.usbserial.driver.UsbSerialProber;
import com.hoho.android.usbserial.util.SerialInputOutputManager;
import com.agvahealthcare.ventilator_ext.presentation.utils.SerialInputOutputHIDManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

//Serial Device class for the CDC Devices
class CustomProber {

    static UsbSerialProber getCustomProber() {
        ProbeTable customTable = new ProbeTable();
        customTable.addProduct(0x1234, 0xabcd, FtdiSerialDriver.class); // e.g. device with custom VID+PID
        return new UsbSerialProber(customTable);
    }
}

public class UsbService extends CommunicationService implements SerialInputOutputManager.Listener, SerialInputOutputHIDManager.Listener {

    private static final String CHANNEL_ID = "ventilatorApp";
    //For the Main PCB 9025 is the Vendor ID

    private static final int ARDUINO_VENDOR_ID_VENTILATOR = 9025;
    private static final int DEFAULT_BAUD_RATE_VENTILATOR = 9600;

    private static final int READ_DELAY = 11;

    //For the Knob 1003 is the Vendor ID
    private static final int ARDUINO_VENDOR_ID_HID = 1003;
    private static final int DEFAULT_BAUD_RATE_HID = 9600;

    private UsbManager usbManager;
    private UsbSerialPort usbVentilatorPort;
    private UsbSerialPort usbHIDPort;

    private final StringBuffer dataBufferVentilator = new StringBuffer();
    private final StringBuffer dataBufferHID = new StringBuffer();
    private Thread bufferReadingThreadVentilator;
    private Thread bufferReadingThreadVentilatorConnection;
    private Thread bufferReadingThreadHID;
    private Thread bufferReadingThreadHIDConnection;
    private PreferenceManager preferenceManager;


    private SerialInputOutputManager ioManager;
    private SerialInputOutputHIDManager ioManagerHID;

    /*
     * Reading thread : Constantly monitors the data buffer and reads the data frames
     * intercept the data into acknowledgements and vent data etc
     */
//Callback for the Ventilator to control the data for write and read operations

    @Override
    public void onNewData(byte[] data) {
//        Log.i("hfnc_crash","6");
        readBytesDataVentilator(new String(data));
    }

    //Callback for the HID to control the data for write and read operations
    @Override
    public void onNewHIDData(byte[] data) {
        readBytesDataHID(new String((data)));
    }

    @Override
    public void onRunError(Exception e) {
    }

    @Override
    public void onRunErrorHID(Exception e) {

    }

    //Runnable implementation for the continuous data flow
    private class ReadingRunnableVentilator implements Runnable {
        private volatile boolean isProcessingData = false;
        private long startTime = 0;

        @Override
        public void run() {
            // reading and interception of received ventilator data
            Log.i("USB_BUFFER", "Reading thread started");
            while (true) {
                if (!isProcessingData) {
                    startTime = System.currentTimeMillis();
                }
                if(dataBufferVentilator.length() > 120){
                    dataBufferVentilator.delete(0,dataBufferVentilator.length());
                }
                if (dataBufferVentilator.length() > 0) {
                    String buffData = dataBufferVentilator.toString();
                    Log.i("READ_CHECK", dataBufferVentilator.toString());
                    try {

                        // To separated the ACKNOWLEDGEMENTS
                        if (buffData.contains(PREFIX_ACK)) {
                            try {
                                int ackStartIndex = buffData.indexOf(Constants.PREFIX_ACK);
                                if (ackStartIndex != -1) {
                                    int ackTerminalIndex = buffData.indexOf(Constants.SUFFIX_ACK, ackStartIndex);
                                    if (ackTerminalIndex != -1) {
                                        String ack = buffData.substring(ackStartIndex, ackTerminalIndex);
                                        Log.i("MASOOMACK", String.valueOf(ack));
                                        Log.d("ACK_CHECK", ack);
                                        broadcastAcknowledgement(ack);
                                        dataBufferVentilator.delete(ackStartIndex, ackTerminalIndex + Constants.SUFFIX_ACK.length());
                                    }
                                }
                            }
                            catch (Exception e) {
                                Log.i("MASOOM", "BUFFER_HERE" + String.valueOf(buffData));
                            }
                        }

                        else if (buffData.contains(PREFIX_THERAPY)) {

                            int testrt = buffData.indexOf(PREFIX_THERAPY);
                            int teTerminalIndex = buffData.indexOf(DELIMITER_THERAPY);

                            String teCheckData = buffData.substring(testrt + 3, teTerminalIndex);
                            try {

                                String[] list = teCheckData.split(",");

                                broadcastTherapyEnd(list[0],list[1]);
                                Log.i("TE_STRING", teCheckData);
                                dataBufferVentilator.delete(testrt, teTerminalIndex + 1);
                            } catch (Exception e) {
                                dataBufferVentilator.delete(0, dataBufferVentilator.length());
                            }
                        }
                        else if (buffData.contains(PREFIX_BATTERY)) {

                            int btstrt = buffData.indexOf(PREFIX_BATTERY);
                            int btryTerminalIndex = buffData.indexOf(DELIMITER_BATTERY);

                            String btryCheckData = buffData.substring(btstrt + 5, btryTerminalIndex);
                            try {

                                String[] list = btryCheckData.split(",");

                                broadcastBatteryStatus(list[0],list[1],list[2]);
                                Log.i("BATTERY", btryCheckData);
                                dataBufferVentilator.delete(btstrt, btryTerminalIndex + 1);
                                Log.i("HEREDBV", dataBufferVentilator.toString());
                            } catch (Exception e) {
                                dataBufferVentilator.delete(0, dataBufferVentilator.length());
                            }
                            Log.i("BATTRERYSTARTINTT", buffData.toString());
                        }

                        else if (buffData.contains(PREFIX_HANDSHAKE_CALIBRATE)) {
                            try {
                            Log.i("RAWREAD", buffData.substring(buffData.indexOf(Constants.PREFIX_HANDSHAKE_CALIBRATE)));
                            // +1 for STANDBY STATUS code number (Don't remove -1 +1 this is for understanding)
                            int handshakeCalibrationStartIndex = buffData.indexOf(Constants.PREFIX_HANDSHAKE_CALIBRATE);
                            int handshakeCalibrationTerminalIndex = buffData.indexOf(Constants.PREFIX_HANDSHAKE_CALIBRATE) + Constants.PREFIX_HANDSHAKE_CALIBRATE.length() + Constants.HANDSHAKE_CALIBRATE_LENGTH - 1;
                            String handshakeCalibrationValue = buffData.substring(handshakeCalibrationStartIndex + Constants.PREFIX_HANDSHAKE_CALIBRATE.length(), handshakeCalibrationTerminalIndex + 1);
                            broadcastHandshakeCalibration(handshakeCalibrationValue);
                            dataBufferVentilator.delete(handshakeCalibrationStartIndex, handshakeCalibrationTerminalIndex + 1);
                            } catch (Exception e) {
                                dataBufferVentilator.delete(0, dataBufferVentilator.length());
                            }

                        }

                        else {
//                            // Ventilator data
                            if (buffData.contains("#")) {
                                Log.i("CHECK_DATA_INDEX",buffData.toString());
                                int dataTerminalIndex = buffData.indexOf("#");
                                String data = buffData.substring(0, dataTerminalIndex + 1);
                                broadcastData(data);
                                dataBufferVentilator.delete(0, dataTerminalIndex + 1);
                            }
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        dataBufferVentilator.delete(0,dataBufferVentilator.length());
                        Log.i("READ_THREAD_CHECK", "Index shortage");
                        e.printStackTrace();
//                        FileLogger.Companion.e(UsbService.this, e);
                    }
                    startTime = System.currentTimeMillis();
                    isProcessingData = false;
                } else {
                    // No data to process, check if the timer has exceeded 3 seconds
                    long currentTime = System.currentTimeMillis();
                    if (currentTime - startTime > 3000) {
                        // Code appears stuck, clear the buffer and restart reading
                        dataBufferVentilator.delete(0, dataBufferVentilator.length());
                        // log this event for debugging or reporting
                        Log.i("STUCK_IN_LOOP", "Buffer cleared due to timeout");
                    }
                }
                try {
                    Thread.sleep(READ_DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class ReadingRunnableHID implements Runnable {
        @Override
        public void run() {
            // reading and interception of received ventilator data
            // Log.i("USB_BUFFER2", "Reading thread started");
            while (true) {
                if (dataBufferHID.length() > 0) {

                    if (dataBufferHID.length() > 5) dataBufferHID.delete(0, dataBufferHID.length());

                    String buffData2 = dataBufferHID.toString();
                    Log.i("USB_BUFFER2", "Reading thread started  " + buffData2.contains(PREFIX_MINUS) + " " + buffData2);

                    try {

                        if (buffData2.contains("X")) {
                            int prefixPlusStartIndex = buffData2.indexOf("X");
                            int prefixPlusTerminalIndex = buffData2.indexOf("X") + KNOB_LENGTH;
                            String xValue = buffData2.substring(prefixPlusStartIndex, prefixPlusTerminalIndex);
                            broadcastKnobResponse(xValue);
                            dataBufferHID.delete(prefixPlusStartIndex, prefixPlusTerminalIndex + 1);
                        }

                        if (buffData2.contains(PREFIX_PLUS)) {
                            int prefixPlusStartIndex = buffData2.indexOf(PREFIX_PLUS);
                            int prefixPlusTerminalIndex = buffData2.indexOf(PREFIX_PLUS) + KNOB_LENGTH;
                            String plusValue = buffData2.substring(prefixPlusStartIndex, prefixPlusTerminalIndex);
                            broadcastKnobResponse(plusValue);
                            dataBufferHID.delete(prefixPlusStartIndex, prefixPlusTerminalIndex + 1);

                        } else if (buffData2.contains(PREFIX_MINUS)) {
                            int prefixMinusStartIndex = buffData2.indexOf(PREFIX_MINUS);
                            int prefixMinusTerminalIndex = buffData2.indexOf(PREFIX_MINUS) + KNOB_LENGTH;
                            String minusValue = buffData2.substring(prefixMinusStartIndex, prefixMinusTerminalIndex);
                            broadcastKnobResponse(minusValue);
                            dataBufferHID.delete(prefixMinusStartIndex, prefixMinusTerminalIndex + 1);

                        } else if (buffData2.contains(PREFIX_AND)) {
                            int prefixAndStartIndex = buffData2.indexOf(PREFIX_AND);
                            int prefixAndTerminalIndex = buffData2.indexOf(PREFIX_AND) + KNOB_LENGTH;
                            String andValue = buffData2.substring(prefixAndStartIndex, prefixAndTerminalIndex);


                            // Log.i("READ THREAD CHECK push", "Index shortage "+motorLifeLevel);
                            // buffData2="";
                            broadcastKnobResponse(andValue);
                            dataBufferHID.delete(prefixAndStartIndex, prefixAndTerminalIndex + 1);

                        }

                        // To separated the ACKNOWLEDGEMENTS
                    } catch (StringIndexOutOfBoundsException e) {
                        Log.i("READ THREAD CHECK", "Index shortage");
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    private final BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {


            if (intent == null || intent.getAction() == null) return;
            switch (intent.getAction()) {
                case IntentFactory.ACTION_USB_PERMISSION_VENTILATOR:
                    Log.i("USB_SERVICE_STATUS", "USB PERMISSION VENTILATOR onIntent");
                    if (intent.getExtras().getBoolean(UsbManager.EXTRA_PERMISSION_GRANTED)) {
                        Log.i("hfnc_crash", "4");
                        openConnectionToReadVentilator(true);
                    }
                    break;

                case IntentFactory.ACTION_USB_PERMISSION_HID:
                    Log.i("USB_SERVICE_STATUS_HID", "USB PERMISSION HID on Intent");
                    if (intent.getExtras().getBoolean(UsbManager.EXTRA_PERMISSION_GRANTED)) {
                        openConnectionToReadHID(true);
                    }
                    break;

                case UsbManager.ACTION_USB_DEVICE_ATTACHED:
                    Log.i("USB_SERVICE_STATUS", "USB STATE_CONNECTED");
                    sendBroadcast(new Intent(IntentFactory.ACTION_DEVICE_CONNECTED));
                    break;

                case UsbManager.ACTION_USB_DEVICE_DETACHED:
                    Log.e("USB_SERVICE_STATUS", "USB STATE_DISCONNECTED");
                    sendBroadcast(new Intent(IntentFactory.ACTION_DEVICE_DISCONNECTED));
                    usbVentilatorPort = null;
                    break;
            }
        }
    };

    private IntentFilter getIntentFilter() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(IntentFactory.ACTION_USB_PERMISSION_VENTILATOR);
        filter.addAction(IntentFactory.ACTION_USB_PERMISSION_HID);
        filter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED);
        filter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED);
        return filter;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("value_error", "12");
        preferenceManager = new PreferenceManager(this);
        usbManager = (UsbManager) getSystemService(USB_SERVICE);
        registerReceiver(receiver, getIntentFilter());

        Log.i("hfnc_crash", "1");

        Log.i("USB_SERVICE_STATUS", "Created Service onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i("hfnc_crash", "2");

        preferenceManager.setServiceStatus(true);


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Example Service")
                .setContentText("Services Started")
                .build();
        startForeground(1, notification);

        Log.i("USB_SERVICE_STATUS", "Started service onStartCommand");
        return START_STICKY;
    }


    @Override
    public void onDestroy() {

        Log.i("hfnc_crash", "3");
        Log.i("USB_SERVICE_STATUS", "Destroyed service onDestroy");
        unregisterReceiver(receiver);
        try {
            closeConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        dataBufferVentilator.delete(0, dataBufferVentilator.length());
        dataBufferHID.delete(0, dataBufferHID.length());
        preferenceManager.setServiceStatus(false);
//        usbVentilator = null;// NEW SHARED PREFERENCE STATUS
//        usbHID = null;
        super.onDestroy();

    }

    @Override
    public boolean isVentilatorConnected() {
        Log.i("CHECK_MANAGER", "3");

        for (Map.Entry<String, UsbDevice> entry : usbManager.getDeviceList().entrySet()) {
            if (entry.getValue().getVendorId() == ARDUINO_VENDOR_ID_VENTILATOR) return true;
        }
        return false;
    }

    @Override
    public boolean isHIDConnected() {
        for (Map.Entry<String, UsbDevice> entry : usbManager.getDeviceList().entrySet()) {
            if (entry.getValue().getVendorId() == ARDUINO_VENDOR_ID_HID) return true;
        }
        return false;
    }

    @Override
    public void sendBroadcastHandshakeCompleted() {
        Log.i("HSCALIB", "Double handshake completed");
        sendBroadcast(new Intent(IntentFactory.ACTION_HANDSHAKE_COMPLETED));
    }

    @Override
    protected void broadcastAcknowledgement(String ack) {
        Log.w("ACK CHECK", ack);
        Intent i = new Intent(IntentFactory.ACTION_ACK_AVAILABLE);
        i.putExtra(VENTILATOR_ACK, ack);
        sendBroadcast(i);
    }

    protected void broadcastBatteryStatus(String btryVolt, String O2Pressure, String N2OPressure) {
        Log.w("BATTERY CHECK", btryVolt);
        try {
            Intent i = new Intent(IntentFactory.ACTION_BATTERY_STATUS_AVAILABLE);
            i.putExtra(VENTILATOR_BATTERY_LEVEL, Float.valueOf(btryVolt));
            i.putExtra(VENTILATOR_O2_PRESSURE, Double.valueOf(O2Pressure));
            i.putExtra(VENTILATOR_N2O_PRESSURE, Double.valueOf(N2OPressure));
            sendBroadcast(i);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    protected void broadcastTherapyEnd(String n2o, String o2) {
        try {
            Intent i = new Intent(IntentFactory.ACTION_THERAPY_END_AVAILABLE);
            i.putExtra(VENTILATOR_n2o_THERAPY, Integer.valueOf(n2o));
            i.putExtra(VENTILATOR_O2_THERAPY, Integer.valueOf(o2));
            sendBroadcast(i);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void broadcastStandbyResponse(String standbyResponse) {
        Log.w("STANDBY_CHECK", standbyResponse);

    }




    @Override
    protected void broadcastData(String data) {
        Log.w("SMART DATA CHECK", data);
        Intent i = new Intent(IntentFactory.ACTION_DATA_AVAILABLE);
        i.putExtra(VENTILATOR_DATA, data);
        sendBroadcast(i);
    }


    @Override
    protected void broadcastRawData(String data) {
        Log.w("PLAIN DATA CHECK", data);
        Intent i = new Intent(IntentFactory.ACTION_RAW_DATA_AVAILABLE);
//        i.putExtra(VENTILATOR_RAW_DATA, data);
        sendBroadcast(i);
    }

    @Override
    public void startReading() {
        Log.i("value_error", "streading");
        if (usbManager != null) {
            Log.i("value_error", "4");

            openConnectionToReadVentilator(null);
            openConnectionToReadHID(null);
        }

        // starting watch dog surveillance
        new Handler().postDelayed(this::startWatchDog, 500);

        // start monitoring buffer and read data concurrently
        if (bufferReadingThreadVentilator == null)
            bufferReadingThreadVentilator = new Thread(new ReadingRunnableVentilator());
        if (!bufferReadingThreadVentilator.isAlive()) bufferReadingThreadVentilator.start();

        if (bufferReadingThreadHID == null)
            bufferReadingThreadHID = new Thread(new ReadingRunnableHID());
        if (!bufferReadingThreadHID.isAlive()) bufferReadingThreadHID.start();

        Log.i("THREAD_CHECK", "Ventilator Thread name = " + bufferReadingThreadVentilator.getName() + " | id = " + bufferReadingThreadVentilator.getId());
        Log.i("THREAD_CHECK", "HID Thread name = " + bufferReadingThreadHID.getName() + " | id = " + bufferReadingThreadHID.getId());

    }

    @Override
    public void stopReading() {
        stopWatchDog();

        if (bufferReadingThreadVentilator != null) {
            if (bufferReadingThreadVentilator.isAlive() && !bufferReadingThreadVentilator.isInterrupted()) {
                bufferReadingThreadVentilator.interrupt();
            }
        }

        if (bufferReadingThreadHID != null) {
            if (bufferReadingThreadHID.isAlive() && !bufferReadingThreadHID.isInterrupted()) {
                bufferReadingThreadHID.interrupt();
            }
        }

    }

    @Override
    public void sendDatatoKnob(String data) {
        if (usbHIDPort != null) {
            try {
                usbHIDPort.write(data.getBytes(), 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.i("WRITE_CHECK_KNOB", "DATA : " + data);
        } else {
            Log.i("USB_SERVICE_STOPPED", "USB SERVICE IS STOPPED");
        }
    }

    //to send data
    @Override
    public void send(String data) {
        Log.i("WRITE_CHECK", "PRE_DATA : " + data);

        if (usbVentilatorPort != null) {
            if (data.isEmpty()) return;
            Log.i("WRITE_CHECK", "NO_EMPTY_DATA : " + data);

                try {
                    usbVentilatorPort.write(data.getBytes(), 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }

//                Intent i = new Intent(IntentFactory.ACTION_DATA_SENT);
//                i.putExtra(VENTILATOR_DATA_SEND, data);
//                sendBroadcast(i);
            }
            Log.i("WRITE_CHECK", "DATA : " + data);
    }



    @Override
    protected void broadcastKnobResponse(String knobResponse) {
        if (knobResponse != null) {
            Log.i("KNOB_CHECK", "DATA : " + knobResponse);
            Intent i = new Intent(IntentFactory.ACTION_KNOB_CHANGE);
            i.putExtra(VENTILATOR_CONTROL_KNOB, knobResponse);
            sendBroadcast(i);
        }
    }







    public void closeConnection() throws IOException {
        if (usbVentilatorPort != null) {
            usbVentilatorPort.close();
            usbVentilatorPort = null;
        }
        if (usbHIDPort != null) {
            usbHIDPort.close();
            usbHIDPort = null;
        }
    }

    private void broadcastHandshakeCalibration(String calibrationValue) {
        Log.i("HS_CALIB_CHECK", calibrationValue);
        try {
            Intent i = new Intent(IntentFactory.ACTION_HANDSHAKE_CALIBRATION_AVAILABLE);
            i.putExtra(VENTILATOR_HANDSHAKE_CALIBRATION, calibrationValue);
            sendBroadcast(i);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            //   ServerLogger.Companion.e(UsbService.this, e);
        }
    }


    public void openConnectionToReadVentilator(Boolean permissionGranted) {
        Log.i("value_error", "swad");
        UsbDevice device = null;
        for (UsbDevice v : usbManager.getDeviceList().values())
            if (v.getVendorId() == ARDUINO_VENDOR_ID_VENTILATOR)
                device = v;
        if (device == null) {
            return;
        }
        Log.i("value_error", "swad1");
        UsbSerialDriver driver = UsbSerialProber.getDefaultProber().probeDevice(device);
        if (driver == null) {
            driver = CustomProber.getCustomProber().probeDevice(device);
        }
        if (driver == null) {
            return;
        }
        Log.i("value_error", "swad3");
        usbVentilatorPort = driver.getPorts().get(0);
        UsbDeviceConnection usbConnection = usbManager.openDevice(driver.getDevice());
        Log.i("value_error", String.valueOf(!usbManager.hasPermission(driver.getDevice())));
        if (usbConnection == null && permissionGranted == null && !usbManager.hasPermission(driver.getDevice())) {
            Intent intent = new Intent(IntentFactory.ACTION_USB_PERMISSION_VENTILATOR);
            PendingIntent usbPermissionIntent = PendingIntent.getBroadcast(UsbService.this, 0, intent, 0);
            usbManager.requestPermission(driver.getDevice(), usbPermissionIntent);
            return;

        }

        try {
            Log.i("hfnc_crash", "5");
            usbVentilatorPort.open(usbConnection);
            usbVentilatorPort.setParameters(DEFAULT_BAUD_RATE_VENTILATOR, usbVentilatorPort.DATABITS_8, usbVentilatorPort.STOPBITS_1, usbVentilatorPort.PARITY_NONE);
            ioManager = new SerialInputOutputManager(usbVentilatorPort, this);
            ioManager.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void openConnectionToReadHID(Boolean permissionGranted) {

        UsbDevice device = null;
        for (UsbDevice v : usbManager.getDeviceList().values())
            if (v.getVendorId() == ARDUINO_VENDOR_ID_HID)
                device = v;
        if (device == null) {
            return;
        }
        UsbSerialDriver driver = UsbSerialProber.getDefaultProber().probeDevice(device);
        if (driver == null) {
            driver = CustomProber.getCustomProber().probeDevice(device);
        }
        if (driver == null) {
            return;
        }
        usbHIDPort = driver.getPorts().get(0);
        UsbDeviceConnection usbConnection = usbManager.openDevice(driver.getDevice());
        if (usbConnection == null && permissionGranted && !usbManager.hasPermission(driver.getDevice())) {
            Intent intent = new Intent(IntentFactory.ACTION_USB_PERMISSION_HID);
            PendingIntent usbPermissionIntent = PendingIntent.getBroadcast(UsbService.this, 0, intent, 0);
            usbManager.requestPermission(driver.getDevice(), usbPermissionIntent);
            return;
        }

        try {
            usbHIDPort.open(usbConnection);
            usbHIDPort.setParameters(DEFAULT_BAUD_RATE_HID, usbHIDPort.DATABITS_8, usbHIDPort.STOPBITS_1, usbHIDPort.PARITY_NONE);
            ioManagerHID = new SerialInputOutputHIDManager(usbHIDPort, this);
            ioManagerHID.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void readBytesDataVentilator(String receivedData) {
        Log.i("USB_READ_RAW", "Data received from ventilator : " + receivedData);
//        Log.i("hfnc_crash","7");
        // appending to the data buffer
        if (receivedData.trim().length() > 0) {
            dataBufferVentilator.append(receivedData);
            informWatchDog();
        }
    }

    private void readBytesDataHID(String receivedData) {

        // appending to the data buffer
        if (receivedData.trim().length() > 0) {
            dataBufferHID.append(receivedData);
        }
    }

//    // created by masoom on 04 jan 2023
//    @Override
//    public void broadcastHFNCModeResponse(String[] value) {
//        if (value.length != 0) {
//            Intent i = new Intent(IntentFactory.ACTION_HFNC_RESPONSE);
//            i.putExtra(HFNC_MODE, value);
//            sendBroadcast(i);
//        }
//    }


    protected void finalize() {

    }
}

