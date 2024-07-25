package com.agvahealthcare.ventilator_ext.data.api.model.alarmDataModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JG\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001R.\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012\u00a8\u0006\""}, d2 = {"Lcom/agvahealthcare/ventilator_ext/data/api/model/alarmDataModel/AlarmRequestBodyModel;", "", "did", "", "type", "ack", "Ljava/util/ArrayList;", "Lcom/agvahealthcare/ventilator_ext/data/api/model/alarmDataModel/Ack;", "Lkotlin/collections/ArrayList;", "priority", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getAck", "()Ljava/util/ArrayList;", "setAck", "(Ljava/util/ArrayList;)V", "getDid", "()Ljava/lang/String;", "setDid", "(Ljava/lang/String;)V", "getPriority", "setPriority", "getType", "setType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class AlarmRequestBodyModel {
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "did")
    private java.lang.String did;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "type")
    private java.lang.String type;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "ack")
    private java.util.ArrayList<com.agvahealthcare.ventilator_ext.data.api.model.alarmDataModel.Ack> ack;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "priority")
    private java.lang.String priority;
    
    @org.jetbrains.annotations.NotNull
    public final com.agvahealthcare.ventilator_ext.data.api.model.alarmDataModel.AlarmRequestBodyModel copy(@org.jetbrains.annotations.Nullable
    java.lang.String did, @org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.agvahealthcare.ventilator_ext.data.api.model.alarmDataModel.Ack> ack, @org.jetbrains.annotations.Nullable
    java.lang.String priority) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public AlarmRequestBodyModel() {
        super();
    }
    
    public AlarmRequestBodyModel(@org.jetbrains.annotations.Nullable
    java.lang.String did, @org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.agvahealthcare.ventilator_ext.data.api.model.alarmDataModel.Ack> ack, @org.jetbrains.annotations.Nullable
    java.lang.String priority) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDid() {
        return null;
    }
    
    public final void setDid(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.agvahealthcare.ventilator_ext.data.api.model.alarmDataModel.Ack> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.agvahealthcare.ventilator_ext.data.api.model.alarmDataModel.Ack> getAck() {
        return null;
    }
    
    public final void setAck(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.agvahealthcare.ventilator_ext.data.api.model.alarmDataModel.Ack> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPriority() {
        return null;
    }
    
    public final void setPriority(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
}