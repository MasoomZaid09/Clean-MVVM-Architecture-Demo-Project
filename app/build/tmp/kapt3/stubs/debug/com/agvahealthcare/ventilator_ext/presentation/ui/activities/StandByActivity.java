package com.agvahealthcare.ventilator_ext.presentation.ui.activities;

import java.lang.System;

/**
 * Created by MASOOM ZAID on 20-04-2023.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u00d0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001sB\u0005\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CJ\u0010\u0010E\u001a\u00020A2\u0006\u0010F\u001a\u00020CH\u0003J\b\u0010G\u001a\u00020AH\u0002J\b\u0010H\u001a\u00020AH\u0002J\b\u0010I\u001a\u00020AH\u0002J\b\u0010J\u001a\u00020KH\u0002J\u001c\u0010L\u001a\u00020A2\b\u0010M\u001a\u0004\u0018\u00010:2\b\u0010N\u001a\u0004\u0018\u000108H\u0002J\u0010\u0010O\u001a\u00020A2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020AH\u0002J\b\u0010S\u001a\u00020AH\u0002J\u001c\u0010T\u001a\u00020A2\b\u0010M\u001a\u0004\u0018\u00010:2\b\u0010N\u001a\u0004\u0018\u000108H\u0002J\u0012\u0010U\u001a\u00020A2\b\u0010V\u001a\u0004\u0018\u00010WH\u0014J\b\u0010X\u001a\u00020AH\u0014J\b\u0010Y\u001a\u00020AH\u0002J\b\u0010Z\u001a\u00020AH\u0002J\b\u0010[\u001a\u00020AH\u0016J\u0018\u0010\\\u001a\u00020A2\u0006\u0010]\u001a\u00020C2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010\\\u001a\u00020A2\u0006\u0010]\u001a\u00020C2\u0006\u0010^\u001a\u00020\u0017H\u0016J \u0010`\u001a\u00020A2\u0006\u0010P\u001a\u00020a2\u0006\u0010]\u001a\u00020C2\u0006\u0010^\u001a\u00020_H\u0016J \u0010`\u001a\u00020A2\u0006\u0010P\u001a\u00020a2\u0006\u0010]\u001a\u00020C2\u0006\u0010^\u001a\u00020\u0017H\u0016J\b\u0010b\u001a\u00020AH\u0014J\b\u0010c\u001a\u00020AH\u0014J\b\u0010d\u001a\u00020AH\u0016J\u0010\u0010e\u001a\u00020A2\u0006\u0010f\u001a\u00020\u0017H\u0016J\b\u0010g\u001a\u00020AH\u0002J\u0010\u0010h\u001a\u00020A2\u0006\u0010f\u001a\u00020\u0017H\u0002J\b\u0010i\u001a\u00020AH\u0002J\b\u0010j\u001a\u00020AH\u0002J\b\u0010k\u001a\u00020AH\u0002J\u0010\u0010l\u001a\u00020A2\u0006\u0010f\u001a\u00020\u0017H\u0002J\b\u0010m\u001a\u00020AH\u0002J\b\u0010n\u001a\u00020AH\u0002J\b\u0010o\u001a\u00020AH\u0002J\b\u0010p\u001a\u00020AH\u0002J\u0010\u0010q\u001a\u00020A2\u0006\u0010r\u001a\u00020\u0017H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010#R\u000e\u0010$\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010=\u001a\u00060>R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006t"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/activities/StandByActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnStandbyCLickListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/DialogCloseListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnStartSedationListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnLimitChangeListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnKnobPressListener;", "()V", "binding", "Lcom/agvahealthcare/ventilator_ext/databinding/ActivityStandByBinding;", "commonViewModel", "Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "getCommonViewModel", "()Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "commonViewModel$delegate", "Lkotlin/Lazy;", "communicationService", "Lcom/agvahealthcare/ventilator_ext/domain/support/service/CommunicationService;", "connReceiver", "Landroid/content/BroadcastReceiver;", "controlFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/ControlFragment;", "currentMode", "", "getCurrentMode$app_debug", "()I", "setCurrentMode$app_debug", "(I)V", "eventViewModel", "Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/EventViewModel;", "getEventViewModel", "()Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/EventViewModel;", "eventViewModel$delegate", "isExistingVentilation", "", "Ljava/lang/Boolean;", "isReadingFromConnection", "isServiceBound", "()Z", "setServiceBound", "(Z)V", "knobClass", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/KnobClass;", "mServiceConnection", "Landroid/content/ServiceConnection;", "menuFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/MenuFragment;", "modeFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/ModeFragment;", "pingingTask", "Lcom/agvahealthcare/ventilator_ext/domain/support/PingingTask;", "preferenceManager", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;", "selectedMenuType", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$AllMenuType;", "selectedTextView", "Landroid/widget/TextView;", "selectedView", "Landroid/view/View;", "serviceIntent", "Landroid/content/Intent;", "settingsCountDownTimer", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/activities/StandByActivity$SettingsCountDownTimer;", "testCount", "addEvents", "", "eventMsg", "", "uhid", "callRunningStatusApi", "status", "closeAllFragment", "doBindService", "doUnbindService", "getIntentFilter", "Landroid/content/IntentFilter;", "highLightTile", "view", "textView", "highlightProgressBars", "type", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$BodyParamsType;", "initViewOfBodyParamsViaPreferences", "normaliseAllProgressBar", "normaliseTile", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDeviceConnect", "onDeviceDisconnect", "onHandleDialogClose", "onKnobPress", "label", "newValue", "", "onLimitChange", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$KnobSelectedType;", "onPause", "onResume", "onStandby", "onStartSedation", "mode", "sendConfigurationToVentilatorWithWatchDog", "sendControlModeToVentilator", "setDataFemale", "setDataMale", "setOnClickListener", "showControlFragment", "showMenuFragment", "showModeFragment", "startPinging", "stopPinging", "updateBatteryImage", "batteryLevel", "SettingsCountDownTimer", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class StandByActivity extends androidx.appcompat.app.AppCompatActivity implements com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnStandbyCLickListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnStartSedationListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitChangeListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnKnobPressListener {
    private com.agvahealthcare.ventilator_ext.databinding.ActivityStandByBinding binding;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.ModeFragment modeFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.MenuFragment menuFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.ControlFragment controlFragment;
    private int currentMode = -1;
    private com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AllMenuType selectedMenuType;
    private android.view.View selectedView;
    private android.widget.TextView selectedTextView;
    private com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager preferenceManager;
    private com.agvahealthcare.ventilator_ext.presentation.utils.KnobClass knobClass;
    private java.lang.Boolean isExistingVentilation;
    private int testCount = 100;
    private android.content.Intent serviceIntent;
    private com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService communicationService;
    private com.agvahealthcare.ventilator_ext.domain.support.PingingTask pingingTask;
    private final kotlin.Lazy commonViewModel$delegate = null;
    private final kotlin.Lazy eventViewModel$delegate = null;
    private final com.agvahealthcare.ventilator_ext.presentation.ui.activities.StandByActivity.SettingsCountDownTimer settingsCountDownTimer = null;
    private boolean isServiceBound = false;
    private boolean isReadingFromConnection = false;
    private final android.content.ServiceConnection mServiceConnection = null;
    private final android.content.BroadcastReceiver connReceiver = null;
    
    public StandByActivity() {
        super();
    }
    
    public final int getCurrentMode$app_debug() {
        return 0;
    }
    
    public final void setCurrentMode$app_debug(int p0) {
    }
    
    private final com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel getCommonViewModel() {
        return null;
    }
    
    private final com.agvahealthcare.ventilator_ext.presentation.viewmodels.EventViewModel getEventViewModel() {
        return null;
    }
    
    public final boolean isServiceBound() {
        return false;
    }
    
    public final void setServiceBound(boolean p0) {
    }
    
    private final void onDeviceConnect() {
    }
    
    private final void doBindService() {
    }
    
    private final void doUnbindService() {
    }
    
    public final void addEvents(@org.jetbrains.annotations.NotNull
    java.lang.String eventMsg, @org.jetbrains.annotations.NotNull
    java.lang.String uhid) {
    }
    
    @java.lang.Override
    public void onHandleDialogClose() {
    }
    
    private final void sendControlModeToVentilator(int mode) {
    }
    
    @java.lang.Override
    public void onStartSedation(int mode) {
    }
    
    private final void showModeFragment() {
    }
    
    private final void sendConfigurationToVentilatorWithWatchDog() {
    }
    
    private final void showMenuFragment() {
    }
    
    private final void showControlFragment(int mode) {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    private final void normaliseAllProgressBar() {
    }
    
    private final void highlightProgressBars(com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.BodyParamsType type) {
    }
    
    private final void initViewOfBodyParamsViaPreferences() {
    }
    
    private final void updateBatteryImage(int batteryLevel) {
    }
    
    @android.annotation.SuppressLint(value = {"HardwareIds"})
    private final void callRunningStatusApi(java.lang.String status) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final android.content.IntentFilter getIntentFilter() {
        return null;
    }
    
    private final void onDeviceDisconnect() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void startPinging() {
    }
    
    private final void stopPinging() {
    }
    
    private final void setOnClickListener() {
    }
    
    private final void setDataMale() {
    }
    
    private final void setDataFemale() {
    }
    
    private final void normaliseTile(android.view.View view, android.widget.TextView textView) {
    }
    
    private final void highLightTile(android.view.View view, android.widget.TextView textView) {
    }
    
    @java.lang.Override
    public void onStandby() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    private final void closeAllFragment() {
    }
    
    @java.lang.Override
    public void onKnobPress(@org.jetbrains.annotations.NotNull
    java.lang.String label, float newValue) {
    }
    
    @java.lang.Override
    public void onKnobPress(@org.jetbrains.annotations.NotNull
    java.lang.String label, int newValue) {
    }
    
    @java.lang.Override
    public void onLimitChange(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.KnobSelectedType type, @org.jetbrains.annotations.NotNull
    java.lang.String label, float newValue) {
    }
    
    @java.lang.Override
    public void onLimitChange(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.KnobSelectedType type, @org.jetbrains.annotations.NotNull
    java.lang.String label, int newValue) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0096\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/activities/StandByActivity$SettingsCountDownTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/agvahealthcare/ventilator_ext/presentation/ui/activities/StandByActivity;JJ)V", "isFirstCallElapsed", "", "isRunning", "isSafeStop", "onFinish", "", "onTick", "millis", "safeStop", "startRunning", "app_debug"})
    public class SettingsCountDownTimer extends android.os.CountDownTimer {
        private boolean isSafeStop = false;
        private boolean isRunning = false;
        private boolean isFirstCallElapsed = false;
        
        public SettingsCountDownTimer(long millisInFuture, long countDownInterval) {
            super(0L, 0L);
        }
        
        public final void startRunning() {
        }
        
        public final void safeStop() {
        }
        
        @java.lang.Override
        public void onTick(long millis) {
        }
        
        @java.lang.Override
        public void onFinish() {
        }
    }
}