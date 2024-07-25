package com.agvahealthcare.ventilator_ext.data.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006H\'J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\rH\'J\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\'J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\'J\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\'J\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\'J\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\'J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u001dH\'J\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u001f\u001a\u00020 H\'\u00a8\u0006!"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/data/api/LoggerApiService;", "", "getServiceRequests", "Lretrofit2/Call;", "Lcom/agvahealthcare/ventilator_ext/data/api/model/serviceDataModel/ResponseModel;", "deviceId", "", "project_code", "getVentiDetailsRequest", "Lcom/agvahealthcare/ventilator_ext/data/api/model/serviceDataModel/VentiDetailsResponseModel;", "sendServiceCloseRequest", "Lcom/agvahealthcare/ventilator_ext/data/api/model/LogResponseModel;", "serviceCloseRequestModel", "Lcom/agvahealthcare/ventilator_ext/data/api/model/serviceDataModel/ServiceCloseRequestModel;", "updateServerWithAlarms", "alarmRequestBodyModel", "Lcom/agvahealthcare/ventilator_ext/data/api/model/alarmDataModel/AlarmRequestBodyModel;", "updateServerWithCrash", "requestBodyModel", "Lcom/agvahealthcare/ventilator_ext/data/api/model/CrashRequestBody;", "updateServerWithEvents", "eventRequestBodyModel", "Lcom/agvahealthcare/ventilator_ext/data/api/model/EventRequestBodyModel;", "updateServerWithOtpVerify", "serviceOtpVerifyModel", "Lcom/agvahealthcare/ventilator_ext/data/api/model/serviceDataModel/ServiceOtpVerifyModel;", "updateServerWithOtpVerifyForTicketClose", "updateServerWithService", "serviceRequestModel", "Lcom/agvahealthcare/ventilator_ext/data/api/model/serviceDataModel/ServiceRequestModel;", "updateServerWithStatus", "statusRequestModel", "Lcom/agvahealthcare/ventilator_ext/data/api/model/StatusRequestModel;", "app_debug"})
public abstract interface LoggerApiService {
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.POST(value = "api/logger/logs/v2/status/006")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<com.agvahealthcare.ventilator_ext.data.api.model.LogResponseModel> updateServerWithStatus(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.agvahealthcare.ventilator_ext.data.api.model.StatusRequestModel statusRequestModel);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.POST(value = "api/logger/logs/v2/006")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<com.agvahealthcare.ventilator_ext.data.api.model.LogResponseModel> updateServerWithCrash(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.agvahealthcare.ventilator_ext.data.api.model.CrashRequestBody requestBodyModel);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.POST(value = "api/logger/logs/v2/alerts-new/006")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<com.agvahealthcare.ventilator_ext.data.api.model.LogResponseModel> updateServerWithAlarms(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.agvahealthcare.ventilator_ext.data.api.model.alarmDataModel.AlarmRequestBodyModel alarmRequestBodyModel);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.POST(value = "api/logger/logs/v2/events/006")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<com.agvahealthcare.ventilator_ext.data.api.model.LogResponseModel> updateServerWithEvents(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.agvahealthcare.ventilator_ext.data.api.model.EventRequestBodyModel eventRequestBodyModel);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.POST(value = "api/logger/logs/services/v2/006")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<com.agvahealthcare.ventilator_ext.data.api.model.LogResponseModel> updateServerWithService(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.ServiceRequestModel serviceRequestModel);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.POST(value = "api/logger/logs/services/verify-sms-otp/006")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<com.agvahealthcare.ventilator_ext.data.api.model.LogResponseModel> updateServerWithOtpVerify(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.ServiceOtpVerifyModel serviceOtpVerifyModel);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.POST(value = "api/logger/logs/services/verify-otp-for-ticket-close/006")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<com.agvahealthcare.ventilator_ext.data.api.model.LogResponseModel> updateServerWithOtpVerifyForTicketClose(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.ServiceOtpVerifyModel serviceOtpVerifyModel);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.POST(value = "api/logger/logs/services/ticket-status/006")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<com.agvahealthcare.ventilator_ext.data.api.model.LogResponseModel> sendServiceCloseRequest(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.ServiceCloseRequestModel serviceCloseRequestModel);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.GET(value = "api/logger/logs/services/get-by-deviceId")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.ResponseModel> getServiceRequests(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "deviceId")
    java.lang.String deviceId, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "project_code")
    java.lang.String project_code);
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.GET(value = "devices/getdevice/v2/{deviceId}")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.VentiDetailsResponseModel> getVentiDetailsRequest(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "deviceId")
    java.lang.String deviceId);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
    }
}