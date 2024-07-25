package com.agvahealthcare.ventilator_ext.data.db.repository

import androidx.lifecycle.LiveData
import com.agvahealthcare.ventilator_ext.data.db.daos.EventDao
import com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel

// User Repository abstracts access to multiple data sources. However this is not the part of the Architecture Component libraries.

class EventRepository(private val eventDao: EventDao) {


    suspend fun addEventData(eventDataModel: EventDataModel) {
         eventDao.addEventData(eventDataModel)
    }

    fun getAllEvents() : LiveData<List<EventDataModel>>  =eventDao.getAllEvents()
    suspend fun deleteEvents(id: Int) = eventDao.deleteEvents(id)

    //Uhid filter for the events and alarms
    fun readAllUhid():LiveData<List<String>> = eventDao.readAllUhid()

//    fun readAllEvents(uhid: String):LiveData<List<EventDataModel>> = eventDao.readAllEvents(uhid)
//    suspend fun readEventsByUhidNew(uhid: String,id: Int): List<EventDataModel> = eventDao.readEventsByUhidNew(uhid,id)
//    suspend fun readEventsByUhidOld(uhid: String,id: Int): List<EventDataModel> = eventDao.readEventsByUhidOld(uhid,id)
//
    fun readAllEvents(uhid: String):LiveData<List<EventDataModel>> = if (uhid=="All") eventDao.readAllEvents() else eventDao.readAllEventsUhid(uhid)
    suspend fun readEventsByUhidNew(uhid: String,id: Int): List<EventDataModel> = if (uhid=="All") eventDao.readEventsByNew(id) else eventDao.readEventsByUhidNew(uhid,id)
    suspend fun readEventsByUhidOld(uhid: String,id: Int): List<EventDataModel> = if (uhid=="All") eventDao.readEventsByOld(id) else eventDao.readEventsByUhidOld(uhid,id)


    suspend fun updateEventData(eventDataModel: EventDataModel) {
            eventDao.updateEventData(eventDataModel)
    }

    suspend fun deleteEventData(eventDataModel: EventDataModel) {
            eventDao.deleteEventData(eventDataModel)
    }

    suspend fun deleteAllEvents() {
            eventDao.deleteAllEvents()
    }

}