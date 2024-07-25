package com.agvahealthcare.ventilator_ext.presentation.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\nH\u0016J \u0010$\u001a\u00020\u001d2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/adapters/ControlParamsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/ControlParamsAdapter$ControlParamsViewHolder;", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/models/Tile_Model_Class;", "Lkotlin/collections/ArrayList;", "mode", "", "onTileSelectListener", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnTileSelectListener;", "type", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$AllControlType;", "(Landroid/content/Context;Ljava/util/ArrayList;ILcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnTileSelectListener;Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$AllControlType;)V", "selectedTile", "getSelectedTile", "()I", "setSelectedTile", "(I)V", "getItemCount", "getPercentage", "", "param", "value", "min", "max", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateAdapter", "newList", "ControlParamsViewHolder", "app_debug"})
public final class ControlParamsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.agvahealthcare.ventilator_ext.presentation.adapters.ControlParamsAdapter.ControlParamsViewHolder> {
    private android.content.Context context;
    private java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class> dataList;
    private int mode;
    private com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTileSelectListener onTileSelectListener;
    private com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AllControlType type;
    private int selectedTile = -1;
    
    public ControlParamsAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class> dataList, int mode, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTileSelectListener onTileSelectListener, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.AllControlType type) {
        super();
    }
    
    public final int getSelectedTile() {
        return 0;
    }
    
    public final void setSelectedTile(int p0) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void updateAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class> newList) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.agvahealthcare.ventilator_ext.presentation.adapters.ControlParamsAdapter.ControlParamsViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.adapters.ControlParamsAdapter.ControlParamsViewHolder holder, int position) {
    }
    
    private final double getPercentage(double value, double min, double max) {
        return 0.0;
    }
    
    private final double getPercentage(com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class param) {
        return 0.0;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/adapters/ControlParamsAdapter$ControlParamsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "mainLayoutPanel", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMainLayoutPanel", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMainLayoutPanel", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "progressBar", "Lantonkozyriatskyi/circularprogressindicator/CircularProgressIndicator;", "getProgressBar", "()Lantonkozyriatskyi/circularprogressindicator/CircularProgressIndicator;", "setProgressBar", "(Lantonkozyriatskyi/circularprogressindicator/CircularProgressIndicator;)V", "txtLabel", "Landroid/widget/TextView;", "getTxtLabel", "()Landroid/widget/TextView;", "setTxtLabel", "(Landroid/widget/TextView;)V", "txtUnit", "getTxtUnit", "setTxtUnit", "txtValue", "getTxtValue", "setTxtValue", "app_debug"})
    public static final class ControlParamsViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.Nullable
        private android.widget.TextView txtLabel;
        @org.jetbrains.annotations.Nullable
        private android.widget.TextView txtUnit;
        @org.jetbrains.annotations.Nullable
        private android.widget.TextView txtValue;
        @org.jetbrains.annotations.Nullable
        private androidx.constraintlayout.widget.ConstraintLayout mainLayoutPanel;
        @org.jetbrains.annotations.Nullable
        private antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator progressBar;
        
        public ControlParamsViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.widget.TextView getTxtLabel() {
            return null;
        }
        
        public final void setTxtLabel(@org.jetbrains.annotations.Nullable
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.widget.TextView getTxtUnit() {
            return null;
        }
        
        public final void setTxtUnit(@org.jetbrains.annotations.Nullable
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
        public final androidx.constraintlayout.widget.ConstraintLayout getMainLayoutPanel() {
            return null;
        }
        
        public final void setMainLayoutPanel(@org.jetbrains.annotations.Nullable
        androidx.constraintlayout.widget.ConstraintLayout p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator getProgressBar() {
            return null;
        }
        
        public final void setProgressBar(@org.jetbrains.annotations.Nullable
        antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator p0) {
        }
    }
}