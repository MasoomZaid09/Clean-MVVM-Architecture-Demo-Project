package com.agvahealthcare.ventilator_ext.presentation.utils

import android.os.CountDownTimer
import android.util.Log
import com.agvahealthcare.ventilator_ext.Sedation_App.Companion.tileClicked
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.AlarmLimitsModelClass
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnKnobPressListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitChangeListener
import com.agvahealthcare.ventilator_ext.presentation.ui.models.Body_Params_Data_Class
import com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.PREFIX_AND
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.PREFIX_MINUS
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.PREFIX_PLUS

class KnobClass(
    private var onKnobPressListener: OnKnobPressListener,
    private var onDialogCloseListener: DialogCloseListener,
    private var onLimitChangeListener: OnLimitChangeListener
) {

    //Parameter model needs to be changed to null safety
    private lateinit var tileModel: Tile_Model_Class
    lateinit var alarmModel: AlarmLimitsModelClass
    private lateinit var bodyParams: Body_Params_Data_Class
    private var isCloseListenerAvoided = false
    private var currentValue = -1
    private var currentValueFloat = -1f
    private var currentLable: String = ""
    private var countOfMaxLimit = 0
    var type: Constants.Companion.KnobSelectedType? = null
    private var visibilityTimeout: CountDownTimer? = null

    fun getAllParams(
        data: Tile_Model_Class,
        type: Constants.Companion.KnobSelectedType
    ) {
        startTimeoutWithDebounce()
        tileClicked = true
        this.type = type
        tileModel = data

        if (type == Constants.Companion.KnobSelectedType.tileType) currentValue = tileModel.value.toInt()
        else currentValueFloat = tileModel.value.toFloat()
    }

    fun getAllAlarms(
        data : AlarmLimitsModelClass,
        type: Constants.Companion.KnobSelectedType
    ) {
        startTimeoutWithDebounce()
        tileClicked = true
        this.type = type
        alarmModel = data
        currentValue = alarmModel.value.toInt()
    }

    fun getAllBodyParams(data: Body_Params_Data_Class,type: Constants.Companion.KnobSelectedType){
        tileClicked = true
        this.type = type
        startTimeoutWithDebounce()
        bodyParams = data
    }

    fun updateWithTimeoutDebounce( value: String) {
        Log.i("casdha",type.toString())

        when (value) {
            PREFIX_PLUS -> {

                when (type) {
                    Constants.Companion.KnobSelectedType.tileType -> addition()
                    Constants.Companion.KnobSelectedType.AlarmTileType -> additionAlarms()
                    Constants.Companion.KnobSelectedType.BodyParams -> additionBodyParams()
                    else -> additionTargetPressure()
                }
            }
            PREFIX_MINUS -> {
                when (type) {
                    Constants.Companion.KnobSelectedType.tileType -> subtraction()
                    Constants.Companion.KnobSelectedType.AlarmTileType -> subtractionAlarms()
                    Constants.Companion.KnobSelectedType.BodyParams -> subtractionBodyParams()
                    else -> subtractionTargetPressure()
                }
            }
            PREFIX_AND -> {
                ok()
            }
        }
    }

    private fun startTimeoutWithDebounce() {

        cancelTimeout()

        visibilityTimeout = object : CountDownTimer(10000, 2000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                tileClicked = false
                onDialogCloseListener.onHandleDialogClose()
                cancelTimeout()
            }
        }

        visibilityTimeout?.start()
    }

    fun cancelTimeout() {
        if (visibilityTimeout != null) {
            visibilityTimeout?.cancel()
            visibilityTimeout = null
        }

    }

    private fun addition() {
        startTimeoutWithDebounce()
        currentLable = tileModel.label
        val newValue = tileModel.value.toInt() + tileModel.steps.toInt()
        val isNewValueValid = newValue <= tileModel.upperLimit.toInt()

        if (isNewValueValid) {
            currentValue = newValue
            countOfMaxLimit = 1
        } else {
            if (countOfMaxLimit == 1) {
                countOfMaxLimit = 0
            }
        }

        // notify change in value
        type?.let { onLimitChangeListener.onLimitChange(it,tileModel.label, currentValue) }
    }

    private fun additionAlarms() {
        startTimeoutWithDebounce()
        currentLable = alarmModel.label
        val newValue = alarmModel.value.toInt() + alarmModel.step.toInt()
        val isNewValueValid = newValue <= alarmModel.upperLimit

        if (isNewValueValid) {
            currentValue = newValue
            countOfMaxLimit = 1
        } else {
            if (countOfMaxLimit == 1) {
                countOfMaxLimit = 0
            }
        }

        // notify change in value
        type?.let { onLimitChangeListener.onLimitChange(it,alarmModel.label, currentValue) }
    }

    private fun additionBodyParams() {
        startTimeoutWithDebounce()
        currentLable = bodyParams.label
        val newValue = bodyParams.value.toDouble().toInt() + bodyParams.steps.toDouble().toInt()

        val isNewValueValid = newValue <= bodyParams.upperLimit.toDouble().toInt()

        if (isNewValueValid) {
            currentValue = newValue
            countOfMaxLimit = 1
        } else {
            if (countOfMaxLimit == 1) {
                countOfMaxLimit = 0
            }
        }

        // notify change in value
        type?.let { onLimitChangeListener.onLimitChange(it,bodyParams.label, currentValue) }
    }

    private fun additionTargetPressure() {
        startTimeoutWithDebounce()
        currentLable = tileModel.label

        val steps = if (tileModel.value.toFloat() < 1.0f) tileModel.steps.toFloat() else 0.5f
        val newValue = tileModel.value.toFloat() + steps
        val isNewValueValid = newValue <= tileModel.upperLimit.toFloat()

        if (isNewValueValid) {
            currentValueFloat = newValue
            countOfMaxLimit = 1
        } else {
            if (countOfMaxLimit == 1) countOfMaxLimit = 0
        }
        // notify change in value
        type?.let { onLimitChangeListener.onLimitChange(it,tileModel.label, currentValueFloat) }
    }



    private fun subtraction() {
        startTimeoutWithDebounce()
        currentLable = tileModel.label
        val newValue = tileModel.value.toInt() - tileModel.steps.toInt()
        val isNewValueValid = newValue >= tileModel.lowerlimit.toInt()

        if (isNewValueValid) {
            if (currentValue > 0) currentValue = newValue
            countOfMaxLimit = 1
        } else {
            countOfMaxLimit = 0
        }

        // notify change in value
        type?.let { onLimitChangeListener.onLimitChange(it,tileModel.label, currentValue) }
    }

    private fun subtractionAlarms() {
        startTimeoutWithDebounce()
        currentLable = alarmModel.label
        val newValue = alarmModel.value.toInt() - alarmModel.step.toInt()
        val isNewValueValid = newValue >= alarmModel.lowerLimit

        if (isNewValueValid) {
            if (currentValue > 0) currentValue = newValue
            countOfMaxLimit = 1
        } else {
            countOfMaxLimit = 0
        }

        // notify change in value
        type?.let { onLimitChangeListener.onLimitChange(it,alarmModel.label, currentValue) }
    }

    private fun subtractionBodyParams() {
        startTimeoutWithDebounce()
        currentLable = bodyParams.label

        val newValue = bodyParams.value.toDouble().toInt() - bodyParams.steps.toDouble().toInt()
        val isNewValueValid = newValue >= bodyParams.lowerlimit.toDouble().toInt()

        if (isNewValueValid) {
            currentValue = newValue
            countOfMaxLimit = 1
        } else {
            countOfMaxLimit = 0
        }

        // notify change in value
        type?.let { onLimitChangeListener.onLimitChange(it,bodyParams.label, currentValue) }
    }


    private fun subtractionTargetPressure() {
        startTimeoutWithDebounce()
        currentLable = tileModel.label
        val steps = if (tileModel.value.toFloat() < 1.0f) tileModel.steps.toFloat() else 0.5f
        val newValue = tileModel.value.toFloat() - steps
        val isNewValueValid = newValue >= tileModel.lowerlimit.toFloat()

        if (isNewValueValid) {
            if (currentValueFloat > 0.0f) currentValueFloat = newValue
            countOfMaxLimit = 1
        } else {
            countOfMaxLimit = 0
        }
        // notify change in value
        type?.let { onLimitChangeListener.onLimitChange(it,tileModel.label, currentValueFloat) }
    }

    // integrated here
    private fun ok() {

        tileClicked = false
        isCloseListenerAvoided = true
        cancelTimeout()
        when (type) {
            Constants.Companion.KnobSelectedType.TargetPressureType -> onKnobPressListener.onKnobPress(
                currentLable,
                currentValueFloat
            )
            else -> onKnobPressListener.onKnobPress(currentLable, currentValue)
        }
    }
}

