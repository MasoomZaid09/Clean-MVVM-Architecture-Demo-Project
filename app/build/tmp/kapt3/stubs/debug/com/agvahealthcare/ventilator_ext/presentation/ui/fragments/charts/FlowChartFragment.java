package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.charts;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000bJ\b\u0010\u001f\u001a\u00020\u001cH\u0002J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u001a\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/charts/FlowChartFragment;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/charts/GraphFragment;", "()V", "_binding", "Lcom/agvahealthcare/ventilator_ext/databinding/FragmentChartBinding;", "binding", "getBinding", "()Lcom/agvahealthcare/ventilator_ext/databinding/FragmentChartBinding;", "dataSeries0", "Lcom/scichart/charting/model/dataSeries/IXyDataSeries;", "", "", "dataSeries1", "mCommonViewModel", "Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "maxRange", "", "minRange", "prefManager", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;", "timePeek", "titleStyle", "Lcom/scichart/drawing/common/FontStyle;", "getTitleStyle", "()Lcom/scichart/drawing/common/FontStyle;", "whichTrace", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$TraceArc;", "addEntry", "", "x", "y", "initGraph", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class FlowChartFragment extends com.agvahealthcare.ventilator_ext.presentation.ui.fragments.charts.GraphFragment {
    private com.agvahealthcare.ventilator_ext.databinding.FragmentChartBinding _binding;
    private com.scichart.charting.model.dataSeries.IXyDataSeries<java.lang.Integer, java.lang.Float> dataSeries0;
    private com.scichart.charting.model.dataSeries.IXyDataSeries<java.lang.Integer, java.lang.Float> dataSeries1;
    private com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager prefManager;
    private com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.TraceArc whichTrace;
    @org.jetbrains.annotations.NotNull
    private final com.scichart.drawing.common.FontStyle titleStyle = null;
    private com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel mCommonViewModel;
    private double minRange = 0.0;
    private double maxRange = 0.0;
    private int timePeek = -1;
    
    public FlowChartFragment() {
        super();
    }
    
    private final com.agvahealthcare.ventilator_ext.databinding.FragmentChartBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.scichart.drawing.common.FontStyle getTitleStyle() {
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
    
    private final void initGraph() {
    }
    
    public final void addEntry(int x, float y) {
    }
}