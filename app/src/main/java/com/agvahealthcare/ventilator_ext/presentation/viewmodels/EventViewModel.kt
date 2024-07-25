package com.agvahealthcare.ventilator_ext.presentation.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.agvahealthcare.ventilator_ext.data.api.ServerLogger
import com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel
import com.agvahealthcare.ventilator_ext.data.db.repository.EventRepository
import com.agvahealthcare.ventilator_ext.database.AgVaDatabase
import com.agvahealthcare.ventilator_ext.presentation.utils.FileLogger
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

//This class is for the data to be sent to the server for the events from the ventilator.

@HiltViewModel
class EventViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

    fun addEvent(ctx: Context, eventDataModel: EventDataModel) {
        CoroutineScope(Dispatchers.IO).launch {
            val eventSingleLineData = "${eventDataModel.timeStamp},${eventDataModel.event},${eventDataModel.uhid} |\n"
            val eventuhidData = "${eventDataModel.uhid} |\n"
            FileLogger.event(eventSingleLineData)
            FileLogger.eventUhid(ctx, eventuhidData)
            ServerLogger.sendEvent(getApplication(), eventDataModel.event)
        }
    }

}
