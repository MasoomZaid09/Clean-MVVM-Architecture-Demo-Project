package com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/data/api/model/serviceDataModel/ResponseModel;", "", "ServiceRequestCurrentPage", "", "ServiceRequestData", "Ljava/util/ArrayList;", "Lcom/agvahealthcare/ventilator_ext/data/api/model/serviceDataModel/Data;", "Lkotlin/collections/ArrayList;", "ServiceRequestMessage", "", "ServiceRequestStatusCode", "ServiceRequestStatusValue", "ServiceRequestTotalDataCount", "ServiceRequestTotalPages", "(ILjava/util/ArrayList;Ljava/lang/String;ILjava/lang/String;II)V", "getServiceRequestCurrentPage", "()I", "getServiceRequestData", "()Ljava/util/ArrayList;", "getServiceRequestMessage", "()Ljava/lang/String;", "getServiceRequestStatusCode", "getServiceRequestStatusValue", "getServiceRequestTotalDataCount", "getServiceRequestTotalPages", "app_debug"})
public final class ResponseModel {
    @com.google.gson.annotations.SerializedName(value = "currentPage")
    private final int ServiceRequestCurrentPage = 0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "data")
    private final java.util.ArrayList<com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.Data> ServiceRequestData = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "message")
    private final java.lang.String ServiceRequestMessage = null;
    @com.google.gson.annotations.SerializedName(value = "statusCode")
    private final int ServiceRequestStatusCode = 0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "statusValue")
    private final java.lang.String ServiceRequestStatusValue = null;
    @com.google.gson.annotations.SerializedName(value = "totalDataCount")
    private final int ServiceRequestTotalDataCount = 0;
    @com.google.gson.annotations.SerializedName(value = "totalPages")
    private final int ServiceRequestTotalPages = 0;
    
    public ResponseModel(int ServiceRequestCurrentPage, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.Data> ServiceRequestData, @org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequestMessage, int ServiceRequestStatusCode, @org.jetbrains.annotations.NotNull
    java.lang.String ServiceRequestStatusValue, int ServiceRequestTotalDataCount, int ServiceRequestTotalPages) {
        super();
    }
    
    public final int getServiceRequestCurrentPage() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.agvahealthcare.ventilator_ext.data.api.model.serviceDataModel.Data> getServiceRequestData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequestMessage() {
        return null;
    }
    
    public final int getServiceRequestStatusCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServiceRequestStatusValue() {
        return null;
    }
    
    public final int getServiceRequestTotalDataCount() {
        return 0;
    }
    
    public final int getServiceRequestTotalPages() {
        return 0;
    }
}