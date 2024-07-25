package com.agvahealthcare.ventilator_ext.data.db.entities;

import java.lang.System;

@androidx.room.Entity(tableName = "alarm_table")
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000b\u00a8\u0006#"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/data/db/entities/AlarmDataModel;", "", "message", "", "ackcode", "startTimeStamp", "endTimeStamp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAckcode", "()Ljava/lang/String;", "setAckcode", "(Ljava/lang/String;)V", "getEndTimeStamp", "setEndTimeStamp", "id", "", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMessage", "setMessage", "getStartTimeStamp", "setStartTimeStamp", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class AlarmDataModel {
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "message")
    private java.lang.String message;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "ackcode", defaultValue = "0")
    private java.lang.String ackcode;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "StartDatetimeStamp")
    private java.lang.String startTimeStamp;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "EndDatetimeStamp")
    private java.lang.String endTimeStamp;
    @org.jetbrains.annotations.Nullable
    @androidx.room.ColumnInfo(name = "Id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private java.lang.Integer id;
    
    @org.jetbrains.annotations.NotNull
    public final com.agvahealthcare.ventilator_ext.data.db.entities.AlarmDataModel copy(@org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    java.lang.String ackcode, @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverters(value = {com.agvahealthcare.ventilator_ext.data.db.DateConverter.class})
    java.lang.String startTimeStamp, @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverters(value = {com.agvahealthcare.ventilator_ext.data.db.DateConverter.class})
    java.lang.String endTimeStamp) {
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
    
    public AlarmDataModel(@org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    java.lang.String ackcode, @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverters(value = {com.agvahealthcare.ventilator_ext.data.db.DateConverter.class})
    java.lang.String startTimeStamp, @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverters(value = {com.agvahealthcare.ventilator_ext.data.db.DateConverter.class})
    java.lang.String endTimeStamp) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAckcode() {
        return null;
    }
    
    public final void setAckcode(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getStartTimeStamp() {
        return null;
    }
    
    public final void setStartTimeStamp(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEndTimeStamp() {
        return null;
    }
    
    public final void setEndTimeStamp(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
}