package com.agvahealthcare.ventilator_ext.presentation.ui.activities

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.ServiceConnection
import android.os.*
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.distinctUntilChanged
import com.scichart.extensions.builders.SciChartBuilder
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.Sedation_App
import com.agvahealthcare.ventilator_ext.Sedation_App.Companion.tileClicked
import com.agvahealthcare.ventilator_ext.data.api.ServerLogger
import com.agvahealthcare.ventilator_ext.data.api.model.StatusRequestModel
import com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel
import com.agvahealthcare.ventilator_ext.databinding.ActivityStandByBinding
import com.agvahealthcare.ventilator_ext.domain.support.PingingTask
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.ControlFragment
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.MenuFragment
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.ModeFragment
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.*
import com.agvahealthcare.ventilator_ext.presentation.ui.models.Body_Params_Data_Class
import com.agvahealthcare.ventilator_ext.presentation.utils.*
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AGE_LOWER
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AGE_UPPER
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.HEIGHT_LOWER
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.HEIGHT_UPPER
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_CONTROL_KNOB
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_MODES
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.WEIGHT_LOWER
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.WEIGHT_UPPER
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_age
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_height
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_weight
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.EventViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*


/**
 * Created by MASOOM ZAID on 20-04-2023.
 */


@AndroidEntryPoint
class StandByActivity : AppCompatActivity(), OnStandbyCLickListener,
    DialogCloseListener, OnStartSedationListener, OnLimitChangeListener, OnKnobPressListener {

    private var binding: ActivityStandByBinding? = null
    private var modeFragment: ModeFragment? = null
    private var menuFragment: MenuFragment? = null
    private var controlFragment: ControlFragment? = null
    internal var currentMode: Int = -1
    private var selectedMenuType: Constants.Companion.AllMenuType? = null
    private var selectedView: View? = null
    private var selectedTextView: TextView? = null
    private var preferenceManager: PreferenceManager? = null
    private var knobClass: KnobClass? = null
    private var isExistingVentilation: Boolean? = null

    private var testCount = 100

    private var serviceIntent: Intent? = null

    private var communicationService: com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService? = null
    private var pingingTask: PingingTask? = null

    private val commonViewModel: CommonViewModel by viewModels()
    private val eventViewModel: EventViewModel by viewModels()

    private val settingsCountDownTimer = SettingsCountDownTimer(2500, 700)

    var isServiceBound = false
    private var isReadingFromConnection = false

    private val mServiceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, ibinder: IBinder) {
            isServiceBound = true
            communicationService = (ibinder as com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService.LocalBinder).service
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
        communicationService?.takeIf { it.isPortsConnected() }?.apply {
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
            serviceIntent = Intent(this, com.agvahealthcare.ventilator_ext.domain.support.service.UsbService::class.java)
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

    fun addEvents(eventMsg: String, uhid: String) {

        val eventDataModel = EventDataModel(
            eventMsg, uhid
        )

        eventViewModel.addEvent(this@StandByActivity,eventDataModel)
    }

    override fun onHandleDialogClose() {
        closeAllFragment()
        normaliseTile(selectedView, selectedTextView)
        commonViewModel.currentModeCode.postValue(currentMode)
    }

    private fun sendControlModeToVentilator(mode: Int) {
        communicationService?.takeIf { it.isPortsConnected }?.apply {
            send(mode.toString())
            currentMode = mode
        }
        binding?.progressIndicator?.visibility = View.VISIBLE
    }

    override fun onStartSedation(mode: Int) {
        sendControlModeToVentilator(mode)
    }

    private fun showModeFragment() {
        closeAllFragment()
        modeFragment = ModeFragment(this)
        modeFragment?.let {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewStandby, it)
                .commit()
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
                start()
            }
        }

        fun safeStop() {
            isSafeStop = true
            if (isRunning) cancel()
        }

        override fun onTick(millis: Long) {

            communicationService?.takeIf { it.isPortsConnected() }?.apply {
                sendConfigurationToVentilator()
            }
        }

        override fun onFinish() {
            if (!isFirstCallElapsed) true
            isRunning = false
        }
    }

    private fun sendConfigurationToVentilatorWithWatchDog() {

        communicationService?.takeIf { it.isPortsConnected() }?.apply {
            sendConfigurationToVentilator()
            settingsCountDownTimer.startRunning()
        }
    }

    private fun showMenuFragment() {
        closeAllFragment()
        menuFragment = MenuFragment(this, true)
        menuFragment?.let {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewStandby, it)
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
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewStandby, it)
                .commit()
        }


    }

    override fun onPause() {
        unregisterReceiver(connReceiver)
        doUnbindService()
        super.onPause()
    }


    private fun normaliseAllProgressBar() {
        Sedation_App.tileClicked = false

        binding?.paramProgressBarHeight?.background =
            ContextCompat.getDrawable(
                this@StandByActivity,
                R.drawable.progresscircle
            )
        binding?.txtHeightValue?.setTextColor(this@StandByActivity.resources.getColor(R.color.white))

        binding?.paramProgressBarWeight?.background =
            ContextCompat.getDrawable(
                this@StandByActivity,
                R.drawable.progresscircle
            )
        binding?.txtWeightValue?.setTextColor(this@StandByActivity.resources.getColor(R.color.white))

        binding?.paramProgressBarAge?.background =
            ContextCompat.getDrawable(
                this@StandByActivity,
                R.drawable.progresscircle
            )
        binding?.txtAgeValue?.setTextColor(this@StandByActivity.resources.getColor(R.color.white))
    }

    private fun highlightProgressBars(type: Constants.Companion.BodyParamsType) {
        normaliseAllProgressBar()
        when (type) {
            Constants.Companion.BodyParamsType.Height -> {
                binding?.paramProgressBarHeight?.background =
                    ContextCompat.getDrawable(
                        this@StandByActivity,
                        R.drawable.progresscircle_with_selection_yellow
                    )
                binding?.txtHeightValue?.setTextColor(this@StandByActivity.resources.getColor(R.color.black))
            }

            Constants.Companion.BodyParamsType.Age -> {
                binding?.paramProgressBarAge?.background =
                    ContextCompat.getDrawable(
                        this@StandByActivity,
                        R.drawable.progresscircle_with_selection_yellow
                    )
                binding?.txtAgeValue?.setTextColor(this@StandByActivity.resources.getColor(R.color.black))
            }

            Constants.Companion.BodyParamsType.Weight -> {
                binding?.paramProgressBarWeight?.background =
                    ContextCompat.getDrawable(
                        this@StandByActivity,
                        R.drawable.progresscircle_with_selection_yellow
                    )
                binding?.txtWeightValue?.setTextColor(this@StandByActivity.resources.getColor(R.color.black))
            }
        }
    }

    private fun initViewOfBodyParamsViaPreferences() {

        binding?.btnStartSedationwithExisting?.visibility = if (preferenceManager?.getSedationMode() != -1) View.VISIBLE else View.INVISIBLE

        preferenceManager?.apply {

            binding?.tvModeName?.text =
                Constants.Companion.getModeNameViaCode(this@StandByActivity, getSedationMode())

            readGender()?.let {
                if (Constants.Companion.Gender.TYPE_MALE == it) setDataMale()
                else setDataFemale()
            }

            readBodyHeight()?.toDouble()?.toInt()?.let {

                binding?.paramProgressBarHeight?.setProgress(
                    it.toDouble(),
                    HEIGHT_UPPER.toDouble()
                )
                binding?.txtHeightValue?.text = it.toString()
            }
            readAge()?.toDouble()?.toInt()?.let {

                binding?.paramProgressBarAge?.setProgress(
                    it.toDouble(),
                    AGE_UPPER.toDouble()
                )
                binding?.txtAgeValue?.text = it.toString()
            }
            readBodyWeight()?.toDouble()?.toInt()?.let {
                binding?.paramProgressBarWeight?.setProgress(
                    it.toDouble(),
                    WEIGHT_UPPER.toDouble()
                )
                binding?.txtWeightValue?.text = it.toString()
            }

            binding?.paramProgressBarWeight?.maxProgress =
                WEIGHT_UPPER.toDouble()


            binding?.paramProgressBarAge?.maxProgress =
                AGE_UPPER.toDouble()


            binding?.paramProgressBarHeight?.maxProgress =
                HEIGHT_UPPER.toDouble()
        }
    }


    private fun updateBatteryImage(batteryLevel: Int) {

        if (batteryLevel in 76..100) {
            Log.i("value_s123","in 100")

            binding?.imgBattery?.setImageResource(R.drawable.ic_battery_full)
        } else if (batteryLevel in 51..75) {
            Log.i("value_s123","in 75")
            binding?.imgBattery?.setImageResource(R.drawable.ic_threefourth)
        } else if (batteryLevel in 26..50) {
            Log.i("value_s123","in 50")
            binding?.imgBattery?.setImageResource(R.drawable.ic_battery_half)
        } else if (batteryLevel in 0..25) {
            Log.i("value_s123","in 25")
            binding?.imgBattery?.setImageResource(R.drawable.ic_battery_low)
            addEvents("Battery Critically Low", preferenceManager?.readUHID().toString())
            DialogBoxFactory.dismissDialogs()
//            DialogBoxFactory.showBatteryCriticallyLowStatusDialog(
//                "Ventilator will shutdown anytime,For patient's safety please connect the ventilator to AC source.",
//                ctx
//            )
        }
    }

    @SuppressLint("HardwareIds")
    private fun callRunningStatusApi(status: String) {

        CoroutineScope(Dispatchers.IO).launch {
            val request = StatusRequestModel()
            request.apply {
                this.did = Settings.Secure.getString(
                    this@StandByActivity.contentResolver,
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
        binding = ActivityStandByBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding?.root)

        preferenceManager = PreferenceManager(this@StandByActivity)
        knobClass = KnobClass(this, this, this)

        SciChartBuilder.init(this@StandByActivity)

        initViewOfBodyParamsViaPreferences()
        setOnClickListener()
        callRunningStatusApi(Constants.RUNNING_STATUS_INACTIVE)
        commonViewModel.o2PressureValue.observe(this){ it1->
            it1?.let {
                binding?.txtO2Progress?.text = "$it%"
                binding?.o2Progress?.progress = it
            }
        }

        commonViewModel.n2oPressureValue.observe(this){ it1->
            it1?.let {
                binding?.txtn2oProgress?.text = "$it%"
                binding?.n2oProgress?.progress = it
            }
        }

        commonViewModel.isBatteryConnected.postValue(false)

        commonViewModel.isBatteryConnected.distinctUntilChanged()
            .observe(this, Observer { it ->
                if (it == true) {
                    commonViewModel.ventBatteryLevel.value?.let {
                        updateBatteryImage(it)
                    }
                    binding?.powerStatus?.setImageDrawable(getDrawable(R.drawable.ic_plug_out))
                } else {
                    binding?.powerStatus?.setImageDrawable(getDrawable(R.drawable.ic_plug_in))
                    binding?.imgBattery?.setImageDrawable(getDrawable(R.drawable.ic_charging))
                }
            })

        commonViewModel.ventBatteryLevel.distinctUntilChanged()
            .observe(this, androidx.lifecycle.Observer {
                if (commonViewModel.isBatteryConnected.value == true) {
                    updateBatteryImage(it)
                }
            })
    }

    private fun getIntentFilter(): IntentFilter {
        val intentFilter = IntentFilter()
        intentFilter.addAction(IntentFactory.ACTION_DEVICE_CONNECTED)
        intentFilter.addAction(IntentFactory.ACTION_DEVICE_DISCONNECTED)
        intentFilter.addAction(IntentFactory.ACTION_BATTERY_STATUS_AVAILABLE)
        intentFilter.addAction(IntentFactory.ACTION_BATTERY_CONNECTED)
        intentFilter.addAction(IntentFactory.ACTION_BATTERY_DISCONNECTED)
        intentFilter.addAction(IntentFactory.ACTION_ACK_AVAILABLE)
        intentFilter.addAction(IntentFactory.ACTION_MODE_SET)
        intentFilter.addAction(IntentFactory.ACTION_KNOB_CHANGE)
        return intentFilter
    }

    private val connReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            intent.action?.apply {
                when (this) {

                    IntentFactory.ACTION_BATTERY_STATUS_AVAILABLE -> {

                        val btryVolt = intent.getFloatExtra(Constants.VENTILATOR_BATTERY_LEVEL, 0f)
                        val o2_pressure = intent.getIntExtra(Constants.VENTILATOR_O2_PRESSURE, 0)
                        val n2o_pressure = intent.getIntExtra(Constants.VENTILATOR_N2O_PRESSURE, 0)

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

                    IntentFactory.ACTION_KNOB_CHANGE -> {
                        val data = intent.getStringExtra(VENTILATOR_CONTROL_KNOB)
                        data?.takeIf { it.isNotEmpty() }?.apply {

                            Log.i("valuseawd", Sedation_App.tileClicked.toString())
                            if(tileClicked == true){
                                if (controlFragment?.isVisible == true) {
                                    controlFragment?.updateKnobData(data)
                                } else {
                                    // for body params
                                    knobClass?.updateWithTimeoutDebounce(data)
                                }
                            }
                        }
                    }

                    IntentFactory.ACTION_MODE_SET -> {
                        currentMode = intent.getIntExtra(VENTILATOR_MODES, -1)
                        Sedation_App.isFromStandBy = true
                        preferenceManager?.updateTempPreferecesViaPreferences()
                        showControlFragment(currentMode)
                    }

                    IntentFactory.ACTION_ACK_AVAILABLE -> {

                        val ack = intent.getStringExtra(Constants.VENTILATOR_ACK)

                        if (!ack.isNullOrEmpty()) {
                            when (ack) {

                                Constants.ACK_CODE_5003 -> {
                                    val inte = Intent(this@StandByActivity,ShutdownActivity::class.java)
                                    inte.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                                    startActivity(inte)
                                    finish()
                                }

                                Constants.ACK_CODE_5014 -> {
                                    commonViewModel.isBatteryConnected.postValue(false)
                                }
                                Constants.ACK_CODE_5013 -> {
                                    commonViewModel.isBatteryConnected.postValue(true)
                                }

                                Constants.ACK_CODE_5005 -> {

                                    normaliseTile(selectedView, selectedTextView)
                                    closeAllFragment()

                                    Intent(this@StandByActivity, MainActivity::class.java).also { startActivity(it) }
                                    finish()
                                }

                                Constants.ACK_CODE_5006 ->{
                                    preferenceManager?.setTherapyEndStatus(false)
                                    preferenceManager?.setO2FlushStatus(false)
                                    if (isExistingVentilation == true) {

                                        sendConfigurationToVentilatorWithWatchDog()
                                    }else{
                                        preferenceManager?.setSedationMode(currentMode)

                                        preferenceManager?.apply {
                                            updatePreferecesViaTempPreferences()
                                            removeAllTempPreferences()
                                        }
                                        sendConfigurationToVentilatorWithWatchDog()
                                    }
                                }

                                Constants.ACK_CODE_5012 -> {
                                    // start therapy end

                                }



                            }
                        }


                    }
                }
            }
        }
    }

    private fun onDeviceDisconnect() {
        // FOR ALLOWING SCREEN AUTO LOCK
        AppUtils.keepScreenAlive(this@StandByActivity, false)

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

    private fun setOnClickListener() {

        binding?.includeWeightLayout?.setOnClickListener {

            initViewOfBodyParamsViaPreferences()
            highlightProgressBars(Constants.Companion.BodyParamsType.Weight)

            val data = Body_Params_Data_Class(
                lbl_weight, preferenceManager?.readBodyWeight().toString(),
                WEIGHT_UPPER.toString(), WEIGHT_LOWER.toString(), "1.0"
            )

            knobClass?.getAllBodyParams(data, Constants.Companion.KnobSelectedType.BodyParams)

        }
        binding?.includeHeightLayout?.setOnClickListener {
            initViewOfBodyParamsViaPreferences()
            highlightProgressBars(Constants.Companion.BodyParamsType.Height)
            val data = Body_Params_Data_Class(
                lbl_height, preferenceManager?.readBodyHeight().toString(),
                HEIGHT_UPPER.toString(), HEIGHT_LOWER.toString(), "1.0"
            )

            knobClass?.getAllBodyParams(data, Constants.Companion.KnobSelectedType.BodyParams)
        }
        binding?.includeAgeLayout?.setOnClickListener {
            initViewOfBodyParamsViaPreferences()
            highlightProgressBars(Constants.Companion.BodyParamsType.Age)

            val data = Body_Params_Data_Class(
                lbl_age, preferenceManager?.readAge().toString(),
                AGE_UPPER.toString(), AGE_LOWER.toString(), "1.0"
            )

            knobClass?.getAllBodyParams(data, Constants.Companion.KnobSelectedType.BodyParams)
        }


        binding?.modeLayout?.setOnClickListener {
            highLightTile(it, binding?.txtMode)
            showModeFragment()
        }

        binding?.btnStartSedationwithExisting?.setOnClickListener {
            isExistingVentilation = true

            sendControlModeToVentilator(preferenceManager?.getSedationMode()!!)
        }

        binding?.btnstartSedationWithNewPatient?.setOnClickListener {
            isExistingVentilation = false
            highLightTile(binding?.modeLayout, binding?.txtMode)
            showModeFragment()
        }

        binding?.systemLayout?.setOnClickListener {
            highLightTile(it, binding?.txtSystem)
            showMenuFragment()
            communicationService?.takeIf { it.isPortsConnected() }?.apply {
                send("Hello")
            }
        }

        binding?.includeMale?.buttonMale?.setOnClickListener {
            setDataMale()
        }

        binding?.includeFemale?.buttonFemale?.setOnClickListener {
            setDataFemale()
        }

        binding?.includeMale?.imageViewMale?.setOnClickListener {
            setDataMale()
        }

        binding?.includeFemale?.imageViewFemale?.setOnClickListener {
            setDataFemale()
        }

    }

    private fun setDataMale() {
        binding?.includeMale?.imageViewMale?.setImageResource(R.drawable.ic_male_select)
        binding?.includeMale?.buttonMale?.setBackgroundColor(resources.getColor(R.color.racing_green))
        binding?.includeMale?.buttonMale?.setTextColor(ContextCompat.getColor(this, R.color.white))
        binding?.includeFemale?.imageViewFemale?.setImageResource(R.drawable.ic_female_unselect)
        binding?.includeFemale?.buttonFemale?.setBackgroundColor(resources.getColor(R.color.light_grey))
        binding?.includeFemale?.buttonFemale?.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.black
            )
        )
        preferenceManager?.setGender(Constants.Companion.Gender.TYPE_MALE)
    }

    private fun setDataFemale() {
        binding?.includeMale?.imageViewMale?.setImageResource(R.drawable.ic_male_unselect)
        binding?.includeMale?.buttonMale?.setBackgroundColor(resources.getColor(R.color.light_grey))
        binding?.includeMale?.buttonMale?.setTextColor(ContextCompat.getColor(this, R.color.black))
        binding?.includeFemale?.imageViewFemale?.setImageResource(R.drawable.ic_female_select)
        binding?.includeFemale?.buttonFemale?.setBackgroundColor(resources.getColor(R.color.racing_green))
        binding?.includeFemale?.buttonFemale?.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.white
            )
        )
        preferenceManager?.setGender(Constants.Companion.Gender.TYPE_FEMALE)
    }


    private fun normaliseTile(view: View?, textView: TextView?) {
        view?.setBackgroundResource(R.drawable.button_box_drawables)
        textView?.setTextColor(ContextCompat.getColor(this, R.color.black))
    }

    private fun highLightTile(
        view: View?,
        textView: TextView?
    ) {

        normaliseTile(selectedView, selectedTextView)
        selectedView = view
        selectedTextView = textView

        view?.setBackgroundResource(R.drawable.racing_green_box_drawables)
        textView?.let {
            it.setTextColor(ContextCompat.getColor(this, R.color.white))
        }
    }

    override fun onStandby() {
        closeAllFragment()
        selectedMenuType = null
    }


    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun closeAllFragment() {

        binding?.fragmentContainerViewStandby?.removeAllViews()
        modeFragment = null
        menuFragment = null
        controlFragment = null
    }

    override fun onKnobPress(label: String, newValue: Float) {

    }

    override fun onKnobPress(label: String, newValue: Int) {
        normaliseAllProgressBar()
        when (label) {
            lbl_height -> {
                binding?.paramProgressBarHeight?.setProgress(
                    newValue.toDouble(),
                    HEIGHT_UPPER.toDouble()
                )
                binding?.txtHeightValue?.text = newValue.toString()

                preferenceManager?.setBodyHeight(newValue.toFloat())
            }

            lbl_weight -> {
                binding?.paramProgressBarWeight?.setProgress(
                    newValue.toDouble(),
                    WEIGHT_UPPER.toDouble()
                )
                binding?.txtWeightValue?.text = newValue.toString()

                preferenceManager?.setBodyWeight(newValue.toFloat())
            }

            lbl_age -> {
                binding?.paramProgressBarAge?.setProgress(
                    newValue.toDouble(),
                    AGE_UPPER.toDouble()
                )
                binding?.txtAgeValue?.text = newValue.toString()
                preferenceManager?.setAge(newValue.toFloat())
            }
        }
    }


    override fun onLimitChange(
        type: Constants.Companion.KnobSelectedType,
        label: String,
        newValue: Float
    ) {

    }

    override fun onLimitChange(
        type: Constants.Companion.KnobSelectedType,
        label: String,
        newValue: Int
    ) {
        when (label) {

            lbl_height -> {
                binding?.paramProgressBarHeight?.setProgress(
                    newValue.toDouble(),
                    HEIGHT_UPPER.toDouble()
                )
                binding?.txtHeightValue?.text = newValue.toString()
                val data = Body_Params_Data_Class(
                    lbl_height, newValue.toString(),
                    HEIGHT_UPPER.toString(), HEIGHT_LOWER.toString(), "1.0"
                )

                knobClass?.getAllBodyParams(data, Constants.Companion.KnobSelectedType.BodyParams)
            }

            lbl_weight -> {
                binding?.paramProgressBarWeight?.setProgress(
                    newValue.toDouble(),
                    WEIGHT_UPPER.toDouble()
                )
                binding?.txtWeightValue?.text = newValue.toString()

                val data = Body_Params_Data_Class(
                    lbl_weight, newValue.toString(),
                    WEIGHT_UPPER.toString(), WEIGHT_LOWER.toString(), "1.0"
                )

                knobClass?.getAllBodyParams(data, Constants.Companion.KnobSelectedType.BodyParams)
            }

            lbl_age -> {
                binding?.paramProgressBarAge?.setProgress(
                    newValue.toDouble(),
                    AGE_UPPER.toDouble()
                )
                binding?.txtAgeValue?.text = newValue.toString()

                val data = Body_Params_Data_Class(
                    lbl_age, newValue.toString(),
                    AGE_UPPER.toString(), AGE_LOWER.toString(), "1.0"
                )

                knobClass?.getAllBodyParams(data, Constants.Companion.KnobSelectedType.BodyParams)
            }
        }
    }

}