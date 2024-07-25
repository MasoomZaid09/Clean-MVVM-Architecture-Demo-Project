package com.agvahealthcare.ventilator_ext.presentation.viewmodels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001BB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207J\u000e\u00102\u001a\u0002032\u0006\u00108\u001a\u00020\u0011J\u000e\u00109\u001a\u0002032\u0006\u00108\u001a\u00020\u0011J\u000e\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010<\u001a\u0002032\u0006\u0010=\u001a\u00020%J\u000e\u0010>\u001a\u0002032\u0006\u0010=\u001a\u00020%J\u000e\u0010?\u001a\u0002032\u0006\u0010=\u001a\u00020%J\u0016\u0010@\u001a\u000203\"\u0004\b\u0000\u0010A*\b\u0012\u0004\u0012\u0002HA0\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R,\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0011 \u0014*\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00130\u00130\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR(\u0010\u0016\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0011 \u0014*\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u00100\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\fR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\fR\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020%0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\fR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\fR\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\fR\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\fR,\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\f\u00a8\u0006C"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "ALARM_BUFFER_THRESHOLD", "", "_graphData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "get_graphData", "()Landroidx/lifecycle/MutableLiveData;", "set_graphData", "(Landroidx/lifecycle/MutableLiveData;)V", "alarmBuffer", "Ljava/util/ArrayList;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/models/AlarmModel;", "alarms", "Ljava/util/PriorityQueue;", "kotlin.jvm.PlatformType", "getAlarms", "arrayListTemp", "clickedControlItem", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$AllControlType;", "getClickedControlItem", "setClickedControlItem", "clickedSubMenuItem", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$AllSubMenuType;", "getClickedSubMenuItem", "setClickedSubMenuItem", "currentModeCode", "getCurrentModeCode", "setCurrentModeCode", "graphPeekValue", "getGraphPeekValue", "isBatteryConnected", "", "isLogsAlarmFragmentVisible", "isLogsEventsFragmentVisible", "isLogsTrendsFragmentVisible", "n2oPressureValue", "getN2oPressureValue", "o2PressureValue", "getO2PressureValue", "therapyEndData", "getTherapyEndData", "setTherapyEndData", "ventBatteryLevel", "getVentBatteryLevel", "addAlarm", "", "ctx", "Landroid/content/Context;", "alarmDBModel", "Lcom/agvahealthcare/ventilator_ext/database/entities/AlarmDBModel;", "alarm", "removeAlarm", "setVentBatteryLevel", "batteryLevel", "updateIsAlarmsFragmentVisible", "flag", "updateIsEventsFragmentVisible", "updateIsLogsTrendsFragmentVisible", "notifyObserver", "T", "AlarmComparator", "app_debug"})
public final class CommonViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.PriorityQueue<com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel>> alarms = null;
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel>> arrayListTemp = null;
    private final int ALARM_BUFFER_THRESHOLD = 5;
    private final java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel> alarmBuffer = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLogsTrendsFragmentVisible = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLogsEventsFragmentVisible = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLogsAlarmFragmentVisible = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> ventBatteryLevel = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isBatteryConnected = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> o2PressureValue = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> n2oPressureValue = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> graphPeekValue = null;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.String, java.lang.String>> _graphData;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Integer, java.lang.Integer>> therapyEndData;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> currentModeCode;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AllSubMenuType> clickedSubMenuItem;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AllControlType> clickedControlItem;
    
    @javax.inject.Inject
    public CommonViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.PriorityQueue<com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel>> getAlarms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLogsTrendsFragmentVisible() {
        return null;
    }
    
    public final void updateIsLogsTrendsFragmentVisible(boolean flag) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLogsEventsFragmentVisible() {
        return null;
    }
    
    public final void updateIsEventsFragmentVisible(boolean flag) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLogsAlarmFragmentVisible() {
        return null;
    }
    
    public final void updateIsAlarmsFragmentVisible(boolean flag) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getVentBatteryLevel() {
        return null;
    }
    
    public final void setVentBatteryLevel(int batteryLevel) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isBatteryConnected() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getO2PressureValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getN2oPressureValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getGraphPeekValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.String, java.lang.String>> get_graphData() {
        return null;
    }
    
    public final void set_graphData(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.String, java.lang.String>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Integer, java.lang.Integer>> getTherapyEndData() {
        return null;
    }
    
    public final void setTherapyEndData(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Integer, java.lang.Integer>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getCurrentModeCode() {
        return null;
    }
    
    public final void setCurrentModeCode(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AllSubMenuType> getClickedSubMenuItem() {
        return null;
    }
    
    public final void setClickedSubMenuItem(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AllSubMenuType> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AllControlType> getClickedControlItem() {
        return null;
    }
    
    public final void setClickedControlItem(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AllControlType> p0) {
    }
    
    public final void addAlarm(@org.jetbrains.annotations.NotNull
    android.content.Context ctx, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.database.entities.AlarmDBModel alarmDBModel) {
    }
    
    public final void removeAlarm(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel alarm) {
    }
    
    public final <T extends java.lang.Object>void notifyObserver(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<T> $this$notifyObserver) {
    }
    
    public final void addAlarm(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel alarm) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel$AlarmComparator;", "Ljava/util/Comparator;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/models/AlarmModel;", "()V", "compare", "", "p0", "p1", "app_debug"})
    public static class AlarmComparator implements java.util.Comparator<com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel> {
        
        public AlarmComparator() {
            super();
        }
        
        @java.lang.Override
        public int compare(@org.jetbrains.annotations.NotNull
        com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel p0, @org.jetbrains.annotations.NotNull
        com.agvahealthcare.ventilator_ext.presentation.ui.models.AlarmModel p1) {
            return 0;
        }
    }
}