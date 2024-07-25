package com.agvahealthcare.ventilator_ext.presentation.ui.customViews;

import java.lang.System;

/**
 * Created by MASOOM ZAID on 23-04-2023.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B1\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0014J(\u0010\'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J\u000e\u0010,\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/customViews/N2OView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "amplitude", "circlePaint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "progress", "", "screenHeignt", "screenWidth", "startPoint", "Landroid/graphics/Point;", "textPaint", "textProgress", "wavePaint", "clipCircle", "", "canvas", "Landroid/graphics/Canvas;", "drawCircle", "drawText", "drawWave", "init", "measureSize", "defaultSize", "measureSpec", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setProgress", "app_debug"})
public final class N2OView extends android.view.View {
    
    /**
     * 波浪画笔
     */
    private android.graphics.Paint wavePaint;
    
    /**
     * 圆圈画笔
     */
    private android.graphics.Paint circlePaint;
    
    /**
     * 文字画笔
     */
    private android.graphics.Paint textPaint;
    
    /**
     * 控件宽度
     */
    private int screenWidth = 0;
    
    /**
     * 控件高度
     */
    private int screenHeignt = 0;
    
    /**
     * 振幅
     */
    private int amplitude = 100;
    private android.graphics.Path path;
    
    /**
     * 进度
     */
    private float progress = 0.0F;
    private float textProgress = 0.0F;
    
    /**
     * 起始点
     */
    private final android.graphics.Point startPoint = null;
    
    @kotlin.jvm.JvmOverloads
    public N2OView(@org.jetbrains.annotations.Nullable
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public N2OView(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    @androidx.annotation.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public N2OView(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    @androidx.annotation.Nullable
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public N2OView(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    @androidx.annotation.Nullable
    android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(null);
    }
    
    /**
     * 设置进度
     *
     * @param progress
     */
    public final void setProgress(float progress) {
    }
    
    private final void init() {
    }
    
    @java.lang.Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    @java.lang.Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    }
    
    @java.lang.Override
    protected void onDraw(@org.jetbrains.annotations.NotNull
    android.graphics.Canvas canvas) {
    }
    
    /**
     * 绘制文字
     *
     * @param canvas
     */
    private final void drawText(android.graphics.Canvas canvas) {
    }
    
    /**
     * 画波浪
     *
     * @param canvas
     */
    private final void drawWave(android.graphics.Canvas canvas) {
    }
    
    /**
     * 画圆形
     *
     * @param canvas
     */
    private final void drawCircle(android.graphics.Canvas canvas) {
    }
    
    /**
     * 剪裁画圆
     *
     * @param canvas
     */
    private final void clipCircle(android.graphics.Canvas canvas) {
    }
    
    private final int measureSize(int defaultSize, int measureSpec) {
        return 0;
    }
}