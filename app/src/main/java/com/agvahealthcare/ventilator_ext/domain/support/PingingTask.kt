package com.agvahealthcare.ventilator_ext.domain.support

import android.os.CountDownTimer
import android.util.Log

class PingingTask(service: com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService?) {
    var isRunning = false
        private set
    private val service: com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService?
    private val pingingTimer: CountDownTimer? =
        object : CountDownTimer(PINGING_SESSION_LIFE, PINGING_INTERVAL) {
            override fun onTick(millisUntilFinished: Long) {
                sendPinging()
            }

            override fun onFinish() {
                Log.w(TAG, "Pinging thread rebooted itself")
                this.start()
            }
        }

    init {
        this.service = service
    }

    fun setRunningState(isRunning: Boolean) {
        this.isRunning = isRunning
    }

    /*
     * Sends handshake to ventilator
     * NOTE : use only after gatt connects
     */
    private fun sendPinging() {
        // INFORM VENTILATOR ABOUT THE CONNECTION
        if (service != null) {
            if (service is com.agvahealthcare.ventilator_ext.domain.support.service.UsbService) {
                Log.i(TAG, "Pinging ventilator through USB")
                service.send("_")
                service.sendDatatoKnob("-")
            }
        }
    }

    fun start() {
        if (pingingTimer != null && !isRunning) {
            pingingTimer.start()
            isRunning = true
            Log.w(TAG, "Pinging thread started")
        }
    }

    fun stop() {
        if (pingingTimer != null) {
            pingingTimer.cancel()
            isRunning = false
            Log.w(TAG, "Pinging thread killed")
        }
    }

    companion object {
        private const val TAG = "PINGING THREAD"
        private const val PINGING_INTERVAL = (1000 * 3 // 10 secs
                ).toLong()
        private const val PINGING_SESSION_LIFE = (1000 * 60 * 60 // 60 mins
                ).toLong()
    }
}