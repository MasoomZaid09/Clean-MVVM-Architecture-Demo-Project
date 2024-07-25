package com.agvahealthcare.ventilator_ext.presentation.ui.fragments;

import java.lang.System;

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0017J\u001a\u0010\'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010)\u001a\u00020\u001bH\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\u000e\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u0017R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/MenuFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnMenuChangeListener;", "closeListener", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/DialogCloseListener;", "fromStandby", "", "(Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/DialogCloseListener;Z)V", "_binding", "Lcom/agvahealthcare/ventilator_ext/databinding/FragmentMenuBinding;", "binding", "getBinding", "()Lcom/agvahealthcare/ventilator_ext/databinding/FragmentMenuBinding;", "commonSubMenuFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/CommonSubMenuFragment;", "commonViewModel", "Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "getCommonViewModel", "()Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "commonViewModel$delegate", "Lkotlin/Lazy;", "dataList", "Ljava/util/ArrayList;", "", "menuAdapter", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/MenuAdapter;", "closeFragment", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onMenuChange", "position", "", "onViewCreated", "view", "setupAdapter", "setupDefaultView", "showCommonSubMenuFragment", "updateViaKnob", "data", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class MenuFragment extends androidx.fragment.app.Fragment implements com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnMenuChangeListener {
    private com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener closeListener;
    private boolean fromStandby;
    private com.agvahealthcare.ventilator_ext.databinding.FragmentMenuBinding _binding;
    private com.agvahealthcare.ventilator_ext.presentation.adapters.MenuAdapter menuAdapter;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.CommonSubMenuFragment commonSubMenuFragment;
    private java.util.ArrayList<java.lang.String> dataList;
    private final kotlin.Lazy commonViewModel$delegate = null;
    
    public MenuFragment(@org.jetbrains.annotations.Nullable
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener closeListener, boolean fromStandby) {
        super();
    }
    
    private final com.agvahealthcare.ventilator_ext.databinding.FragmentMenuBinding getBinding() {
        return null;
    }
    
    private final com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel getCommonViewModel() {
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
    
    public final void updateViaKnob(@org.jetbrains.annotations.NotNull
    java.lang.String data) {
    }
    
    private final void showCommonSubMenuFragment() {
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