package com.agvahealthcare.ventilator_ext.presentation.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\rH\u0017J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0016J \u0010\u001b\u001a\u00020\u00142\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/adapters/ObserverdAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/ObserverdAdapter$InfoViewHolder;", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/models/ObservedModelClass;", "Lkotlin/collections/ArrayList;", "preferenceManager", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;)V", "getItemCount", "", "giveConditionOfColoring", "", "label", "", "actualValue", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateAdapter", "newList", "InfoViewHolder", "app_debug"})
public final class ObserverdAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.agvahealthcare.ventilator_ext.presentation.adapters.ObserverdAdapter.InfoViewHolder> {
    private android.content.Context context;
    private java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.ObservedModelClass> dataList;
    private com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager preferenceManager;
    
    public ObserverdAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.ObservedModelClass> dataList, @org.jetbrains.annotations.Nullable
    com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager preferenceManager) {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void updateAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.ObservedModelClass> newList) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.agvahealthcare.ventilator_ext.presentation.adapters.ObserverdAdapter.InfoViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"ResourceAsColor"})
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.adapters.ObserverdAdapter.InfoViewHolder holder, int position) {
    }
    
    private final boolean giveConditionOfColoring(java.lang.String label, java.lang.String actualValue) {
        return false;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/adapters/ObserverdAdapter$InfoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "mainLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMainLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMainLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "txtLabel", "Landroid/widget/TextView;", "getTxtLabel", "()Landroid/widget/TextView;", "setTxtLabel", "(Landroid/widget/TextView;)V", "txtUnit", "getTxtUnit", "setTxtUnit", "txtValue", "getTxtValue", "setTxtValue", "app_debug"})
    public static final class InfoViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.Nullable
        private android.widget.TextView txtUnit;
        @org.jetbrains.annotations.Nullable
        private android.widget.TextView txtLabel;
        @org.jetbrains.annotations.Nullable
        private android.widget.TextView txtValue;
        @org.jetbrains.annotations.Nullable
        private androidx.constraintlayout.widget.ConstraintLayout mainLayout;
        
        public InfoViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.widget.TextView getTxtUnit() {
            return null;
        }
        
        public final void setTxtUnit(@org.jetbrains.annotations.Nullable
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.widget.TextView getTxtLabel() {
            return null;
        }
        
        public final void setTxtLabel(@org.jetbrains.annotations.Nullable
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.widget.TextView getTxtValue() {
            return null;
        }
        
        public final void setTxtValue(@org.jetbrains.annotations.Nullable
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final androidx.constraintlayout.widget.ConstraintLayout getMainLayout() {
            return null;
        }
        
        public final void setMainLayout(@org.jetbrains.annotations.Nullable
        androidx.constraintlayout.widget.ConstraintLayout p0) {
        }
    }
}