package com.agvahealthcare.ventilator_ext.presentation.ui.activities

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.ServiceConnection
import android.graphics.Color
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.*
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.scichart.extensions.builders.SciChartBuilder
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.Sedation_App
import com.agvahealthcare.ventilator_ext.Sedation_App.Companion.isFromStandBy
import com.agvahealthcare.ventilator_ext.Sedation_App.Companion.therapyEndStarted
import com.agvahealthcare.ventilator_ext.Sedation_App.Companion.tileClicked
import com.agvahealthcare.ventilator_ext.data.api.ServerLogger
import com.agvahealthcare.ventilator_ext.data.api.model.StatusRequestModel
import com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel
import com.agvahealthcare.ventilator_ext.databinding.ActivityMainBinding
import com.agvahealthcare.ventilator_ext.domain.support.PingingTask
import com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService
import com.agvahealthcare.ventilator_ext.presentation.adapters.InfoAdapter
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.CommonFragment
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.ControlFragment
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.MenuFragment
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.ModeFragment
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnStandbyCLickListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnStartSedationListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTherapyEndListener
import com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel
import com.agvahealthcare.ventilator_ext.presentation.utils.*
import com.agvahealthcare.ventilator_ext.presentation.utils.AppUtils.getCurrentDateTime
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ACK_CODE_5005
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ACK_CODE_5012
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ACK_CODE_5013
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ACK_CODE_5014
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ACK_CODE_5015
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ACK_CODE_5016
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ACK_CODE_5017
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ACK_CODE_5018
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ACK_CODE_746
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ALARM_Fio2
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ALARM_Flow
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ALARM_Paw
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ALERT_LABEL
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.ALERT_MSG
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.DELIMETER_ALARM_PRIORITY
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.FIRST_FILTER_NAME
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.LIMITTER_ALARM_PRIORITY
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.MUTE_UNMUTE_RESPONSE
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.RUNNING_STATUS_ACTIVE
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_ACK
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_BATTERY_LEVEL
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_CONTROL_KNOB
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_DATA
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_MODES
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_N2O_PRESSURE
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_O2_PRESSURE
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_O2_THERAPY
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_n2o_THERAPY
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_time_THERAPY
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VOLUME_MAX_VALUE
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.command_to_standby
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_fio2
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.AlarmViewModel
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.EventViewModel
import com.agvahealthcare.ventilator_ext.utility.utils.AlarmConfiguration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import java.time.LocalDate
import java.util.Formatter
import java.util.LinkedHashMap
import java.util.concurrent.TimeUnit


