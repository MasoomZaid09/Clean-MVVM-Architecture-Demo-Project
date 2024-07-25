package com.agvahealthcare.ventilator_ext.data.db.repository

import androidx.lifecycle.LiveData
import com.agvahealthcare.ventilator_ext.data.db.daos.ServiceDao
import com.agvahealthcare.ventilator_ext.database.entities.ServiceDataModel


class ServiceRepository(private val serviceDao: ServiceDao) {

    suspend fun addService(serviceDataModel: ServiceDataModel) {
        serviceDao.addService(serviceDataModel)
    }

    fun readAllService():LiveData<List<ServiceDataModel>> = serviceDao.readAllServices()
}