package com.agvahealthcare.ventilator_ext.presentation.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010\'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0002J\u0006\u0010)\u001a\u00020%J\u0016\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010,\u001a\u00020%2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010-\u001a\u00020%2\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010.\u001a\u00020%H\u0002J\b\u0010/\u001a\u00020%H\u0002J\b\u00100\u001a\u00020%H\u0002J\b\u00101\u001a\u00020%H\u0002J\b\u00102\u001a\u00020%H\u0002J\b\u00103\u001a\u00020%H\u0002J\u000e\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/utils/KnobClass;", "", "onKnobPressListener", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnKnobPressListener;", "onDialogCloseListener", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/DialogCloseListener;", "onLimitChangeListener", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnLimitChangeListener;", "(Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnKnobPressListener;Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/DialogCloseListener;Lcom/agvahealthcare/ventilator_ext/presentation/ui/interfaces/OnLimitChangeListener;)V", "alarmModel", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/AlarmLimitsModelClass;", "getAlarmModel", "()Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/AlarmLimitsModelClass;", "setAlarmModel", "(Lcom/agvahealthcare/ventilator_ext/presentation/ui/fragments/subMenuFragments/AlarmLimitsModelClass;)V", "bodyParams", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/models/Body_Params_Data_Class;", "countOfMaxLimit", "", "currentLable", "", "currentValue", "currentValueFloat", "", "isCloseListenerAvoided", "", "tileModel", "Lcom/agvahealthcare/ventilator_ext/presentation/ui/models/Tile_Model_Class;", "type", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$KnobSelectedType;", "getType", "()Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$KnobSelectedType;", "setType", "(Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$KnobSelectedType;)V", "visibilityTimeout", "Landroid/os/CountDownTimer;", "addition", "", "additionAlarms", "additionBodyParams", "additionTargetPressure", "cancelTimeout", "getAllAlarms", "data", "getAllBodyParams", "getAllParams", "ok", "startTimeoutWithDebounce", "subtraction", "subtractionAlarms", "subtractionBodyParams", "subtractionTargetPressure", "updateWithTimeoutDebounce", "value", "app_debug"})
public final class KnobClass {
    private com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnKnobPressListener onKnobPressListener;
    private com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener onDialogCloseListener;
    private com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitChangeListener onLimitChangeListener;
    private com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class tileModel;
    public com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.AlarmLimitsModelClass alarmModel;
    private com.agvahealthcare.ventilator_ext.presentation.ui.models.Body_Params_Data_Class bodyParams;
    private boolean isCloseListenerAvoided = false;
    private int currentValue = -1;
    private float currentValueFloat = -1.0F;
    private java.lang.String currentLable = "";
    private int countOfMaxLimit = 0;
    @org.jetbrains.annotations.Nullable
    private com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.KnobSelectedType type;
    private android.os.CountDownTimer visibilityTimeout;
    
    public KnobClass(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnKnobPressListener onKnobPressListener, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener onDialogCloseListener, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitChangeListener onLimitChangeListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.AlarmLimitsModelClass getAlarmModel() {
        return null;
    }
    
    public final void setAlarmModel(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.AlarmLimitsModelClass p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.KnobSelectedType getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.Nullable
    com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.KnobSelectedType p0) {
    }
    
    public final void getAllParams(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class data, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.KnobSelectedType type) {
    }
    
    public final void getAllAlarms(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.AlarmLimitsModelClass data, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.KnobSelectedType type) {
    }
    
    public final void getAllBodyParams(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.ui.models.Body_Params_Data_Class data, @org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.KnobSelectedType type) {
    }
    
    public final void updateWithTimeoutDebounce(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    private final void startTimeoutWithDebounce() {
    }
    
    public final void cancelTimeout() {
    }
    
    private final void addition() {
    }
    
    private final void additionAlarms() {
    }
    
    private final void additionBodyParams() {
    }
    
    private final void additionTargetPressure() {
    }
    
    private final void subtraction() {
    }
    
    private final void subtractionAlarms() {
    }
    
    private final void subtractionBodyParams() {
    }
    
    private final void subtractionTargetPressure() {
    }
    
    private final void ok() {
    }
}