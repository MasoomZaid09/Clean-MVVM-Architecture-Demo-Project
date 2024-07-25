package com.agvahealthcare.ventilator_ext.data.api

import com.agvahealthcare.ventilator_ext.data.api.model.CrashRequestBody
import com.agvahealthcare.ventilator_ext.data.api.model.EventRequestBodyModel
import com.agvahealthcare.ventilator_ext.data.api.model.LogResponseModel
import com.agvahealthcare.ventilator_ext.data.api.model.StatusRequestModel
import com.agvahealthcare.ventilator_ext.data.api.model.alarmDataModel.AlarmRequestBodyModel
import com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LoggerApiService {

    //interface for the retrofit to make a crash update on the server
    @Headers("Content-Type: application/json")
    @POST("api/logger/logs/v2/status/006")
    fun updateServerWithStatus(@Body statusRequestModel: StatusRequestModel):Call<LogResponseModel>

    @Headers( "Content-Type: application/json" )
    @POST("api/logger/logs/v2/006")
    fun updateServerWithCrash(@Body requestBodyModel: CrashRequestBody):Call<LogResponseModel>

    @Headers("Content-Type: application/json")
    @POST("api/logger/logs/v2/alerts-new/006")
    fun updateServerWithAlarms(@Body alarmRequestBodyModel: AlarmRequestBodyModel):Call<LogResponseModel>

    @Headers("Content-Type: application/json")
    @POST("api/logger/logs/v2/events/006")
    fun updateServerWithEvents(@Body eventRequestBodyModel: EventRequestBodyModel):Call<LogResponseModel>

    @Headers("Content-Type: application/json")
    @POST("api/logger/logs/services/v2/006")
    fun updateServerWithService(@Body serviceRequestModel: ServiceRequestModel):Call<LogResponseModel>

    @Headers("Content-Type: application/json")
    @POST("api/logger/logs/services/verify-sms-otp/006")
    fun updateServerWithOtpVerify(@Body serviceOtpVerifyModel: ServiceOtpVerifyModel):Call<LogResponseModel>

    @Headers("Content-Type: application/json")
    @POST("api/logger/logs/services/verify-otp-for-ticket-close/006")
    fun updateServerWithOtpVerifyForTicketClose(@Body serviceOtpVerifyModel: ServiceOtpVerifyModel):Call
    <LogResponseModel>

    @Headers("Content-Type: application/json")
    @POST("api/logger/logs/services/ticket-status/006")
    fun sendServiceCloseRequest(@Body serviceCloseRequestModel: ServiceCloseRequestModel):Call<LogResponseModel>

    @Headers("Content-Type: application/json")
    @GET("api/logger/logs/services/get-by-deviceId")
    fun getServiceRequests(@Query("deviceId") deviceId: String, @Query("project_code") project_code: String = "003"):Call<ResponseModel>

    @Headers("Content-Type: application/json")
    @GET("devices/getdevice/v2/{deviceId}")
    fun getVentiDetailsRequest(@Path("deviceId") deviceId: String):Call<VentiDetailsResponseModel>
}