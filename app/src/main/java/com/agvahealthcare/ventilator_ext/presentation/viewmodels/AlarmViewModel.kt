package com.agvahealthcare.ventilator_ext.presentation.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.agvahealthcare.ventilator_ext.data.db.repository.AlarmRepository
import com.agvahealthcare.ventilator_ext.database.AgVaDatabase
import com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel
import com.agvahealthcare.ventilator_ext.presentation.utils.FileLogger
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class AlarmViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

    private val repository: AlarmRepository

    init {
        val alarmDao = AgVaDatabase.getInstance(application).alarmDao()
        repository= AlarmRepository(alarmDao)
    }

    fun addAlarm(ctx: Context, alarmDBModel: AlarmDBModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val alarmSingleLineData = "${alarmDBModel.createdAt},${alarmDBModel.message},${alarmDBModel.key},${alarmDBModel.uhid} |\n"
            val alarmUhidData = "${alarmDBModel.uhid} |\n"
            FileLogger.alarm(alarmSingleLineData)
            FileLogger.alarmUhid(ctx,alarmUhidData)
        }
    }

}