package com.agvahealthcare.ventilator_ext.data.db.daos;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\'\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\fH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/data/db/daos/AlarmDao;", "", "addAlarmData", "", "alarmDBModel", "Lcom/agvahealthcare/ventilator_ext/database/entities/AlarmDBModel;", "(Lcom/agvahealthcare/ventilator_ext/database/entities/AlarmDBModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAlarms", "id1", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAlarms", "Landroidx/lifecycle/LiveData;", "", "readAlarmsByNew", "readAlarmsByOld", "readAlarmsByUhidNew", "uhid1", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAlarmsByUhidOld", "readAllAlarms", "readAllAlarmsUhid", "readAllUhid", "app_debug"})
public abstract interface AlarmDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 3)
    public abstract java.lang.Object addAlarmData(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel alarmDBModel, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM alarm_table ORDER BY id DESC LIMIT 12")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel>> readAllAlarms();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM (SELECT * FROM alarm_table ORDER BY id DESC) WHERE id < :id1 LIMIT 12")
    public abstract java.lang.Object readAlarmsByOld(int id1, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM alarm_table WHERE id > :id1 LIMIT 12")
    public abstract java.lang.Object readAlarmsByNew(int id1, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel>> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT DISTINCT Uhid FROM alarm_table")
    public abstract androidx.lifecycle.LiveData<java.util.List<java.lang.String>> readAllUhid();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM alarm_table WHERE Uhid= :uhid1 ORDER BY id DESC LIMIT 12")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel>> readAllAlarmsUhid(@org.jetbrains.annotations.NotNull
    java.lang.String uhid1);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM alarm_table WHERE Uhid= :uhid1 AND id > :id1 LIMIT 12")
    public abstract java.lang.Object readAlarmsByUhidNew(@org.jetbrains.annotations.NotNull
    java.lang.String uhid1, int id1, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM (SELECT * FROM alarm_table ORDER BY id DESC) WHERE Uhid= :uhid1 AND id < :id1 LIMIT 12")
    public abstract java.lang.Object readAlarmsByUhidOld(@org.jetbrains.annotations.NotNull
    java.lang.String uhid1, int id1, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel>> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM alarm_table ORDER BY id DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel>> getAllAlarms();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "DELETE FROM alarm_table WHERE id < :id1")
    public abstract java.lang.Object deleteAlarms(int id1, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}