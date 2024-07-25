package com.agvahealthcare.ventilator_ext.data.api

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings.Secure
import android.util.Log
import com.agvahealthcare.ventilator_ext.data.api.model.alarmDataModel.AlarmRequestBodyModel
import com.agvahealthcare.ventilator_ext.data.api.model.CrashRequestBody
import com.agvahealthcare.ventilator_ext.data.api.model.EventRequestBodyModel
import com.agvahealthcare.ventilator_ext.data.api.model.LogResponseModel
import com.agvahealthcare.ventilator_ext.data.api.model.StatusRequestModel
import com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.*
import com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel
import com.agvahealthcare.ventilator_ext.presentation.utils.AppUtils
import com.agvahealthcare.ventilator_ext.presentation.utils.FileLogger
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ServerLogger {

    companion object{


        private fun sendCrashRequest(requestBodyModel: CrashRequestBody): Boolean {
            try {
                val okHttpClient = OkHttpClient.Builder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .build()

                val retrofit = Retrofit.Builder()
                    .baseUrl(FileLogger.readBaseUrl())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()

                val response = retrofit.create(LoggerApiService::class.java)
                val responseEvent = response.updateServerWithCrash(requestBodyModel).execute()

                Log.d("responseEventPass", responseEvent.message())
                responseEvent.body()?.let {
                    return it.status == 201 || it.statusCodeNew == 201
                } ?: kotlin.run {
                    return false
                }
            } catch (e: Exception) {
                e.printStackTrace()
                return false
            }
        }

        // done
        @SuppressLint("HardwareIds")
        fun d(ctx: Context, data: String, filename: String): Boolean {
            val requestBodyModel = CrashRequestBody()
            requestBodyModel.apply {
                did = Secure.getString(ctx.contentResolver, Secure.ANDROID_ID)
                msg = data
                file = filename
                date = AppUtils.getCurrentDateReverse()
            }

            Log.i("crashReposrt", requestBodyModel.toString())
            return sendCrashRequest(requestBodyModel)
        }

        // changes here for alarm
        @SuppressLint("HardwareIds")
        fun sendAlarm(ctx: Context, ackList: ArrayList<AlarmModel>): Boolean {
            val alarmRequestBodyModel = AlarmRequestBodyModel()
            alarmRequestBodyModel.did = Secure.getString(ctx.contentResolver, Secure.ANDROID_ID)
            alarmRequestBodyModel.type = "006"  // ToDO : add to build config
            alarmRequestBodyModel.ack = ArrayList(ackList.map { it.toAckModel() })
            return sendAlarmRequest(alarmRequestBodyModel)
        }

        private fun sendAlarmRequest(alarmRequestBodyModel: AlarmRequestBodyModel): Boolean {
            try {
                val okHttpClient = OkHttpClient.Builder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .build()

                val retrofit = Retrofit.Builder()
                    .baseUrl(FileLogger.readBaseUrl())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()

                val response = retrofit.create(LoggerApiService::class.java)
                Log.d("responseAlarmPass", alarmRequestBodyModel.toString())
                val responseEvent = response.updateServerWithAlarms(alarmRequestBodyModel).execute()
                responseEvent.body()?.let {
                    return it.status == 201 || it.statusCodeNew == 201
                } ?: kotlin.run {
                    return false
                }
            } catch (e: Exception) {
                Log.d("responseAlarmPass", e.toString())
                e.printStackTrace()
                return false
            }
        }

        @SuppressLint("HardwareIds")
        fun sendEvent(ctx: Context, message: String): Boolean {
            val eventRequestBodyModel = EventRequestBodyModel()
            eventRequestBodyModel.did = Secure.getString(ctx.contentResolver, Secure.ANDROID_ID)
            eventRequestBodyModel.type = "006"
            eventRequestBodyModel.message = message
            eventRequestBodyModel.date = AppUtils.getCurrentDateReverse()
            return sendEventRequest(eventRequestBodyModel)
        }

        // done
        private fun sendEventRequest(eventRequestBodyModel: EventRequestBodyModel): Boolean {
            try {
                val okHttpClient = OkHttpClient.Builder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .build()

                val retrofit = Retrofit.Builder()
                    .baseUrl(FileLogger.readBaseUrl())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()

                val response = retrofit.create(LoggerApiService::class.java)
                val responseEvent = response.updateServerWithEvents(eventRequestBodyModel).execute()
                // this log will represent the successful Hit to the server

                Log.d("responseEventPass", responseEvent.message())
                responseEvent.body()?.let {
                    return it.status == 201 || it.statusCodeNew == 201
                } ?: kotlin.run {
                    return false
                }
            } catch (e: Exception) {
                e.printStackTrace()
                return false
            }
        }

        fun sendServiceRequest(serviceRequestModel: ServiceRequestModel) : Response<LogResponseModel>?{

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(FileLogger.readBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            val response = retrofit.create(LoggerApiService::class.java)
            return try {
                val response = response.updateServerWithService(serviceRequestModel).execute()
                Log.i("value_Repsinse",response.toString())

                response
            } catch (e:Exception){
                Log.i("dataSuccessfully",e.message.toString())
                null
            }
        }

        fun getVentiDetailsRequest(deviceId:String) : VentiDetailsResponseModel?{

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(FileLogger.readBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()


            return try {
                val response = retrofit.create(LoggerApiService::class.java).getVentiDetailsRequest(deviceId).execute()
                Log.i("asds",response.toString())

                if (response.isSuccessful){
                    response.body()
                }else{
                    null
                }
            }catch (e:Exception){
                Log.i("valiueRead",e.toString())
                e.printStackTrace()
                null
            }
        }

        fun getServiceRequests(deviceId:String) : ResponseModel?{

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(FileLogger.readBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            return try {
                val response = retrofit.create(LoggerApiService::class.java).getServiceRequests(deviceId).execute()
                if (response.isSuccessful){
                    response.body()
                }else{
                    null
                }
            }catch (e:Exception){
                Log.i("valiueRead",e.message.toString())
                e.printStackTrace()
                null
            }

        }

        fun sendOtpVerifyForTicketClose(serviceOtpVerifyModel: ServiceOtpVerifyModel) : Boolean{

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(FileLogger.readBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            val response = retrofit.create(LoggerApiService::class.java)
            return try {
                val response = response.updateServerWithOtpVerifyForTicketClose(serviceOtpVerifyModel).execute()
                Log.i("dataSuccessfully","Successfully")
                response.isSuccessful
            } catch (e:Exception){
                Log.i("dataSuccessfully",e.message.toString())
                false
            }
        }

        // done
        fun sendStatusRequest(statusRequestModel: StatusRequestModel): Boolean {

            try {
                val okHttpClient = OkHttpClient.Builder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .build()

                val retrofit = Retrofit.Builder()
                    .baseUrl(FileLogger.readBaseUrl())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()

                val response = retrofit.create(LoggerApiService::class.java)
                val responseEvent = response.updateServerWithStatus(statusRequestModel).execute()
                // this log will represent the successful Hit to the server

                Log.d("responseEventPass", responseEvent.message())
                responseEvent.body()?.let {
                    return it.status == 201 || it.statusCodeNew == 201
                } ?: kotlin.run {
                    return false
                }

            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("responseEventPass", e.message.toString())
                return false
            }

        }

        fun sendServiceCloseRequest(serviceCloseRequestModel: ServiceCloseRequestModel) : Boolean{

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(FileLogger.readBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            val response = retrofit.create(LoggerApiService::class.java)
            return try {
                val response = response.sendServiceCloseRequest(serviceCloseRequestModel).execute()
                Log.i("dataSuccessfully","Successfully with $response")
                response.isSuccessful
            } catch (e:Exception){
                Log.i("dataSuccessfully",e.message.toString())
                false
            }
        }

        fun sendOtpVerifyRequest(serviceOtpVerifyModel: ServiceOtpVerifyModel) : Boolean{

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(FileLogger.readBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            val response = retrofit.create(LoggerApiService::class.java)
            return try {
                val response = response.updateServerWithOtpVerify(serviceOtpVerifyModel).execute()
                Log.i("dataSuccessfully","Successfully")
                response.isSuccessful
            } catch (e:Exception){
                Log.i("dataSuccessfully",e.message.toString())
                false
            }
        }

    }

}
