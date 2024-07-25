package com.agvahealthcare.ventilator_ext.presentation.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B5\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0017H\u0016J\u001e\u0010&\u001a\u00020 2\u0016\u0010\'\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006)"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/adapters/TileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/TileAdapter$TileParameterViewHolder;", "dataList", "Ljava/util/ArrayList;", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/models/Tile_Model_Class;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "onTileSelectListener", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnTileSelectListener;", "onLimitSelectListener", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnLimitSelectListener;", "(Ljava/util/ArrayList;Landroid/content/Context;Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnTileSelectListener;Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnLimitSelectListener;)V", "getOnLimitSelectListener", "()Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnLimitSelectListener;", "setOnLimitSelectListener", "(Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnLimitSelectListener;)V", "getOnTileSelectListener", "()Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnTileSelectListener;", "setOnTileSelectListener", "(Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnTileSelectListener;)V", "selectedTile", "", "getSelectedTile", "()I", "setSelectedTile", "(I)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateAdapter", "newList", "TileParameterViewHolder", "app_debug"})
public final class TileAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.agvahealthcare.ventilator_ext.presentation.adapters.TileAdapter.TileParameterViewHolder> {
    private java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class> dataList;
    private android.content.Context context;
    @org.jetbrains.annotations.NotNull
    private com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTileSelectListener onTileSelectListener;
    @org.jetbrains.annotations.NotNull
    private com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitSelectListener onLimitSelectListener;
    private int selectedTile = -1;
    
    public TileAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class> dataList, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTileSelectListener onTileSelectListener, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitSelectListener onLimitSelectListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTileSelectListener getOnTileSelectListener() {
        return null;
    }
    
    public final void setOnTileSelectListener(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTileSelectListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitSelectListener getOnLimitSelectListener() {
        return null;
    }
    
    public final void setOnLimitSelectListener(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitSelectListener p0) {
    }
    
    public final void updateAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class> newList) {
    }
    
    public final int getSelectedTile() {
        return 0;
    }
    
