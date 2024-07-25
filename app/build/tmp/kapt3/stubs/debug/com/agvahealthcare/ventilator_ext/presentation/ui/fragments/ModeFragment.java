package com.agvahealthcare.ventilator_ext.presentation.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u001c\u0010\u0015\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0002J&\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/ModeFragment;", "Landroidx/fragment/app/Fragment;", "closeListener", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/DialogCloseListener;", "(Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/DialogCloseListener;)V", "_binding", "Lcom/agvahealthcare/ventilator_ext/databinding/FragmentModeBinding;", "binding", "getBinding", "()Lcom/agvahealthcare/ventilator_ext/databinding/FragmentModeBinding;", "preferenceManager", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;", "selectedLayout", "Landroid/view/View;", "selectedTextView", "Landroid/widget/TextView;", "highlightTile", "", "view", "textView", "initView", "normaliseTile", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "sendModeBroadcast", "mode", "", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class ModeFragment extends androidx.fragment.app.Fragment {
    private com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener closeListener;
    private com.agvahealthcare.ventilator_ext.databinding.FragmentModeBinding _binding;
    private com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager preferenceManager;
    private android.view.View selectedLayout;
    private android.widget.TextView selectedTextView;
    
    public ModeFragment(@org.jetbrains.annotations.Nullable
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener closeListener) {
        super();
    }
    
    private final com.agvahealthcare.ventilator_ext.databinding.FragmentModeBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
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
    
    private final void initView() {
    }
    
    private final void highlightTile(android.view.View view, android.widget.TextView textView) {
    }
    
    private final void normaliseTile(android.view.View view, android.widget.TextView textView) {
    }
    
    private final void sendModeBroadcast(int mode) {
    }
}