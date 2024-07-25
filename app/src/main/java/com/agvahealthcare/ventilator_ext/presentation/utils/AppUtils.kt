package com.agvahealthcare.ventilator_ext.presentation.utils

import android.content.Context
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by MASOOM ZAID on 23-04-2023.
 */

object AppUtils {

    const val PATH_FOLDER_AGVA = ".Sedation"
    const val PATH_FOLDER_LOGS = "logs"
    const val PATH_FOLDER_SYSSNAPSHOT = "snapshots"
    const val PATH_FOLDER_SERVICE_AND_OP_MOD = ".servop"
    val ventDateTimeFormatter = SimpleDateFormat("yyyyMMddHH:mm:ss")
    val timeFormatter = SimpleDateFormat("HH:mm:ss")
    val timeHourMinuteFormatter = SimpleDateFormat("HH:mm")
    val errorDateTimeFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val dateTimeFormatter = SimpleDateFormat("dd-MM-yyyy HH:mm")
    val dateTimeFormatterTest = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
    val dateFormatterReverse = SimpleDateFormat("yyy-MM-dd")
    val dateFormatter = SimpleDateFormat("dd-MM-yyyy")
    var decimalFormat = DecimalFormat("0")
    // Does not let the screen die for the @param activity
    fun keepScreenAlive(activity: AppCompatActivity, isAlive: Boolean) {
        if (isAlive) activity.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON) else activity.window.clearFlags(
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
        )
    }

    fun getCurrentDateTime(): String? {
        return AppUtils.dateTimeFormatterTest.format(Date())
    }

    fun getCurrentDateReverse(): String? {
        return AppUtils.errorDateTimeFormatter.format(Date())
    }


    fun getCurrentDateTimeForTrends(): String? {
        return AppUtils.timeHourMinuteFormatter.format(Date())
    }

    fun getCurrentTime(): String? {
        return AppUtils.timeFormatter.format(Date())
    }

    fun getCurrentDate(): String? {
        return AppUtils.dateFormatter.format(Date())
    }

    fun hideKeyBoard(context: Context, view: View) {
        try {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        } catch (error: Error) {
            Log.e("error", "Keyboard hiding issue$error")
        }
    }
}