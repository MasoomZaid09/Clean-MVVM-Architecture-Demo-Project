package com.agvahealthcare.ventilator_ext.presentation.utils;

import java.lang.System;

/**
 * Created by MOHIT MALHOTRA on 14-09-2018.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J0\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J:\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013J\"\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u001bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/utils/DialogBoxFactory;", "", "()V", "dialogView", "Landroidx/appcompat/app/AlertDialog;", "handler", "Landroid/os/Handler;", "dismissDialogs", "", "setDialogView", "status", "", "showDialog", "ctx", "Landroid/content/Context;", "title", "", "message", "listener", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/SimpleCallbackListener;", "btnText", "clickListener", "showStandbyDialog", "msg", "onClick", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnStandbyCLickListener;", "showtherapyEndDialog", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnTherapyEndListener;", "app_debug"})
public final class DialogBoxFactory {
    @org.jetbrains.annotations.NotNull
    public static final com.agvahealthcare.ventilator_ext.presentation.utils.DialogBoxFactory INSTANCE = null;
    private static androidx.appcompat.app.AlertDialog dialogView;
    private static final android.os.Handler handler = null;
    
    private DialogBoxFactory() {
        super();
    }
    
    public final void dismissDialogs() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.appcompat.app.AlertDialog showtherapyEndDialog(@org.jetbrains.annotations.Nullable
    java.lang.String msg, @org.jetbrains.annotations.Nullable
    android.content.Context ctx, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTherapyEndListener onClick) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.appcompat.app.AlertDialog showStandbyDialog(@org.jetbrains.annotations.Nullable
    java.lang.String msg, @org.jetbrains.annotations.Nullable
    android.content.Context ctx, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnStandbyCLickListener onClick) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.appcompat.app.AlertDialog showDialog(@org.jetbrains.annotations.Nullable
    android.content.Context ctx, @org.jetbrains.annotations.Nullable
    java.lang.String title, @org.jetbrains.annotations.Nullable
    java.lang.String message, @org.jetbrains.annotations.Nullable
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.SimpleCallbackListener listener) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.appcompat.app.AlertDialog showDialog(@org.jetbrains.annotations.Nullable
    android.content.Context ctx, @org.jetbrains.annotations.Nullable
    java.lang.String title, @org.jetbrains.annotations.Nullable
    java.lang.String message, @org.jetbrains.annotations.Nullable
    java.lang.String btnText, @org.jetbrains.annotations.Nullable
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.SimpleCallbackListener clickListener) {
        return null;
    }
    
    private final void setDialogView(androidx.appcompat.app.AlertDialog dialogView, boolean status) {
    }
}