package com.agvahealthcare.ventilator_ext;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0014\u0010\u0015\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017J\f\u0010\u0018\u001a\u00020\u0019*\u00020\rH\u0002J\f\u0010\u001a\u001a\u00020\u0019*\u00020\rH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/GraphView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dataPointLinePaint", "Landroid/graphics/Paint;", "dataSet", "", "Lcom/agvahealthcare/ventilator_ext/DataPoint;", "xMax", "", "xMin", "yMax", "yMin", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setData", "newDataSet", "", "toRealX", "", "toRealY", "app_debug"})
public final class GraphView extends android.view.View {
    private final java.util.List<com.agvahealthcare.ventilator_ext.DataPoint> dataSet = null;
    private int xMin = 0;
    private int xMax = 0;
    private int yMin = 0;
    private int yMax = 0;
    private final android.graphics.Paint dataPointLinePaint = null;
    
    public GraphView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.util.AttributeSet attributeSet) {
        super(null);
    }
    
    @java.lang.Override
    protected void onDraw(@org.jetbrains.annotations.NotNull
    android.graphics.Canvas canvas) {
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    java.util.List<com.agvahealthcare.ventilator_ext.DataPoint> newDataSet) {
    }
    
    private final float toRealX(int $this$toRealX) {
        return 0.0F;
    }
    
    private final float toRealY(int $this$toRealY) {
        return 0.0F;
    }
}