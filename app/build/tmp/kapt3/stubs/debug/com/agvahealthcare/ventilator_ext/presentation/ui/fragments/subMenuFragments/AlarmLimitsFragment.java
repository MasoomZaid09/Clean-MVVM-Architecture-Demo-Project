package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\"H\u0016J \u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J \u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\"H\u0016J\u001a\u0010&\u001a\u00020\u00122\u0006\u0010\'\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010(\u001a\u00020\u0012H\u0002J\u000e\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u001fR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/AlarmLimitsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnKnobPressListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/DialogCloseListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnLimitChangeListener;", "()V", "_binding", "Lcom/agvahealthcare/ventilator_ext/databinding/FragmentAlarmLimitsBinding;", "binding", "getBinding", "()Lcom/agvahealthcare/ventilator_ext/databinding/FragmentAlarmLimitsBinding;", "isUpperLimit", "", "knobClass", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/KnobClass;", "preferenceManager", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;", "initViewForAlarmLimits", "", "normaliseTile", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHandleDialogClose", "onKnobPress", "label", "", "newValue", "", "", "onLimitChange", "type", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$KnobSelectedType;", "onViewCreated", "view", "setOnClickListener", "updateKnobData", "value", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class AlarmLimitsFragment extends androidx.fragment.app.Fragment implements com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnKnobPressListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitChangeListener {
    private com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager preferenceManager;
    private com.agvahealthcare.ventilator_ext.databinding.FragmentAlarmLimitsBinding _binding;
    private com.agvahealthcare.ventilator_ext.presentation.utils.KnobClass knobClass;
    private boolean isUpperLimit = false;
    
    public AlarmLimitsFragment() {
        super();
    }
    
    private final com.agvahealthcare.ventilator_ext.databinding.FragmentAlarmLimitsBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void normaliseTile() {
    }
    
    private final void setOnClickListener() {
    }
    
    public final void updateKnobData(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @java.lang.Override
    public void onKnobPress(@org.jetbrains.annotations.NotNull
    java.lang.String label, int newValue) {
    }
    
    @java.lang.Override
    public void onLimitChange(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.KnobSelectedType type, @org.jetbrains.annotations.NotNull
    java.lang.String label, int newValue) {
    }
    
    @java.lang.Override
    public void onLimitChange(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.KnobSelectedType type, @org.jetbrains.annotations.NotNull
    java.lang.String label, float newValue) {
    }
    
    @java.lang.Override
    public void onKnobPress(@org.jetbrains.annotations.NotNull
    java.lang.String label, float newValue) {
    }
    
    @java.lang.Override
    public void onHandleDialogClose() {
    }
    
    private final void initViewForAlarmLimits() {
    }
}