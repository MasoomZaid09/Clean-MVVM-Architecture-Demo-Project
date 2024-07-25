package com.agvahealthcare.ventilator_ext.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.Sedation_App
import com.agvahealthcare.ventilator_ext.databinding.CommonMenuSubFragmentBinding
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.*
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */

@AndroidEntryPoint
class CommonSubMenuFragment : Fragment() {

    private var _binding: CommonMenuSubFragmentBinding? = null
    private val binding get() = _binding!!
    private val commonViewModel: CommonViewModel by activityViewModels()

    private var alarmLimitsFragment: AlarmLimitsFragment? = null
    private var recentPatientFragment: RecentPatientsFragment? = null
    private var calibrationFragment: CalibrationFragment? = null
    private var serviceFragment: ServiceFragment? = null
    private var infoFragment: InfoFragment? = null
    private var eventFragment: EventFragment? = null
    private var advancedCalibrationFragment: AdvancedCalibrationFragment? = null
    private var errorLogsFragment: ErrorLogsFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CommonMenuSubFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        commonViewModel.clickedSubMenuItem.observe(viewLifecycleOwner) {
            when (it) {
                Constants.Companion.AllSubMenuType.EventLogs -> {
                    showEventLogFragment()
                }

                Constants.Companion.AllSubMenuType.ErrorLogs -> {
                    showErrorLogsFragment()
                }

                Constants.Companion.AllSubMenuType.Calibrations -> {
                    showCalibrationFragment()
                }

                Constants.Companion.AllSubMenuType.AlarmLimits -> {
                    showAlarmLimitsFragment()
                }


                Constants.Companion.AllSubMenuType.Settings -> {
                    showInfoFragment()
                }

                Constants.Companion.AllSubMenuType.ServiceWindow -> {
                    showServiceFragment()
                }

                Constants.Companion.AllSubMenuType.AdvancedCalibration -> {
                    showAdvancedCalibrationFragment()
                }

                else -> {

                }
            }
        }
    }

    fun updateViaKnob(data:String){
        if (eventFragment?.isVisible == true) {
            when(data){
                Constants.PREFIX_PLUS -> eventFragment?.scrollForward()
                Constants.PREFIX_MINUS -> eventFragment?.scrollBack()
            }
        }
        else if (errorLogsFragment?.isVisible == true) {
            when(data){
                Constants.PREFIX_PLUS -> errorLogsFragment?.scrollForward()
                Constants.PREFIX_MINUS -> errorLogsFragment?.scrollBack()
            }
        }
        else if (alarmLimitsFragment?.isVisible == true && Sedation_App.tileClicked == true) {
           alarmLimitsFragment?.updateKnobData(data)
        }
    }

    private fun showErrorLogsFragment() {
        hideAllFragments()
        errorLogsFragment = ErrorLogsFragment()
        errorLogsFragment?.let {
            childFragmentManager.beginTransaction().replace(R.id.subMenuContainer, it).commitNow()
        }
    }

    private fun showEventLogFragment() {
        hideAllFragments()
        eventFragment = EventFragment()
        eventFragment?.let {
            childFragmentManager.beginTransaction().replace(R.id.subMenuContainer, it).commitNow()
        }
    }

    private fun showCalibrationFragment() {
        hideAllFragments()
        calibrationFragment = CalibrationFragment(communicationService = null)
        calibrationFragment?.let {
            childFragmentManager.beginTransaction().replace(R.id.subMenuContainer, it).commitNow()
        }
    }

    private fun showAdvancedCalibrationFragment() {
        hideAllFragments()
        advancedCalibrationFragment = AdvancedCalibrationFragment()
        advancedCalibrationFragment?.let {
            childFragmentManager.beginTransaction().replace(R.id.subMenuContainer, it).commitNow()
        }
    }

    private fun showInfoFragment() {
        hideAllFragments()
        infoFragment = InfoFragment()
        infoFragment?.let {
            childFragmentManager.beginTransaction().replace(R.id.subMenuContainer, it).commitNow()
        }
    }

    private fun showServiceFragment() {
        hideAllFragments()
        serviceFragment = ServiceFragment()
        serviceFragment?.let {
            childFragmentManager.beginTransaction().replace(R.id.subMenuContainer, it).commitNow()
        }
    }


    private fun showAlarmLimitsFragment() {
        hideAllFragments()
        alarmLimitsFragment = AlarmLimitsFragment()
        alarmLimitsFragment?.let {
            childFragmentManager.beginTransaction().replace(R.id.subMenuContainer, it).commitNow()
        }
    }

    private fun showRecentPatientFragment() {
        hideAllFragments()
        recentPatientFragment = RecentPatientsFragment()
        recentPatientFragment?.let {
            childFragmentManager.beginTransaction().replace(R.id.subMenuContainer, it).commitNow()
        }
    }

    private fun hideAllFragments() {

        alarmLimitsFragment = null
        recentPatientFragment = null
        calibrationFragment = null
        advancedCalibrationFragment = null
        serviceFragment = null
        infoFragment = null
        eventFragment = null
        errorLogsFragment = null

        binding.subMenuContainer.removeAllViews()

    }


}