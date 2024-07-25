package com.agvahealthcare.ventilator_ext.presentation.ui.fragments;

import java.lang.System;

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u001a\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010*\u001a\u00020\u001fH\u0002J\b\u0010+\u001a\u00020\u001fH\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\b\u0010.\u001a\u00020\u001fH\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J\b\u00100\u001a\u00020\u001fH\u0002J\b\u00101\u001a\u00020\u001fH\u0002J\u000e\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u000204R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/CommonSubMenuFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/agvahealthcare/ventilator_ext/databinding/CommonMenuSubFragmentBinding;", "advancedCalibrationFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/AdvancedCalibrationFragment;", "alarmLimitsFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/AlarmLimitsFragment;", "binding", "getBinding", "()Lcom/agvahealthcare/ventilator_ext/databinding/CommonMenuSubFragmentBinding;", "calibrationFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/CalibrationFragment;", "commonViewModel", "Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "getCommonViewModel", "()Lcom/agvahealthcare/ventilator_ext/presentation/viewmodels/CommonViewModel;", "commonViewModel$delegate", "Lkotlin/Lazy;", "errorLogsFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/ErrorLogsFragment;", "eventFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/EventFragment;", "infoFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/InfoFragment;", "recentPatientFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/RecentPatientsFragment;", "serviceFragment", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/ServiceFragment;", "hideAllFragments", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showAdvancedCalibrationFragment", "showAlarmLimitsFragment", "showCalibrationFragment", "showErrorLogsFragment", "showEventLogFragment", "showInfoFragment", "showRecentPatientFragment", "showServiceFragment", "updateViaKnob", "data", "", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class CommonSubMenuFragment extends androidx.fragment.app.Fragment {
    private com.agvahealthcare.ventilator_ext.databinding.CommonMenuSubFragmentBinding _binding;
    private final kotlin.Lazy commonViewModel$delegate = null;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.AlarmLimitsFragment alarmLimitsFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.RecentPatientsFragment recentPatientFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.CalibrationFragment calibrationFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.ServiceFragment serviceFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.InfoFragment infoFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.EventFragment eventFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.AdvancedCalibrationFragment advancedCalibrationFragment;
    private com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.ErrorLogsFragment errorLogsFragment;
    
    public CommonSubMenuFragment() {
        super();
    }
    
    private final com.agvahealthcare.ventilator_ext.databinding.CommonMenuSubFragmentBinding getBinding() {
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
    
    private final void showErrorLogsFragment() {
    }
    
    private final void showEventLogFragment() {
    }
    
    private final void showCalibrationFragment() {
    }
    
    private final void showAdvancedCalibrationFragment() {
    }
    
    private final void showInfoFragment() {
    }
    
    private final void showServiceFragment() {
    }
    
    private final void showAlarmLimitsFragment() {
    }
    
    private final void showRecentPatientFragment() {
    }
    
    private final void hideAllFragments() {
    }
}