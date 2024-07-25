package com.agvahealthcare.ventilator_ext.utility.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/utility/utils/AlarmConfiguration;", "", "()V", "Companion", "app_debug"})
public final class AlarmConfiguration {
    @org.jetbrains.annotations.NotNull
    public static final com.agvahealthcare.ventilator_ext.utility.utils.AlarmConfiguration.Companion Companion = null;
    private static final java.util.List<java.lang.String> cycleCheckedAcks = null;
    private static final java.util.List<java.lang.String> controlLimitAlarms = null;
    private static final java.util.List<java.lang.String> lowLimitAlarms = null;
    
    public AlarmConfiguration() {
        super();
    }
    
    @kotlin.jvm.JvmStatic
    public static final int getColor(@org.jetbrains.annotations.NotNull
    java.lang.String alarm) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AlarmType getPriority(@org.jetbrains.annotations.NotNull
    java.lang.String alarm) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AckType getAckType(@org.jetbrains.annotations.NotNull
    java.lang.String ack) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmStatic
    public static final java.lang.String getAckFor(@org.jetbrains.annotations.NotNull
    java.lang.String ack) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmStatic
    public static final java.lang.String getNackFor(@org.jetbrains.annotations.NotNull
    java.lang.String ack) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmStatic
    public static final java.lang.Integer getAlarmUri(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AlarmType priority) {
        return null;
    }
    
    @kotlin.jvm.JvmStatic
    public static final boolean isCycleCheckRequired(@org.jetbrains.annotations.NotNull
    java.lang.String ack) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0017\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0005H\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0005H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0005H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/utility/utils/AlarmConfiguration$Companion;", "", "()V", "controlLimitAlarms", "", "", "cycleCheckedAcks", "lowLimitAlarms", "getAckFor", "ack", "getAckType", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$AckType;", "getAlarmUri", "", "priority", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$AlarmType;", "(Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$AlarmType;)Ljava/lang/Integer;", "getColor", "alarm", "getNackFor", "getPriority", "isAckValid", "", "isCycleCheckRequired", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final boolean isAckValid(java.lang.String ack) {
            return false;
        }
        
        @kotlin.jvm.JvmStatic
        public final int getColor(@org.jetbrains.annotations.NotNull
        java.lang.String alarm) {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.JvmStatic
        public final com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AlarmType getPriority(@org.jetbrains.annotations.NotNull
        java.lang.String alarm) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.JvmStatic
        public final com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AckType getAckType(@org.jetbrains.annotations.NotNull
        java.lang.String ack) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        @kotlin.jvm.JvmStatic
        public final java.lang.String getAckFor(@org.jetbrains.annotations.NotNull
        java.lang.String ack) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        @kotlin.jvm.JvmStatic
        public final java.lang.String getNackFor(@org.jetbrains.annotations.NotNull
        java.lang.String ack) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        @kotlin.jvm.JvmStatic
        public final java.lang.Integer getAlarmUri(@org.jetbrains.annotations.NotNull
        com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AlarmType priority) {
            return null;
        }
        
        @kotlin.jvm.JvmStatic
        public final boolean isCycleCheckRequired(@org.jetbrains.annotations.NotNull
        java.lang.String ack) {
            return false;
        }
    }
}