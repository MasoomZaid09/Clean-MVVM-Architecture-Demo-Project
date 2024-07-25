package com.agvahealthcare.ventilator_ext.presentation.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u001aR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0005R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/utils/CustomCountDownTimer;", "", "mutableLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "(Landroidx/lifecycle/MutableLiveData;)V", "count", "", "getCount", "()J", "setCount", "(J)V", "day", "", "getDay", "()I", "setDay", "(I)V", "getMutableLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setMutableLiveData", "timer", "Landroid/os/CountDownTimer;", "getTimerState", "Landroidx/lifecycle/LiveData;", "start", "", "endOn", "stop", "app_debug"})
public final class CustomCountDownTimer {
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.lang.String> mutableLiveData;
    private android.os.CountDownTimer timer;
    private long count = 0L;
    private int day = 0;
    
    public CustomCountDownTimer(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.lang.String> mutableLiveData) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getMutableLiveData() {
        return null;
    }
    
    public final void setMutableLiveData(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    public final long getCount() {
        return 0L;
    }
    
    public final void setCount(long p0) {
    }
    
    public final int getDay() {
        return 0;
    }
    
    public final void setDay(int p0) {
    }
    
    public final void start(long endOn) {
    }
    
    public final void stop() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getTimerState() {
        return null;
    }
}