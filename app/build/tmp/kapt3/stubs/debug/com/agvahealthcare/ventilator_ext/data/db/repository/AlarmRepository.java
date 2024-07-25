package com.agvahealthcare.ventilator_ext.data.db.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000fJ\'\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/data/db/repository/AlarmRepository;", "", "alarmDao", "Lcom/agvahealthcare/ventilator_ext/data/db/daos/AlarmDao;", "(Lcom/agvahealthcare/ventilator_ext/data/db/daos/AlarmDao;)V", "addAlarmData", "", "alarmDBModel", "Lcom/agvahealthcare/ventilator_ext/database/entities/AlarmDBModel;", "(Lcom/agvahealthcare/ventilator_ext/database/entities/AlarmDBModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAlarms", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAlarms", "Landroidx/lifecycle/LiveData;", "", "readAlarmsByUhidNew", "uhid", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAlarmsByUhidOld", "readAllAlarms", "app_debug"})
public final class AlarmRepository {
    private final com.agvahealthcare.ventilator_ext.data.db.daos.AlarmDao alarmDao = null;
    
    public AlarmRepository(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.data.db.daos.AlarmDao alarmDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addAlarmData(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel alarmDBModel, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel>> getAllAlarms() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteAlarms(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel>> readAllAlarms(@org.jetbrains.annotations.NotNull
    java.lang.String uhid) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object readAlarmsByUhidNew(@org.jetbrains.annotations.NotNull
    java.lang.String uhid, int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object readAlarmsByUhidOld(@org.jetbrains.annotations.NotNull
    java.lang.String uhid, int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel>> continuation) {
        return null;
    }
}