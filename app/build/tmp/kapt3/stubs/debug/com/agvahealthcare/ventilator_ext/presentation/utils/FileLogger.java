package com.agvahealthcare.ventilator_ext.presentation.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/utils/FileLogger;", "", "()V", "Companion", "app_debug"})
public abstract class FileLogger {
    @org.jetbrains.annotations.NotNull
    public static final com.agvahealthcare.ventilator_ext.presentation.utils.FileLogger.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String dataNotFound = "Data Not Found";
    private static final java.lang.String TAG = "FileLogger";
    private static final java.lang.String PATH_DEBUG_LOG_FILE = "debug_report";
    private static final java.lang.String PATH_EXCEPTION_LOG_FILE = "crash_report";
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    private static final java.text.SimpleDateFormat fileDateTimeFormatter = null;
    private static final java.text.SimpleDateFormat fileDateFormatter = null;
    
    public FileLogger() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\'B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0004J\u0018\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0004J\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004J\u001e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0004J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0016\u0010$\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010%\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010&\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\t8\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/utils/FileLogger$Companion;", "", "()V", "PATH_DEBUG_LOG_FILE", "", "PATH_EXCEPTION_LOG_FILE", "TAG", "dataNotFound", "fileDateFormatter", "Ljava/text/SimpleDateFormat;", "fileDateTimeFormatter", "alarm", "", "data", "alarmUhid", "ctx", "Landroid/content/Context;", "d", "err", "", "e", "event", "eventUhid", "readAlarmFile", "startIndex", "", "endIndex", "whereCondtion", "readAlarmUhidFile", "readBaseUrl", "readCrashFile", "readEventFile", "readEventUhidFile", "writeAlarmFile", "", "writeAlarmUhidFile", "writeCrashFile", "writeEventFile", "writeEventUhidFile", "TypeOfCall", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void alarm(@org.jetbrains.annotations.NotNull
        java.lang.String data) {
        }
        
        public final void event(@org.jetbrains.annotations.NotNull
        java.lang.String data) {
        }
        
        public final void alarmUhid(@org.jetbrains.annotations.NotNull
        android.content.Context ctx, @org.jetbrains.annotations.NotNull
        java.lang.String data) {
        }
        
        public final void eventUhid(@org.jetbrains.annotations.NotNull
        android.content.Context ctx, @org.jetbrains.annotations.NotNull
        java.lang.String data) {
        }
        
        private final boolean writeAlarmUhidFile(android.content.Context ctx, java.lang.String data) {
            return false;
        }
        
        private final boolean writeEventUhidFile(android.content.Context ctx, java.lang.String data) {
            return false;
        }
        
        private final boolean writeEventFile(java.lang.String data) {
            return false;
        }
        
        private final boolean writeAlarmFile(java.lang.String data) {
            return false;
        }
        
        public final boolean writeCrashFile(@org.jetbrains.annotations.NotNull
        android.content.Context ctx, @org.jetbrains.annotations.NotNull
        java.lang.String data) {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String readCrashFile() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String readBaseUrl() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String readEventFile(int startIndex, int endIndex, @org.jetbrains.annotations.NotNull
        java.lang.String whereCondtion) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String readAlarmFile(int startIndex, int endIndex, @org.jetbrains.annotations.NotNull
        java.lang.String whereCondtion) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String readAlarmUhidFile() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String readEventUhidFile() {
            return null;
        }
        
        public final void d(@org.jetbrains.annotations.Nullable
        android.content.Context ctx, @org.jetbrains.annotations.NotNull
        java.lang.Throwable err) {
        }
        
        public final void d(@org.jetbrains.annotations.NotNull
        android.content.Context ctx, @org.jetbrains.annotations.NotNull
        java.lang.String data) {
        }
        
        public final void e(@org.jetbrains.annotations.Nullable
        android.content.Context ctx, @org.jetbrains.annotations.NotNull
        java.lang.Throwable err) {
        }
        
        public final void e(@org.jetbrains.annotations.NotNull
        android.content.Context ctx, @org.jetbrains.annotations.NotNull
        java.lang.String data) {
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/utils/FileLogger$Companion$TypeOfCall;", "", "(Ljava/lang/String;I)V", "TYPE_FAIL", "TYPE_PASS", "TYPE_CHANGE", "app_debug"})
        public static enum TypeOfCall {
            /*public static final*/ TYPE_FAIL /* = new TYPE_FAIL() */,
            /*public static final*/ TYPE_PASS /* = new TYPE_PASS() */,
            /*public static final*/ TYPE_CHANGE /* = new TYPE_CHANGE() */;
            
            TypeOfCall() {
            }
        }
    }
}