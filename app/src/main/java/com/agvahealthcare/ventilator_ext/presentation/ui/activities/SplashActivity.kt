

//Updated Activity Switching code

package com.agvahealthcare.ventilator_ext.presentation.ui.activities

import android.annotation.SuppressLint
import android.content.*
import android.content.pm.PackageManager
import android.os.*
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.appcompat.app.AlertDialog

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.data.api.ServerLogger
import com.agvahealthcare.ventilator_ext.data.api.model.StatusRequestModel
import com.agvahealthcare.ventilator_ext.domain.support.AppLevelExceptionHandle
import com.agvahealthcare.ventilator_ext.presentation.utils.*
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ACK_CODE_5004
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.IS_STAND_BY
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.RUNNING_STATUS_INACTIVE
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_ACK
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_DATA
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_HANDSHAKE_CALIBRATION
import com.agvahealthcare.ventilator_ext.presentation.utils.FileLogger.Companion.dataNotFound

import kotlinx.coroutines.*
import java.lang.Thread.setDefaultUncaughtExceptionHandler
import java.util.concurrent.TimeUnit

const val apkUrl = "https://raw.githubusercontent.com/feicien/android-auto-update/develop/extras/android-auto-update-v1.3.apk"

class SplashActivity : AppCompatActivity() {

    companion object {
        const val PERMISSION_REQUEST_STORAGE = 0
    }

    private var appLevelExceptionHandler: AppLevelExceptionHandle? = null

    private val REQUEST_STORAGE_PERMISSION_CODE = 111
    private val REQUEST_FINE_PERMISSION_CODE = 112
    private val REQUEST_COURSE_PERMISSION_CODE = 113
    private val locationPermissionCode = 2
    private var isHandshakeAcknowledged = false
    private var communicationService: com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService? = null
    private var handshakingTask: com.agvahealthcare.ventilator_ext.domain.support.HandshakingTask? = null
    private var preferenceManager: PreferenceManager? = null
    //    private var dataStoreManager: DataStoreManager? = null
    private var progressThread: Thread? = null
    private var isSplashTimerRunning = false
    private var isHandshakingCompleted = false
    private var isServiceBound = false
    private var progressThreadState = true
    private var isReadingFromConnection = false
    private var startupCount: Int = 0
    private var hsCalibrationDialog: AlertDialog? = null
    private var hsFailureDialog: AlertDialog? = null
    private var commServiceIntent: Intent? = null
    private var threadTocheckActionDataAvailable: Thread? = null
    private var checkVentDataTimer: CountDownTimer? = null
    private var raspiParser: com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser? = com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser()
        .addExtension(com.agvahealthcare.ventilator_ext.connection.parser.SpO2ParserExtension::class.java)// SpO2 extension added
    var isActivitySwitching: Boolean = false
    var isTimerRunning: Boolean = true

