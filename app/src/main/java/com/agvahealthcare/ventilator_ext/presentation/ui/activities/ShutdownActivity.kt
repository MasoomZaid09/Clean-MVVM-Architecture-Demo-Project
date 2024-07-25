package com.agvahealthcare.ventilator_ext.presentation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.Sedation_App
import com.agvahealthcare.ventilator_ext.presentation.utils.DialogBoxFactory
import org.w3c.dom.Text

/**
 * Created by MASOOM ZAID on 20-04-2023.
 */


class ShutdownActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shutdown)

        var tvVersion = findViewById<TextView>(R.id.tvVersion)

        val shutdownTimer = object : CountDownTimer(30000,1000){
            override fun onTick(millisUntilFinished: Long) {
                Log.i("shutdown clock tick",millisUntilFinished.toString())
            }

            override fun onFinish() {

            }
        }
        shutdownTimer.start()
    }



}