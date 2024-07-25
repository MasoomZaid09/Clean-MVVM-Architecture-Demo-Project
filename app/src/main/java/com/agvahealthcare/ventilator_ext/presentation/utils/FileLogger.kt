package com.agvahealthcare.ventilator_ext.presentation.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Environment
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.*
import java.text.SimpleDateFormat
import java.util.*

/*
 * Created by MOHIT MALHOTRA
 *
 * FileLogger : Class is customized to log data
 * in a separate file under a specific app folder
 */

abstract class FileLogger {

    companion object {

        enum class TypeOfCall{
            TYPE_FAIL,
            TYPE_PASS,
            TYPE_CHANGE
        }
        const val dataNotFound = "Data Not Found"
        private const val TAG = "FileLogger"
        private const val PATH_DEBUG_LOG_FILE = "debug_report"
        private const val PATH_EXCEPTION_LOG_FILE = "crash_report"

        @SuppressLint("SimpleDateFormat")
        private val fileDateTimeFormatter = SimpleDateFormat("YYYYMMdd_HHmmss")
        private val fileDateFormatter = SimpleDateFormat("YYYYMMdd")


        fun alarm(data: String) {
            writeAlarmFile(data)
        }

        fun event(data: String){
            writeEventFile(data)
        }

        fun alarmUhid(ctx: Context, data: String) {
            if (!writeAlarmUhidFile(ctx,  data)) {
                Log.w(TAG, "Unable to write to $PATH_DEBUG_LOG_FILE")
            }
        }

        fun eventUhid(ctx: Context, data: String) {
            if (!writeEventUhidFile(ctx,  data)) {
                Log.w(TAG, "Unable to write to $PATH_DEBUG_LOG_FILE")
            }
        }

        private fun writeAlarmUhidFile(ctx: Context, data: String): Boolean {
            var isSuccess = false

            val path = File(
                Environment.getExternalStorageDirectory(),
                AppUtils.PATH_FOLDER_AGVA + File.separator + "uhid"
            )
            val isPathAccessible = path.exists() || path.mkdirs()
            if (isPathAccessible) {

                val file = File(path, "alarm_uhids")

                try {

                    if (file.exists()) {
                        if (readAlarmUhidFile().contains(data.dropLast(data.length - 2))) return false

                        isSuccess = true
                        val fileOutPutStream = FileOutputStream(file, true)
                        fileOutPutStream.write(data.toByteArray())
                        fileOutPutStream.close()

                    } else {
                        if (file.createNewFile()) {
                            Log.i("ad989","7")
                            isSuccess = true
                            val fileOutPutStream = FileOutputStream(file)
                            fileOutPutStream.write(data.toByteArray())
                            fileOutPutStream.close()
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
            return isSuccess
        }

        private fun writeEventUhidFile(ctx: Context, data: String): Boolean {
            var isSuccess = false

            val path = File(
                Environment.getExternalStorageDirectory(),
                AppUtils.PATH_FOLDER_AGVA + File.separator + "uhid"
            )
            val isPathAccessible = path.exists() || path.mkdirs()
            if (isPathAccessible) {

                val file = File(path, "event_uhids")

                try {

                    if (file.exists()) {
                        if (readEventUhidFile().contains(data.dropLast(data.length - 2))) return false

                        isSuccess = true
                        val fileOutPutStream = FileOutputStream(file, true)
                        fileOutPutStream.write(data.toByteArray())
                        fileOutPutStream.close()

                    } else {
                        if (file.createNewFile()) {
                            Log.i("ad989","7")
                            isSuccess = true
                            val fileOutPutStream = FileOutputStream(file)
                            fileOutPutStream.write(data.toByteArray())
                            fileOutPutStream.close()
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
            return isSuccess
        }

        private fun writeEventFile(data: String): Boolean {
            var isSuccess = false

            val path = File(Environment.getExternalStorageDirectory(), AppUtils.PATH_FOLDER_AGVA + File.separator + "event")
            val isPathAccessible = path.exists() || path.mkdirs()
            if (isPathAccessible) {

                val file = File(path, "events")
                try {
                    if (file.exists()) {

                        if (file.readLines().size < 1000){
                            isSuccess = true
                            val fileOutPutStream = FileOutputStream(file, true)
                            fileOutPutStream.write(data.toByteArray())
                            fileOutPutStream.close()
                        }
                        else {

                        }
                    } else {
                        if (file.createNewFile()) {
                            isSuccess = true
                            val fileOutPutStream = FileOutputStream(file)
                            fileOutPutStream.write(data.toByteArray())
                            fileOutPutStream.close()
                        }
                    }
                }
                catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            return isSuccess
        }

        private fun writeAlarmFile(data: String): Boolean {
            var isSuccess = false

            val path = File(
                Environment.getExternalStorageDirectory(),
                AppUtils.PATH_FOLDER_AGVA + File.separator + "alarm"
            )
            val isPathAccessible = path.exists() || path.mkdirs()
            if (isPathAccessible) {

                val file = File(path, "alarms")
                try {
                    if (file.exists()) {

                        if (file.readLines().size < 1000){
                            isSuccess = true
                            val fileOutPutStream = FileOutputStream(file, true)
                            fileOutPutStream.write(data.toByteArray())
                            fileOutPutStream.close()
                        }else{

                        }

                    } else {
                        if (file.createNewFile()) {

                            isSuccess = true
                            val fileOutPutStream = FileOutputStream(file)
                            fileOutPutStream.write(data.toByteArray())
                            fileOutPutStream.close()
                        }
                    }
                }
                catch (e: Exception) {
                    e.printStackTrace()
                }

            }
            return isSuccess
        }

        // write crash file
        fun writeCrashFile(ctx: Context, data: String): Boolean {
            var isSuccess = false

            val path = File(
                Environment.getExternalStorageDirectory(),
                AppUtils.PATH_FOLDER_AGVA + File.separator + AppUtils.PATH_FOLDER_LOGS
            )
            val isPathAccessible = path.exists() || path.mkdirs()
            if (isPathAccessible) {
                Log.i(TAG, "Creating folder for AgVa")

                val file = File(path, "crash")
                try {
                    if (file.createNewFile()) {
                        isSuccess = true
                        val fileOutPutStream = FileOutputStream(file)
                        fileOutPutStream.write(data.toByteArray())
                        fileOutPutStream.close()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            return isSuccess
        }

        fun readCrashFile(): String {
            val filePath = Environment.getExternalStorageDirectory()
                .toString() + File.separator + AppUtils.PATH_FOLDER_AGVA + File.separator + AppUtils.PATH_FOLDER_LOGS + File.separator

            val file = File(filePath, "crash")
            var data = dataNotFound
            try {
                if (file.exists()) {
                    data =  file.readText()
                    file.delete()
                    return data
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return data
        }

        fun readBaseUrl(): String {
            val filePath = Environment.getExternalStorageDirectory()
                .toString() + File.separator + AppUtils.PATH_FOLDER_AGVA + File.separator + AppUtils.PATH_FOLDER_LOGS + File.separator

            val file = File(filePath, "baseurl")
            try {
                if (file.exists()) return file.readText()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return "http://172.23.100.128:8000"
        }
        //reading of file
        fun readEventFile(startIndex: Int, endIndex: Int, whereCondtion : String): String {

            var filePath = File(
                Environment.getExternalStorageDirectory(),
                AppUtils.PATH_FOLDER_AGVA + File.separator + "event"
            )
            filePath = File(filePath, "events")
            try {
                if (filePath.exists()) {
                    var data = ""
                    var startIndex = startIndex
                    var endIndex = endIndex
                    val fileSize = filePath.readLines().size - 1

                    if (whereCondtion == "Default"){
                        Log.i("asdasd",fileSize.toString())
                        if (fileSize == 0){
                            return dataNotFound
                        }
                        else {
                            if (fileSize > 10){
                                endIndex = fileSize
                                startIndex = fileSize - 10

                                for (i in endIndex downTo  startIndex){
                                    data += filePath.readLines()[i]
                                }
                            }else{
                                endIndex = fileSize
                                startIndex = 0
                                for (i in endIndex downTo  startIndex){
                                    data += filePath.readLines()[i]
                                }
                            }
                        }

                        data = "$data#$startIndex,$endIndex"
                        return data
                    }
                    else if (whereCondtion == "Increment"){

                        if (endIndex >= 10){
                            for (i in endIndex downTo  startIndex){
                                data += filePath.readLines()[i]
                            }
                        }
                        else{
                            return dataNotFound
                        }

                        data = "$data#$startIndex,$endIndex"
                        return data
                    }
                    else{
                        //decrement condition
                        if (startIndex <= fileSize - 10){
                            for (i in endIndex downTo  startIndex){
                                data += filePath.readLines()[i]
                            }
                        }
                        else{
                            return dataNotFound
                        }

                        data = "$data#$startIndex,$endIndex"
                        return data
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
                Log.i("dataClearAlarm", e.message.toString())
            }
            return dataNotFound
        }

        fun readAlarmFile(startIndex: Int, endIndex: Int, whereCondtion : String): String {

            var filePath = File(
                Environment.getExternalStorageDirectory(),
                AppUtils.PATH_FOLDER_AGVA + File.separator + "alarm"
            )
            filePath = File(filePath, "alarms")
            try {
                if (filePath.exists()) {
                    var data = ""
                    var startIndex = startIndex
                    var endIndex = endIndex
                    val fileSize = filePath.readLines().size - 1

                    if (whereCondtion == "Default"){
                        Log.i("asdasd",fileSize.toString())
                        if (fileSize == 0){
                            return dataNotFound
                        }
                        else {
                            if (fileSize > 10){
                                endIndex = fileSize
                                startIndex = fileSize - 10

                                for (i in endIndex downTo  startIndex){
                                    data += filePath.readLines()[i]
                                }
                            }else{
                                endIndex = fileSize
                                startIndex = 0
                                for (i in endIndex downTo  startIndex){
                                    data += filePath.readLines()[i]
                                }
                            }
                        }

                        data = "$data#$startIndex,$endIndex"
                        return data
                    }
                    else if (whereCondtion == "Increment"){

                        if (endIndex >= 10){
                            for (i in endIndex downTo  startIndex){
                                data += filePath.readLines()[i]
                            }
                        }
                        else{
                            return dataNotFound
                        }

                        data = "$data#$startIndex,$endIndex"
                        return data
                    }
                    else{
                        //decrement condition
                        if (startIndex <= fileSize - 10){
                            for (i in endIndex downTo  startIndex){
                                data += filePath.readLines()[i]
                            }
                        }
                        else{
                            return dataNotFound
                        }

                        data = "$data#$startIndex,$endIndex"
                        return data
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
                Log.i("dataClearAlarm", e.message.toString())
            }
            return dataNotFound
        }


        fun readAlarmUhidFile(): String {

            var setOfData = ""
            var filePath = File(
                Environment.getExternalStorageDirectory(),
                AppUtils.PATH_FOLDER_AGVA + File.separator + "uhid"
            )
            filePath = File(filePath, "alarm_uhids")
            try {
                Log.i("ad989","4")
                if (filePath.exists()) {
                    Log.i("ad989","5")
                    val fileSize = filePath.readLines().size
                    for (i in 0 until fileSize) {
                        setOfData += filePath.readLines()[i]
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
                Log.i("dataClearAlarm", e.message.toString())
            }
            return setOfData
        }

        fun readEventUhidFile(): String {

            var setOfData = ""
            var filePath = File(
                Environment.getExternalStorageDirectory(),
                AppUtils.PATH_FOLDER_AGVA + File.separator + "uhid"
            )
            filePath = File(filePath, "event_uhids")
            try {
                if (filePath.exists()) {

                    Log.i("masoom_zaid",filePath.readLines().size.toString())
                    val fileSize = filePath.readLines().size
                    for (i in 0 until fileSize) {
                        setOfData += filePath.readLines()[i]
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
                Log.i("dataClearEvent", e.message.toString())
            }
            return setOfData
        }

        fun d(ctx: Context?, err: Throwable) {
            if (ctx == null) {
                Log.w(TAG, "Context is null, Unable to log data")
                return
            }

            d(ctx, err.stackTraceToString())
        }

        fun d(ctx: Context, data: String) {
//            if (!writeFile(ctx, PATH_DEBUG_LOG_FILE, data)) {
//                Log.w(TAG, "Unable to write to " + PATH_DEBUG_LOG_FILE)
//            }
        }

        fun e(ctx: Context?, err: Throwable) {
            if (ctx == null) {
                Log.w(TAG, "Context is null, Unable to log data")
                return
            }
            e(ctx, err.stackTraceToString())
        }

        fun e(ctx: Context, data: String) {
//            if (!writeFile(ctx, PATH_EXCEPTION_LOG_FILE, data)) {
//                Log.w(TAG, "Unable to write to " + PATH_EXCEPTION_LOG_FILE)
//            }
        }

    }

}