package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.Sedation_App
import com.agvahealthcare.ventilator_ext.databinding.FragmentAlarmLimitsBinding
import com.agvahealthcare.ventilator_ext.presentation.ui.activities.MainActivity
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.*
import com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel
import com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_fio2
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_flow
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_paw
import com.agvahealthcare.ventilator_ext.presentation.utils.KnobClass
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */

data class AlarmLimitsModelClass(
    var label: String,
    var value: String,
    var upperLimit :Int,
    var lowerLimit :Int,
    var step : String
)

@AndroidEntryPoint
class AlarmLimitsFragment : Fragment(), OnKnobPressListener, DialogCloseListener,
    OnLimitChangeListener {

    private var preferenceManager: PreferenceManager? = null
    private var _binding: FragmentAlarmLimitsBinding? = null
    private var knobClass: KnobClass? = null
    private var isUpperLimit = false
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlarmLimitsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        knobClass = KnobClass(this, this, this)
        preferenceManager = PreferenceManager(requireContext())
        initViewForAlarmLimits()
        setOnClickListener()
    }

    private fun normaliseTile(){
        binding.fio2LowLimit.root.setBackgroundResource(R.drawable.alarm_limit_btn)
        binding.flowLowLimit.root.setBackgroundResource(R.drawable.alarm_limit_btn)
        binding.pawLowLimit.root.setBackgroundResource(R.drawable.alarm_limit_btn)
        binding.pawHighLimit.root.setBackgroundResource(R.drawable.alarm_limit_btn)
        binding.flowHighLimit.root.setBackgroundResource(R.drawable.alarm_limit_btn)
        binding.fio2HighLimit.root.setBackgroundResource(R.drawable.alarm_limit_btn)
    }

    private fun setOnClickListener(){
        binding.fio2LowLimit.root.setOnClickListener {
            normaliseTile()
            it.setBackgroundResource(R.drawable.alarm_limit_btn_green)
            isUpperLimit = false
            val model = AlarmLimitsModelClass(label = lbl_fio2,
                value = preferenceManager?.getPrefFio2LowerLimits()!!,
                upperLimit = binding.fio2HighLimit.alarmLimitTvItem.text.toString().toInt() - 1,
                lowerLimit = resources.getString(R.string.fio2_min).toInt(),
                step = resources.getString(R.string.fio2_step))
            knobClass?.getAllAlarms(model,Constants.Companion.KnobSelectedType.AlarmTileType)
        }

        binding.fio2HighLimit.root.setOnClickListener {
            normaliseTile()
            it.setBackgroundResource(R.drawable.alarm_limit_btn_green)
            isUpperLimit = true
            val model = AlarmLimitsModelClass(label = lbl_fio2,
                value = preferenceManager?.getPrefFio2UpperLimits()!!,
                upperLimit = resources.getString(R.string.fio2_max).toInt(),
                lowerLimit = binding.fio2LowLimit.alarmLimitTvItem.text.toString().toInt() + 1,
                step = resources.getString(R.string.fio2_step))
            knobClass?.getAllAlarms(model,Constants.Companion.KnobSelectedType.AlarmTileType)
        }

        binding.pawLowLimit.root.setOnClickListener {
            normaliseTile()
            it.setBackgroundResource(R.drawable.alarm_limit_btn_green)
            isUpperLimit = false
            val model = AlarmLimitsModelClass(label = lbl_paw,
                value = preferenceManager?.getPrefPAWLowerLimits()!!,
                upperLimit = binding.pawHighLimit.alarmLimitTvItem.text.toString().toInt() - 1,
                lowerLimit = 0,
                step = resources.getString(R.string.paw_step))
            knobClass?.getAllAlarms(model,Constants.Companion.KnobSelectedType.AlarmTileType)
        }

        binding.pawHighLimit.root.setOnClickListener {
            normaliseTile()
            it.setBackgroundResource(R.drawable.alarm_limit_btn_green)
            isUpperLimit = true
            val model = AlarmLimitsModelClass(label = lbl_paw,
                value = preferenceManager?.getPrefPAWUpperLimits()!!,
                upperLimit = preferenceManager?.getPlimit()!! +1,
                lowerLimit = binding.pawLowLimit.alarmLimitTvItem.text.toString().toInt() + 1,
                step = resources.getString(R.string.paw_step))
            knobClass?.getAllAlarms(model,Constants.Companion.KnobSelectedType.AlarmTileType)
        }

        binding.flowLowLimit.root.setOnClickListener {
            normaliseTile()
            it.setBackgroundResource(R.drawable.alarm_limit_btn_green)
            isUpperLimit = false
            val model = AlarmLimitsModelClass(label = lbl_flow,
                value = preferenceManager?.getPrefFLOWLowerLimits()!!,
                upperLimit = binding.flowHighLimit.alarmLimitTvItem.text.toString().toInt() - 1,
                lowerLimit = resources.getString(R.string.flow_min).toInt(),
                step = resources.getString(R.string.flow_step))
            knobClass?.getAllAlarms(model,Constants.Companion.KnobSelectedType.AlarmTileType)
        }

        binding.flowHighLimit.root.setOnClickListener {
            normaliseTile()
            it.setBackgroundResource(R.drawable.alarm_limit_btn_green)
            isUpperLimit = true
            val model = AlarmLimitsModelClass(label = lbl_flow,
                value = preferenceManager?.getPrefFLOWUpperLimits()!!,
                upperLimit = preferenceManager?.getTotalFlow()?.plus(1)!!,
                lowerLimit = binding.flowLowLimit.alarmLimitTvItem.text.toString().toInt() + 1,
                step = resources.getString(R.string.flow_step))
            knobClass?.getAllAlarms(model,Constants.Companion.KnobSelectedType.AlarmTileType)
        }
    }

    fun updateKnobData(value: String) {
        knobClass?.updateWithTimeoutDebounce(value)
    }

    override fun onKnobPress(label: String, newValue: Int) {
        preferenceManager?.updateAlarmLimits(label, newValue.toString(),isUpperLimit)
        normaliseTile()
    }

    override fun onLimitChange(
        type: Constants.Companion.KnobSelectedType,
        label: String,
        newValue: Int
    ) {

        knobClass?.alarmModel?.value = newValue.toString()
        when (type) {
            Constants.Companion.KnobSelectedType.AlarmTileType -> {
                when (label) {
                    lbl_flow -> {
                        if (isUpperLimit) binding.flowHighLimit.alarmLimitTvItem.text = newValue.toString()
                        else binding.flowLowLimit.alarmLimitTvItem.text = newValue.toString()
                    }
                    lbl_fio2 -> {
                        if (isUpperLimit) binding.fio2HighLimit.alarmLimitTvItem.text = newValue.toString()
                        else binding.fio2LowLimit.alarmLimitTvItem.text = newValue.toString()
                    }
                    lbl_paw -> {
                        if (isUpperLimit) binding.pawHighLimit.alarmLimitTvItem.text = newValue.toString()
                        else binding.pawLowLimit.alarmLimitTvItem.text = newValue.toString()
                    }
                }
            }
            else -> {}
        }
    }

    // nothing for floating point value limits
    override fun onLimitChange(
        type: Constants.Companion.KnobSelectedType,
        label: String,
        newValue: Float
    ) {

    }

    // nothing for float value
    override fun onKnobPress(label: String, newValue: Float) {
    }

    override fun onHandleDialogClose() {
        initViewForAlarmLimits()
        normaliseTile()
    }

    private fun initViewForAlarmLimits() {
        preferenceManager?.apply {
            binding.fio2LowLimit.alarmLimitTvItem.text = getPrefFio2LowerLimits()
            binding.fio2HighLimit.alarmLimitTvItem.text = getPrefFio2UpperLimits()
            binding.flowLowLimit.alarmLimitTvItem.text = getPrefFLOWLowerLimits()
            binding.flowHighLimit.alarmLimitTvItem.text = getPrefFLOWUpperLimits()
            binding.pawLowLimit.alarmLimitTvItem.text = getPrefPAWLowerLimits()
            binding.pawHighLimit.alarmLimitTvItem.text = getPrefPAWUpperLimits()
        }
    }
}