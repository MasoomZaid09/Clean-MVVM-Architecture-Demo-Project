package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments;

import java.lang.System;

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000bJ\b\u0010\u001d\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0003J\u0006\u0010\u001f\u001a\u00020\u000fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/CalibrationFragment;", "Landroidx/fragment/app/Fragment;", "communicationService", "Lcom/agvahealthcare/ventilator_ext/domain/support/service/CommunicationService;", "(Lcom/agvahealthcare/ventilator_ext/domain/support/service/CommunicationService;)V", "_binding", "Lcom/agvahealthcare/ventilator_ext/databinding/FragmentCalibrationBinding;", "binding", "getBinding", "()Lcom/agvahealthcare/ventilator_ext/databinding/FragmentCalibrationBinding;", "currentTag", "", "prefManager", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;", "normaliseChanges", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "postCalibrationbehaviourChange", "sendCalibrationCommandToVentilator", "sensorTag", "setUpOnClickListener", "setUpView", "updateSensorCalibrationStatus", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class CalibrationFragment extends androidx.fragment.app.Fragment {
    private com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService communicationService;
    private com.agvahealthcare.ventilator_ext.databinding.FragmentCalibrationBinding _binding;
    private com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager prefManager;
    private java.lang.String currentTag = "";
    
    public CalibrationFragment(@org.jetbrains.annotations.Nullable
    com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService communicationService) {
        super();
    }
    
    private final com.agvahealthcare.ventilator_ext.databinding.FragmentCalibrationBinding getBinding() {
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
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void setUpView() {
    }
    
    private final void setUpOnClickListener() {
    }
    
    public final void updateSensorCalibrationStatus() {
    }
    
    public final void sendCalibrationCommandToVentilator(@org.jetbrains.annotations.NotNull
    java.lang.String sensorTag) {
    }
    
    private final void normaliseChanges() {
    }
    
    private final void postCalibrationbehaviourChange() {
    }
}