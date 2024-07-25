package com.agvahealthcare.ventilator_ext.presentation.viewmodels

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel
import com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CommonViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

//     alarm vars
    val alarms = MutableLiveData(PriorityQueue<AlarmModel>(AlarmComparator()))
    private val arrayListTemp = MutableLiveData(arrayListOf<AlarmModel>())
    private val ALARM_BUFFER_THRESHOLD = 5
    private val alarmBuffer = arrayListOf<AlarmModel>()

    val isLogsTrendsFragmentVisible=MutableLiveData<Boolean>()
    fun updateIsLogsTrendsFragmentVisible(flag:Boolean){
        isLogsTrendsFragmentVisible.value=flag
    }

    val isLogsEventsFragmentVisible= MutableLiveData<Boolean>()
    fun updateIsEventsFragmentVisible(flag:Boolean){
        isLogsEventsFragmentVisible.value=flag
    }

    val isLogsAlarmFragmentVisible= MutableLiveData<Boolean>()
    fun updateIsAlarmsFragmentVisible(flag:Boolean){
        isLogsAlarmFragmentVisible.value=flag
    }

    val ventBatteryLevel = MutableLiveData<Int>()
    fun setVentBatteryLevel(batteryLevel: Int) {
        ventBatteryLevel.value = batteryLevel
    }

    val isBatteryConnected=MutableLiveData<Boolean>()
    val o2PressureValue = MutableLiveData<Int>()
    val n2oPressureValue = MutableLiveData<Int>()

    val graphPeekValue = MutableLiveData<String>()
    var _graphData : MutableLiveData<Pair<String,String>> = MutableLiveData()
    var therapyEndData : MutableLiveData<Pair<Int,Int>> = MutableLiveData()
    var currentModeCode : MutableLiveData<Int> = MutableLiveData()
    var clickedSubMenuItem : MutableLiveData<Constants.Companion.AllSubMenuType> = MutableLiveData()
    var clickedControlItem : MutableLiveData<Constants.Companion.AllControlType> = MutableLiveData()

    fun addAlarm(ctx: Context, alarmDBModel: AlarmDBModel) {
//        viewModelScope.launch(Dispatchers.IO) {
//            val alarmSingleLineData = "${alarmDBModel.createdAt},${alarmDBModel.message},${alarmDBModel.key},${alarmDBModel.uhid} |\n"
//            FileLogger.alarm(ctx, alarmSingleLineData)
//        }
    }


    fun removeAlarm(alarm: AlarmModel){
        Log.d("alarmremove",alarm.code)
        arrayListTemp.value?.remove(alarm)
        arrayListTemp.notifyObserver()
        alarms.value?.remove(alarm)
        alarms.notifyObserver()
    }


    fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }


    open class AlarmComparator : Comparator<AlarmModel> {

        override fun compare(
            p0: AlarmModel,
            p1: AlarmModel): Int {
            if(p0.priority < p1.priority) return 1 else if (p0.priority > p1.priority) return  -1
            return  0
        }
    }


    fun addAlarm(alarm: AlarmModel){

        alarms.value?.let {
            arrayListTemp.value?.add(alarm)
            it.add(alarm)
            if(alarmBuffer.size < ALARM_BUFFER_THRESHOLD) alarmBuffer.add(alarm)
            else {
//                ServerLogger.sendAlarm(getApplication(), ArrayList(alarmBuffer))
                alarmBuffer.clear()
            }
            Log.d("alarmadd",alarm.code)

        }

        arrayListTemp.notifyObserver()
        alarms.notifyObserver()
    }
}