package com.agvahealthcare.ventilator_ext.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel

// UserDao contains the methods used for accessing the database, including queries.
@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.ABORT) // <- Annotate the 'addUser' function below. Set the onConflict strategy to IGNORE so if exactly the same user exists, it will just ignore it.
    suspend fun addEventData(eventDataModel: EventDataModel)

    @Update
    suspend fun updateEventData(eventDataModel: EventDataModel)

    @Delete
    suspend fun deleteEventData(eventDataModel: EventDataModel)

    @Query("DELETE FROM event_table")
    suspend fun deleteAllEvents()

    @Query("SELECT * FROM event_table ORDER BY id DESC LIMIT 11" ) // <- Add a query to fetch all users (in user_table) in ascending order by their IDs.
    fun readAllEvents(): LiveData<List<EventDataModel>>

    //Uhid filter for the events and alarms
    @Query("SELECT * FROM event_table WHERE id > :id1 LIMIT 11" )
    suspend fun readEventsByNew(id1: Int) : List<EventDataModel>

    //Uhid filter for the events and alarms
    @Query("SELECT * FROM (SELECT * FROM event_table ORDER BY id DESC) WHERE id < :id1 LIMIT 11" )
    suspend fun readEventsByOld(id1: Int) : List<EventDataModel>

    //Uhid filter for the events and alarms
    @Query("SELECT DISTINCT Uhid FROM event_table")
    fun readAllUhid(): LiveData<List<String>>

    @Query("SELECT * FROM event_table WHERE Uhid= :uhid ORDER BY id DESC LIMIT 11" ) // <- Add a query to fetch all users (in user_table) in ascending order by their IDs.
    fun readAllEventsUhid(uhid: String): LiveData<List<EventDataModel>>

    //Uhid filter for the events and alarms
    @Query("SELECT * FROM event_table WHERE Uhid= :uhid AND id > :id1 LIMIT 11" )
    suspend fun readEventsByUhidNew(uhid: String,id1: Int) : List<EventDataModel>

    //Uhid filter for the events and alarms
    @Query("SELECT * FROM (SELECT * FROM event_table ORDER BY id DESC) WHERE Uhid= :uhid AND id < :id1 LIMIT 11" )
    suspend fun readEventsByUhidOld(uhid: String,id1: Int) : List<EventDataModel>

    // code for delete events size
    @Query("SELECT * FROM event_table ORDER BY id DESC")
    fun getAllEvents() :LiveData<List<EventDataModel>>

    @Query("DELETE FROM event_table WHERE id < :id1")
    suspend fun deleteEvents(id1: Int)
}