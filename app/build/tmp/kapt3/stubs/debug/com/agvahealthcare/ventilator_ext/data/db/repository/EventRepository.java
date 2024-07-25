package com.agvahealthcare.ventilator_ext.data.db.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u0012J\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00130\u0012J\'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/data/db/repository/EventRepository;", "", "eventDao", "Lcom/agvahealthcare/ventilator_ext/data/db/daos/EventDao;", "(Lcom/agvahealthcare/ventilator_ext/data/db/daos/EventDao;)V", "addEventData", "", "eventDataModel", "Lcom/agvahealthcare/ventilator_ext/data/db/entities/EventDataModel;", "(Lcom/agvahealthcare/ventilator_ext/data/db/entities/EventDataModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllEvents", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteEventData", "deleteEvents", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEvents", "Landroidx/lifecycle/LiveData;", "", "readAllEvents", "uhid", "", "readAllUhid", "readEventsByUhidNew", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readEventsByUhidOld", "updateEventData", "app_debug"})
public final class EventRepository {
    private final com.agvahealthcare.ventilator_ext.data.db.daos.EventDao eventDao = null;
    
    public EventRepository(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.data.db.daos.EventDao eventDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addEventData(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel eventDataModel, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel>> getAllEvents() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteEvents(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> readAllUhid() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel>> readAllEvents(@org.jetbrains.annotations.NotNull
    java.lang.String uhid) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object readEventsByUhidNew(@org.jetbrains.annotations.NotNull
    java.lang.String uhid, int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object readEventsByUhidOld(@org.jetbrains.annotations.NotNull
    java.lang.String uhid, int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateEventData(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel eventDataModel, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteEventData(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel eventDataModel, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteAllEvents(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}