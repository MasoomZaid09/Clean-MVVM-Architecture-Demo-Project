package com.agvahealthcare.ventilator_ext.presentation.utils;

import java.lang.System;

/**
 * Created by MASOOM ZAID on 23-04-2023.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u0004\u0018\u00010\u0004J\b\u0010!\u001a\u0004\u0018\u00010\u0004J\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\b\u0010#\u001a\u0004\u0018\u00010\u0004J\b\u0010$\u001a\u0004\u0018\u00010\u0004J\u0016\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0016\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0011\u0010\u001a\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0011\u0010\u001c\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR\u0011\u0010\u001e\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000b\u00a8\u00060"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/utils/AppUtils;", "", "()V", "PATH_FOLDER_AGVA", "", "PATH_FOLDER_LOGS", "PATH_FOLDER_SERVICE_AND_OP_MOD", "PATH_FOLDER_SYSSNAPSHOT", "dateFormatter", "Ljava/text/SimpleDateFormat;", "getDateFormatter", "()Ljava/text/SimpleDateFormat;", "dateFormatterReverse", "getDateFormatterReverse", "dateTimeFormatter", "getDateTimeFormatter", "dateTimeFormatterTest", "getDateTimeFormatterTest", "decimalFormat", "Ljava/text/DecimalFormat;", "getDecimalFormat", "()Ljava/text/DecimalFormat;", "setDecimalFormat", "(Ljava/text/DecimalFormat;)V", "errorDateTimeFormatter", "getErrorDateTimeFormatter", "timeFormatter", "getTimeFormatter", "timeHourMinuteFormatter", "getTimeHourMinuteFormatter", "ventDateTimeFormatter", "getVentDateTimeFormatter", "getCurrentDate", "getCurrentDateReverse", "getCurrentDateTime", "getCurrentDateTimeForTrends", "getCurrentTime", "hideKeyBoard", "", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "keepScreenAlive", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "isAlive", "", "app_debug"})
public final class AppUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.agvahealthcare.ventilator_ext.presentation.utils.AppUtils INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PATH_FOLDER_AGVA = ".Sedation";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PATH_FOLDER_LOGS = "logs";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PATH_FOLDER_SYSSNAPSHOT = "snapshots";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PATH_FOLDER_SERVICE_AND_OP_MOD = ".servop";
    @org.jetbrains.annotations.NotNull
    private static final java.text.SimpleDateFormat ventDateTimeFormatter = null;
    @org.jetbrains.annotations.NotNull
    private static final java.text.SimpleDateFormat timeFormatter = null;
    @org.jetbrains.annotations.NotNull
    private static final java.text.SimpleDateFormat timeHourMinuteFormatter = null;
    @org.jetbrains.annotations.NotNull
    private static final java.text.SimpleDateFormat errorDateTimeFormatter = null;
    @org.jetbrains.annotations.NotNull
    private static final java.text.SimpleDateFormat dateTimeFormatter = null;
    @org.jetbrains.annotations.NotNull
    private static final java.text.SimpleDateFormat dateTimeFormatterTest = null;
    @org.jetbrains.annotations.NotNull
    private static final java.text.SimpleDateFormat dateFormatterReverse = null;
    @org.jetbrains.annotations.NotNull
    private static final java.text.SimpleDateFormat dateFormatter = null;
    @org.jetbrains.annotations.NotNull
    private static java.text.DecimalFormat decimalFormat;
    
    private AppUtils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.text.SimpleDateFormat getVentDateTimeFormatter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.text.SimpleDateFormat getTimeFormatter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.text.SimpleDateFormat getTimeHourMinuteFormatter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.text.SimpleDateFormat getErrorDateTimeFormatter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.text.SimpleDateFormat getDateTimeFormatter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.text.SimpleDateFormat getDateTimeFormatterTest() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.text.SimpleDateFormat getDateFormatterReverse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.text.SimpleDateFormat getDateFormatter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.text.DecimalFormat getDecimalFormat() {
        return null;
    }
    
    public final void setDecimalFormat(@org.jetbrains.annotations.NotNull
    java.text.DecimalFormat p0) {
    }
    
    public final void keepScreenAlive(@org.jetbrains.annotations.NotNull
    androidx.appcompat.app.AppCompatActivity activity, boolean isAlive) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCurrentDateTime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCurrentDateReverse() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCurrentDateTimeForTrends() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCurrentTime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCurrentDate() {
        return null;
    }
    
    public final void hideKeyBoard(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
}