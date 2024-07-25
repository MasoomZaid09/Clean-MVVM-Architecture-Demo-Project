package com.agvahealthcare.ventilator_ext.presentation.ui.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnLimitChangeListener;", "", "onLimitChange", "", "type", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$KnobSelectedType;", "label", "", "newValue", "", "", "app_debug"})
public abstract interface OnLimitChangeListener {
    
    public abstract void onLimitChange(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.KnobSelectedType type, @org.jetbrains.annotations.NotNull
    java.lang.String label, float newValue);
    
    public abstract void onLimitChange(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.KnobSelectedType type, @org.jetbrains.annotations.NotNull
    java.lang.String label, int newValue);
}