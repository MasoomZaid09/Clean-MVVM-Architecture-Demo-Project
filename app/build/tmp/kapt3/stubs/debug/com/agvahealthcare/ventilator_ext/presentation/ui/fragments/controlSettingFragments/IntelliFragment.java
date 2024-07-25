package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.controlSettingFragments;

import java.lang.System;

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0003J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0014H\u0016J \u0010\'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J \u0010\'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0014H\u0016J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0010H\u0016J\u001a\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010.\u001a\u00020\u0018H\u0002J\u000e\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020$R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/controlSettingFragments/IntelliFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnTileSelectListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnKnobPressListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnLimitChangeListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/DialogCloseListener;", "()V", "_binding", "Lcom/agvahealthcare/ventilator_ext/databinding/FragmentIntelliBinding;", "adapter", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/ControlParamsAdapter;", "binding", "getBinding", "()Lcom/agvahealthcare/ventilator_ext/databinding/FragmentIntelliBinding;", "dataList", "Ljava/util/ArrayList;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/models/Tile_Model_Class;", "knobClass", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/KnobClass;", "mode", "", "preferenceManager", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;", "notifyAdapter", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHandleDialogClose", "onKnobPress", "label", "", "newValue", "", "onLimitChange", "type", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$KnobSelectedType;", "onTileSelect", "data", "onViewCreated", "view", "setupAdapter", "updateKnobData", "value", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class IntelliFragment extends androidx.fragment.app.Fragment implements com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTileSelectListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnKnobPressListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitChangeListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener {
    private com.agvahealthcare.ventilator_ext.databinding.FragmentIntelliBinding _binding;
    private com.agvahealthcare.ventilator_ext.presentation.adapters.ControlParamsAdapter adapter;
    private java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class> dataList;
    private int mode = -1;
    private com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager preferenceManager;
    private com.agvahealthcare.ventilator_ext.presentation.utils.KnobClass knobClass;
    
    public IntelliFragment() {
        super();
    }
    
    private final com.agvahealthcare.ventilator_ext.databinding.FragmentIntelliBinding getBinding() {
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
    
    private final void setupAdapter() {
    }
    
    @java.lang.Override
    public void onTileSelect(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class data) {
    }
    
    public final void updateKnobData(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @java.lang.Override
    public void onKnobPress(@org.jetbrains.annotations.NotNull
    java.lang.String label, float newValue) {
    }
    
    @java.lang.Override
    public void onKnobPress(@org.jetbrains.annotations.NotNull
    java.lang.String label, int newValue) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    private final void notifyAdapter() {
    }
    
    @java.lang.Override
    public void onHandleDialogClose() {
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
}