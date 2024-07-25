package com.agvahealthcare.ventilator_ext.domain.support.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.agvahealthcare.ventilator_ext.domain.support.ConfigurationArrayList;
import com.agvahealthcare.ventilator_ext.domain.support.WatchDogTask;
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager;


public abstract class CommunicationService extends Service {

    private final IBinder mBinder = new LocalBinder();

    private final WatchDogTask watchDog;

    public CommunicationService() {
        watchDog = new WatchDogTask(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;

    }


    /*
     * Generates a log for the class with which service is bound
     */

    public void makeLog(String className) {
        Log.i(this.getClass().getSimpleName(), "bounded with " + className);
    }

    /*
     * Initiate Watch dog timer to keep a check of incoming data
     */

    public void startWatchDog() {
        if (watchDog != null) watchDog.startSurveillance();
    }

    /*
     * Halt the watching and kills the watch dog thread
     * After this invocation, data monitoring will no more work
     */
    public void stopWatchDog() {
        if (watchDog != null) watchDog.stop();
    }

    /*
     * Inform the watch dog thread regarding the incoming data
     * and updates the last updation count
     */

    public void informWatchDog() {
        if (watchDog != null) watchDog.inform();
    }

    /*
     * Verifies if the ventilator is connected to the device
     */

    abstract public boolean isVentilatorConnected();

    /*
     * Verifies if the encoder knob is connected to the device
     */
    abstract public boolean isHIDConnected();

    /*
     * Verifies if the encoder knob & ventilator both are connected to the device
     */

    public final boolean isPortsConnected() {
        return isVentilatorConnected() || isHIDConnected();
    }

    /*
     * Broadcast Ventilator raw data signal throughout app receivers
     */
    abstract protected void broadcastRawData(String data);

    /*
     * Broadcast Ventilator functional data signal throughout app receivers
     */
    abstract protected void broadcastData(String data);

    /*
     * Broadcast Ventilator acknowledgement throughout app receivers
     */
    abstract protected void broadcastAcknowledgement(String ack);

    /*
     * Broadcast Ventilator battery status throughout app receivers
     */
    abstract protected void broadcastBatteryStatus(String btryVolt, String O2Pressure, String N2OPressure);

    /*
     * Broadcast Standby response (in code 00/01) status throughout app receivers
     */

    abstract protected void broadcastStandbyResponse(String standbyResponse);

    //Broadcast for HFNC Response for FLOW , FiO2 in HFNC Mode.

//    abstract public void broadcastHFNCModeResponse(String[] value);

    /*
     * Broadcast Available ventilator software version throughout app receivers
     */

    abstract public void openConnectionToReadHID(Boolean permissionGranted);

    abstract public void openConnectionToReadVentilator(Boolean permissionGranted);

    abstract public void sendBroadcastHandshakeCompleted();

    /*
     * This enables the device to start listening from Ventilator.
     */

    abstract public void startReading();

    /*
     * This disable the device to stop listening from Ventilator.
     */

    abstract public void stopReading();

    /*
     * Send data to the KNOB
     */

    abstract public void sendDatatoKnob(String data);

    /*
     * Send data to the ventilator
     */
    abstract public void send(String data);

    // send tube compliance calibration

    /*
     *  send KNob response
     */

    abstract protected void broadcastKnobResponse(String knobResponse);



    String pPlatValue = "";
    String statusVGV = "";



    public void sendConfigurationToVentilator() {

        sendConfigurationToVentilator(null);
    }

    // send when alarm limits set
    public void sendAlarmLimitsToVentilator() {
        final ConfigurationArrayList settings = getAlarmSettingsList();
        String prefix = "L,";
        String data = prefix + settings + ",#";
        send(data);
        Log.i("ALARMSETTINGCHECK", "Sent -> " + data);
    }


    public void sendConfigurationToVentilator(ConfigurationMiddleware middleware) {
//        int moduleIndex = 1;

        final ConfigurationArrayList settings = (middleware != null) ? middleware.modify(
                getControlSettingsList()) : getControlSettingsList();


        String prefix = "S,";
        String data = prefix + settings.toString() + ",#";
        send(data);
        Log.i("CONFIGCHECK", "Sent -> " + data);

    }

    private ConfigurationArrayList getAlarmSettingsList() {
        final PreferenceManager prefManager = new PreferenceManager(getApplicationContext());

//        List<Float> pip = Arrays.asList(prefManager.readPipLimits());
//        List<Float> vte = Arrays.asList(prefManager.readVteLimits());
//        List<Float> peep = Arrays.asList(prefManager.readPeepLimits());
//        List<Float> rr = Arrays.asList(prefManager.readRRLimits());
//        List<Float> mve = Arrays.asList(prefManager.readMveLimits());
//        List<Float> fio2 = Arrays.asList(prefManager.readFiO2Limits());
//        List<Float> spo2 = Arrays.asList(prefManager.readSpO2Limits());

//        List<String> flattenList = Stream.of(
//                pip,
//                vte,
//                peep,
//                rr,
//                mve,
//                fio2,
//                spo2
//        ).flatMap(List::stream).map(e -> String.valueOf(e.intValue())).collect(Collectors.toList());
//        Log.i("ALARMSETTINGCHECK", "FLAT : " + flattenList);
//
        ConfigurationArrayList configs = new ConfigurationArrayList();
//        configs.addAll(flattenList);
//        Log.i("ALARMSETTINGCHECK", "CONFIG ARRAY : " + flattenList);

        return configs;
    }

    private ConfigurationArrayList getControlSettingsList() {

        final PreferenceManager prefManager = new PreferenceManager(getApplicationContext());
        String flow = String.valueOf(prefManager.getTotalFlow());
        String n2o = String.valueOf(prefManager.getN2O());
        String riseRate = String.valueOf(prefManager.getRiseRate());
        String targetPressure = String.valueOf(prefManager.getTargetPressure());
        String fallRate = String.valueOf(prefManager.getFallRate());
        String maxPR = String.valueOf(prefManager.getMaxPr());
        String deltaFio2 = String.valueOf(prefManager.getDeltaFio2());
        String targetSpo2 = String.valueOf(prefManager.getTargetSpo2());
        String plimit = String.valueOf(prefManager.getPlimit());
        String o2FlushStatus = prefManager.getO2FlushStatus() ? "1" : "0";
        String therapyEndStatus = prefManager.getTherapyEndStatus() ? "1" : "0";

        Log.i("value", String.valueOf(prefManager.getTherapyEndStatus()));

        ConfigurationArrayList configs = new ConfigurationArrayList();
        configs.add(flow);
        configs.add(n2o);
        configs.add(riseRate);
        configs.add(fallRate);
        configs.add(targetPressure);
        configs.add(maxPR);
        configs.add(deltaFio2);
        configs.add(targetSpo2);
        configs.add(o2FlushStatus);
        configs.add(therapyEndStatus);
        configs.add(plimit);

        return configs;
    }


    public class LocalBinder extends Binder {
        public CommunicationService getService() {
            return CommunicationService.this;
        }
    }

    public interface ConfigurationMiddleware {
        ConfigurationArrayList modify(ConfigurationArrayList list);
    }

}
