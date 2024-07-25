package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments

import android.annotation.SuppressLint
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.Settings
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.lifecycleScope
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.databinding.FragmentAlarmLimitsBinding
import com.agvahealthcare.ventilator_ext.databinding.FragmentSettingsBinding
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */

@AndroidEntryPoint
class InfoFragment : Fragment(){

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private var timerForBatteryData: CountDownTimer? = null
    private var batteryLevel: Int? = null
    private var batteryHealth: Int? = null
    private var batteryRemainingTime: Int? = null
    private var isBatteryConnected: Boolean? = null
    private var isClicked = false
    var prefManager: PreferenceManager? = null
    private var activityViewModel: AndroidViewModel? = null
    val usageStats: UsageStatsManager by lazy {
        requireContext().getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
    }
    var usageStat: UsageStatsManager? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("HardwareIds")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefManager = PreferenceManager(requireContext())

        binding.textViewLogIdData.text = Settings.Secure.getString(requireContext().contentResolver,
            Settings.Secure.ANDROID_ID)

        if (tag == "MainActivity") {

//            activityViewModel =
//                ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
//            (activityViewModel as MainActivityViewModel).ventBatteryRemainingTime.observe(
//                viewLifecycleOwner,
//                Observer { it ->
//                    setBatteryTTEUpdate(it)
//                })
//            (activityViewModel as MainActivityViewModel).ventBatteryHealth.observe(
//                viewLifecycleOwner,
//                Observer { it ->
//                    setBatteryHealthUpdate(it)
//                })
//            (activityViewModel as MainActivityViewModel).ventBatteryLevel.observe(
//                viewLifecycleOwner,
//                Observer { it ->
//                    setBatteryLevelUpdate(it)
//                })
//            (activityViewModel as MainActivityViewModel).isBatteryConnected.distinctUntilChanged()
//                .observe(viewLifecycleOwner, Observer { it ->
//                    isBatteryConnected = it
//                })

//            //Operational hours in hours and minutes.
//            (activityViewModel as MainActivityViewModel).OPHours.observe(viewLifecycleOwner,
//                Observer {
//                    textViewOpHoursData.text = it
//                    Log.i("CHECK_OP_HOURS",it.toString())
//                })
//            (activityViewModel as MainActivityViewModel).serviceHours.observe(viewLifecycleOwner,
//                Observer {
//                    textViewServiceHoursData.text = it
//                    Log.i("CHECK_SERVICE_HOURS",it.toString())
//                })

        } else if (tag == "FromDashboard") {

//            activityViewModel =
//                ViewModelProvider(requireActivity()).get(DashBoardViewModel::class.java)
//            (activityViewModel as DashBoardViewModel).ventBatteryRemainingTime.observe(
//                viewLifecycleOwner,
//                Observer { it ->
//                    Log.i("swasdwa","s124")
//                    setBatteryTTEUpdate(it)
//                })
//            (activityViewModel as DashBoardViewModel).ventBatteryHealth.observe(
//                viewLifecycleOwner,
//                Observer { it ->
//                    setBatteryHealthUpdate(it)
//                })
//            (activityViewModel as DashBoardViewModel).ventBatteryLevel.observe(
//                viewLifecycleOwner,
//                Observer { it ->
//                    setBatteryLevelUpdate(it)
//                })
//            (activityViewModel as DashBoardViewModel).isBatteryConnected.distinctUntilChanged()
//                .observe(viewLifecycleOwner, Observer { it ->
//                    isBatteryConnected = it
//                })
//            //Operational hours in hours and minutes.
//            (activityViewModel as DashBoardViewModel).OPHours.observe(viewLifecycleOwner,
//                Observer {
//                    Log.i("CHECK_OP_HOURS_DASH",it.toString())
//                    textViewOpHoursData.text = it
//                })
//            (activityViewModel as DashBoardViewModel).serviceHours.observe(viewLifecycleOwner,
//                Observer {
//                    textViewServiceHoursData.text = it
//                    Log.i("CHECK_SERVICE_HOURS_DASH",it.toString())
//                })
        }
//        prefManager?.apply {
//            try {
//                setSoftWareUpdate(readVentilatorSoftwareVersion())
//            } catch (e: Exception) {
//                Toast.makeText(requireContext(), "" + e.printStackTrace(), Toast.LENGTH_LONG).show()
//            }
//        }

        // set hardware serial number
//        textViewHardwareSerialNumberData.text = VentilatorApp.hardwareSerialNumber

        // set hardware version
//
//        CoroutineScope(Dispatchers.Main).launch {
//            try{
//                val dataArr = dataStoreManager?.getStartUpCheckValue()?.first()?.split(',')
//                textViewOperatingHoursData.text = dataArr?.get(0).toString()
//            }catch (e:Exception){
//                e.printStackTrace()
//            }
//
//        }




