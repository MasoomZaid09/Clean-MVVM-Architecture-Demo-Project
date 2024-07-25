package com.agvahealthcare.ventilator_ext.presentation.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/adapters/MenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/MenuAdapter$MenuViewHolder;", "context", "Landroid/content/Context;", "items", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "click", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnMenuChangeListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnMenuChangeListener;)V", "selectedIndex", "", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MenuViewHolder", "app_debug"})
public final class MenuAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.agvahealthcare.ventilator_ext.presentation.adapters.MenuAdapter.MenuViewHolder> {
    private android.content.Context context;
    private java.util.ArrayList<java.lang.String> items;
    private com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnMenuChangeListener click;
    private int selectedIndex = 0;
    
    public MenuAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> items, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnMenuChangeListener click) {
        super();
    }
    
    public final int getSelectedIndex() {
        return 0;
    }
    
    public final void setSelectedIndex(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.agvahealthcare.ventilator_ext.presentation.adapters.MenuAdapter.MenuViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.adapters.MenuAdapter.MenuViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/adapters/MenuAdapter$MenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "txtLabel", "Landroid/widget/TextView;", "getTxtLabel", "()Landroid/widget/TextView;", "setTxtLabel", "(Landroid/widget/TextView;)V", "app_debug"})
    public static final class MenuViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.Nullable
        private androidx.constraintlayout.widget.ConstraintLayout layout;
        @org.jetbrains.annotations.Nullable
        private android.widget.TextView txtLabel;
        
        public MenuViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.Nullable
        public final androidx.constraintlayout.widget.ConstraintLayout getLayout() {
            return null;
        }
        
        public final void setLayout(@org.jetbrains.annotations.Nullable
        androidx.constraintlayout.widget.ConstraintLayout p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.widget.TextView getTxtLabel() {
            return null;
        }
        
        public final void setTxtLabel(@org.jetbrains.annotations.Nullable
        android.widget.TextView p0) {
        }
    }
}