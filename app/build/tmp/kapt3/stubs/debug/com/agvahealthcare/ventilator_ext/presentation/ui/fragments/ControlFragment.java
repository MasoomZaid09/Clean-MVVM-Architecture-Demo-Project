package com.agvahealthcare.ventilator_ext.presentation.ui.fragments;

import java.lang.System;

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010&\u001a\u00020\'H\u0002J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020\'2\u0006\u00101\u001a\u00020\u001fH\u0017J\u001a\u00102\u001a\u00020\'2\u0006\u00103\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0017J\b\u00104\u001a\u00020\'H\u0002J\b\u00105\u001a\u00020\'H\u0002J\b\u00106\u001a\u00020\'H\u0002J\b\u00107\u001a\u00020\'H\u0002J\b\u00108\u001a\u00020\'H\u0002J\u000e\u00109\u001a\u00020\'2\u0006\u0010:\u001a\u00020\u001bR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/ControlFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnMenuChangeListener;", "closeListener", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/DialogCloseListener;", "onStartSedation", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnStartSedationListener;", "(Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/DialogCloseListener;Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnStartSedationListener;)V", "_binding", "Lcom/agvahealthcare/ventilator_ext/databinding/FragmentControlBinding;", "advancedFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/controlSettingFragments/AdvancedFragment;", "basicFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/controlSettingFragments/BasicFragment;", "binding", "getBinding", "()Lcom/agvahealthcare/ventilator_ext/databinding/FragmentControlBinding;", "commonViewModel", "Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "getCommonViewModel", "()Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "commonViewModel$delegate", "Lkotlin/Lazy;", "controlAdapter", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/ControlAdapter;", "dataList", "Ljava/util/ArrayList;", "", "intelliFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/controlSettingFragments/IntelliFragment;", "mode", "", "getMode", "()I", "setMode", "(I)V", "preferenceManager", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;", "closeFragment", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onMenuChange", "position", "onViewCreated", "view", "setupAdapter", "setupDefaultView", "showAdvancedFragment", "showBasicFragment", "showIntelliFragment", "updateKnobData", "value", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class ControlFragment extends androidx.fragment.app.Fragment implements com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnMenuChangeListener {
    private com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener closeListener;
    private com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnStartSedationListener onStartSedation;
    private com.agvahealthcare.ventilator_ext.databinding.FragmentControlBinding _binding;
    private com.agvahealthcare.ventilator_ext.presentation.adapters.ControlAdapter controlAdapter;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.controlSettingFragments.BasicFragment basicFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.controlSettingFragments.AdvancedFragment advancedFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.controlSettingFragments.IntelliFragment intelliFragment;
    private java.util.ArrayList<java.lang.String> dataList;
    private final kotlin.Lazy commonViewModel$delegate = null;
    private com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager preferenceManager;
    private int mode = -1;
    
    public ControlFragment(@org.jetbrains.annotations.Nullable
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener closeListener, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnStartSedationListener onStartSedation) {
        super();
    }
    
    private final com.agvahealthcare.ventilator_ext.databinding.FragmentControlBinding getBinding() {
        return null;
    }
    
    private final com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel getCommonViewModel() {
        return null;
    }
    
    public final int getMode() {
        return 0;
    }
    
    public final void setMode(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public final void updateKnobData(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    private final void showBasicFragment() {
    }
    
    private final void showAdvancedFragment() {
    }
    
    private final void showIntelliFragment() {
    }
    
    private final void closeFragment() {
    }
    
    private final void setupAdapter() {
    }
    
    private final void setupDefaultView() {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    @java.lang.Override
    public void onMenuChange(int position) {
    }
}