    // Service connection for bound services
    private val mServiceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, ibinder: IBinder) {
            isServiceBound = true
            communicationService = (ibinder as com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService.LocalBinder).service
            Log.i("SERVICE_CHECK", "calling device connect from service")
            onDeviceConnect()
        }

        override fun onServiceDisconnected(name: ComponentName) {
            isReadingFromConnection = false
            isServiceBound = false
        }
    }

    /*
     * This provides intent filter for the Gatt Data Receiver
     */

    private fun getIntentFilter(): IntentFilter {
        val intentFilter = IntentFilter()
//        intentFilter.addAction(IntentFactory.ACTION_DATA_AVAILABLE)
        intentFilter.addAction(IntentFactory.ACTION_DEVICE_CONNECTED)
        intentFilter.addAction(IntentFactory.ACTION_DEVICE_DISCONNECTED)
        intentFilter.addAction(IntentFactory.ACTION_HANDSHAKE_COMPLETED)
        intentFilter.addAction(IntentFactory.ACTION_HANDSHAKE_TIMEOUT)
        intentFilter.addAction(IntentFactory.ACTION_ACK_AVAILABLE)
        intentFilter.addAction(IntentFactory.ACTION_HANDSHAKE_CALIBRATION_AVAILABLE)
        return intentFilter
    }

    private val connReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == null) return

            when (intent.action) {

                IntentFactory.ACTION_DATA_AVAILABLE -> {
                    val data = intent.getStringExtra(VENTILATOR_DATA)
                    var stringType: String? = null
                    try {
                        stringType = raspiParser!!.getDataType(data.toString())
                    } catch (e: Exception) {
                        stringType = null
                    }

                    threadTocheckActionDataAvailable = Thread {
                        runOnUiThread {
                            checkVentDataTimer = object : CountDownTimer(2000, 1000) {
                                override fun onTick(millisUntilFinished: Long) {
                                    Log.i("checkHandling","enter3")
                                    if (stringType != null) {
                                        if (stringType == "A" || stringType == "B") {
                                            isActivitySwitching = true
                                            checkVentDataTimer?.onFinish()
                                            if (preferenceManager?.getSedationMode() != -1) {
//                                                tvUpdateMsg.text =
//                                                    getString(R.string.hint_entering_ventilation)
                                                Intent(
                                                    this@SplashActivity,
                                                    MainActivity::class.java
                                                ).also {
                                                    it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                                                    startActivity(it)
                                                }
                                                finish()
                                            } else {
                                                isActivitySwitching = false
                                            }
                                        }
                                    }
                                }

                                override fun onFinish() {
                                    isTimerRunning = false
                                }
                            }.start()
                        }
                    }
                }

                IntentFactory.ACTION_DEVICE_CONNECTED -> {
                    Log.i("SPLASH_CHECK", "ventilator connected")

                    onDeviceConnect()
                }

                IntentFactory.ACTION_DEVICE_DISCONNECTED -> {
                    Log.i("SPLASH_CHECK", "ventilator disconnected")
                    onDeviceDisconnect()
                }

                IntentFactory.ACTION_ACK_AVAILABLE -> {
                    val ack = intent.getStringExtra(VENTILATOR_ACK)

                    if (ack != null && ack.isNotEmpty()) {
                        when (ack) {

                            ACK_CODE_5004 -> {

                                Log.i("checkHandling","enter1")

                                if (threadTocheckActionDataAvailable != null || threadTocheckActionDataAvailable?.isAlive == false) {
                                    threadTocheckActionDataAvailable?.start()
                                }

                                threadTocheckActionDataAvailable?.join()
                                stopHandshaking()
                                isHandshakingCompleted = true

                                CoroutineScope(Dispatchers.Main).launch {
                                    delay(250L)

                                        // Dismiss progress bar after 2 seconds
                                        if (!isActivitySwitching) {
                                            val intentData = Intent(
                                                this@SplashActivity,
                                                StandByActivity::class.java
                                            )
                                            intentData.putExtra(IS_STAND_BY, false)
                                            startActivity(intentData)
                                            finish()
                                        }
                                }

                            }
                        }
                    }
                }


                IntentFactory.ACTION_HANDSHAKE_COMPLETED -> {

                    Log.i("swdadwa13123","in handshake completed")
                    Log.i("checkHandling","enter2")
                    stopHandshaking()
                    isHandshakingCompleted = true

                    runOnUiThread {
//                        tvUpdateMsg.text = getString(R.string.hint_handshake_completed)
                    }

                    Thread {

                        runOnUiThread {
                            Handler(Looper.getMainLooper()).postDelayed({
                                Log.i("STANDBY", "Sandby is false");
                                // Dismiss progress bar after 2 seconds

                                val intentData = Intent(this@SplashActivity, StandByActivity::class.java)
                                intentData.putExtra(IS_STAND_BY, false)
                                startActivity(intentData)
                                finish()
                            }, 250)
                        }
                    }.start()
                }

                IntentFactory.ACTION_HANDSHAKE_TIMEOUT -> {
                    isHandshakeAcknowledged = false
                    showTimeoutState()
                    stopHandshaking()
                    isHandshakingCompleted = false

                    if (hsFailureDialog == null) {
                        hsFailureDialog = DialogBoxFactory.showDialog(
                            this@SplashActivity,
                            "CONNECTION FAILED",
                            "Unable to verify the connection with the sedation system",
                            "Try Again"
                        ) {
                            try {
                                validateConnectionState()
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }
                }

                IntentFactory.ACTION_HANDSHAKE_CALIBRATION_AVAILABLE -> {
                    val calibrationValue = intent.getStringExtra(VENTILATOR_HANDSHAKE_CALIBRATION)
                    var isPressureValid = false
                    var isFlowValid = false
                    if (calibrationValue != null) {
                        try {
                            val pressure = calibrationValue.substring(0, 2).toInt()
                            val flow = calibrationValue.substring(2, 5).toInt()
                            Log.i("HSCALIB", "FLOW=$flow, PRESSURE=$pressure")
                            isPressureValid = pressure < 5
                            isFlowValid = flow < 50
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    Log.i("HSCALIB",isHandshakeAcknowledged.toString())

                    if (isHandshakeAcknowledged) {

                        if (isPressureValid && isFlowValid) {

                            broadcastHandshakeCompleted()
                        } else {

                            var msg: String? = null
                            if (!isPressureValid) {
                                msg = "Error detected in pressure sensor calibration"
                            }
                            if (!isFlowValid) {
                                msg = "Error detected in flow sensor calibration"
                            }
                            msg += ". Please contact the manufacturer for support"
                            if (hsCalibrationDialog == null) hsCalibrationDialog =
                                DialogBoxFactory.showDialog(
                                    this@SplashActivity,
                                    getString(R.string.hint_calibration_error),
                                    msg
                                ) {
                                    Handler(Looper.getMainLooper()).postDelayed({
                                        communicationService?.takeIf { it.isPortsConnected }
                                            ?.apply {
                                                send("CE")
                                            }
                                    }, 1000)
                                    broadcastHandshakeCompleted()
                                }
                        }
                    }
                }

            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == SplashActivity.PERMISSION_REQUEST_STORAGE || requestCode == locationPermissionCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // start downloading
            } else {
                // Permission request was denied.
//                binding.mainLayout.showSnackbar(R.string.storage_permission_denied, Snackbar.LENGTH_SHORT)
            }
        }
    }

    private fun calculateTotalAndLastHours(
        millis: Long
    ): String {
        return String.format(
            "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
            TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
            TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1)
        )
    }
    @SuppressLint("HardwareIds")
    private fun callRunningStatusApi(status: String) {

        CoroutineScope(Dispatchers.IO).launch {
            val request = StatusRequestModel()
            request.apply {
                this.did = Settings.Secure.getString(
                    this@SplashActivity.contentResolver,
                    Settings.Secure.ANDROID_ID
                )
                this.message = status
                this.last_hours = ""
                this.total_hours = ""
                this.health = " Good"
                this.address = ""
                ServerLogger.sendStatusRequest(request)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        // restart app after crashing
        appLevelExceptionHandler = AppLevelExceptionHandle(this@SplashActivity)
        setDefaultUncaughtExceptionHandler(appLevelExceptionHandler)

        Log.i("CHECK_COUNTER", startupCount.toString())


        requestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.activity_splash)

        AppUtils.keepScreenAlive(this@SplashActivity, true)

        checkPermissions()
        preferenceManager = PreferenceManager(this)
        callRunningStatusApi(RUNNING_STATUS_INACTIVE)

        CoroutineScope(Dispatchers.IO).launch {

            FileLogger.readCrashFile().let {
                if (it != dataNotFound) {
                    ServerLogger.d(this@SplashActivity, it, "SedationSystem")
                }
            }
        }


        // setting app version
        registerReceiver(connReceiver, getIntentFilter())
        initServices()
        doBindService()
    }

    private fun checkPermissions(){
        if(checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            Log.i("APP_EXCEPTION_HANDLER", "Already has storage permissions")
        } else {
            ActivityCompat.requestPermissions(this, arrayOf<String>(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_STORAGE_PERMISSION_CODE)
        }
    }

    override fun onRestart() {
        super.onRestart()
        if (threadTocheckActionDataAvailable != null || threadTocheckActionDataAvailable?.isAlive == false) {
            threadTocheckActionDataAvailable?.start()
        }
    }

    private fun onDeviceConnect() {
        Log.i(
            "SERVICE_CHECK", "called device connect with com service " + communicationService
                    + " | ventCOnnected = " + communicationService?.isVentilatorConnected
                    + " | hidConnected = " + communicationService?.isHIDConnected
        )

        // FOR ALLOWING SCREEN AUTO LOCK
        AppUtils.keepScreenAlive(this@SplashActivity, true)
        communicationService?.takeIf { it.isPortsConnected }?.apply {
            //showConnectState()
            validateConnectionState()
            if (!isReadingFromConnection) {
                Log.i(
                    "SERVICE_CHECK",
                    "connection status = ${isPortsConnected} during DEVICE_CONNECTED check"
                )

                isReadingFromConnection = true
                startReading()
            }
        } ?: kotlin.run {
            ToastFactory.custom(
                this@SplashActivity,
                "Unable to start sedation system, please restart manually."
            )
        }
    }


    private fun onDeviceDisconnect() {

        // FOR ALLOWING SCREEN AUTO LOCK
        AppUtils.keepScreenAlive(this@SplashActivity, false)
        showDisconnectState()
        stopHandshaking()
        if (isReadingFromConnection) {
            communicationService?.apply {
                stopReading()
            }
            isReadingFromConnection = false
        }

        hsCalibrationDialog?.takeIf { it.isShowing }?.apply {
            cancel()
        }

        hsFailureDialog?.takeIf { it.isShowing }?.apply {
            cancel()
        }

    }

//    private fun startSplashTimerWithState() {
//        if (isDeepSleep()) {
//            Log.i("SLEEP_CHECK", "Ventilator was in deep sleep in last session")
//            showDeepSleepState()
//        } else {
//            Log.i("SLEEP_CHECK", "Ventilator was normally shut down")
//            startSplashTimer()
//        }
//
//    }

//    private fun startSplashTimer() {
//        // Timer is required for the permission to resolve before validating the screen
//        if(!isSplashTimerRunning) {
//            isSplashTimerRunning = true
//            Handler(Looper.getMainLooper()).postDelayed({
//                validateConnectionState()
//                isSplashTimerRunning = false
//            }, SPLASH_SCREEN_LIFE)
//        }
//
//    }

    private fun validateConnectionState() {
        communicationService?.takeIf { it.isPortsConnected }?.apply {
            showConnectState()
            startHandshakingWithThreadSafety()
        } ?: kotlin.run {
            Log.i("CONNECTION_STATE_CHECK", "Comm service is null")
            showDisconnectState()
            // FOR ALLOWING SCREEN AUTO LOCK
            AppUtils.keepScreenAlive(this@SplashActivity, false)
        }
    }

    private fun broadcastHandshakeCompleted() {
        Log.i("HSCALIB","in hadnasdn")
        communicationService?.takeIf { it.isPortsConnected }?.apply {
            sendBroadcastHandshakeCompleted()
        }
    }

    /*
  * This method will start handshaking countdown thread
  */
    private fun startHandshakingWithThreadSafety() {
        Handler(Looper.getMainLooper()).post {
            try {
                startHandshaking()
            } catch (e: Exception) {
                ToastFactory.custom(
                    this@SplashActivity,
                    getString(R.string.error_in_connection_restart_app)
                )
                e.printStackTrace()
            }
        }
    }

//    override fun onPause() {
//        super.onPause()
//        unregisterReceiver(connReceiver)
//        unbindService(mServiceConnection)
//    }

    override fun onDestroy() {

        unregisterReceiver(connReceiver)
        doUnbindService()
        super.onDestroy()

    }

    private fun startHandshaking() {
        communicationService?.takeIf { it.isPortsConnected }?.apply {
            Log.i("valuesadw","11")
            if (handshakingTask == null) handshakingTask =
                com.agvahealthcare.ventilator_ext.domain.support.HandshakingTask(this)


            if (handshakingTask?.isRunning == true) return

            // send WAKEUP for coming out of STANDBY incase ventilator is in STANDBY

            Handler(Looper.getMainLooper()).postDelayed({
            }, 1000)


            // starting handshaking
            Handler(Looper.getMainLooper()).postDelayed({
                handshakingTask?.apply {
                    Log.i("HS_CHECK", "HS started successfully inside 1000 ms looper")
                    start()
                }
            }, 100)

            // showing progress bar
            if (progressThread == null) {
                progressThread = Thread {
                    var i = 0
                    while (i < 70) {
                        if (progressThreadState) {
                            try {
                                Thread.sleep(30)
                            } catch (e: InterruptedException) {
                                e.printStackTrace()
                            }
                            val finalFixI = i
                        } else {
                            return@Thread
                        }
                        i += 1
                    }
                }
            }
            progressThreadState = true
            progressThread?.takeUnless { it.isAlive }?.start()
        }

    }

    /*
     * This method will stop handshaking thread
     */
    private fun stopHandshaking() {
        handshakingTask?.stop()
        progressThreadState = false
        progressThread = null
    }


    private fun showDisconnectState() {
//        layoutProgress.visibility = View.GONE
//        //  progressBar.progress = 0
//        tvSwitchOffMsg.text = getString(R.string.press_switch_onn_manually)
//        layoutVentiSwitchOff.visibility = View.VISIBLE

    }

    private fun showConnectState() {
//        layoutVentiSwitchOff.visibility = View.GONE
//        //   progressBar.progress = 0
//        layoutProgress.visibility = View.VISIBLE
    }

    private fun showTimeoutState() {
//        layoutVentiSwitchOff.visibility = View.GONE
//        layoutProgress.visibility = View.GONE
        //  progressBar.progress = 0
    }

    private fun initServices() {
        if (commServiceIntent == null) {
            Log.i("SERVICE_CHECK", "Service intent created from init")
            commServiceIntent = Intent(this@SplashActivity, com.agvahealthcare.ventilator_ext.domain.support.service.UsbService::class.java)
        }
    }


    private fun doBindService() {

        if (!isServiceBound && commServiceIntent != null) {
            bindService(commServiceIntent, mServiceConnection, BIND_AUTO_CREATE)
            Log.i("SERVICE_CHECK", "Service bound ")
            isServiceBound = true
        }

        startService(commServiceIntent)
    }


    private fun doUnbindService() {
        if (isServiceBound) {
            try {
                unbindService(mServiceConnection)
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
                //ServerLogger.e(this@SplashActivity, e)
            }
            stopService(commServiceIntent)
        }
    }

    fun hideSystemUI(view: View) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, view).let { controller ->
            controller.hide(WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.navigationBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

    }

    fun hideSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.let {
                it.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
        }
    }

    fun showSystemUI(view: View) {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(
            window,
            view
        ).show(WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.navigationBars())
    }
}


