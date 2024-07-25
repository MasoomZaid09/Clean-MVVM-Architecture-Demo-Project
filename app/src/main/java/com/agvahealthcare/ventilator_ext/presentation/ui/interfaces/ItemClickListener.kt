package com.agvahealthcare.ventilator_ext.presentation.ui.interfaces

import com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class

interface OnTileSelectListener {
    fun onTileSelect(data: Tile_Model_Class)
}

interface OnLimitSelectListener {
    fun onLimitSelect(value:Boolean)
}

interface OnStandbyCLickListener {
    fun onStandby()
}
interface OnTherapyEndListener{
    fun onTherapyEnd()
}

interface OnStartSedationListener {
    fun onStartSedation(mode:Int)

}