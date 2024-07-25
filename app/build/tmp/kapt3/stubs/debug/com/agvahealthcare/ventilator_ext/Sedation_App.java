package com.agvahealthcare.ventilator_ext;

import java.lang.System;

/**
 * Created by MASOOM ZAID on 20-04-2023.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0002\u00a8\u0006\b"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/Sedation_App;", "Landroid/app/Application;", "()V", "createNotificationChannel", "", "onCreate", "setUpSciChartLicense", "Companion", "app_debug"})
@dagger.hilt.android.HiltAndroidApp
public final class Sedation_App extends android.app.Application {
    @org.jetbrains.annotations.NotNull
    public static final com.agvahealthcare.ventilator_ext.Sedation_App.Companion Companion = null;
    private static boolean isFromStandBy = false;
    @org.jetbrains.annotations.Nullable
    private static java.lang.Boolean tileClicked;
    private static java.lang.String CHANNEL_ID = "ventilatorApp";
    private static com.agvahealthcare.ventilator_ext.Sedation_App sInstance;
    private static java.lang.String appVersion = "N/A";
    private static boolean therapyEndStarted = false;
    @org.jetbrains.annotations.NotNull
    private static java.util.List<java.lang.String> uhidDataListAlarm;
    @org.jetbrains.annotations.NotNull
    private static java.util.List<java.lang.String> uhidDataListEvent;
    
    public Sedation_App() {
        super();
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    private final void setUpSciChartLicense() {
    }
    
    private final void createNotificationChannel() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/agvahealthcare/ventilator_ext/Sedation_App$Companion;", "", "()V", "CHANNEL_ID", "", "appVersion", "isFromStandBy", "", "()Z", "setFromStandBy", "(Z)V", "sInstance", "Lcom/agvahealthcare/ventilator_ext/Sedation_App;", "therapyEndStarted", "getTherapyEndStarted", "setTherapyEndStarted", "tileClicked", "getTileClicked", "()Ljava/lang/Boolean;", "setTileClicked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "uhidDataListAlarm", "", "getUhidDataListAlarm", "()Ljava/util/List;", "setUhidDataListAlarm", "(Ljava/util/List;)V", "uhidDataListEvent", "getUhidDataListEvent", "setUhidDataListEvent", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean isFromStandBy() {
            return false;
        }
        
        public final void setFromStandBy(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Boolean getTileClicked() {
            return null;
        }
        
        public final void setTileClicked(@org.jetbrains.annotations.Nullable
        java.lang.Boolean p0) {
        }
        
        public final boolean getTherapyEndStarted() {
            return false;
        }
        
        public final void setTherapyEndStarted(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.String> getUhidDataListAlarm() {
            return null;
        }
        
        public final void setUhidDataListAlarm(@org.jetbrains.annotations.NotNull
        java.util.List<java.lang.String> p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.String> getUhidDataListEvent() {
            return null;
        }
        
        public final void setUhidDataListEvent(@org.jetbrains.annotations.NotNull
        java.util.List<java.lang.String> p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.agvahealthcare.ventilator_ext.Sedation_App getInstance() {
            return null;
        }
    }
}