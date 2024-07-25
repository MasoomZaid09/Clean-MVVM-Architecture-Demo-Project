package com.agvahealthcare.ventilator_ext.database;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.agvahealthcare.ventilator_ext.data.db.DateConverter.class})
@androidx.room.Database(entities = {com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel.class, com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel.class, com.agvahealthcare.ventilator_ext.database.entities.ServiceDataModel.class}, version = 2, exportSchema = true)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/database/AgVaDatabase;", "Landroidx/room/RoomDatabase;", "()V", "alarmDao", "Lcom/agvahealthcare/ventilator_ext/data/db/daos/AlarmDao;", "eventDao", "Lcom/agvahealthcare/ventilator_ext/data/db/daos/EventDao;", "serviceDao", "Lcom/agvahealthcare/ventilator_ext/data/db/daos/ServiceDao;", "Companion", "app_debug"})
public abstract class AgVaDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull
    public static final com.agvahealthcare.ventilator_ext.database.AgVaDatabase.Companion Companion = null;
    @kotlin.jvm.Volatile
    private static volatile com.agvahealthcare.ventilator_ext.database.AgVaDatabase INSTANCE;
    
    public AgVaDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.agvahealthcare.ventilator_ext.data.db.daos.EventDao eventDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.agvahealthcare.ventilator_ext.data.db.daos.AlarmDao alarmDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.agvahealthcare.ventilator_ext.data.db.daos.ServiceDao serviceDao();
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/database/AgVaDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/agvahealthcare/ventilator_ext/database/AgVaDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "destroyInstance", "", "getInstance", "ctx", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.agvahealthcare.ventilator_ext.database.AgVaDatabase getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context ctx) {
            return null;
        }
        
        private final com.agvahealthcare.ventilator_ext.database.AgVaDatabase buildDatabase(android.content.Context context) {
            return null;
        }
        
        public final void destroyInstance() {
        }
    }
}