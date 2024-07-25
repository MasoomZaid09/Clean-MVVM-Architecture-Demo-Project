package com.agvahealthcare.ventilator_ext.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.agvahealthcare.ventilator_ext.database.entities.ServiceDataModel


@Dao
interface ServiceDao {

    @Insert(onConflict = OnConflictStrategy.ABORT) // <- Annotate the 'addUser' function below. Set the onConflict strategy to IGNORE so if exactly the same user exists, it will just ignore it.
    suspend fun addService(serviceDataModel: ServiceDataModel)

    @Query("SELECT * FROM service_table ORDER BY id DESC" ) // <- Add a query to fetch all users (in user_table) in ascending order by their IDs.
    fun readAllServices(): LiveData<List<ServiceDataModel>>
}