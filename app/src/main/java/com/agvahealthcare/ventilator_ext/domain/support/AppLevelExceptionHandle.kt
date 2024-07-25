package com.agvahealthcare.ventilator_ext.domain.support

import android.content.Context
import android.content.Intent
import android.util.Log
import com.agvahealthcare.ventilator_ext.presentation.ui.activities.SplashActivity
import com.agvahealthcare.ventilator_ext.presentation.utils.FileLogger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Thread.UncaughtExceptionHandler

class AppLevelExceptionHandle(var context : Context) :UncaughtExceptionHandler {

    override fun uncaughtException(thread: Thread, exception: Throwable) {


        CoroutineScope(Dispatchers.IO).launch {
            FileLogger.writeCrashFile(context,exception.stackTraceToString())
        }

        Intent(context, SplashActivity::class.java).also {
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(it)
        }
        System.exit(2)
    }
}