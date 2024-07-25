package com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016\u00a8\u0006\'"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/data/api/model/serviceDataModel/Data;", "", "ServiceRequest_id", "", "ServiceRequestContactNo", "ServiceRequestDate", "ServiceRequestDepartment", "ServiceRequestDeviceId", "ServiceRequestEmail", "ServiceRequestHospitalName", "ServiceRequestIsVerified", "", "ServiceRequestMessage", "ServiceRequestName", "ServiceRequestOtp", "ServiceRequestSerialNo", "ServiceRequestTicketStatus", "ServiceRequestWardNo", "ticketStatus", "serviceEngName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getServiceRequestContactNo", "()Ljava/lang/String;", "getServiceRequestDate", "getServiceRequestDepartment", "getServiceRequestDeviceId", "getServiceRequestEmail", "getServiceRequestHospitalName", "getServiceRequestIsVerified", "()Z", "getServiceRequestMessage", "getServiceRequestName", "getServiceRequestOtp", "getServiceRequestSerialNo", "getServiceRequestTicketStatus", "getServiceRequestWardNo", "getServiceRequest_id", "getServiceEngName", "getTicketStatus", "app_debug"})
public final class Data {
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "_id")
    private final java.lang.String ServiceRequest_id = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "contactNo")
    private final java.lang.String ServiceRequestContactNo = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "date")
    private final java.lang.String ServiceRequestDate = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "department")
    private final java.lang.String ServiceRequestDepartment = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "deviceId")
    private final java.lang.String ServiceRequestDeviceId = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "email")
    private final java.lang.String ServiceRequestEmail = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "hospitalName")
    private final java.lang.String ServiceRequestHospitalName = null;
    @com.google.gson.annotations.SerializedName(value = "isVerified")
    private final boolean ServiceRequestIsVerified = false;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "message")
    private final java.lang.String ServiceRequestMessage = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "name")
    private final java.lang.String ServiceRequestName = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "otp")
    private final java.lang.String ServiceRequestOtp = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "serialNo")
    private final java.lang.String ServiceRequestSerialNo = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "currentPage")
    private final java.lang.String ServiceRequestTicketStatus = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "wardNo")
    private final java.lang.String ServiceRequestWardNo = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "ticketStatus")
    private final java.lang.String ticketStatus = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "serviceEngName")
    private final java.lang.String serviceEngName = null;
    
    public Data(@org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequest_id, @org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequestContactNo, @org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequestDate, @org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequestDepartment, @org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequestDeviceId, @org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequestEmail, @org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequestHospitalName, boolean ServiceRequestIsVerified, @org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequestMessage, @org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequestName, @org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequestOtp, @org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequestSerialNo, @org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequestTicketStatus, @org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequestWardNo, @org.jetbrains.annotations.NotNull
    java.lang.String ticketStatus, @org.jetbrains.annotations.NotNull
    java.lang.String serviceEngName) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequest_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequestContactNo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequestDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequestDepartment() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequestDeviceId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequestEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequestHospitalName() {
        return null;
    }
    
    public final boolean getServiceRequestIsVerified() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequestMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequestName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequestOtp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequestSerialNo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequestTicketStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequestWardNo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTicketStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceEngName() {
        return null;
    }
}