    public final void setSelectedTile(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.agvahealthcare.ventilator_ext.presentation.adapters.TileAdapter.TileParameterViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.adapters.TileAdapter.TileParameterViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u0082\u0001\u0002\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/adapters/TileAdapter$TileParameterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "FourTileViewHolder", "TwoTileViewHolder", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/TileAdapter$TileParameterViewHolder$FourTileViewHolder;", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/TileAdapter$TileParameterViewHolder$TwoTileViewHolder;", "app_debug"})
    public static abstract class TileParameterViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        private TileParameterViewHolder(android.view.View view) {
            super(null);
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/adapters/TileAdapter$TileParameterViewHolder$TwoTileViewHolder;", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/TileAdapter$TileParameterViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "ccDownButtonLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getCcDownButtonLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setCcDownButtonLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "ccUpButtonLayout", "getCcUpButtonLayout", "setCcUpButtonLayout", "tileLayout", "getTileLayout", "setTileLayout", "txtTitle", "Landroid/widget/TextView;", "getTxtTitle", "()Landroid/widget/TextView;", "setTxtTitle", "(Landroid/widget/TextView;)V", "txtUnit", "getTxtUnit", "setTxtUnit", "txtValue", "getTxtValue", "setTxtValue", "app_debug"})
        public static final class TwoTileViewHolder extends com.agvahealthcare.ventilator_ext.presentation.adapters.TileAdapter.TileParameterViewHolder {
            @org.jetbrains.annotations.Nullable
            private androidx.constraintlayout.widget.ConstraintLayout ccUpButtonLayout;
            @org.jetbrains.annotations.Nullable
            private androidx.constraintlayout.widget.ConstraintLayout ccDownButtonLayout;
            @org.jetbrains.annotations.Nullable
            private android.widget.TextView txtTitle;
            @org.jetbrains.annotations.Nullable
            private android.widget.TextView txtValue;
            @org.jetbrains.annotations.Nullable
            private android.widget.TextView txtUnit;
            @org.jetbrains.annotations.Nullable
            private androidx.constraintlayout.widget.ConstraintLayout tileLayout;
            
            public TwoTileViewHolder(@org.jetbrains.annotations.NotNull
            android.view.View view) {
                super(null);
            }
            
            @org.jetbrains.annotations.Nullable
            public final androidx.constraintlayout.widget.ConstraintLayout getCcUpButtonLayout() {
                return null;
            }
            
            public final void setCcUpButtonLayout(@org.jetbrains.annotations.Nullable
            androidx.constraintlayout.widget.ConstraintLayout p0) {
            }
            
            @org.jetbrains.annotations.Nullable
            public final androidx.constraintlayout.widget.ConstraintLayout getCcDownButtonLayout() {
                return null;
            }
            
            public final void setCcDownButtonLayout(@org.jetbrains.annotations.Nullable
            androidx.constraintlayout.widget.ConstraintLayout p0) {
            }
            
            @org.jetbrains.annotations.Nullable
            public final android.widget.TextView getTxtTitle() {
                return null;
            }
            
            public final void setTxtTitle(@org.jetbrains.annotations.Nullable
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
            public final android.widget.TextView getTxtUnit() {
                return null;
            }
            
            public final void setTxtUnit(@org.jetbrains.annotations.Nullable
            android.widget.TextView p0) {
            }
            
            @org.jetbrains.annotations.Nullable
            public final androidx.constraintlayout.widget.ConstraintLayout getTileLayout() {
                return null;
            }
            
            public final void setTileLayout(@org.jetbrains.annotations.Nullable
            androidx.constraintlayout.widget.ConstraintLayout p0) {
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/adapters/TileAdapter$TileParameterViewHolder$FourTileViewHolder;", "Lcom/agvahealthcare/ventilator_ext/presentation/adapters/TileAdapter$TileParameterViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "ccDownButtonLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getCcDownButtonLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setCcDownButtonLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "ccUpButtonLayout", "getCcUpButtonLayout", "setCcUpButtonLayout", "tileLayout", "getTileLayout", "setTileLayout", "txtTitle", "Landroid/widget/TextView;", "getTxtTitle", "()Landroid/widget/TextView;", "setTxtTitle", "(Landroid/widget/TextView;)V", "txtUnit", "getTxtUnit", "setTxtUnit", "txtValue", "getTxtValue", "setTxtValue", "app_debug"})
        public static final class FourTileViewHolder extends com.agvahealthcare.ventilator_ext.presentation.adapters.TileAdapter.TileParameterViewHolder {
            @org.jetbrains.annotations.Nullable
            private androidx.constraintlayout.widget.ConstraintLayout ccUpButtonLayout;
            @org.jetbrains.annotations.Nullable
            private androidx.constraintlayout.widget.ConstraintLayout ccDownButtonLayout;
            @org.jetbrains.annotations.Nullable
            private android.widget.TextView txtTitle;
            @org.jetbrains.annotations.Nullable
            private android.widget.TextView txtValue;
            @org.jetbrains.annotations.Nullable
            private android.widget.TextView txtUnit;
            @org.jetbrains.annotations.Nullable
            private androidx.constraintlayout.widget.ConstraintLayout tileLayout;
            
            public FourTileViewHolder(@org.jetbrains.annotations.NotNull
            android.view.View view) {
                super(null);
            }
            
            @org.jetbrains.annotations.Nullable
            public final androidx.constraintlayout.widget.ConstraintLayout getCcUpButtonLayout() {
                return null;
            }
            
            public final void setCcUpButtonLayout(@org.jetbrains.annotations.Nullable
            androidx.constraintlayout.widget.ConstraintLayout p0) {
            }
            
            @org.jetbrains.annotations.Nullable
            public final androidx.constraintlayout.widget.ConstraintLayout getCcDownButtonLayout() {
                return null;
            }
            
            public final void setCcDownButtonLayout(@org.jetbrains.annotations.Nullable
            androidx.constraintlayout.widget.ConstraintLayout p0) {
            }
            
            @org.jetbrains.annotations.Nullable
            public final android.widget.TextView getTxtTitle() {
                return null;
            }
            
            public final void setTxtTitle(@org.jetbrains.annotations.Nullable
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
            public final android.widget.TextView getTxtUnit() {
                return null;
            }
            
            public final void setTxtUnit(@org.jetbrains.annotations.Nullable
            android.widget.TextView p0) {
            }
            
            @org.jetbrains.annotations.Nullable
            public final androidx.constraintlayout.widget.ConstraintLayout getTileLayout() {
                return null;
            }
            
            public final void setTileLayout(@org.jetbrains.annotations.Nullable
            androidx.constraintlayout.widget.ConstraintLayout p0) {
            }
        }
    }
}