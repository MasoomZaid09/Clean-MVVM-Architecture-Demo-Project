package com.agvahealthcare.ventilator_ext.domain.support;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fR\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/domain/support/PingingTask;", "", "service", "Lcom/agvahealthcare/ventilator_ext/domain/support/service/CommunicationService;", "(Lcom/agvahealthcare/ventilator_ext/domain/support/service/CommunicationService;)V", "<set-?>", "", "isRunning", "()Z", "pingingTimer", "Landroid/os/CountDownTimer;", "sendPinging", "", "setRunningState", "start", "stop", "Companion", "app_debug"})
public final class PingingTask {
    private boolean isRunning = false;
    private final com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService service = null;
    private final android.os.CountDownTimer pingingTimer = null;
    @org.jetbrains.annotations.NotNull
    public static final com.agvahealthcare.ventilator_ext.domain.support.PingingTask.Companion Companion = null;
    private static final java.lang.String TAG = "PINGING THREAD";
    private static final long PINGING_INTERVAL = 3000L;
    private static final long PINGING_SESSION_LIFE = 3600000L;
    
    public PingingTask(@org.jetbrains.annotations.Nullable
    com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService service) {
        super();
    }
    
    public final boolean isRunning() {
        return false;
    }
    
    public final void setRunningState(boolean isRunning) {
    }
    
    private final void sendPinging() {
    }
    
    public final void start() {
    }
    
    public final void stop() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/domain/support/PingingTask$Companion;", "", "()V", "PINGING_INTERVAL", "", "PINGING_SESSION_LIFE", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}