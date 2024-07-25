package com.agvahealthcare.ventilator_ext.data.db.daos;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000fH\'J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000fH\'J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\'J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00100\u000fH\'J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/data/db/daos/EventDao;", "", "addEventData", "", "eventDataModel", "Lcom/agvahealthcare/ventilator_ext/data/db/entities/EventDataModel;", "(Lcom/agvahealthcare/ventilator_ext/data/db/entities/EventDataModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllEvents", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteEventData", "deleteEvents", "id1", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEvents", "Landroidx/lifecycle/LiveData;", "", "readAllEvents", "readAllEventsUhid", "uhid", "", "readAllUhid", "readEventsByNew", "readEventsByOld", "readEventsByUhidNew", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readEventsByUhidOld", "updateEventData", "app_debug"})
public abstract interface EventDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 3)
    public abstract java.lang.Object addEventData(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel eventDataModel, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateEventData(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel eventDataModel, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deleteEventData(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel eventDataModel, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "DELETE FROM event_table")
    public abstract java.lang.Object deleteAllEvents(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM event_table ORDER BY id DESC LIMIT 11")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel>> readAllEvents();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM event_table WHERE id > :id1 LIMIT 11")
    public abstract java.lang.Object readEventsByNew(int id1, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM (SELECT * FROM event_table ORDER BY id DESC) WHERE id < :id1 LIMIT 11")
    public abstract java.lang.Object readEventsByOld(int id1, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel>> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT DISTINCT Uhid FROM event_table")
    public abstract androidx.lifecycle.LiveData<java.util.List<java.lang.String>> readAllUhid();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM event_table WHERE Uhid= :uhid ORDER BY id DESC LIMIT 11")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel>> readAllEventsUhid(@org.jetbrains.annotations.NotNull
    java.lang.String uhid);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM event_table WHERE Uhid= :uhid AND id > :id1 LIMIT 11")
    public abstract java.lang.Object readEventsByUhidNew(@org.jetbrains.annotations.NotNull
    java.lang.String uhid, int id1, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM (SELECT * FROM event_table ORDER BY id DESC) WHERE Uhid= :uhid AND id < :id1 LIMIT 11")
    public abstract java.lang.Object readEventsByUhidOld(@org.jetbrains.annotations.NotNull
    java.lang.String uhid, int id1, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel>> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM event_table ORDER BY id DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel>> getAllEvents();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "DELETE FROM event_table WHERE id < :id1")
    public abstract java.lang.Object deleteEvents(int id1, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}