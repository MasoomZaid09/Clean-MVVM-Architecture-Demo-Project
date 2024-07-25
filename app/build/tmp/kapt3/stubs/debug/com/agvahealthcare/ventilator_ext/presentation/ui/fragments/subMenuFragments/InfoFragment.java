package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments;

import java.lang.System;

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020&H\u0002J$\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020&H\u0016J\b\u00100\u001a\u00020&H\u0016J\b\u00101\u001a\u00020&H\u0016J\u001a\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010.H\u0017J\u0010\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\f\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\u001c8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\"\u0010\u001e\u00a8\u00066"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/InfoFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/agvahealthcare/ventilator_ext/databinding/FragmentSettingsBinding;", "activityViewModel", "Landroidx/lifecycle/AndroidViewModel;", "batteryHealth", "", "Ljava/lang/Integer;", "batteryLevel", "batteryRemainingTime", "binding", "getBinding", "()Lcom/agvahealthcare/ventilator_ext/databinding/FragmentSettingsBinding;", "isBatteryConnected", "", "Ljava/lang/Boolean;", "isClicked", "prefManager", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;", "getPrefManager", "()Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;", "setPrefManager", "(Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;)V", "timerForBatteryData", "Landroid/os/CountDownTimer;", "usageStat", "Landroid/app/usage/UsageStatsManager;", "getUsageStat", "()Landroid/app/usage/UsageStatsManager;", "setUsageStat", "(Landroid/app/usage/UsageStatsManager;)V", "usageStats", "getUsageStats", "usageStats$delegate", "Lkotlin/Lazy;", "cancelTimeOut", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onPause", "onResume", "onViewCreated", "view", "roundMinutes", "value", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class InfoFragment extends androidx.fragment.app.Fragment {
    private com.agvahealthcare.ventilator_ext.databinding.FragmentSettingsBinding _binding;
    private android.os.CountDownTimer timerForBatteryData;
    private java.lang.Integer batteryLevel;
    private java.lang.Integer batteryHealth;
    private java.lang.Integer batteryRemainingTime;
    private java.lang.Boolean isBatteryConnected;
    private boolean isClicked = false;
    @org.jetbrains.annotations.Nullable
    private com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager prefManager;
    private androidx.lifecycle.AndroidViewModel activityViewModel;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy usageStats$delegate = null;
    @org.jetbrains.annotations.Nullable
    private android.app.usage.UsageStatsManager usageStat;
    
    public InfoFragment() {
        super();
    }
    
    private final com.agvahealthcare.ventilator_ext.databinding.FragmentSettingsBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager getPrefManager() {
        return null;
    }
    
    public final void setPrefManager(@org.jetbrains.annotations.Nullable
    com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.app.usage.UsageStatsManager getUsageStats() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.app.usage.UsageStatsManager getUsageStat() {
        return null;
    }
    
    public final void setUsageStat(@org.jetbrains.annotations.Nullable
    android.app.usage.UsageStatsManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"HardwareIds"})
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final int roundMinutes(int value) {
        return 0;
    }
    
    private final void cancelTimeOut() {
    }
    
    @java.lang.Override
    public void onPause() {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onDetach() {
    }
}