/**
 * Created by MASOOM ZAID on 20-04-2023.
 */


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener, OnStandbyCLickListener,
    OnTherapyEndListener,
    DialogCloseListener, OnStartSedationListener {
    lateinit var muteUnMuteTimer: CountDownTimer
    var isAlarmPlaying = false
    var alarmBarColor = ""
    var alarmTextColor = ""
    var alarmStringBuffer = ""
    var sizeOfLow = 0
    var sizeOfMedium = 0
    var sizeOfHigh = 0
    var sizeOfCritical = 0
    private var currentPriority = Constants.Companion.AlarmType.ALARM_CRITICAL_LEVEL
    private var therapyEndTime = 0L

    private var settingsCountDownTimer: SettingsCountDownTimer? = null
    private var lastUhidAlarms = ""
    private lateinit var binding: ActivityMainBinding
    private var commonFragment: CommonFragment? = null
    private var modeFragment: ModeFragment? = null
    private var menuFragment: MenuFragment? = null
    private var controlFragment: ControlFragment? = null
    internal var currentMode: Int = 0
    private var selectedMenuType: Constants.Companion.AllMenuType? = null
    private var selectedView: View? = null
    private var selectedTextView: TextView? = null
    private var countDownTimer: CountDownTimer? = null
    private var zeroN2o: Boolean = false
    private var therapyEndTimer: CountDownTimer? = null
    private var text: String? = ""
    private var infoList = ArrayList<String>()
    private var infoAdapter: InfoAdapter? = null
    private var preferenceManager: PreferenceManager? = null
    private var parseMap: Map<String, Map<String, String>>? = null
    private var alarmsMap: MutableMap<String, AlarmModel> = LinkedHashMap()
    private var ackVisibilities: BooleanArray = BooleanArray(6000)

    private var raspiParser: com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser? =
        com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser()
            .addExtension(com.agvahealthcare.ventilator_ext.connection.parser.SpO2ParserExtension::class.java)// SpO2 extension added

    private var testCount = 100
    private var pCount = 0
    private var fCount = 0
    private var mediaPlayer: MediaPlayer? = null

    private var isAlarmMuted: Boolean = false
    private var serviceIntent: Intent? = null

    private var communicationService: CommunicationService? =
        null
    private var pingingTask: PingingTask? = null

    private val commonViewModel: CommonViewModel by viewModels()
    private val alarmVIewModel: AlarmViewModel by viewModels()
    private val eventViewModel: EventViewModel by viewModels()

    var isServiceBound = false
    private var isReadingFromConnection = false

    private val mServiceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, ibinder: IBinder) {
            isServiceBound = true
            communicationService =
                (ibinder as com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService.LocalBinder).service
            onDeviceConnect()
        }

        override fun onServiceDisconnected(name: ComponentName) {
            isServiceBound = false
            isReadingFromConnection = false
            onDeviceDisconnect()
        }
    }

    private fun onDeviceConnect() {

        // FOR ALLOWING SCREEN AUTO LOCK
        AppUtils.keepScreenAlive(this, true)
        communicationService?.takeIf { it.isPortsConnected }?.apply {
            if (!isReadingFromConnection) {
                isReadingFromConnection = true
                Log.i("CONN_CHECK", "Pinging has started from MainActivity")
                startPinging()
                startReading()
            }
        }
    }

    // to bind service
    private fun doBindService() {
        if (!isServiceBound) {
            serviceIntent = Intent(
                this,
                com.agvahealthcare.ventilator_ext.domain.support.service.UsbService::class.java
            )
            bindService(serviceIntent, mServiceConnection, BIND_AUTO_CREATE)
        }
        startService(serviceIntent)
    }

    // to unbind service
    private fun doUnbindService() {
        if (isServiceBound) {
            try {
                unbindService(mServiceConnection)
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
            }
        }

        serviceIntent?.let {
            stopService(it)
        }
    }


    override fun onHandleDialogClose() {
        closeAllFragment()
        normaliseTile(selectedView, selectedTextView)
        commonViewModel.currentModeCode.postValue(currentMode)
        isFromStandBy = false
    }

    private fun showCommonFragment() {
        commonFragment?.let {
            commonViewModel.currentModeCode.postValue(currentMode)
        } ?: kotlin.run {
            commonFragment = CommonFragment(communicationService)
            commonFragment?.let {
                supportFragmentManager.beginTransaction().replace(R.id.GraphContainerView, it)
                    .commit()
            }
            commonViewModel.currentModeCode.postValue(currentMode)
        }
    }

    private fun showMenuFragment() {
        closeAllFragment()
        menuFragment = MenuFragment(this, false)
        menuFragment?.let {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, it)
                .commit()
        }
    }

    private fun showControlFragment(mode: Int) {
        closeAllFragment()

        controlFragment = ControlFragment(this, this)
        controlFragment?.let {
            val bundle = Bundle()
            bundle.putInt(VENTILATOR_MODES, mode)
            it.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, it)
                .commit()
        }

    }

    private fun sendControlModeToVentilator(mode: Int) {
        communicationService?.takeIf { it.isPortsConnected }?.apply {
            send(mode.toString())
            currentMode = mode
        }
    }

    override fun onStartSedation(mode: Int) {
        sendControlModeToVentilator(mode)
    }

    private fun showModeFragment() {
        closeAllFragment()
        modeFragment = ModeFragment(this)
        modeFragment?.let {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, it)
                .commit()
        }
    }

    override fun onPause() {
        unregisterReceiver(connReceiver)
        doUnbindService()
        therapyEndTimer?.cancel()
        therapyEndStarted = false
        mediaPlayer?.release()
        super.onPause()
    }

    @SuppressLint("HardwareIds")
    private fun callRunningStatusApi(status: String) {

        CoroutineScope(Dispatchers.IO).launch {
            val request = StatusRequestModel()
            request.apply {
                this.did = Settings.Secure.getString(
                    this@MainActivity.contentResolver,
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding.root)
        preferenceManager = PreferenceManager(this@MainActivity)

        SciChartBuilder.init(this@MainActivity)
        isFromStandBy = false

        // read uhid
        lastUhidAlarms = preferenceManager?.readUHID().toString()
        commonViewModel.isBatteryConnected.postValue(false)
        callRunningStatusApi(RUNNING_STATUS_ACTIVE)

        observeAlarmsAndEventData()
        commonViewModel.isBatteryConnected.distinctUntilChanged()
            .observe(this, Observer { it ->
                if (it == true) {
                    commonViewModel.ventBatteryLevel.value?.let {
                        updateBatteryImage(it)
                    }
                    binding.powerStatus.setImageDrawable(getDrawable(R.drawable.ic_plug_out))
                } else {
                    binding.powerStatus.setImageDrawable(getDrawable(R.drawable.ic_plug_in))
                    binding.imgBattery.setImageDrawable(getDrawable(R.drawable.ic_charging))
                }
            })

        commonViewModel.ventBatteryLevel.distinctUntilChanged()
            .observe(this, androidx.lifecycle.Observer {
                if (commonViewModel.isBatteryConnected.value == true) {
                    updateBatteryImage(it)
                }
            })

        commonViewModel.alarms.observe(this) { validateErrorBar() }


        commonViewModel.o2PressureValue.observe(this) { it1 ->
            it1?.let {
                binding.txtO2Progress.text = "$it%"
                binding.o2Progress.progress = it
            }
        }

        commonViewModel.n2oPressureValue.observe(this) { it1 ->
            it1?.let {
                binding.txtn2oProgress.text = "$it%"
                binding.n2oProgress.progress = it
            }
        }

        currentMode = preferenceManager?.getSedationMode()!!
        showCommonFragment()

        getModeName(preferenceManager?.getSedationMode())
        onPlayAlarm()
        setOnClickListeners()
        setupAlertDialogForOxygen(null)
        setupView()
    }

    private fun updateBatteryImage(batteryLevel: Int) {

        if (batteryLevel in 76..100) {
            Log.i("value_s123", "in 100")

            binding.imgBattery.setImageResource(R.drawable.ic_battery_full)
        } else if (batteryLevel in 51..75) {
            Log.i("value_s123", "in 75")
            binding.imgBattery.setImageResource(R.drawable.ic_threefourth)
        } else if (batteryLevel in 26..50) {
            Log.i("value_s123", "in 50")
            binding.imgBattery.setImageResource(R.drawable.ic_battery_half)
        } else if (batteryLevel in 0..25) {
            Log.i("value_s123", "in 25")
            binding.imgBattery.setImageResource(R.drawable.ic_battery_low)
            addEvents("Battery Critically Low", preferenceManager?.readUHID().toString())
            DialogBoxFactory.dismissDialogs()
//            DialogBoxFactory.showBatteryCriticallyLowStatusDialog(
//                "Ventilator will shutdown anytime,For patient's safety please connect the ventilator to AC source.",
//                ctx
//            )
        }
    }

    private fun validateErrorBar() {

        if (commonViewModel.alarms.value?.isEmpty() == true) {

            commonViewModel.alarms.value?.let {

                sizeOfLow = it.filter {
                    it.priority == Constants.Companion.AlarmType.ALARM_LOW_LEVEL
                }.size

                sizeOfMedium = it.filter {
                    it.priority == Constants.Companion.AlarmType.ALARM_MEDIUM_LEVEL
                }.size

                sizeOfHigh = it.filter {
                    it.priority == Constants.Companion.AlarmType.ALARM_HIGH_LEVEL
                }.size

                sizeOfCritical = it.filter {
                    it.priority == Constants.Companion.AlarmType.ALARM_CRITICAL_LEVEL
                }.size

                alarmStringBuffer =
                    "${LIMITTER_ALARM_PRIORITY}$sizeOfCritical,$sizeOfHigh,$sizeOfMedium,$sizeOfLow${DELIMETER_ALARM_PRIORITY}"
                Log.i("AlarmBuffer", alarmStringBuffer)
                CoroutineScope(Dispatchers.IO).launch {
                    delay(100L)
                    communicationService?.takeIf { it.isPortsConnected }?.apply {
                        send(alarmStringBuffer)
                    }
                }
            }
        }

        if (commonViewModel.alarms.value?.isNotEmpty() == true) {

            commonViewModel.alarms.value?.let {

                sizeOfLow = it.filter {
                    it.priority == Constants.Companion.AlarmType.ALARM_LOW_LEVEL
                }.size

                sizeOfMedium = it.filter {
                    it.priority == Constants.Companion.AlarmType.ALARM_MEDIUM_LEVEL
                }.size

                sizeOfHigh = it.filter {
                    it.priority == Constants.Companion.AlarmType.ALARM_HIGH_LEVEL
                }.size

                sizeOfCritical = it.filter {
                    it.priority == Constants.Companion.AlarmType.ALARM_CRITICAL_LEVEL
                }.size

                alarmStringBuffer =
                    "${LIMITTER_ALARM_PRIORITY}$sizeOfCritical,$sizeOfHigh,$sizeOfMedium,$sizeOfLow${DELIMETER_ALARM_PRIORITY}"
                Log.i("AlarmBuffer", alarmStringBuffer)
                CoroutineScope(Dispatchers.IO).launch {
                    delay(100L)
                    communicationService?.takeIf { it.isPortsConnected }?.apply {
                        send(alarmStringBuffer)
                    }
                }


            }
            // set color of error bar according to alarm level priority
            if (commonViewModel.alarms.value?.any { a ->
                    a.priority == Constants.Companion.AlarmType.ALARM_HIGH_LEVEL || a.priority == Constants.Companion.AlarmType.ALARM_CRITICAL_LEVEL
                } == true) {
                binding.alertTitle.text = "#AC0303"
                alarmTextColor = "#FFFFFF"
                binding.ccAlarmBarLayout.setBackgroundResource(R.drawable.red_box_drawables)
                binding.txtAlarm.setTextColor(Color.WHITE)
                commonViewModel.alarms.value?.first()?.let {
                    binding.txtAlarm.text = it.message
                }

            } else if (commonViewModel.alarms.value?.any { a ->
                    a.priority == Constants.Companion.AlarmType.ALARM_MEDIUM_LEVEL || a.priority == Constants.Companion.AlarmType.ALARM_LOW_LEVEL
                } == true) {

                binding.ccAlarmBarLayout.setBackgroundResource(R.drawable.amber_box_drawable)
                binding.txtAlarm.setTextColor(Color.BLACK)
                commonViewModel.alarms.value?.first()?.let {
                    binding.txtAlarm.text = it.message
                }

            } else {

                binding.ccAlarmBarLayout.setBackgroundResource(R.drawable.red_box_drawables)
                binding.txtAlarm.setTextColor(Color.WHITE)
                commonViewModel.alarms.value?.first()?.let {
                    binding.txtAlarm.text = it.message
                }
            }
// change here 19 sep
            if (commonViewModel.alarms.value?.any { a -> a.priority == Constants.Companion.AlarmType.ALARM_HIGH_LEVEL || a.priority == Constants.Companion.AlarmType.ALARM_MEDIUM_LEVEL || a.priority == Constants.Companion.AlarmType.ALARM_LOW_LEVEL } == true) {

                if (sizeOfHigh > 0) {
                    currentPriority = Constants.Companion.AlarmType.ALARM_HIGH_LEVEL
                    changeMediaInMediaPlayer()
                } else if (sizeOfMedium > 0) {
                    currentPriority = Constants.Companion.AlarmType.ALARM_MEDIUM_LEVEL
                    changeMediaInMediaPlayer()
                } else if (sizeOfLow > 0) {
                    isAlarmPlaying = false
                    currentSoundIndex = -1
                    try {
                        mediaPlayer?.setVolume(0.0f, 0.0f)
                    } catch (e: Exception) {
                        Log.i("CHECK_MEDIA", e.toString())
                    }
                }
            }
        } else {
            // change here 19 sep
            // NO ALARM SHOULD PLAY WHEN COUNT = 0
            binding.ccAlarmBarLayout.setBackgroundResource(R.drawable.black_box_drawable)
            binding.txtAlarm.text = ""
            isAlarmPlaying = false
            currentSoundIndex = -1
            try {
                mediaPlayer?.setVolume(0.0f, 0.0f)
            } catch (e: Exception) {
                Log.i("CHECK_MEDIA", e.toString())
            }
        }
    }

    private fun setupView() {
        binding.txtDate.text = LocalDate.now().toString()
    }

    // show o2 and n2o alerts
    private fun setupAlertDialogForOxygen(isO2Failure: Boolean?) {

        isO2Failure?.let {
            binding?.alertLayout?.visibility = View.VISIBLE
            if (it) {
                // o2 failure
                binding?.alertTitle?.setTextColor(resources.getColor(R.color.white))
                binding?.alertDesignLayout?.setBackgroundResource(R.drawable.red_box_drawables)
                binding?.alertTitle?.text = resources.getString(R.string.o2_alert)
                binding?.txtContinue?.text = resources.getString(R.string.btn_continue_o2)
                binding?.btnContinue?.setBackgroundResource(R.drawable.grey_box_drawable)
                binding?.btnHold?.visibility = View.GONE

            } else {
                // n2o failure
                binding?.alertTitle?.setTextColor(resources.getColor(R.color.black))
                binding?.alertDesignLayout?.setBackgroundResource(R.drawable.yellow_box_drawable)
                binding?.alertTitle?.text = resources.getString(R.string.n2o_alert)
                binding?.txtContinue?.text = resources.getString(R.string.btn_continue_n2o)
                binding?.txtHold?.text = resources.getString(R.string.btn_hold)
                binding?.btnContinue?.setBackgroundResource(R.drawable.grey_box_drawable)
                binding?.btnHold?.setBackgroundResource(R.drawable.grey_box_drawable)
                binding?.btnHold?.visibility = View.VISIBLE
            }

            setupInfoAdapter(it)
        }

    }

    private fun setupInfoAdapter(isO2Failure: Boolean) {

        infoList.clear()
        if (isO2Failure) {
            infoList.add(resources.getString(R.string.o2_info))
            infoList.add(resources.getString(R.string.o2_info1))
            infoList.add(resources.getString(R.string.o2_info2))
        } else {
            infoList.add(resources.getString(R.string.n2o_info))
        }

        infoAdapter = InfoAdapter(this@MainActivity, infoList, isO2Failure)
        binding?.InfoRecycler?.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity
            )
            this.adapter = infoAdapter
        }
    }


    private fun getIntentFilter(): IntentFilter {
        val intentFilter = IntentFilter()
        intentFilter.addAction(IntentFactory.ACTION_DEVICE_CONNECTED)
        intentFilter.addAction(IntentFactory.ACTION_THERAPY_END_AVAILABLE)
        intentFilter.addAction(IntentFactory.ACTION_TESTING)
        intentFilter.addAction(IntentFactory.ACTION_DATA_AVAILABLE)
        intentFilter.addAction(IntentFactory.ACTION_DEVICE_DISCONNECTED)
        intentFilter.addAction(IntentFactory.ACTION_BATTERY_STATUS_AVAILABLE)
        intentFilter.addAction(IntentFactory.ACTION_ACK_AVAILABLE)
        intentFilter.addAction(IntentFactory.ACTION_MODE_SET)
        intentFilter.addAction(IntentFactory.ACTION_BATTERY_CONNECTED)
        intentFilter.addAction(IntentFactory.ACTION_BATTERY_DISCONNECTED)
        intentFilter.addAction(IntentFactory.ACTION_KNOB_CHANGE)
        intentFilter.addAction(IntentFactory.ACTION_VENT_PARAM_LIMIT_OVERFLOW)
        intentFilter.addAction(IntentFactory.ACTION_VENT_PARAM_LIMIT_UNDERFLOW)
        return intentFilter
    }

    var count = 0
    private val connReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            intent.action?.apply {
                when (this) {

                    IntentFactory.ACTION_VENT_PARAM_LIMIT_OVERFLOW -> {

                        val lbl = intent.getStringExtra(ALERT_LABEL)
                        val message = intent.getStringExtra(ALERT_MSG)
                        lbl?.let {
                            if (alarmsMap.containsKey(it)) return
                            else {
                                Log.i("OVERFLOW", "Added $it -> $message")
                                message?.let { alarmMsg ->
                                    addAlarm(
                                        it,
                                        alarmMsg,
                                        (if (preferenceManager?.readUHID() == null) FIRST_FILTER_NAME else preferenceManager?.readUHID()).toString()
                                    )
                                }
                            }
                        }

                    }

                    IntentFactory.ACTION_VENT_PARAM_LIMIT_UNDERFLOW -> {
                        val lbl = intent.getStringExtra(ALERT_LABEL)
                        Log.i("UNDERFLOW", (alarmsMap.keys).toString())
                        lbl?.let {
                            if (alarmsMap.containsKey(it)) {
                                removeAlarm(it)
                            }
                        }
                    }

                    IntentFactory.ACTION_TESTING -> {
                        addAlarm(
                            "TESTING",
                            "testing ${count++}",
                            preferenceManager?.readUHID().toString()
                        )
                    }

                    IntentFactory.ACTION_THERAPY_END_AVAILABLE -> {

                        val o2_pressure = intent.getIntExtra(VENTILATOR_O2_THERAPY, 0)
                        val n2o_pressure = intent.getIntExtra(VENTILATOR_n2o_THERAPY, 0)

                        commonFragment?.updateObservedTherapyEnd(n2o_pressure, o2_pressure)
                    }

                    IntentFactory.ACTION_BATTERY_STATUS_AVAILABLE -> {

                        val btryVolt = intent.getFloatExtra(VENTILATOR_BATTERY_LEVEL, 0f)
                        val o2_pressure = intent.getIntExtra(VENTILATOR_O2_PRESSURE, 0)
                        val n2o_pressure = intent.getIntExtra(VENTILATOR_N2O_PRESSURE, 0)

                        var batteryLevel = 0

                        if (btryVolt > 2.84f) batteryLevel = 100
                        else if (btryVolt < 2.84f && btryVolt >= 2.68f) batteryLevel = 75
                        else if (btryVolt < 2.68f && btryVolt >= 2.56f) batteryLevel = 50
                        else if (btryVolt < 2.56f) batteryLevel = 25

                        commonViewModel.setVentBatteryLevel(batteryLevel)
                        commonViewModel.o2PressureValue.postValue(o2_pressure)
                        commonViewModel.n2oPressureValue.postValue(n2o_pressure)

                        Log.i("battery_value", btryVolt.toString())
                    }

                    IntentFactory.ACTION_BATTERY_CONNECTED -> {
                        commonViewModel.isBatteryConnected.postValue(true)
                    }

                    IntentFactory.ACTION_BATTERY_DISCONNECTED -> {
                        commonViewModel.isBatteryConnected.postValue(false)
                    }

                    IntentFactory.ACTION_DEVICE_CONNECTED -> {
                        onDeviceConnect()
                    }

                    IntentFactory.ACTION_DEVICE_DISCONNECTED -> {
                        onDeviceDisconnect()
                    }

                    IntentFactory.ACTION_DATA_AVAILABLE -> {

                        runOnUiThread {
                            val data = intent.getStringExtra(VENTILATOR_DATA)
                            data?.takeIf { it.isNotBlank() }?.apply {
                                Log.i("VENT DATA", this)
                                parseMap = raspiParser?.parser(data)
                                Log.i("VENT_DATA_PARSED", parseMap.toString())
                                parseMap?.apply {
                                    setDataOnScreen(this)
                                }
                            }
                        }
                    }

                    IntentFactory.ACTION_KNOB_CHANGE -> {
                        val data = intent.getStringExtra(VENTILATOR_CONTROL_KNOB)
                        data?.takeIf { it.isNotEmpty() }?.apply {

                            // NOTE : CHECK EVERY OTHER FRAGMENT VISIBILITY BEFORE COMMON FRAGMENT BECAUSE OF IT VISIBLE ALL THE TIME
                            Log.i("valuseawd", tileClicked.toString())
                            if (controlFragment?.isVisible == true && tileClicked == true) {
                                controlFragment?.updateKnobData(data)
                            } else if (menuFragment?.isVisible == true && tileClicked == true) {
                                menuFragment?.updateViaKnob(data)
                            } else if (commonFragment?.isVisible == true && tileClicked == true) {
                                commonFragment?.updateKnobData(data)
                            }
                        }
                    }

                    IntentFactory.ACTION_MUTE_UNMUTE -> {
                        val data = intent.getStringExtra(MUTE_UNMUTE_RESPONSE)
                        binding.imgAlarm.callOnClick()
                    }

                    IntentFactory.ACTION_MODE_SET -> {
                        currentMode = intent.getIntExtra(VENTILATOR_MODES, -1)
                        Sedation_App.isFromStandBy = true
                        selectedMenuType = Constants.Companion.AllMenuType.Controls
                        highLightTile(
                            binding.ccControlLayout,
                            binding.txtControl,
                            selectedMenuType
                        )
                        preferenceManager?.updateTempPreferecesViaPreferences()
                        showControlFragment(currentMode)
                    }

                    IntentFactory.ACTION_ACK_AVAILABLE -> {

                        val ackValue = intent.getStringExtra(VENTILATOR_ACK)

                        ackValue?.takeIf {
                            isNotEmpty()
                        }?.apply { handleAcknowledgements(this) }
                    }
                }
            }
        }
    }

    private fun addAlarm(alarmKey: String, alarmMsg: String, uhid: String) {

        AlarmModel(
            alarmMsg, alarmKey, getCurrentDateTime(), uhid
        ).let {
            alarmsMap[alarmKey] = it
            commonViewModel.addAlarm(it)
            alarmVIewModel.addAlarm(this@MainActivity, it.toDBModel())
        }
        lastUhidAlarms = uhid
    }

    private fun addEvents(eventMsg: String, uhid: String) {

        val eventDataModel = EventDataModel(
            eventMsg, uhid
        )

        eventViewModel.addEvent(this@MainActivity, eventDataModel)
    }

    private fun removeAlarm(ackValue: String) {
        alarmsMap.getOrDefault(ackValue, null)?.let {
            commonViewModel.removeAlarm(it)
            alarmsMap.remove(ackValue)
        }
    }

    private fun handleAcknowledgements(ackValue: String) {

        val isAckValid = ackValue.startsWith(Constants.PREFIX_ACK)
        if (!isAckValid) return

        if (alarmsMap.containsKey(ackValue)) {
            // IF ACK IS REPEATED, IGNORE MESSAGE
            Log.i("ACK_TAG", "IGNORING EXISTING ACK $ackValue")
            return
        } else {
            val ackMsg =
                Constants.getAckMessage(this, ackValue, preferenceManager?.getSedationMode()!!)

            when (AlarmConfiguration.getAckType(ackValue)) {
                Constants.Companion.AckType.ACK -> {
                    val ackCode = ackValue.replace("ACK", "").toIntOrNull()

                    addAlarm(
                        ackValue, ackMsg!!, preferenceManager?.readUHID().toString()
                    )
                    ackCode?.let { ackVisibilities[it] = true }
                }

                Constants.Companion.AckType.NACK -> {
                    val correspondingAckValue = AlarmConfiguration.getAckFor(ackValue)
                    correspondingAckValue?.let {
                        val nackCode = it.replace("ACK", "").toIntOrNull()
                        removeAlarm(it)
                        nackCode?.apply { ackVisibilities[this] = false }
                    }
                }

                Constants.Companion.AckType.INVALID_ACK -> {
                    Log.i("ACK_TAG", "Invalid (untracked) ack code found in handleAcknowledgement")
                    return
                }

                Constants.Companion.AckType.OP_ACK -> {

                }
            }
        }

        when (ackValue) {

            ACK_CODE_5014 -> {
                commonViewModel.isBatteryConnected.postValue(false)
            }
            ACK_CODE_5013 -> {
                commonViewModel.isBatteryConnected.postValue(true)
            }

            ACK_CODE_5005 -> {
                Log.i("cvasdaw","13")

                commonViewModel.currentModeCode.postValue(currentMode)
                getModeName(preferenceManager?.getSedationMode())
            }

            Constants.ACK_CODE_5006 -> {
                isFromStandBy = false
                normaliseTile(selectedView, selectedTextView)
                closeAllFragment()
                preferenceManager?.setSedationMode(currentMode)

                preferenceManager?.apply {
                    updatePreferecesViaTempPreferences()
                    removeAllTempPreferences()
                }
                sendConfigurationToVentilatorWithWatchDog()
            }

            ACK_CODE_746 -> {
                closeAllFragment()
                selectedMenuType = null
                addEvents("Standby process success", preferenceManager?.readUHID().toString())
                Intent(this@MainActivity, StandByActivity::class.java).also { startActivity(it) }
                finish()
            }

            ACK_CODE_5017 -> {
                // start therapy end timer
                therapyEndStarted = true
                Log.i("vkaueasd","111")
                preferenceManager?.apply {
                    therapyEndTimer((((100 / getRiseRate()) * 60) + 60) * 1000L)
                }
            }

            ACK_CODE_5018 -> {
                o2FlushTimer()
            }

        }
    }

    private fun observeAlarmsAndEventData() {

        //observe uhid list for alarm filter
        CoroutineScope(Dispatchers.Main).launch {
            val alarm = FileLogger.readAlarmUhidFile()
            val alarmData = alarm.split("|")
            Sedation_App.uhidDataListAlarm = alarmData

            val event = FileLogger.readEventUhidFile()
            val eventData = event.split("|")
            Sedation_App.uhidDataListEvent = eventData
        }
    }


    open inner class SettingsCountDownTimer(millisInFuture: Long, countDownInterval: Long) :
        CountDownTimer(millisInFuture, countDownInterval) {
        private var isSafeStop = false
        private var isRunning = false
        private var isFirstCallElapsed = false
        fun startRunning() {
            if (!isRunning) {
                isSafeStop = false
                isRunning = true
                Log.i("WATCHDOG_CHECK", "Starting watchdog")
                start()
            }
        }

        fun safeStop() {
            isSafeStop = true
            if (isRunning) {
                Log.i("WATCHDOG_CHECK", "Stoping watchdog")
                cancel()
            }
        }

        override fun onTick(millis: Long) {

            communicationService?.takeIf { it.isPortsConnected }?.apply {
                sendConfigurationToVentilator()
            }
        }

        override fun onFinish() {
            if (isFirstCallElapsed) {
                if (!isSafeStop) {
                }
            } else isFirstCallElapsed = true
            isRunning = false
        }
    }

    fun sendConfigurationToVentilatorWithWatchDog() {

        if (settingsCountDownTimer == null) {
            settingsCountDownTimer = SettingsCountDownTimer(2500, 700)
        }

        communicationService?.takeIf { it.isPortsConnected }?.apply {
            settingsCountDownTimer?.startRunning()
        }
    }

    private fun onDeviceDisconnect() {
        // FOR ALLOWING SCREEN AUTO LOCK
        AppUtils.keepScreenAlive(this@MainActivity, false)

        if (isReadingFromConnection) {
            communicationService?.takeIf { it.isPortsConnected() }?.apply {
                stopPinging()
                stopReading()
            }
            isReadingFromConnection = false
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(connReceiver, getIntentFilter())
        doBindService()
    }

    /*
* This methods start pinging to sedation
*/
    private fun startPinging() {
        communicationService?.apply {
            if (pingingTask == null) pingingTask = PingingTask(this)
            if (pingingTask?.isRunning == false) pingingTask?.start()
        }
    }

    /*
* This methods stop pinging to sedation
*/
    private fun stopPinging() {
        pingingTask?.apply {
            if (isRunning) stop()
        }
    }

    private fun setDataOnScreen(dataMap: Map<String, Map<String, String>>?) {

        dataMap?.takeIf { it.isNotEmpty() }?.apply {
            val lbl = this.keys.iterator().next()
            this[lbl]?.apply {
                updateData(lbl, this)
            }
        }
    }

    private fun validateRangeLimits(key: String, value: Int) {

        var currentLable: String? = null
        var i: Intent? = null
        preferenceManager?.apply {
            currentLable = key
            when (key) {

                ALARM_Fio2 -> {
                    if (value < getPrefFio2LowerLimits()!!.toInt()) {
                        i = Intent(IntentFactory.ACTION_VENT_PARAM_LIMIT_OVERFLOW).apply {
                            putExtra(ALERT_LABEL, currentLable)
                            putExtra(
                                ALERT_MSG,
                                key + " " + getString(R.string.low_value_msg_suffix)
                            )
                        }
                    } else if (value > getPrefFio2UpperLimits()!!.toInt()) {
                        i = Intent(IntentFactory.ACTION_VENT_PARAM_LIMIT_OVERFLOW).apply {
                            putExtra(ALERT_LABEL, currentLable)
                            putExtra(
                                ALERT_MSG,
                                key + " " + getString(R.string.high_value_msg_suffix)
                            )
                        }
                    } else {
                        i = Intent(IntentFactory.ACTION_VENT_PARAM_LIMIT_UNDERFLOW).apply {
                            putExtra(ALERT_LABEL, currentLable)
                            putExtra(
                                ALERT_MSG,
                                key + " " + getString(R.string.normal_value_msg_suffix)
                            )
                        }
                    }
                }

                ALARM_Flow -> {
                    if (value < 0) {
                        i = Intent(IntentFactory.ACTION_VENT_PARAM_LIMIT_OVERFLOW).apply {
                            putExtra(ALERT_LABEL, currentLable)
                            putExtra(
                                ALERT_MSG,
                                key + " " + getString(R.string.low_value_msg_suffix)
                            )
                        }
                    } else {
                        i = Intent(IntentFactory.ACTION_VENT_PARAM_LIMIT_UNDERFLOW).apply {
                            putExtra(ALERT_LABEL, currentLable)
                            putExtra(
                                ALERT_MSG,
                                key + " " + getString(R.string.normal_value_msg_suffix)
                            )
                        }
                    }
                }

            }

            i?.run { sendBroadcast(this) }
        }
    }

    private fun getMapValueFromLabelIntoFloat(map: Map<String, String>, lbl: String): Float? {
        try {
            if (map.containsKey(lbl)) return (map[lbl]?.toFloatOrNull())
        } catch (exception: NumberFormatException) {
            exception.printStackTrace()
            return null
        }
        return null
    }

    private fun getMapValueFromLabelIntoInteger(map: Map<String, String>, lbl: String): Int? {
        try {
            if (map.containsKey(lbl)) return (map[lbl]?.toIntOrNull())
        } catch (exception: NumberFormatException) {
            exception.printStackTrace()
            return null
        }
        return null
    }


    private fun updateData(label: String, map: Map<String, String>) {

        // wave
        var pressure: Float? = getMapValueFromLabelIntoFloat(
            map,
            com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser.DATA_PRESSURE
        )
        val flow: Float? = getMapValueFromLabelIntoFloat(
            map,
            com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser.DATA_FLOW
        )

        // celenders
        val n2o: Float? = getMapValueFromLabelIntoFloat(
            map,
            com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser.DATA_N2O
        )
        val o2: Float? = getMapValueFromLabelIntoFloat(
            map,
            com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser.DATA_O2
        )

        //params
        val flow_value: Int? = getMapValueFromLabelIntoInteger(
            map,
            com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser.DATA_FLOW_VALUE
        )
        val paw_value: Float? = getMapValueFromLabelIntoFloat(
            map,
            com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser.DATA_PAW
        )
        val fio2_value: Int? = getMapValueFromLabelIntoInteger(
            map,
            com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser.DATA_FIO2
        )
        val o2_value: Int? = getMapValueFromLabelIntoInteger(
            map,
            com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser.DATA_O2
        )

        Log.i("LABEL_CHECK", "Entry mode is $fio2_value,$paw_value,$flow_value")
        when (label) {

            // Prefix : A@
            com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser.TYPE_INHALATION -> {
                commonViewModel.graphPeekValue.postValue("A")
                // updating graphs
                pressure?.apply {
                    Log.i("DIVIDE_PRESSURE", pressure.toString())
                    pressure = if (this < 0) 0f else this
                    commonFragment?.updatePressureGraph(pCount++, pressure!!)
                }

                flow?.apply {
                    commonFragment?.updateFlowGraph(fCount++, this)
                }
            }

            // Prefix : B@
            com.agvahealthcare.ventilator_ext.connection.parser.RaspiParser.TYPE_END_OF_INHALATION -> {
                commonViewModel.graphPeekValue.postValue("B")
                commonFragment?.updateObservedTiles(flow_value, paw_value, fio2_value, o2_value)

                validateRangeLimits(ALARM_Fio2, fio2_value!!)
                validateRangeLimits(ALARM_Flow, flow_value!!)

                // validate pressure
                preferenceManager?.apply {
                    paw_value?.let {
                        if (it.toInt() < getPrefPAWLowerLimits()!!.toInt()) {
                            var i = Intent(IntentFactory.ACTION_VENT_PARAM_LIMIT_OVERFLOW).apply {
                                putExtra(ALERT_LABEL, ALARM_Paw)
                                putExtra(
                                    ALERT_MSG,
                                    ALARM_Paw + " " + getString(R.string.low_value_msg_suffix)
                                )
                            }
                        } else if (it.toInt() > getPrefPAWUpperLimits()!!.toInt()) {
                            var i = Intent(IntentFactory.ACTION_VENT_PARAM_LIMIT_OVERFLOW).apply {
                                putExtra(ALERT_LABEL, ALARM_Paw)
                                putExtra(
                                    ALERT_MSG,
                                    ALARM_Paw + " " + getString(R.string.high_value_msg_suffix)
                                )
                            }
                        } else {
                            var i = Intent(IntentFactory.ACTION_VENT_PARAM_LIMIT_UNDERFLOW).apply {
                                putExtra(ALERT_LABEL, ALARM_Paw)
                                putExtra(
                                    ALERT_MSG,
                                    ALARM_Paw + " " + getString(R.string.normal_value_msg_suffix)
                                )
                            }
                        }
                    }
                }
//                binding?.txtn2oProgress?.text = "$n2o%"
//                binding?.n2oProgress?.progress = n2o?.toInt() ?: kotlin.run { 0 }
//                binding?.txtO2Progress?.text = "$o2%"
//                binding?.o2Progress?.progress = o2?.toInt() ?: kotlin.run { 0 }
            }
        }
    }

    private fun setOnClickListeners() {
        binding.ccMenuLayout.setOnClickListener(this)
        binding.ccModeLayout.setOnClickListener(this)
        binding.ccO2FlushLayout.setOnClickListener(this)
        binding.ccTherapyEndLayout.setOnClickListener(this)
        binding.ccControlLayout.setOnClickListener(this)
        binding.ccLockLayout.setOnClickListener(this)
        binding.imgPower.setOnClickListener(this)

        binding.imgBattery.setOnClickListener {
            showMenuFragment()
        }

        binding.powerStatus.setOnClickListener {
            showMenuFragment()
        }

        binding.btnContinue.setOnClickListener {
            binding.alertLayout.visibility = View.GONE
        }

        binding.btnHold.setOnClickListener {
            binding.alertLayout.visibility = View.GONE
        }

        binding.ccModeLayout.setOnClickListener {
            showModeFragment()
        }

        binding.imgAlarm.setOnClickListener {
            alarmMuteUnMuteVisibility()
        }

    }

    private fun normaliseTile(view: View?, textView: TextView?) {
        view?.setBackgroundResource(R.drawable.black_box_drawable)
        textView?.setTextColor(ContextCompat.getColor(this, R.color.grey_label))
        Log.i("cvasdaw","12")
    }

    private fun highLightTile(
        view: ConstraintLayout?,
        textView: TextView?,
        selectedMenuType: Constants.Companion.AllMenuType?
    ) {

        normaliseTile(selectedView, selectedTextView)
        selectedView = view
        selectedTextView = textView

        when (selectedMenuType) {

            Constants.Companion.AllMenuType.o2_flush -> {
                view?.setBackgroundResource(R.drawable.black_box_drawable)
                textView?.let {
                    it.setTextColor(ContextCompat.getColor(this, R.color.grey_label))
                    it.text = resources.getString(R.string.o2_flush)
                }
            }

            Constants.Companion.AllMenuType.thearpy_end -> {
                view?.setBackgroundResource(R.drawable.black_box_drawable)
                textView?.let {
                    it.setTextColor(ContextCompat.getColor(this, R.color.grey_label))
                    it.text = resources.getString(R.string.therapy_end)
                }
            }

            Constants.Companion.AllMenuType.stop_o2_flush -> {
                view?.setBackgroundResource(R.drawable.red_box_drawables)
                textView?.let {
                    it.setTextColor(ContextCompat.getColor(this, R.color.white))
                    it.text = resources.getString(R.string.stop_o2_flush)
                }
            }

            Constants.Companion.AllMenuType.stop_thearpy_end -> {
                view?.setBackgroundResource(R.drawable.red_box_drawables)
                textView?.let {
                    it.setTextColor(ContextCompat.getColor(this, R.color.white))
                    it.text = resources.getString(R.string.stop_therapy_end)
                }
            }

            Constants.Companion.AllMenuType.Unlock -> {
                view?.setBackgroundResource(R.drawable.black_box_drawable)
            }

            Constants.Companion.AllMenuType.Lock -> {
                view?.setBackgroundResource(R.drawable.red_box_drawables)
            }

            else -> {
                view?.let {
                    it.setBackgroundResource(R.drawable.white_box_drawables)
                    textView?.setTextColor(ContextCompat.getColor(this, R.color.black))
                }
            }
        }

    }

    override fun onStandby() {
        sendStandbyCommandToVentilator()
    }

    private fun sendStandbyCommandToVentilator() {
        communicationService?.takeIf { it.isPortsConnected }?.apply {
            sendConfigurationToVentilator()

            CoroutineScope(Dispatchers.IO).launch {
                delay(1000L)
                send(Constants.command_to_standby)
            }
        }
    }


    override fun onClick(view: View?) {

        when (view?.id) {

            R.id.lockWholeLayout -> {
                ToastFactory.custom(this@MainActivity, "Screen Locked!")
            }

            R.id.ccLockLayout -> {

//                if (selectedMenuType == Constants.Companion.AllMenuType.Lock) {
//                    selectedMenuType = Constants.Companion.AllMenuType.Unlock
//                    highLightTile(
//                        binding?.ccLockLayout,
//                        null,
//                        selectedMenuType
//                    )
//                    binding?.lockWholeLayout?.visibility = View.GONE
//                    binding?.lockWholeLayout?.isClickable = false
//                }
//                else {
//                    selectedMenuType = Constants.Companion.AllMenuType.Lock
//                    highLightTile(
//                        binding?.ccLockLayout,
//                        null,
//                        selectedMenuType
//                    )
//                    binding?.lockWholeLayout?.visibility = View.VISIBLE
//                    binding?.lockWholeLayout?.isClickable = false
//                }
            }

            R.id.imgPower -> {
                DialogBoxFactory.dismissDialogs()
                DialogBoxFactory.showStandbyDialog("Do you want to switch to standby ?", this, this)
            }

            R.id.ccControlLayout -> {
                isFromStandBy = false
                selectedMenuType = Constants.Companion.AllMenuType.Controls
                highLightTile(binding.ccControlLayout, binding.txtControl, selectedMenuType)
                preferenceManager?.getSedationMode()?.let { showControlFragment(it) }
            }

            R.id.ccMenuLayout -> {
                selectedMenuType = Constants.Companion.AllMenuType.Menu
                highLightTile(binding.ccMenuLayout, binding.txtMenu, selectedMenuType)
                showMenuFragment()
            }

            R.id.ccModeLayout -> {

                selectedMenuType = Constants.Companion.AllMenuType.Mode

                highLightTile(
                    binding.ccModeLayout,
                    binding.txtMode,
                    selectedMenuType
                )
                showModeFragment()
            }


            R.id.ccTherapyEndLayout -> {

                if (selectedMenuType == Constants.Companion.AllMenuType.stop_thearpy_end) {

                    DialogBoxFactory.showtherapyEndDialog(
                        "Do you want to end therapy ?",
                        this,
                        this
                    )

                } else {


                    preferenceManager?.setTherapyEndStatus(true)
                    sendConfigurationToVentilatorWithWatchDog()
                }

            }

            R.id.ccO2FlushLayout -> {

                // other time
                if (selectedMenuType == Constants.Companion.AllMenuType.stop_o2_flush) {
                    stopO2Flush()

                } else {
                    preferenceManager?.setO2FlushStatus(true)
                    sendConfigurationToVentilatorWithWatchDog()
                }
            }
        }
    }

    private fun getModeName(mode: Int?) {
        when (mode) {
            Constants.Mode_ContinuousSedation -> {
                binding.txtMode.text = "Continuous"
            }

            Constants.Mode_OnDemand -> {
                binding.txtMode.text = "On Demand"
            }

            Constants.Mode_IntelliAuto -> {
                binding.txtMode.text = "Intelli Auto"
            }
        }
    }

    private fun closeAllFragment() {

        binding.fragmentContainerView.removeAllViews()

        modeFragment = null
        menuFragment = null
        controlFragment = null
    }

    fun stopO2Flush() {
        countDownTimer?.cancel()
        binding.ccAlarmBarLayout.setBackgroundResource(R.color.black)
        binding.txtAlarm.setTextColor(getColor(R.color.black))
        selectedMenuType = Constants.Companion.AllMenuType.o2_flush
        highLightTile(binding.ccO2FlushLayout, binding.txtO2Flush, selectedMenuType)
        disableAllMenuButtons(true, false)


        preferenceManager?.setO2FlushStatus(false)
        sendConfigurationToVentilatorWithWatchDog()
    }

    private fun stopTherapyEnd() {
        therapyEndTimer?.cancel()
        Sedation_App.therapyEndStarted = false
        binding.ccAlarmBarLayout.setBackgroundResource(R.color.black)
        binding.txtAlarm.setTextColor(getColor(R.color.black))
        selectedMenuType = Constants.Companion.AllMenuType.thearpy_end
        highLightTile(binding.ccTherapyEndLayout, binding.txtThrapyEnd, selectedMenuType)
        disableAllMenuButtons(false, false)

        preferenceManager?.setTherapyEndStatus(false)
        sendConfigurationToVentilatorWithWatchDog()
    }

    private fun o2FlushTimer() {

        disableAllMenuButtons(true, true)
        selectedMenuType = Constants.Companion.AllMenuType.stop_o2_flush
        highLightTile(
            binding.ccO2FlushLayout,
            binding.txtO2Flush,
            selectedMenuType
        )

        countDownTimer = object : CountDownTimer(120000, 1000) {
            override fun onTick(p0: Long) {

                text = "O₂ FLUSH   ${
                    String.format(
                        "%02d min : %02d sec",
                        TimeUnit.MILLISECONDS.toMinutes(p0),
                        TimeUnit.MILLISECONDS.toSeconds(p0) - TimeUnit.MINUTES.toSeconds(
                            TimeUnit.MILLISECONDS.toMinutes(
                                p0
                            )
                        )
                    )
                } "
                binding.txtAlarm.text = text
                binding.ccAlarmBarLayout.setBackgroundResource(R.drawable.red_box_drawables)
                binding.txtAlarm.setTextColor(getColor(R.color.black))
            }

            override fun onFinish() {
                stopO2Flush()
            }
        }.start()
    }

    private fun therapyEndTimer(time: Long) {

        disableAllMenuButtons(false, true)
        selectedMenuType = Constants.Companion.AllMenuType.stop_thearpy_end
        highLightTile(
            binding.ccTherapyEndLayout,
            binding.txtThrapyEnd,
            selectedMenuType
        )

        therapyEndTimer = object : CountDownTimer(time, 1000) {
            override fun onTick(p0: Long) {

                text = "THERAPY ENDING IN   ${
                    String.format(
                        "%02d min : %02d sec",
                        TimeUnit.MILLISECONDS.toMinutes(p0),
                        TimeUnit.MILLISECONDS.toSeconds(p0) - TimeUnit.MINUTES.toSeconds(
                            TimeUnit.MILLISECONDS.toMinutes(
                                p0
                            )
                        )
                    )
                } "
                binding.txtAlarm.text = text
                binding.ccAlarmBarLayout.setBackgroundResource(R.drawable.amber_box_drawable)
                binding.txtAlarm.setTextColor(getColor(R.color.black))
                commonViewModel.currentModeCode.postValue(currentMode)
            }

            override fun onFinish() {
                communicationService?.send(command_to_standby)
            }
        }.start()
    }

    private fun disableAllMenuButtons(isO2Flush: Boolean, isDisable: Boolean) {
        if (isDisable) {
            binding.ccMenuLayout.isClickable = false
            binding.ccControlLayout.isClickable = false
            binding.ccModeLayout.isClickable = false

            if (isO2Flush) {
                // o2 flush
                binding.ccO2FlushLayout.isClickable = true
                binding.ccTherapyEndLayout.isClickable = false
            } else {
                // therapy end
                binding.ccO2FlushLayout.isClickable = false
                binding.ccTherapyEndLayout.isClickable = true
            }
        } else {
            binding.ccMenuLayout.isClickable = true
            binding.ccControlLayout.isClickable = true
            binding.ccModeLayout.isClickable = true
            binding.ccO2FlushLayout.isClickable = true
            binding.ccTherapyEndLayout.isClickable = true
        }
    }

    private fun openAlertDialog() {
        val dialog = Dialog(this@MainActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setContentView(R.layout.custom_alert)
        dialog.show()
    }

    override fun onTherapyEnd() {
        stopTherapyEnd()
    }

    private fun changeMediaInMediaPlayer() {
        isAlarmPlaying = true
        AlarmConfiguration.getAlarmUri(currentPriority)?.let {
            if (currentSoundIndex != it) {
                currentSoundIndex = it
                mediaPlayer?.stop()
                mediaPlayer?.reset()
                mediaPlayer?.setDataSource(resources.openRawResourceFd(soundResources[currentSoundIndex]))
                mediaPlayer?.prepare()
                mediaPlayer?.isLooping = true
                mediaPlayer?.start()
                // if mute then not start alarm
                if (!isAlarmMuted) {
                    mediaPlayer?.setVolume(
                        preferenceManager?.readVolume()!! / VOLUME_MAX_VALUE,
                        preferenceManager?.readVolume()!! / VOLUME_MAX_VALUE
                    )
                }
            }
        }
    }

    private fun alarmMuteUnMuteVisibility() {
        if (isAlarmMuted) {
            alarmUnMute()
            isAlarmMuted = false
        } else {
            alarmMute()
            isAlarmMuted = true
        }
    }

    private fun alarmMute() {

        communicationService?.takeIf { it.isPortsConnected }?.apply {
            send(getString(R.string.cmd_vent_mute_alarm_permanent))
        }

        mediaPlayer?.setVolume(0.0f, 0.0f)

        binding.alarmcount.visibility = View.VISIBLE

        binding.alarmPanel.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow_dark))
        binding.imgAlarm.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, // Context
                R.drawable.ic_mute_alarm // Drawable
            )
        )
        muteUnMuteTimer = object : CountDownTimer(120000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(milliSec: Long) {
                binding.alarmcount.text = "${(milliSec / 1000)} s"
            }

            override fun onFinish() {
                binding.alarmcount.visibility = View.GONE
                binding.alarmPanel.setBackgroundColor(
                    ContextCompat.getColor(
                        this@MainActivity, R.color.black
                    )
                )
                // change here 19 sep
                isAlarmMuted = false
                try {
                    if (isAlarmPlaying) {
                        preferenceManager?.apply {
                            mediaPlayer?.setVolume(
                                readVolume() / VOLUME_MAX_VALUE, readVolume() / VOLUME_MAX_VALUE
                            )
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                binding.alarmcount.visibility = View.GONE

                binding.imgAlarm.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext, // Context
                        R.drawable.ic_unmute_alarm // Drawable
                    )
                )
                muteUnMuteTimer.cancel()
            }

        }.start()

        addEvents("Alarm are muted", preferenceManager?.readUHID().toString())
    }

    private fun alarmUnMute() {
        communicationService?.takeIf { it.isPortsConnected }?.apply {
            send(getString(R.string.cmd_vent_unmute_alarm))
        }

        addEvents("Alarm are unmuted", preferenceManager?.readUHID().toString())
        muteUnMuteTimer.cancel()

        binding.alarmPanel.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        binding.alarmcount.visibility = View.GONE

        binding.imgAlarm.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, // Context
                R.drawable.ic_unmute_alarm // Drawable
            )
        )
        // change here 19 sep
        try {
            if (isAlarmPlaying) {
                preferenceManager?.apply {
                    mediaPlayer?.setVolume(
                        readVolume() / VOLUME_MAX_VALUE, readVolume() / VOLUME_MAX_VALUE
                    )
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private var currentSoundIndex = 0
    private val soundResources = arrayOf(
        R.raw.warning_low_level,
        R.raw.warning_high_level
    )

    private fun onPlayAlarm() {
        mediaPlayer = MediaPlayer.create(this, soundResources[currentSoundIndex])
        val attrib: AudioAttributes =
            AudioAttributes.Builder().setLegacyStreamType(AudioManager.STREAM_ALARM).build()

        mediaPlayer?.setAudioAttributes(attrib)
        mediaPlayer?.isLooping = true
    }
}
