package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.databinding.FragmentCalibrationBinding
import com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService
import com.agvahealthcare.ventilator_ext.presentation.adapters.*
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.PREFIX_SENSOR_CALIBRATION
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.TAG_SENSOR_N2O_FLOW
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.TAG_SENSOR_O2_FLOW
import com.agvahealthcare.ventilator_ext.presentation.utils.DialogBoxFactory
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager
import com.agvahealthcare.ventilator_ext.presentation.utils.ToastFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */

@AndroidEntryPoint
class CalibrationFragment(private var communicationService: CommunicationService?) : Fragment(){

    private var _binding: FragmentCalibrationBinding? = null
    private val binding get() = _binding!!
    private var prefManager: PreferenceManager? = null
    private var currentTag: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalibrationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefManager = PreferenceManager(requireContext())
        setUpView()
        setUpOnClickListener()
    }

    @SuppressLint("SetTextI18n")
    private fun setUpView() {
        binding.includeButtonO2FlowSensor.buttonView.text = "O₂ Flow Sensor"
        binding.includeButtonN2oFlowSensor.buttonView.text = "N₂O Flow Sensor"
        binding.includeButtonSendCmd.buttonView.text = "START CALIBRATION"
        binding.includeButtonSendCmd.buttonView.textAlignment = View.TEXT_ALIGNMENT_INHERIT
        binding.includeButtonSendCmd.buttonView.setBackgroundColor(R.drawable.background_black_border_white)
        binding.includeButtonSendCmd.buttonView.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.white
            )
        )
        updateSensorCalibrationStatus()
    }

    private fun setUpOnClickListener() {
        if (tag == "FromDashboard") {
            binding.includeButtonO2FlowSensor.buttonView.setOnClickListener {
                ToastFactory.custom(requireContext(),"Switch to standby for calibration process")
            }
            binding.includeButtonN2oFlowSensor.buttonView.setOnClickListener {
                ToastFactory.custom(requireContext(),"Switch to standby for calibration process")
            }
        } else {
            binding.includeButtonO2FlowSensor.buttonView.setOnClickListener{
                postCalibrationbehaviourChange()
                currentTag = "O₂ Flow"
                binding.tvMainTitle.text = "O₂ Flow sensor pre-calibration check"
//                tvtext1.text = "1. Connect external flow calibrator at inspiratory port."
                binding.tvtext4.text = ""
                binding.tvtext1.text = "1. Make sure the machine is connected to mains supply"
                binding.tvtext3.text = "2. Connect external flow calibrator to inspiratory port."
                binding.includeButtonSendCmd.buttonView.text = "Start calibration"
                normaliseChanges()
            }
            binding.includeButtonN2oFlowSensor.buttonView.setOnClickListener{
                postCalibrationbehaviourChange()
                currentTag = "N₂O Flow"
                binding.tvMainTitle.text = "N₂O Flow sensor pre-calibration check"
//                tvtext1.text = "1. Connect external flow calibrator at inspiratory port."
                binding.tvtext4.text = ""
                binding.tvtext1.text = "1. Make sure the machine is connected to mains supply"
                binding.tvtext3.text = "2. Connect external flow calibrator to inspiratory port."
                binding.includeButtonSendCmd.buttonView.text = "Start calibration"
                normaliseChanges()
            }
            binding.includeButtonSendCmd.buttonView.setOnClickListener{
                when (currentTag) {
                    "O₂ Flow" -> {
                        postCalibrationbehaviourChange()

                        sendCalibrationCommandToVentilator(TAG_SENSOR_O2_FLOW)
                    }
                    "N₂O Flow" -> {
                        postCalibrationbehaviourChange()

                        sendCalibrationCommandToVentilator(TAG_SENSOR_N2O_FLOW)
                    }


                }
            }


        }



        binding.backBtn.setOnClickListener {
            binding.topBar.visibility = View.GONE
            binding.mainPanel.visibility = View.VISIBLE
            binding.preCheckPanel.visibility = View.GONE
        }

    }

    fun updateSensorCalibrationStatus() {
        prefManager?.apply {
            Log.i("CALIBCHECK", "Sensor data is refreshing on the view......")

//            // Turbine sensor
//            if (readTurbineCalibrationStatus()) {
//                ivTurbineSensorStatus.visibility = View.VISIBLE
//                tvTurbineSensor.text = readTurbineCalibrationDate()
//                ivTurbineSensorStatus.setImageResource(R.drawable.ic_green_circle_tick)
//            } else {
//                tvTurbineSensor.text = getString(R.string.sensore_not_calibrated)
//                ivTurbineSensorStatus.setImageResource(R.drawable.ic_red_cross)
//            }
//
//            // Flow Insp sensor
//            if (readInspFlowCalibrationStatus()) {
//                tvInspFlowSensor.text = readInspFlowCalibrationDate()
//                ivInspFlowSensorStatus.setImageResource(R.drawable.ic_green_circle_tick)
//            } else {
//                tvInspFlowSensor.text = getString(R.string.sensore_not_calibrated)
//                ivInspFlowSensorStatus.setImageResource(R.drawable.ic_red_cross)
//            }
//
//            // leak test sensor
//            if (readLeakTestCalibrationStatus()) {
//                tvLeakCheckValue.text = readLeakTestCalibrationDate()
//                ivLeakTestStatus.setImageResource(R.drawable.ic_green_circle_tick)
//            } else {
//                tvLeakCheckValue.text = getString(R.string.sensore_not_calibrated)
//                ivLeakTestStatus.setImageResource(R.drawable.ic_red_cross)
//            }
        }
    }

    fun sendCalibrationCommandToVentilator(sensorTag: String) {

        communicationService?.takeIf { it.isPortsConnected }?.apply {
            communicationService?.send("CM+" + PREFIX_SENSOR_CALIBRATION + sensorTag)
        }
    }

    private fun normaliseChanges() {
        binding.mainPanel.visibility = View.GONE
        binding.preCheckPanel.visibility = View.VISIBLE
        binding.MainTopBar.visibility = View.VISIBLE
    }

    private fun postCalibrationbehaviourChange() {
        binding.preCheckPanel.visibility = View.GONE
        binding.mainPanel.visibility = View.VISIBLE
        binding.topBar.visibility = View.VISIBLE
        binding.MainTopBar.visibility = View.GONE
    }

}