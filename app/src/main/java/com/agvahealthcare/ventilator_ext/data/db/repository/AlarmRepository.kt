package com.agvahealthcare.ventilator_ext.data.db.repository

import androidx.lifecycle.LiveData
import com.agvahealthcare.ventilator_ext.data.db.daos.AlarmDao
import com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel

class AlarmRepository(private val alarmDao: AlarmDao) {

    suspend fun addAlarmData(alarmDBModel: AlarmDBModel) {
        alarmDao.addAlarmData(alarmDBModel)
    }

    fun getAllAlarms() : LiveData<List<AlarmDBModel>>  =alarmDao.getAllAlarms()
    suspend fun deleteAlarms(id: Int) = alarmDao.deleteAlarms(id)

//    fun readAllAlarms(uhid: String):LiveData<List<AlarmDBModel>> = alarmDao.readAllAlarms(uhid)
//    suspend fun readAlarmsByUhidNew(uhid: String,id: Int): List<AlarmDBModel> = alarmDao.readAlarmsByUhidNew(uhid,id)
//    suspend fun readAlarmsByUhidOld(uhid: String,id: Int): List<AlarmDBModel> = alarmDao.readAlarmsByUhidOld(uhid,id)

    fun readAllAlarms(uhid: String):LiveData<List<AlarmDBModel>> = if (uhid=="All") alarmDao.readAllAlarms() else alarmDao.readAllAlarmsUhid(uhid)
    suspend fun readAlarmsByUhidNew(uhid: String,id: Int): List<AlarmDBModel> = if (uhid=="All") alarmDao.readAlarmsByNew(id) else alarmDao.readAlarmsByUhidNew(uhid,id)
    suspend fun readAlarmsByUhidOld(uhid: String,id: Int): List<AlarmDBModel> = if (uhid=="All") alarmDao.readAlarmsByOld(id) else alarmDao.readAlarmsByUhidOld(uhid,id)
}