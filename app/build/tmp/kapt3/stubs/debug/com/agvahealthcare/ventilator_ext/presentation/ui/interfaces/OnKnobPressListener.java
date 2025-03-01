package com.agvahealthcare.ventilator_ext.presentation.ui.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnKnobPressListener;", "", "onKnobPress", "", "label", "", "newValue", "", "", "app_debug"})
public abstract interface OnKnobPressListener {
    
    public abstract void onKnobPress(@org.jetbrains.annotations.NotNull
    java.lang.String label, float newValue);
    
    public abstract void onKnobPress(@org.jetbrains.annotations.NotNull
    java.lang.String label, int newValue);
}