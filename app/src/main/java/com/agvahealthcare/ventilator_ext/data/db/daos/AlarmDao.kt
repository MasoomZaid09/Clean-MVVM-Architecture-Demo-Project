package com.agvahealthcare.ventilator_ext.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel

@Dao
interface AlarmDao {

    @Insert(onConflict = OnConflictStrategy.ABORT) // <- Annotate the 'addUser' function below. Set the onConflict strategy to IGNORE so if exactly the same user exists, it will just ignore it.
    suspend fun addAlarmData(alarmDBModel: AlarmDBModel)

    @Query("SELECT * FROM alarm_table ORDER BY id DESC LIMIT 12" ) // <- Add a query to fetch all users (in user_table) in ascending order by their IDs.
    fun readAllAlarms(): LiveData<List<AlarmDBModel>>

    //Uhid filter for the events and alarms
    @Query("SELECT * FROM (SELECT * FROM alarm_table ORDER BY id DESC) WHERE id < :id1 LIMIT 12" )
    suspend fun readAlarmsByOld(id1: Int) : List<AlarmDBModel>

    //Uhid filter for the events and alarms
    @Query("SELECT * FROM alarm_table WHERE id > :id1 LIMIT 12" )
    suspend fun readAlarmsByNew(id1: Int) : List<AlarmDBModel>

    //Uhid filter for the events and alarms
    @Query("SELECT DISTINCT Uhid FROM alarm_table")
    fun readAllUhid(): LiveData<List<String>>

    @Query("SELECT * FROM alarm_table WHERE Uhid= :uhid1 ORDER BY id DESC LIMIT 12" ) // <- Add a query to fetch all users (in user_table) in ascending order by their IDs.
    fun readAllAlarmsUhid(uhid1: String): LiveData<List<AlarmDBModel>>

    //Uhid filter for the events and alarms
    @Query("SELECT * FROM alarm_table WHERE Uhid= :uhid1 AND id > :id1 LIMIT 12" )
    suspend fun readAlarmsByUhidNew(uhid1: String,id1: Int) : List<AlarmDBModel>

    //Uhid filter for the events and alarms
    @Query("SELECT * FROM (SELECT * FROM alarm_table ORDER BY id DESC) WHERE Uhid= :uhid1 AND id < :id1 LIMIT 12" )
    suspend fun readAlarmsByUhidOld(uhid1: String,id1: Int) : List<AlarmDBModel>

    // code for delete alarms size
    @Query("SELECT * FROM alarm_table ORDER BY id DESC")
    fun getAllAlarms() :LiveData<List<AlarmDBModel>>

    @Query("DELETE FROM alarm_table WHERE id < :id1")
    suspend fun deleteAlarms(id1: Int)
}