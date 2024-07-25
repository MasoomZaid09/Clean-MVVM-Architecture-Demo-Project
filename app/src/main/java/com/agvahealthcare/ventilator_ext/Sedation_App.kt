package com.agvahealthcare.ventilator_ext

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.util.Log
import com.scichart.charting.visuals.SciChartSurface
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by MASOOM ZAID on 20-04-2023.
 */

@HiltAndroidApp
class Sedation_App :Application(){

    companion object{
        var isFromStandBy = false
        var tileClicked  : Boolean? = null
        private var CHANNEL_ID = "ventilatorApp"
        private var sInstance: Sedation_App? = null
        private var appVersion = "N/A"
        var therapyEndStarted = false
        var uhidDataListAlarm = listOf<String>()
        var uhidDataListEvent = listOf<String>()

        fun getInstance(): Sedation_App? {
            return sInstance
        }
    }


    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        setUpSciChartLicense()
    }

    private fun setUpSciChartLicense() {

        try {
            SciChartSurface.setRuntimeLicenseKey(BuildConfig.SCHICHART_API)
        } catch (e: Exception) {
            Log.e("SciChart", "Error when setting the license", e)
        }

    }

    private fun createNotificationChannel() {
        val serviceChannel = NotificationChannel(
            CHANNEL_ID,
            "Example Service Channel",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        val manager = getSystemService(
            NotificationManager::class.java
        )
        manager.createNotificationChannel(serviceChannel)
    }
}