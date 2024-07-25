package com.agvahealthcare.ventilator_ext.presentation.ui.fragments;

import java.lang.System;

/**
 * Created by MASOOM ZAID on 20-04-2023.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u000f\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200H\u0002J\b\u00102\u001a\u00020.H\u0003J$\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020.H\u0016J\u0018\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020?H\u0016J\u0018\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020\u0016H\u0016J \u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020B2\u0006\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020?H\u0016J \u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020B2\u0006\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020\u0016H\u0016J\u0010\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020\u0019H\u0016J\u001a\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u0002042\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010J\u001a\u00020.H\u0002J\b\u0010K\u001a\u00020.H\u0002J\b\u0010L\u001a\u00020.H\u0002J\u0016\u0010M\u001a\u00020.2\u0006\u0010N\u001a\u00020\u00162\u0006\u0010O\u001a\u00020?J\u000e\u0010P\u001a\u00020.2\u0006\u0010D\u001a\u000200J\u0018\u0010Q\u001a\u00020.2\u0006\u0010R\u001a\u00020\u00162\u0006\u0010S\u001a\u00020\u0016H\u0007J3\u0010T\u001a\u00020.2\b\u0010U\u001a\u0004\u0018\u00010\u00162\b\u0010V\u001a\u0004\u0018\u00010?2\b\u0010W\u001a\u0004\u0018\u00010\u00162\b\u0010S\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010XJ\u0016\u0010Y\u001a\u00020.2\u0006\u0010N\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020?R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006["}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/CommonFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnTileSelectListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnKnobPressListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnLimitChangeListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/DialogCloseListener;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnLimitSelectListener;", "communicationService", "Lcom/agvahealthcare/ventilator_ext/domain/support/service/CommunicationService;", "(Lcom/agvahealthcare/ventilator_ext/domain/support/service/CommunicationService;)V", "_binding", "Lcom/agvahealthcare/ventilator_ext/databinding/FragmentCommonBinding;", "binding", "getBinding", "()Lcom/agvahealthcare/ventilator_ext/databinding/FragmentCommonBinding;", "commonViewModel", "Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "getCommonViewModel", "()Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "commonViewModel$delegate", "Lkotlin/Lazy;", "currentModeCode", "", "dataList", "Ljava/util/ArrayList;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/models/Tile_Model_Class;", "eventViewModel", "Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/EventViewModel;", "getEventViewModel", "()Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/EventViewModel;", "eventViewModel$delegate", "flowChartFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/charts/FlowChartFragment;", "knobClass", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/KnobClass;", "observedAdapter", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/ObserverdAdapter;", "observedList", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/models/ObservedModelClass;", "preferenceManager", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;", "pressureChartFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/charts/PressureChartFragment;", "tileAdapter", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/TileAdapter;", "addEvents", "", "eventMsg", "", "uhid", "notifyAdapter", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHandleDialogClose", "onKnobPress", "label", "newValue", "", "onLimitChange", "type", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$KnobSelectedType;", "onLimitSelect", "value", "", "onTileSelect", "data", "onViewCreated", "view", "setupAdapter", "setupGraphFragment", "setupObservedAdapter", "updateFlowGraph", "x", "flow", "updateKnobData", "updateObservedTherapyEnd", "n2o", "o2", "updateObservedTiles", "flow_value", "paw_value", "fio2_value", "(Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;)V", "updatePressureGraph", "pressure", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class CommonFragment extends androidx.fragment.app.Fragment implements com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTileSelectListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnKnobPressListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitChangeListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener, com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitSelectListener {
    private com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService communicationService;
    private com.agvahealthcare.ventilator_ext.databinding.FragmentCommonBinding _binding;
    private com.agvahealthcare.ventilator_ext.presentation.adapters.TileAdapter tileAdapter;
    private com.agvahealthcare.ventilator_ext.presentation.adapters.ObserverdAdapter observedAdapter;
    private java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class> dataList;
    private java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.ObservedModelClass> observedList;
    private com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager preferenceManager;
    private com.agvahealthcare.ventilator_ext.presentation.utils.KnobClass knobClass;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.charts.PressureChartFragment pressureChartFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.charts.FlowChartFragment flowChartFragment;
    private int currentModeCode = -1;
    private final kotlin.Lazy commonViewModel$delegate = null;
    private final kotlin.Lazy eventViewModel$delegate = null;
    
    public CommonFragment(@org.jetbrains.annotations.Nullable
    com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService communicationService) {
        super();
    }
    
    private final com.agvahealthcare.ventilator_ext.databinding.FragmentCommonBinding getBinding() {
        return null;
    }
    
    private final com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel getCommonViewModel() {
        return null;
    }
    
    private final com.agvahealthcare.ventilator_ext.presentation.viewmodels.EventViewModel getEventViewModel() {
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
    
    private final void addEvents(java.lang.String eventMsg, java.lang.String uhid) {
    }
    
    private final void setupGraphFragment() {
    }
    
    public final void updatePressureGraph(int x, float pressure) {
    }
    
    public final void updateFlowGraph(int x, float flow) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void updateObservedTherapyEnd(int n2o, int o2) {
    }
    
    public final void updateObservedTiles(@org.jetbrains.annotations.Nullable
    java.lang.Integer flow_value, @org.jetbrains.annotations.Nullable
    java.lang.Float paw_value, @org.jetbrains.annotations.Nullable
    java.lang.Integer fio2_value, @org.jetbrains.annotations.Nullable
    java.lang.Integer o2) {
    }
    
    private final void setupAdapter() {
    }
    
    public final void updateKnobData(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @java.lang.Override
    public void onLimitSelect(boolean value) {
    }
    
    private final void setupObservedAdapter() {
    }
    
    @java.lang.Override
    public void onTileSelect(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class data) {
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