package com.agvahealthcare.ventilator_ext.data.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/data/api/ServerLogger;", "", "()V", "Companion", "app_debug"})
public final class ServerLogger {
    @org.jetbrains.annotations.NotNull
    public static final com.agvahealthcare.ventilator_ext.data.api.ServerLogger.Companion Companion = null;
    
    public ServerLogger() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\bJ(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!J\u000e\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%J\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\'2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-\u00a8\u0006."}, d2 = {"Lcom/agvahealthcare/ventilator_ext/data/api/ServerLogger$Companion;", "", "()V", "d", "", "ctx", "Landroid/content/Context;", "data", "", "filename", "getServiceRequests", "Lcom/agvahealthcare/ventilator_ext/data/api/model/serviceDataModel/ResponseModel;", "deviceId", "getVentiDetailsRequest", "Lcom/agvahealthcare/ventilator_ext/data/api/model/serviceDataModel/VentiDetailsResponseModel;", "sendAlarm", "ackList", "Ljava/util/ArrayList;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/models/AlarmModel;", "Lkotlin/collections/ArrayList;", "sendAlarmRequest", "alarmRequestBodyModel", "Lcom/agvahealthcare/ventilator_ext/data/api/model/alarmDataModel/AlarmRequestBodyModel;", "sendCrashRequest", "requestBodyModel", "Lcom/agvahealthcare/ventilator_ext/data/api/model/CrashRequestBody;", "sendEvent", "message", "sendEventRequest", "eventRequestBodyModel", "Lcom/agvahealthcare/ventilator_ext/data/api/model/EventRequestBodyModel;", "sendOtpVerifyForTicketClose", "serviceOtpVerifyModel", "Lcom/agvahealthcare/ventilator_ext/data/api/model/serviceDataModel/ServiceOtpVerifyModel;", "sendOtpVerifyRequest", "sendServiceCloseRequest", "serviceCloseRequestModel", "Lcom/agvahealthcare/ventilator_ext/data/api/model/serviceDataModel/ServiceCloseRequestModel;", "sendServiceRequest", "Lretrofit2/Response;", "Lcom/agvahealthcare/ventilator_ext/data/api/model/LogResponseModel;", "serviceRequestModel", "Lcom/agvahealthcare/ventilator_ext/data/api/model/serviceDataModel/ServiceRequestModel;", "sendStatusRequest", "statusRequestModel", "Lcom/agvahealthcare/ventilator_ext/data/api/model/StatusRequestModel;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final boolean sendCrashRequest(com.agvahealthcare.ventilator_ext.data.api.model.CrashRequestBody requestBodyModel) {
            return false;
        }
        
        @android.annotation.SuppressLint(value = {"HardwareIds"})
        public final boolean d(@org.jetbrains.annotations.NotNull
        android.content.Context ctx, @org.jetbrains.annotations.NotNull
        java.lang.String data, @org.jetbrains.annotations.NotNull
        java.lang.String filename) {
            return false;
        }
        
        @android.annotation.SuppressLint(value = {"HardwareIds"})
        public final boolean sendAlarm(@org.jetbrains.annotations.NotNull
        android.content.Context ctx, @org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel> ackList) {
            return false;
        }
        
        private final boolean sendAlarmRequest(com.agvahealthcare.ventilator_ext.data.api.model.alarmDataModel.AlarmRequestBodyModel alarmRequestBodyModel) {
            return false;
        }
        
        @android.annotation.SuppressLint(value = {"HardwareIds"})
        public final boolean sendEvent(@org.jetbrains.annotations.NotNull
        android.content.Context ctx, @org.jetbrains.annotations.NotNull
        java.lang.String message) {
            return false;
        }
        
        private final boolean sendEventRequest(com.agvahealthcare.ventilator_ext.data.api.model.EventRequestBodyModel eventRequestBodyModel) {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable
        public final retrofit2.Response<com.agvahealthcare.ventilator_ext.data.api.model.LogResponseModel> sendServiceRequest(@org.jetbrains.annotations.NotNull
        com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.ServiceRequestModel serviceRequestModel) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.VentiDetailsResponseModel getVentiDetailsRequest(@org.jetbrains.annotations.NotNull
        java.lang.String deviceId) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.ResponseModel getServiceRequests(@org.jetbrains.annotations.NotNull
        java.lang.String deviceId) {
            return null;
        }
        
        public final boolean sendOtpVerifyForTicketClose(@org.jetbrains.annotations.NotNull
        com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.ServiceOtpVerifyModel serviceOtpVerifyModel) {
            return false;
        }
        
        public final boolean sendStatusRequest(@org.jetbrains.annotations.NotNull
        com.agvahealthcare.ventilator_ext.data.api.model.StatusRequestModel statusRequestModel) {
            return false;
        }
        
        public final boolean sendServiceCloseRequest(@org.jetbrains.annotations.NotNull
        com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.ServiceCloseRequestModel serviceCloseRequestModel) {
            return false;
        }
        
        public final boolean sendOtpVerifyRequest(@org.jetbrains.annotations.NotNull
        com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.ServiceOtpVerifyModel serviceOtpVerifyModel) {
            return false;
        }
    }
}