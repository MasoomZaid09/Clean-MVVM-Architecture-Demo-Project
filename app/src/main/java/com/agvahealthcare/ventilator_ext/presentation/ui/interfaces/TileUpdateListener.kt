package com.agvahealthcare.ventilator_ext.presentation.ui.interfaces

/**
 * Created by MASOOM ZAID on 20-04-2023.
 */


// need to discuss about update listener
interface TileUpdateListener {
    fun updateTileData(isInc:Boolean,lbl:String)
}
interface OnMenuChangeListener {
    fun onMenuChange(position: Int)
}