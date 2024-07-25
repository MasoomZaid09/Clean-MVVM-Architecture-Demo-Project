package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments;

import java.lang.System;

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(H\u0016J$\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020&H\u0016J\b\u00101\u001a\u00020&H\u0016J\u001a\u00102\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J\b\u00106\u001a\u00020&H\u0002J\b\u00107\u001a\u00020&H\u0002J\u0010\u00108\u001a\u00020&2\u0006\u0010$\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/ErrorLogsFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "_binding", "Lcom/agvahealthcare/ventilator_ext/databinding/FragmentErrorLogsBinding;", "binding", "getBinding", "()Lcom/agvahealthcare/ventilator_ext/databinding/FragmentErrorLogsBinding;", "buttonLayout", "Landroidx/appcompat/widget/LinearLayoutCompat;", "commonViewModel", "Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "getCommonViewModel", "()Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "commonViewModel$delegate", "Lkotlin/Lazy;", "dataList", "Ljava/util/ArrayList;", "", "endIndex", "", "mAdapter", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/AlarmAdapter;", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getMLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setMLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "pageNo", "preferenceManager", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;", "spinnerAlarm", "Landroid/widget/Spinner;", "startIndex", "uhid", "onClick", "", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onViewCreated", "scrollBack", "", "scrollForward", "setUpAlarmsData", "setupAdapter", "setupDataDefault", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class ErrorLogsFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    private androidx.appcompat.widget.LinearLayoutCompat buttonLayout;
    private com.agvahealthcare.ventilator_ext.presentation.adapters.AlarmAdapter mAdapter;
    public androidx.recyclerview.widget.LinearLayoutManager mLayoutManager;
    private android.widget.Spinner spinnerAlarm;
    private java.util.ArrayList<java.lang.String> dataList;
    private java.lang.String uhid = "";
    private int startIndex = 0;
    private int endIndex = 10;
    private int pageNo = 1;
    private final kotlin.Lazy commonViewModel$delegate = null;
    private com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager preferenceManager;
    private com.agvahealthcare.ventilator_ext.databinding.FragmentErrorLogsBinding _binding;
    
    public ErrorLogsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.LinearLayoutManager getMLayoutManager() {
        return null;
    }
    
    public final void setMLayoutManager(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.LinearLayoutManager p0) {
    }
    
    private final com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel getCommonViewModel() {
        return null;
    }
    
    private final com.agvahealthcare.ventilator_ext.databinding.FragmentErrorLogsBinding getBinding() {
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
    public void onPause() {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    private final void setupAdapter() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    private final void setupDataDefault(java.lang.String uhid) {
    }
    
    private final void setUpAlarmsData() {
    }
    
    public final boolean scrollForward() {
        return false;
    }
    
    public final boolean scrollBack() {
        return false;
    }
}