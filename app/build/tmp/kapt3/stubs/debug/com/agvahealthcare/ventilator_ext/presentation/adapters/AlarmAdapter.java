package com.agvahealthcare.ventilator_ext.presentation.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0006\u0010\u000f\u001a\u00020\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\tH\u0007J\u0006\u0010\u001a\u001a\u00020\u0011J\u0006\u0010\u001b\u001a\u00020\u0011J \u0010\u001c\u001a\u00020\u00112\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0007J\u0006\u0010\u001e\u001a\u00020\u0011R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/adapters/AlarmAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/AlarmAdapter$AlarmViewHolder;", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "selectedIndex", "", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "getItemCount", "getSelection", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "pos", "setSelectionDownward", "setSelectionUpward", "updateDataList", "newList", "updateIndex", "AlarmViewHolder", "app_debug"})
public final class AlarmAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.agvahealthcare.ventilator_ext.presentation.adapters.AlarmAdapter.AlarmViewHolder> {
    private java.util.ArrayList<java.lang.String> dataList;
    private int selectedIndex = 0;
    
    public AlarmAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> dataList) {
        super();
    }
    
    public final int getSelectedIndex() {
        return 0;
    }
    
    public final void setSelectedIndex(int p0) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void updateDataList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> newList) {
    }
    
    public final void updateIndex() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.agvahealthcare.ventilator_ext.presentation.adapters.AlarmAdapter.AlarmViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.adapters.AlarmAdapter.AlarmViewHolder holder, int position) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setSelection(int pos) {
    }
    
    public final int getSelection() {
        return 0;
    }
    
    public final void setSelectionDownward() {
    }
    
    public final void setSelectionUpward() {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006#"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/adapters/AlarmAdapter$AlarmViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "layoutId", "Landroidx/appcompat/widget/LinearLayoutCompat;", "getLayoutId", "()Landroidx/appcompat/widget/LinearLayoutCompat;", "setLayoutId", "(Landroidx/appcompat/widget/LinearLayoutCompat;)V", "textViewUHID", "Landroid/widget/TextView;", "getTextViewUHID", "()Landroid/widget/TextView;", "setTextViewUHID", "(Landroid/widget/TextView;)V", "tvAlarmType", "getTvAlarmType", "setTvAlarmType", "tvEndAlarmDate", "getTvEndAlarmDate", "setTvEndAlarmDate", "tvStartAlarmDate", "getTvStartAlarmDate", "setTvStartAlarmDate", "tvStartAlarmtime", "getTvStartAlarmtime", "setTvStartAlarmtime", "tvcolorpriority", "Landroid/widget/Button;", "getTvcolorpriority", "()Landroid/widget/Button;", "setTvcolorpriority", "(Landroid/widget/Button;)V", "app_debug"})
    public static final class AlarmViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.Nullable
        private android.widget.TextView tvAlarmType;
        @org.jetbrains.annotations.Nullable
        private android.widget.Button tvcolorpriority;
        @org.jetbrains.annotations.Nullable
        private android.widget.TextView tvStartAlarmDate;
        @org.jetbrains.annotations.Nullable
        private android.widget.TextView tvStartAlarmtime;
        @org.jetbrains.annotations.Nullable
        private android.widget.TextView tvEndAlarmDate;
        @org.jetbrains.annotations.Nullable
        private android.widget.TextView textViewUHID;
        @org.jetbrains.annotations.Nullable
        private androidx.appcompat.widget.LinearLayoutCompat layoutId;
        
        public AlarmViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.widget.TextView getTvAlarmType() {
            return null;
        }
        
        public final void setTvAlarmType(@org.jetbrains.annotations.Nullable
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.widget.Button getTvcolorpriority() {
            return null;
        }
        
        public final void setTvcolorpriority(@org.jetbrains.annotations.Nullable
        android.widget.Button p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.widget.TextView getTvStartAlarmDate() {
            return null;
        }
        
        public final void setTvStartAlarmDate(@org.jetbrains.annotations.Nullable
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.widget.TextView getTvStartAlarmtime() {
            return null;
        }
        
        public final void setTvStartAlarmtime(@org.jetbrains.annotations.Nullable
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.widget.TextView getTvEndAlarmDate() {
            return null;
        }
        
        public final void setTvEndAlarmDate(@org.jetbrains.annotations.Nullable
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.widget.TextView getTextViewUHID() {
            return null;
        }
        
        public final void setTextViewUHID(@org.jetbrains.annotations.Nullable
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final androidx.appcompat.widget.LinearLayoutCompat getLayoutId() {
            return null;
        }
        
        public final void setLayoutId(@org.jetbrains.annotations.Nullable
        androidx.appcompat.widget.LinearLayoutCompat p0) {
        }
    }
}