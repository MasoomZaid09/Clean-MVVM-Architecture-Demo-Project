package com.agvahealthcare.ventilator_ext.presentation.utils;

import java.lang.System;

/**
 * Created by MOHIT MALHOTRA on 24-10-2018.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/utils/IntentFactory;", "", "Companion", "app_debug"})
public abstract interface IntentFactory {
    @org.jetbrains.annotations.NotNull
    public static final com.agvahealthcare.ventilator_ext.presentation.utils.IntentFactory.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_USB_PERMISSION_VENTILATOR = "com.agvahealthcare.ventilator_ext.ACTION_USB_PERMISSION_VENTILATOR";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_GRAPH_LIMIT_CHANGE = "com.agvahealthcare.ventilator_ext.ACTION_GRAPH_LIMIT_CHANGE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_HARDWARE_SERIAL_NUMBER = "com.agvahealthcare.ventilator_ext.ACTION_HARDWARE_SERIAL_NUMBER";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_USB_PERMISSION_HID = "com.agvahealthcare.ventilator_ext.ACTION_USB_PERMISSION_HID";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_DEVICE_CONNECTED = "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_CONNECTED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_TESTING = "com.agvahealthcare.ventilator_ext.ACTION_TESTING";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_DEVICE_FAST_CONNECTED = "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_CONNECTED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_DEVICE_DISCONNECTED = "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_DISCONNECTED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_BT_DEVICE_FOUND = "com.agvahealthcare.ventilator_ext.ACTION_BT_DEVICE_FOUND";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_BT_DEVICE_NOT_FOUND = "com.agvahealthcare.ventilator_ext.ACTION_BT_DEVICE_NOT_FOUND";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_GATT_SERVICES_DISCOVERED = "com.agvahealthcare.ventilator_ext.ACTION_GATT_SERVICES_DISCOVERED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_DATA_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_DATA_AVAILABLE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_RAW_DATA_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_RAW_DATA_AVAILABLE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_SOFTWARE_VERSION_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_SOFTWARE_VERSION_AVAILABLE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_VENTILATOR_WIFI_CONNECTION_REQUESTED = "com.agvahealthcare.ventilator_ext.ACTION_VENTILATOR_WIFI_CONNECTION_REQUESTED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_VENTILATOR_WIFI_CONNECTION_RESPONSED = "com.agvahealthcare.ventilator_ext.ACTION_VENTILATOR_WIFI_CONNECTION_RESPONSED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_ACK_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_ACK_AVAILABLE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_BATTERY_STATUS_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_BATTERY_STATUS_AVAILABLE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_THERAPY_END_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_THERAPY_END_AVAILABLE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_MOTOR_LIFE_STATUS_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_MOTOR_LIFE_STATUS_AVAILABLE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_HEATSENSE_STATUS_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_HEATSENSE_STATUS_AVAILABLE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_CALIBRATION_ERROR_DATA = "com.agvahealthcare.ventilator_ext.ACTION_CALIBRATION_ERROR_DATA";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_HANDSHAKE_CALIBRATION_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_HANDSHAKE_CALIBRATION_AVAILABLE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_SENSOR_AVAILABILITY_RESPONSE = "com.agvahealthcare.ventilator_ext.ACTION_SENSOR_AVAILABILITY_RESPONSE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_SENSOR_CALIBRATION_RESPONSE = "com.agvahealthcare.ventilator_ext.ACTION_SENSOR_CALIBRATION_RESPONSE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_STANDBY_STATUS_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_STANDBY_STATUS_AVAILABLE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_SELF_TEST_STATUS_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_SELF_TEST_STATUS_AVAILABLE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_DEVICE_NAME_REQUESTED = "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_NAME_REQUESTED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_DEVICE_NAME_RESPONSED = "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_NAME_RESPONSED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_DATA_SENT = "com.agvahealthcare.ventilator_ext.ACTION_DATA_SENT";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_HANDSHAKE_COMPLETED = "com.agvahealthcare.ventilator_ext.ACTION_HANDSHAKE_COMPLETED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_HANDSHAKE_TIMEOUT = "com.agvahealthcare.ventilator_ext.ACTION_HANDSHAKE_TIMEOUT";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_TUBE_BLOCKAGE_DETECTED = "com.agvahealthcare.ventilator_ext.ACTION_TUBE_BLOCKAGE_DETECTED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_TUBE_BLOCKAGE_RESOLVED = "com.agvahealthcare.ventilator_ext.ACTION_TUBE_BLOCKAGE_RESOLVED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_HIGH_LEAK_INACCURACY_DETECTED = "com.agvahealthcare.ventilator_ext.ACTION_HIGH_LEAK_INACCURACY_DETECTED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_HIGH_LEAK_INACCURACY_RESOLVED = "com.agvahealthcare.ventilator_ext.ACTION_HIGH_LEAK_INACCURACY_RESOLVED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_LEAK_BASED_ALARM_DETECTED = "com.agvahealthcare.ventilator_ext.ACTION_LEAK_BASED_ALARM_DETECTED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_LEAK_BASED_ALARM_RESOLVED = "com.agvahealthcare.ventilator_ext.ACTION_LEAK_BASED_ALARM_RESOLVED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_CUFF_LEAKAGE_DETECTED = "com.agvahealthcare.ventilator_ext.ACTION_CUFF_LEAKAGE_DETECTED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_CUFF_LEAKAGE_RESOLVED = "com.agvahealthcare.ventilator_ext.ACTION_CUFF_LEAKAGE_RESOLVED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_FLOW_SENSOR_OCCLUSION_DETECTED = "agvahealthcare.com.falcon.ACTION_FLOW_SENSOR_OCCLUSION_DETECTED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_FLOW_SENSOR_OCCLUSION_RESOLVED = "agvahealthcare.com.falcon.ACTION_FLOW_SENSOR_OCCLUSION_RESOLVED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_EXPIRE_TIME_OUT_OF_RANGE = "com.agvahealthcare.ventilator_ext.ACTION_EXPIRE_TIME_OUT_OF_RANGE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_EXPIRE_TIME_UNDER_RANGE = "com.agvahealthcare.ventilator_ext.ACTION_EXPIRE_TIME_UNDER_RANGE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_MENDOR_SYMLINKING_REQUEST = "com.agvahealthcare.ventilator_ext.ACTION_MENDOR_SYMLINKING_REQUEST";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_MENDOR_SYMLINKING_STARTED = "com.agvahealthcare.ventilator_ext.ACTION_MENDOR_SYMLINKING_STARTED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_MENDOR_SYMLINKING_FAILED = "com.agvahealthcare.ventilator_ext.ACTION_MENDOR_SYMLINKING_FAILED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_MENDOR_SYMLINKING_COMPLETED = "com.agvahealthcare.ventilator_ext.ACTION_MENDOR_SYMLINKING_COMPLETED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_BATTERY_CONNECTED = "com.agvahealthcare.ventilator_ext.ACTION_BATTERY_CONNECTED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_BATTERY_DISCONNECTED = "com.agvahealthcare.ventilator_ext.ACTION_BATTERY_DISCONNECTED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_MODE_SET = "com.agvahealthcare.ventilator_ext.ACTION_MODE_SET";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_MODE_TYPE = "com.agvahealthcare.ventilator_ext.ACTION_MODE_TYPE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_SUBMODE_SET = "com.agvahealthcare.ventilator_ext.ACTION_SUBMODE_SET";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_VENT_PARAM_LIMIT_UNDERFLOW = "com.agvahealthcare.ventilator_ext.ACTION_LIMIT_UNDERFLOW";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_VENT_PARAM_LIMIT_OVERFLOW = "com.agvahealthcare.ventilator_ext.ACTION_LIMIT_OVERFLOW";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_LOW_O2 = "com.agvahealthcare.ventilator_ext.ACTION_LOW_O2";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_INACTIVE = "com.agvahealthcare.ventilator_ext.ACTION_APP_INACTIVE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_SF_SHOW_FULL_SCREEN = "com.promobitech.intent.ADD_FULL_SCREEN";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_SF_HIDE_FULL_SCREEN = "com.promobitech.intent.REMOVE_FULL_SCREEN";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_ON_SYSTEM_KILL = "com.agvahealthcare.ventilator_ext.ACTION_ON_SYSTEM_KILL";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_KNOB_CHANGE = "com.agvahealthcare.ventilator_ext.ACTION_KNOB_CHANGE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_MUTE_UNMUTE = "com.agvahealthcare.ventilator_ext.ACTION_MUTE_UNMUTE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_NEBULISER = "com.agvahealthcare.ventilator_ext.ACTION_NEBULISER";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_OXYGEN_100 = "com.agvahealthcare.ventilator_ext.ACTION_OXYGEN";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_INSPIRATORY_HOLD = "com.agvahealthcare.ventilator_ext.ACTION_INSPIRATORY_HOLD";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_EXPIRATORY_HOLD = "com.agvahealthcare.ventilator_ext.ACTION_EXPIRATORY_HOLD";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_MANUAL_BREATH = "com.agvahealthcare.ventilator_ext.ACTION_MANUAL_BREATH";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_HOME = "com.agvahealthcare.ventilator_ext.ACTION_HOME";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_LOCK = "com.agvahealthcare.ventilator_ext.ACTION_LOCK";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_POWER_OFF = "com.agvahealthcare.ventilator_ext.ACTION_POWER_OFF";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_POWER_ON = "com.agvahealthcare.ventilator_ext.ACTION_POWER_ON";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_DOWNLOADED_ALREADY_LETS_INSTALL = "com.agvahealthcare.ventilator_ext.ACTION_DOWNLOADED_ALREADY_LETS_INSTALL";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_NEO_SENSOR_CONNECT = "com.agvahealthcare.ventilator_ext.ACTION_NEO_SENSOR_CONNECT";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_NEO_SENSOR_DISCONNECT = "com.agvahealthcare.ventilator_ext.ACTION_NEO_SENSOR_DISCONNECT";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_RESISTANCE_CALIBRATION_RESPONSE = "com.agvahealthcare.ventilator_ext.ACTION_RESISTANCE_CALIBRATION_RESPONSE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_COMPLIANCE_CALIBRATION_RESPONSE = "com.agvahealthcare.ventilator_ext.ACTION_COMPLIANCE_CALIBRATION_RESPONSE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_HFNC_RESPONSE = "com.agvahealthcare.ventilator_ext.ACTION_HFNC_RESPONSE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_VENTILATOR_FAILURE_GENERATED = "com.agvahealthcare.ventilator_ext.ACTION_VENTILATOR_FAILURE_GENERATED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_VENTILATOR_FAILURE_REMOVED = "com.agvahealthcare.ventilator_ext.ACTION_VENTILATOR_FAILURE_REMOVED";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_DIAGNOSTIC_TOOL_CHECK = "com.agvahealthcare.ventilator_ext.ACTION_DIAGNOSTIC_TOOL_CHECK";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_O2_REGILATION_TOOL_CHECK = "com.agvahealthcare.ventilator_ext.ACTION_O2_REGILATION_TOOL_CHECK";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_STARTUP_CHECK = "com.agvahealthcare.ventilator_ext.ACTION_STARTUP_CHECK";
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bR\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006V"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/utils/IntentFactory$Companion;", "", "()V", "ACTION_ACK_AVAILABLE", "", "ACTION_BATTERY_CONNECTED", "ACTION_BATTERY_DISCONNECTED", "ACTION_BATTERY_STATUS_AVAILABLE", "ACTION_BT_DEVICE_FOUND", "ACTION_BT_DEVICE_NOT_FOUND", "ACTION_CALIBRATION_ERROR_DATA", "ACTION_COMPLIANCE_CALIBRATION_RESPONSE", "ACTION_CUFF_LEAKAGE_DETECTED", "ACTION_CUFF_LEAKAGE_RESOLVED", "ACTION_DATA_AVAILABLE", "ACTION_DATA_SENT", "ACTION_DEVICE_CONNECTED", "ACTION_DEVICE_DISCONNECTED", "ACTION_DEVICE_FAST_CONNECTED", "ACTION_DEVICE_NAME_REQUESTED", "ACTION_DEVICE_NAME_RESPONSED", "ACTION_DIAGNOSTIC_TOOL_CHECK", "ACTION_DOWNLOADED_ALREADY_LETS_INSTALL", "ACTION_EXPIRATORY_HOLD", "ACTION_EXPIRE_TIME_OUT_OF_RANGE", "ACTION_EXPIRE_TIME_UNDER_RANGE", "ACTION_FLOW_SENSOR_OCCLUSION_DETECTED", "ACTION_FLOW_SENSOR_OCCLUSION_RESOLVED", "ACTION_GATT_SERVICES_DISCOVERED", "ACTION_GRAPH_LIMIT_CHANGE", "ACTION_HANDSHAKE_CALIBRATION_AVAILABLE", "ACTION_HANDSHAKE_COMPLETED", "ACTION_HANDSHAKE_TIMEOUT", "ACTION_HARDWARE_SERIAL_NUMBER", "ACTION_HEATSENSE_STATUS_AVAILABLE", "ACTION_HFNC_RESPONSE", "ACTION_HIGH_LEAK_INACCURACY_DETECTED", "ACTION_HIGH_LEAK_INACCURACY_RESOLVED", "ACTION_HOME", "ACTION_INACTIVE", "ACTION_INSPIRATORY_HOLD", "ACTION_KNOB_CHANGE", "ACTION_LEAK_BASED_ALARM_DETECTED", "ACTION_LEAK_BASED_ALARM_RESOLVED", "ACTION_LOCK", "ACTION_LOW_O2", "ACTION_MANUAL_BREATH", "ACTION_MENDOR_SYMLINKING_COMPLETED", "ACTION_MENDOR_SYMLINKING_FAILED", "ACTION_MENDOR_SYMLINKING_REQUEST", "ACTION_MENDOR_SYMLINKING_STARTED", "ACTION_MODE_SET", "ACTION_MODE_TYPE", "ACTION_MOTOR_LIFE_STATUS_AVAILABLE", "ACTION_MUTE_UNMUTE", "ACTION_NEBULISER", "ACTION_NEO_SENSOR_CONNECT", "ACTION_NEO_SENSOR_DISCONNECT", "ACTION_O2_REGILATION_TOOL_CHECK", "ACTION_ON_SYSTEM_KILL", "ACTION_OXYGEN_100", "ACTION_POWER_OFF", "ACTION_POWER_ON", "ACTION_RAW_DATA_AVAILABLE", "ACTION_RESISTANCE_CALIBRATION_RESPONSE", "ACTION_SELF_TEST_STATUS_AVAILABLE", "ACTION_SENSOR_AVAILABILITY_RESPONSE", "ACTION_SENSOR_CALIBRATION_RESPONSE", "ACTION_SF_HIDE_FULL_SCREEN", "ACTION_SF_SHOW_FULL_SCREEN", "ACTION_SOFTWARE_VERSION_AVAILABLE", "ACTION_STANDBY_STATUS_AVAILABLE", "ACTION_STARTUP_CHECK", "ACTION_SUBMODE_SET", "ACTION_TESTING", "ACTION_THERAPY_END_AVAILABLE", "ACTION_TUBE_BLOCKAGE_DETECTED", "ACTION_TUBE_BLOCKAGE_RESOLVED", "ACTION_USB_PERMISSION_HID", "ACTION_USB_PERMISSION_VENTILATOR", "ACTION_VENTILATOR_FAILURE_GENERATED", "ACTION_VENTILATOR_FAILURE_REMOVED", "ACTION_VENTILATOR_WIFI_CONNECTION_REQUESTED", "ACTION_VENTILATOR_WIFI_CONNECTION_RESPONSED", "ACTION_VENT_PARAM_LIMIT_OVERFLOW", "ACTION_VENT_PARAM_LIMIT_UNDERFLOW", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_USB_PERMISSION_VENTILATOR = "com.agvahealthcare.ventilator_ext.ACTION_USB_PERMISSION_VENTILATOR";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_GRAPH_LIMIT_CHANGE = "com.agvahealthcare.ventilator_ext.ACTION_GRAPH_LIMIT_CHANGE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_HARDWARE_SERIAL_NUMBER = "com.agvahealthcare.ventilator_ext.ACTION_HARDWARE_SERIAL_NUMBER";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_USB_PERMISSION_HID = "com.agvahealthcare.ventilator_ext.ACTION_USB_PERMISSION_HID";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_DEVICE_CONNECTED = "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_CONNECTED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_TESTING = "com.agvahealthcare.ventilator_ext.ACTION_TESTING";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_DEVICE_FAST_CONNECTED = "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_CONNECTED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_DEVICE_DISCONNECTED = "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_DISCONNECTED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_BT_DEVICE_FOUND = "com.agvahealthcare.ventilator_ext.ACTION_BT_DEVICE_FOUND";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_BT_DEVICE_NOT_FOUND = "com.agvahealthcare.ventilator_ext.ACTION_BT_DEVICE_NOT_FOUND";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_GATT_SERVICES_DISCOVERED = "com.agvahealthcare.ventilator_ext.ACTION_GATT_SERVICES_DISCOVERED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_DATA_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_DATA_AVAILABLE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_RAW_DATA_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_RAW_DATA_AVAILABLE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_SOFTWARE_VERSION_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_SOFTWARE_VERSION_AVAILABLE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_VENTILATOR_WIFI_CONNECTION_REQUESTED = "com.agvahealthcare.ventilator_ext.ACTION_VENTILATOR_WIFI_CONNECTION_REQUESTED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_VENTILATOR_WIFI_CONNECTION_RESPONSED = "com.agvahealthcare.ventilator_ext.ACTION_VENTILATOR_WIFI_CONNECTION_RESPONSED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_ACK_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_ACK_AVAILABLE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_BATTERY_STATUS_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_BATTERY_STATUS_AVAILABLE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_THERAPY_END_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_THERAPY_END_AVAILABLE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_MOTOR_LIFE_STATUS_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_MOTOR_LIFE_STATUS_AVAILABLE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_HEATSENSE_STATUS_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_HEATSENSE_STATUS_AVAILABLE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_CALIBRATION_ERROR_DATA = "com.agvahealthcare.ventilator_ext.ACTION_CALIBRATION_ERROR_DATA";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_HANDSHAKE_CALIBRATION_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_HANDSHAKE_CALIBRATION_AVAILABLE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_SENSOR_AVAILABILITY_RESPONSE = "com.agvahealthcare.ventilator_ext.ACTION_SENSOR_AVAILABILITY_RESPONSE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_SENSOR_CALIBRATION_RESPONSE = "com.agvahealthcare.ventilator_ext.ACTION_SENSOR_CALIBRATION_RESPONSE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_STANDBY_STATUS_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_STANDBY_STATUS_AVAILABLE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_SELF_TEST_STATUS_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_SELF_TEST_STATUS_AVAILABLE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_DEVICE_NAME_REQUESTED = "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_NAME_REQUESTED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_DEVICE_NAME_RESPONSED = "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_NAME_RESPONSED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_DATA_SENT = "com.agvahealthcare.ventilator_ext.ACTION_DATA_SENT";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_HANDSHAKE_COMPLETED = "com.agvahealthcare.ventilator_ext.ACTION_HANDSHAKE_COMPLETED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_HANDSHAKE_TIMEOUT = "com.agvahealthcare.ventilator_ext.ACTION_HANDSHAKE_TIMEOUT";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_TUBE_BLOCKAGE_DETECTED = "com.agvahealthcare.ventilator_ext.ACTION_TUBE_BLOCKAGE_DETECTED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_TUBE_BLOCKAGE_RESOLVED = "com.agvahealthcare.ventilator_ext.ACTION_TUBE_BLOCKAGE_RESOLVED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_HIGH_LEAK_INACCURACY_DETECTED = "com.agvahealthcare.ventilator_ext.ACTION_HIGH_LEAK_INACCURACY_DETECTED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_HIGH_LEAK_INACCURACY_RESOLVED = "com.agvahealthcare.ventilator_ext.ACTION_HIGH_LEAK_INACCURACY_RESOLVED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_LEAK_BASED_ALARM_DETECTED = "com.agvahealthcare.ventilator_ext.ACTION_LEAK_BASED_ALARM_DETECTED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_LEAK_BASED_ALARM_RESOLVED = "com.agvahealthcare.ventilator_ext.ACTION_LEAK_BASED_ALARM_RESOLVED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_CUFF_LEAKAGE_DETECTED = "com.agvahealthcare.ventilator_ext.ACTION_CUFF_LEAKAGE_DETECTED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_CUFF_LEAKAGE_RESOLVED = "com.agvahealthcare.ventilator_ext.ACTION_CUFF_LEAKAGE_RESOLVED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_FLOW_SENSOR_OCCLUSION_DETECTED = "agvahealthcare.com.falcon.ACTION_FLOW_SENSOR_OCCLUSION_DETECTED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_FLOW_SENSOR_OCCLUSION_RESOLVED = "agvahealthcare.com.falcon.ACTION_FLOW_SENSOR_OCCLUSION_RESOLVED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_EXPIRE_TIME_OUT_OF_RANGE = "com.agvahealthcare.ventilator_ext.ACTION_EXPIRE_TIME_OUT_OF_RANGE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_EXPIRE_TIME_UNDER_RANGE = "com.agvahealthcare.ventilator_ext.ACTION_EXPIRE_TIME_UNDER_RANGE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_MENDOR_SYMLINKING_REQUEST = "com.agvahealthcare.ventilator_ext.ACTION_MENDOR_SYMLINKING_REQUEST";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_MENDOR_SYMLINKING_STARTED = "com.agvahealthcare.ventilator_ext.ACTION_MENDOR_SYMLINKING_STARTED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_MENDOR_SYMLINKING_FAILED = "com.agvahealthcare.ventilator_ext.ACTION_MENDOR_SYMLINKING_FAILED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_MENDOR_SYMLINKING_COMPLETED = "com.agvahealthcare.ventilator_ext.ACTION_MENDOR_SYMLINKING_COMPLETED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_BATTERY_CONNECTED = "com.agvahealthcare.ventilator_ext.ACTION_BATTERY_CONNECTED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_BATTERY_DISCONNECTED = "com.agvahealthcare.ventilator_ext.ACTION_BATTERY_DISCONNECTED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_MODE_SET = "com.agvahealthcare.ventilator_ext.ACTION_MODE_SET";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_MODE_TYPE = "com.agvahealthcare.ventilator_ext.ACTION_MODE_TYPE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_SUBMODE_SET = "com.agvahealthcare.ventilator_ext.ACTION_SUBMODE_SET";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_VENT_PARAM_LIMIT_UNDERFLOW = "com.agvahealthcare.ventilator_ext.ACTION_LIMIT_UNDERFLOW";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_VENT_PARAM_LIMIT_OVERFLOW = "com.agvahealthcare.ventilator_ext.ACTION_LIMIT_OVERFLOW";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_LOW_O2 = "com.agvahealthcare.ventilator_ext.ACTION_LOW_O2";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_INACTIVE = "com.agvahealthcare.ventilator_ext.ACTION_APP_INACTIVE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_SF_SHOW_FULL_SCREEN = "com.promobitech.intent.ADD_FULL_SCREEN";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_SF_HIDE_FULL_SCREEN = "com.promobitech.intent.REMOVE_FULL_SCREEN";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_ON_SYSTEM_KILL = "com.agvahealthcare.ventilator_ext.ACTION_ON_SYSTEM_KILL";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_KNOB_CHANGE = "com.agvahealthcare.ventilator_ext.ACTION_KNOB_CHANGE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_MUTE_UNMUTE = "com.agvahealthcare.ventilator_ext.ACTION_MUTE_UNMUTE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_NEBULISER = "com.agvahealthcare.ventilator_ext.ACTION_NEBULISER";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_OXYGEN_100 = "com.agvahealthcare.ventilator_ext.ACTION_OXYGEN";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_INSPIRATORY_HOLD = "com.agvahealthcare.ventilator_ext.ACTION_INSPIRATORY_HOLD";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_EXPIRATORY_HOLD = "com.agvahealthcare.ventilator_ext.ACTION_EXPIRATORY_HOLD";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_MANUAL_BREATH = "com.agvahealthcare.ventilator_ext.ACTION_MANUAL_BREATH";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_HOME = "com.agvahealthcare.ventilator_ext.ACTION_HOME";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_LOCK = "com.agvahealthcare.ventilator_ext.ACTION_LOCK";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_POWER_OFF = "com.agvahealthcare.ventilator_ext.ACTION_POWER_OFF";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_POWER_ON = "com.agvahealthcare.ventilator_ext.ACTION_POWER_ON";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_DOWNLOADED_ALREADY_LETS_INSTALL = "com.agvahealthcare.ventilator_ext.ACTION_DOWNLOADED_ALREADY_LETS_INSTALL";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_NEO_SENSOR_CONNECT = "com.agvahealthcare.ventilator_ext.ACTION_NEO_SENSOR_CONNECT";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_NEO_SENSOR_DISCONNECT = "com.agvahealthcare.ventilator_ext.ACTION_NEO_SENSOR_DISCONNECT";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_RESISTANCE_CALIBRATION_RESPONSE = "com.agvahealthcare.ventilator_ext.ACTION_RESISTANCE_CALIBRATION_RESPONSE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_COMPLIANCE_CALIBRATION_RESPONSE = "com.agvahealthcare.ventilator_ext.ACTION_COMPLIANCE_CALIBRATION_RESPONSE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_HFNC_RESPONSE = "com.agvahealthcare.ventilator_ext.ACTION_HFNC_RESPONSE";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_VENTILATOR_FAILURE_GENERATED = "com.agvahealthcare.ventilator_ext.ACTION_VENTILATOR_FAILURE_GENERATED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_VENTILATOR_FAILURE_REMOVED = "com.agvahealthcare.ventilator_ext.ACTION_VENTILATOR_FAILURE_REMOVED";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_DIAGNOSTIC_TOOL_CHECK = "com.agvahealthcare.ventilator_ext.ACTION_DIAGNOSTIC_TOOL_CHECK";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_O2_REGILATION_TOOL_CHECK = "com.agvahealthcare.ventilator_ext.ACTION_O2_REGILATION_TOOL_CHECK";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_STARTUP_CHECK = "com.agvahealthcare.ventilator_ext.ACTION_STARTUP_CHECK";
        
        private Companion() {
            super();
        }
    }
}