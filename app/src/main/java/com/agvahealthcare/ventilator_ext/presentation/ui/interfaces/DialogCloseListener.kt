package com.agvahealthcare.ventilator_ext.presentation.ui.interfaces

import com.agvahealthcare.ventilator_ext.presentation.utils.Constants

interface DialogCloseListener {
    fun onHandleDialogClose()
}

interface OnLimitChangeListener {
    fun onLimitChange(type: Constants.Companion.KnobSelectedType,label: String, newValue: Float)
    fun onLimitChange(type: Constants.Companion.KnobSelectedType,label: String, newValue: Int)
}

interface OnKnobPressListener {
    fun onKnobPress(label: String, newValue: Float)
    fun onKnobPress(label: String, newValue: Int)
}