        try {
            val pInfo =
                requireContext().packageManager.getPackageInfo(requireContext().packageName, 0)
            val version = pInfo.versionName
            Log.i("version name", version + "  " + pInfo.versionCode)
            binding.textViewSoftwareVersionData.text = version
            binding.textViewModelData.text = "Agva Sedation System".uppercase()
        } catch (e: PackageManager.NameNotFoundException) {
            Toast.makeText(requireContext(), "" + e.printStackTrace(), Toast.LENGTH_LONG).show()
        }

        lifecycleScope.launch {
//            VentilatorApp.connectivityObserver?.observe()?.collect {
//                Log.i("value_check_connectivity",it.toString())
//                textViewInternetConnectivityData.text = it.name
//            }
        }
    }


//    private fun setBatteryLevelUpdate(btryLevel: Int) {
//        if (btryLevel < 0 || btryLevel > 100) {
//            textViewBattery1Data.text = "-"
//        } else {
//            textViewBattery1Data.text = "$btryLevel %"
//        }
//        this.batteryLevel = btryLevel
//    }


//    private fun setBatteryHealthUpdate(health: Int) {
//        when (health) {
//            in 0..50 -> {
//                textViewBatteryHealthData.text = "${BatteryHealthStaus.Bad}"
//                textViewBatteryHealthData.setTextColor(Color.RED)
//            }
//            in 51..70 -> {
//                textViewBatteryHealthData.text = "${BatteryHealthStaus.Marginal}"
//                textViewBatteryHealthData.setTextColor(Color.YELLOW)
//            }
//            in 71..85 -> {
//                textViewBatteryHealthData.text = "${BatteryHealthStaus.Good}"
//                textViewBatteryHealthData.setTextColor(
//                    resources.getColor(
//                        R.color.racing_green,
//                        null
//                    )
//                )
//            }
//            in 86..100 -> {
//                textViewBatteryHealthData.text = "${BatteryHealthStaus.Excellent}"
//                textViewBatteryHealthData.setTextColor(
//                    resources.getColor(
//                        R.color.racing_green,
//                        null
//                    )
//                )
//            }
//            !in 0..100 -> {
//                textViewBatteryHealthData.text = "-"
//                textViewBatteryHealthData.setTextColor(Color.BLACK)
//            }
//            else -> {
//                textViewBatteryHealthData.text = "-"
//                textViewBatteryHealthData.setTextColor(Color.BLACK)
//            }
//        }
//
//        this.batteryHealth = health
//    }

    private fun roundMinutes(value: Int): Int {
        val returnmod = value % 5
        return (value - returnmod)
    }

    private fun cancelTimeOut() {
        timerForBatteryData?.cancel()
        timerForBatteryData = null
    }

//    private fun setBatteryTTEUpdate(timeInMins: Int) {
//
//        if (isBatteryConnected == false) {
//            textViewBatteryRemTimeData.text = "-"
//            isClicked = false
//        } else {
//
//            val formatter = DecimalFormat("00")
//            val hour = timeInMins / 60
//            var mins = timeInMins % 60
//            mins = roundMinutes(mins)
//
////            if (!timerIsExists) {
////                textViewBatteryRemTimeData.text = "Calculating...."
////                timerForBatteryData = object : CountDownTimer(120000 , 1000) {
////                    override fun onTick(millisUntilFinished: Long) {}
////
////                    override fun onFinish() {
////                        cancelTimeOut()
////                        timerIsExists = true
////                    }
////                }
////                timerForBatteryData?.start()
////            }
//
//            if (globalCount >= 60) {
//                textViewBatteryRemTimeData.text =
//                    if (hour == 0) "${formatter.format(mins)} min" else "$hour hr ${
//                        formatter.format(mins)
//                    } min"
//            }else {
//                if (!isClicked){
//                    textViewBatteryRemTimeData.text = "Calculating...."
//                    isClicked = true
//                }
//            }
//
//        }
//        this.batteryRemainingTime = timeInMins
//    }

//    fun setSoftWareUpdate(softwareUpdate: String?) {
//        softwareUpdate?.apply {
//            textViewOperatingHoursData.text = this
//        }
//    }



    override fun onPause() {
        cancelTimeOut()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
//        try {
//        } catch (ex: Exception) {
//            textViewOpHoursData.text = "updating"
//            textViewServiceHoursData.text = "updating"
//        }
    }

    override fun onDetach() {
//        timerForBatteryData?.cancel()
        super.onDetach()
    }


}