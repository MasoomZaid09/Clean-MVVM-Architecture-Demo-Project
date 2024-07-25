package com.agvahealthcare.ventilator_ext.presentation.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b2\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u00109\u001a\u00020:J\u0006\u0010;\u001a\u00020:J\u0006\u0010<\u001a\u00020:J\u0006\u0010=\u001a\u00020:J\u0006\u0010>\u001a\u00020:J\u0006\u0010?\u001a\u00020:J\u0006\u0010@\u001a\u00020:J\u0006\u0010A\u001a\u00020:J\u0006\u0010B\u001a\u00020:J\u0006\u0010C\u001a\u00020:J\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u00020:J\u0006\u0010G\u001a\u00020:J\b\u0010H\u001a\u0004\u0018\u00010\u0006J\b\u0010I\u001a\u0004\u0018\u00010\u0006J\b\u0010J\u001a\u0004\u0018\u00010\u0006J\b\u0010K\u001a\u0004\u0018\u00010\u0006J\b\u0010L\u001a\u0004\u0018\u00010\u0006J\b\u0010M\u001a\u0004\u0018\u00010\u0006J\u0006\u0010N\u001a\u00020:J\u0006\u0010O\u001a\u00020:J\u0006\u0010P\u001a\u00020:J\u0006\u0010Q\u001a\u00020RJ\u0006\u0010S\u001a\u00020RJ\u0006\u0010T\u001a\u00020:J\u0006\u0010U\u001a\u00020:J\u0006\u0010V\u001a\u00020EJ\u0006\u0010W\u001a\u00020:J\u0006\u0010X\u001a\u00020:J\r\u0010Y\u001a\u0004\u0018\u00010R\u00a2\u0006\u0002\u0010ZJ\r\u0010[\u001a\u0004\u0018\u00010R\u00a2\u0006\u0002\u0010ZJ\r\u0010\\\u001a\u0004\u0018\u00010R\u00a2\u0006\u0002\u0010ZJ\b\u0010]\u001a\u0004\u0018\u00010^J\b\u0010_\u001a\u0004\u0018\u00010`J\u0006\u0010a\u001a\u00020EJ\b\u0010b\u001a\u0004\u0018\u00010\u0006J\u0006\u0010c\u001a\u00020RJ\u0006\u0010d\u001a\u00020eJ\u000e\u0010f\u001a\u00020e2\u0006\u0010g\u001a\u00020\u0006J\u000e\u0010h\u001a\u00020e2\u0006\u0010g\u001a\u00020\u0006J\u000e\u0010i\u001a\u00020e2\u0006\u0010g\u001a\u00020\u0006J\u000e\u0010j\u001a\u00020e2\u0006\u0010g\u001a\u00020\u0006J\u000e\u0010k\u001a\u00020e2\u0006\u0010g\u001a\u00020\u0006J\u000e\u0010l\u001a\u00020e2\u0006\u0010g\u001a\u00020\u0006J\u0015\u0010m\u001a\u00020e2\b\u0010n\u001a\u0004\u0018\u00010R\u00a2\u0006\u0002\u0010oJ\u000e\u0010p\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u0015\u0010q\u001a\u00020e2\b\u0010n\u001a\u0004\u0018\u00010R\u00a2\u0006\u0002\u0010oJ\u0015\u0010r\u001a\u00020e2\b\u0010n\u001a\u0004\u0018\u00010R\u00a2\u0006\u0002\u0010oJ\u000e\u0010s\u001a\u00020e2\u0006\u0010t\u001a\u00020^J\u000e\u0010u\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000e\u0010v\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000e\u0010w\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000e\u0010x\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000e\u0010y\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000e\u0010z\u001a\u00020e2\u0006\u0010{\u001a\u00020`J\u000e\u0010|\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000e\u0010}\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000e\u0010~\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000e\u0010\u007f\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000f\u0010\u0080\u0001\u001a\u00020e2\u0006\u0010g\u001a\u00020EJ\u000f\u0010\u0081\u0001\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000f\u0010\u0082\u0001\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000f\u0010\u0083\u0001\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000f\u0010\u0084\u0001\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000f\u0010\u0085\u0001\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u0010\u0010\u0086\u0001\u001a\u00020e2\u0007\u0010\u0087\u0001\u001a\u00020EJ\u000f\u0010\u0088\u0001\u001a\u00020e2\u0006\u0010g\u001a\u00020RJ\u000f\u0010\u0089\u0001\u001a\u00020e2\u0006\u0010g\u001a\u00020RJ\u000f\u0010\u008a\u0001\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000f\u0010\u008b\u0001\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000f\u0010\u008c\u0001\u001a\u00020e2\u0006\u0010g\u001a\u00020EJ\u000f\u0010\u008d\u0001\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u000f\u0010\u008e\u0001\u001a\u00020e2\u0006\u0010g\u001a\u00020:J\u0012\u0010\u008f\u0001\u001a\u00020e2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0006J\u000f\u0010\u0091\u0001\u001a\u00020e2\u0006\u0010n\u001a\u00020RJ!\u0010\u0092\u0001\u001a\u00020e2\u0007\u0010\u0093\u0001\u001a\u00020\u00062\u0006\u0010g\u001a\u00020\u00062\u0007\u0010\u0094\u0001\u001a\u00020EJ\"\u0010\u0095\u0001\u001a\u00020e2\u0007\u0010\u0096\u0001\u001a\u00020\u00062\b\u0010n\u001a\u0004\u0018\u00010RH\u0002\u00a2\u0006\u0003\u0010\u0097\u0001J#\u0010\u0095\u0001\u001a\u00020e2\u0007\u0010\u0096\u0001\u001a\u00020\u00062\t\u0010n\u001a\u0005\u0018\u00010\u0098\u0001H\u0002\u00a2\u0006\u0003\u0010\u0099\u0001J$\u0010\u0095\u0001\u001a\u00020e2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010n\u001a\u0004\u0018\u00010EH\u0002\u00a2\u0006\u0003\u0010\u009a\u0001J$\u0010\u0095\u0001\u001a\u00020e2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010n\u001a\u0004\u0018\u00010:H\u0002\u00a2\u0006\u0003\u0010\u009b\u0001J\u001e\u0010\u0095\u0001\u001a\u00020e2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010n\u001a\u0004\u0018\u00010\u0006H\u0002J%\u0010\u0095\u0001\u001a\u00020e2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00062\u000f\u0010n\u001a\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u009c\u0001H\u0002J\u0007\u0010\u009d\u0001\u001a\u00020eJ\u0018\u0010\u009e\u0001\u001a\u00020e2\u0007\u0010\u0093\u0001\u001a\u00020\u00062\u0006\u0010g\u001a\u00020RJ\u0018\u0010\u009e\u0001\u001a\u00020e2\u0007\u0010\u0093\u0001\u001a\u00020\u00062\u0006\u0010g\u001a\u00020:J\u0007\u0010\u009f\u0001\u001a\u00020eJ\u0018\u0010\u00a0\u0001\u001a\u00020e2\u0007\u0010\u0093\u0001\u001a\u00020\u00062\u0006\u0010g\u001a\u00020RJ\u0018\u0010\u00a0\u0001\u001a\u00020e2\u0007\u0010\u0093\u0001\u001a\u00020\u00062\u0006\u0010g\u001a\u00020:R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00a1\u0001"}, d2 = {"Lcom/agvahealthcare/ventilator_ext/presentation/utils/PreferenceManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "BLE_SERVICE_STATUS", "", "CONFIGURATION_SHARED_PREFERENCES", "PREF_AGE", "PREF_ALARM_PAGE_NO", "PREF_BODY_HEIGHT", "PREF_BODY_WEIGHT", "PREF_CURRENT_UID", "PREF_DELTA_FIO2", "PREF_DELTA_FIO2_temp", "PREF_FALL_RATE", "PREF_FALL_RATE_temp", "PREF_FIO2_ALARM_LIMITS", "PREF_FIO2_LOWER_LIMITS", "PREF_FIO2_UPPER_LIMITS", "PREF_FLOW_ALARM_LIMITS", "PREF_FLOW_LOWER_LIMITS", "PREF_FLOW_UPPER_LIMITS", "PREF_GENDER", "PREF_MAX_PR", "PREF_MAX_PR_temp", "PREF_N2O", "PREF_N2O_temp", "PREF_NEO_AGE", "PREF_NEO_BODY_HEIGHT", "PREF_NEO_BODY_WEIGHT", "PREF_O2_FLUSH_STATUS", "PREF_PAGE_NO", "PREF_PAW_ALARM_LIMITS", "PREF_PAW_LOWER_LIMITS", "PREF_PAW_UPPER_LIMITS", "PREF_PED_AGE", "PREF_PED_BODY_HEIGHT", "PREF_PED_BODY_WEIGHT", "PREF_PLIMIT", "PREF_PLIMIT_TEMP", "PREF_RISE_RATE", "PREF_RISE_RATE_temp", "PREF_SEDATION_MODE", "PREF_TARGET_PRESSURE", "PREF_TARGET_PRESSURE_temp", "PREF_TARGET_SPO2", "PREF_TARGET_SPO2_temp", "PREF_THERAPY_END_STATUS", "PREF_TOTAL_FLOW", "PREF_TOTAL_FLOW_temp", "PREF_UHID", "PREF_VOLUME", "gson", "Lcom/google/gson/Gson;", "sp", "Landroid/content/SharedPreferences;", "getAlarmPageNo", "", "getDeltaFio2", "getDeltaFio2Temp", "getEventPageNo", "getFallRate", "getFallRateTemp", "getMaxPr", "getMaxPrTemp", "getN2O", "getN2OTemp", "getO2FlushStatus", "", "getPlimit", "getPlimitTemp", "getPrefFLOWLowerLimits", "getPrefFLOWUpperLimits", "getPrefFio2LowerLimits", "getPrefFio2UpperLimits", "getPrefPAWLowerLimits", "getPrefPAWUpperLimits", "getRiseRate", "getRiseRateTemp", "getSedationMode", "getTargetPressure", "", "getTargetPressureTemp", "getTargetSpo2", "getTargetSpo2Temp", "getTherapyEndStatus", "getTotalFlow", "getTotalFlowTemp", "readAge", "()Ljava/lang/Float;", "readBodyHeight", "readBodyWeight", "readCurrentUid", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$PatientProfile;", "readGender", "Lcom/agvahealthcare/ventilator_ext/presentation/utils/Constants$Companion$Gender;", "readServiceStatus", "readUHID", "readVolume", "removeAllTempPreferences", "", "saveFLOWLowerLimit", "value", "saveFLOWUpperLimit", "saveFio2LowerLimit", "saveFio2UpperLimit", "savePAWLowerLimit", "savePAWUpperLimit", "setAge", "val", "(Ljava/lang/Float;)V", "setAlarmPageNo", "setBodyHeight", "setBodyWeight", "setCurrentUid", "uid", "setDeltaFio2", "setDeltaFio2Temp", "setEventPageNo", "setFallRate", "setFallRateTemp", "setGender", "gender", "setMaxPr", "setMaxPrTemp", "setN2O", "setN2OTemp", "setO2FlushStatus", "setPlimit", "setPlimitTemp", "setRiseRate", "setRiseRateTemp", "setSedationMode", "setServiceStatus", "status", "setTargetPressure", "setTargetPressureTemp", "setTargetSpo2", "setTargetSpo2Temp", "setTherapyEndStatus", "setTotalFlow", "setTotalFlowTemp", "setUHID", "UHID", "setVolume", "updateAlarmLimits", "label", "isUpperLimit", "updateData", "key", "(Ljava/lang/String;Ljava/lang/Float;)V", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "(Ljava/lang/String;Ljava/lang/Integer;)V", "", "updatePreferecesViaTempPreferences", "updatePreferencesOfTiles", "updateTempPreferecesViaPreferences", "updateTempPreferenceOfTiles", "app_debug"})
public final class PreferenceManager {
    private final android.content.Context context = null;
    private final android.content.SharedPreferences sp = null;
    private final com.google.gson.Gson gson = null;
    private final java.lang.String CONFIGURATION_SHARED_PREFERENCES = "sedation.settings";
    private final java.lang.String PREF_PAW_ALARM_LIMITS = "pref_paw_alarm_limits";
    private final java.lang.String PREF_FIO2_ALARM_LIMITS = "pref_fio2_alarm_limits";
    private final java.lang.String PREF_FLOW_ALARM_LIMITS = "pref_flow_alarm_limits";
    private final java.lang.String BLE_SERVICE_STATUS = "service_status.ble";
    private final java.lang.String PREF_CURRENT_UID = "pref_userid";
    private final java.lang.String PREF_VOLUME = "pref_volume";
    private final java.lang.String PREF_TOTAL_FLOW = "pref_total_flow";
    private final java.lang.String PREF_N2O = "pref_n2o";
    private final java.lang.String PREF_TARGET_PRESSURE = "pref_target_pressure";
    private final java.lang.String PREF_RISE_RATE = "pref_rise_rate";
    private final java.lang.String PREF_FALL_RATE = "pref_fall_rate";
    private final java.lang.String PREF_PLIMIT = "pref_plimit";
    private final java.lang.String PREF_MAX_PR = "pref_max_pr";
    private final java.lang.String PREF_TARGET_SPO2 = "pref_target_spo2";
    private final java.lang.String PREF_SEDATION_MODE = "pref_sedation_mode";
    private final java.lang.String PREF_DELTA_FIO2 = "pref_delta_fio2";
    private final java.lang.String PREF_O2_FLUSH_STATUS = "PREF_O2_FLUSH_STATUS";
    private final java.lang.String PREF_THERAPY_END_STATUS = "PREF_THERAPY_END_STATUS";
    private final java.lang.String PREF_UHID = "pref_uhid";
    private final java.lang.String PREF_TOTAL_FLOW_temp = "pref_total_flow_temp";
    private final java.lang.String PREF_N2O_temp = "pref_n2o_temp";
    private final java.lang.String PREF_TARGET_PRESSURE_temp = "pref_target_pressure_temp";
    private final java.lang.String PREF_RISE_RATE_temp = "pref_rise_rate_temp";
    private final java.lang.String PREF_FALL_RATE_temp = "pref_fall_rate_temp";
    private final java.lang.String PREF_PLIMIT_TEMP = "pref_plimit_temp";
    private final java.lang.String PREF_MAX_PR_temp = "pref_max_pr_temp";
    private final java.lang.String PREF_TARGET_SPO2_temp = "pref_target_spo2_temp";
    private final java.lang.String PREF_DELTA_FIO2_temp = "pref_delta_fio2_temp";
    private final java.lang.String PREF_NEO_BODY_WEIGHT = "pref_Neo_body_weight";
    private final java.lang.String PREF_PED_BODY_WEIGHT = "pref_Ped_body_weight";
    private final java.lang.String PREF_AGE = "pref_age";
    private final java.lang.String PREF_NEO_AGE = "pref_Neo_age";
    private final java.lang.String PREF_PED_AGE = "pref_Ped_age";
    private final java.lang.String PREF_BODY_WEIGHT = "pref_body_weight";
    private final java.lang.String PREF_BODY_HEIGHT = "pref_body_height";
    private final java.lang.String PREF_GENDER = "pref_gender";
    private final java.lang.String PREF_NEO_BODY_HEIGHT = "pref_Neo_body_height";
    private final java.lang.String PREF_PED_BODY_HEIGHT = "pref_Ped_body_height";
    private final java.lang.String PREF_PAGE_NO = "pref_page_no";
    private final java.lang.String PREF_ALARM_PAGE_NO = "pref_alarm_page_no";
    private final java.lang.String PREF_FIO2_UPPER_LIMITS = "pref_FIO2_UPPER_limits";
    private final java.lang.String PREF_FIO2_LOWER_LIMITS = "pref_FIO2_LOWER_limits";
    private final java.lang.String PREF_FLOW_UPPER_LIMITS = "pref_FLOW_UPPER_limits";
    private final java.lang.String PREF_FLOW_LOWER_LIMITS = "pref_FLOW_LOWER_limits";
    private final java.lang.String PREF_PAW_UPPER_LIMITS = "pref_PAW_UPPER_limits";
    private final java.lang.String PREF_PAW_LOWER_LIMITS = "pref_PAW_LOWER_limits";
    
    public PreferenceManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    public final void updatePreferencesOfTiles(@org.jetbrains.annotations.NotNull
    java.lang.String label, int value) {
    }
    
    public final void updatePreferencesOfTiles(@org.jetbrains.annotations.NotNull
    java.lang.String label, float value) {
    }
    
    public final void updateAlarmLimits(@org.jetbrains.annotations.NotNull
    java.lang.String label, @org.jetbrains.annotations.NotNull
    java.lang.String value, boolean isUpperLimit) {
    }
    
    public final void updateTempPreferecesViaPreferences() {
    }
    
    public final void updatePreferecesViaTempPreferences() {
    }
    
    public final void updateTempPreferenceOfTiles(@org.jetbrains.annotations.NotNull
    java.lang.String label, int value) {
    }
    
    public final void updateTempPreferenceOfTiles(@org.jetbrains.annotations.NotNull
    java.lang.String label, float value) {
    }
    
    public final void setAlarmPageNo(int value) {
    }
    
    public final int getAlarmPageNo() {
        return 0;
    }
    
    public final void setEventPageNo(int value) {
    }
    
    public final int getEventPageNo() {
        return 0;
    }
    
    public final void setTherapyEndStatus(boolean value) {
    }
    
    public final boolean getTherapyEndStatus() {
        return false;
    }
    
    public final void setO2FlushStatus(boolean value) {
    }
    
    public final boolean getO2FlushStatus() {
        return false;
    }
    
    public final void setSedationMode(int value) {
    }
    
    public final int getSedationMode() {
        return 0;
    }
    
    public final void saveFio2UpperLimit(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPrefFio2UpperLimits() {
        return null;
    }
    
    public final void saveFio2LowerLimit(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPrefFio2LowerLimits() {
        return null;
    }
    
    public final void saveFLOWUpperLimit(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPrefFLOWUpperLimits() {
        return null;
    }
    
    public final void saveFLOWLowerLimit(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPrefFLOWLowerLimits() {
        return null;
    }
    
    public final void savePAWUpperLimit(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPrefPAWUpperLimits() {
        return null;
    }
    
    public final void savePAWLowerLimit(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPrefPAWLowerLimits() {
        return null;
    }
    
    public final void setUHID(@org.jetbrains.annotations.Nullable
    java.lang.String UHID) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String readUHID() {
        return null;
    }
    
    public final boolean readServiceStatus() {
        return false;
    }
    
    public final void setServiceStatus(boolean status) {
    }
    
    public final void setTargetSpo2(int value) {
    }
    
    public final int getTargetSpo2() {
        return 0;
    }
    
    public final void setMaxPr(int value) {
    }
    
    public final int getMaxPr() {
        return 0;
    }
    
    public final void setDeltaFio2(int value) {
    }
    
    public final int getDeltaFio2() {
        return 0;
    }
    
    public final void setFallRate(int value) {
    }
    
    public final int getFallRate() {
        return 0;
    }
    
    public final void setPlimit(int value) {
    }
    
    public final int getPlimit() {
        return 0;
    }
    
    public final void setRiseRate(int value) {
    }
    
    public final int getRiseRate() {
        return 0;
    }
    
    public final void setTargetPressure(float value) {
    }
    
    public final float getTargetPressure() {
        return 0.0F;
    }
    
    public final void setN2O(int value) {
    }
    
    public final int getN2O() {
        return 0;
    }
    
    public final void setTotalFlow(int value) {
    }
    
    public final int getTotalFlow() {
        return 0;
    }
    
    public final void setTargetSpo2Temp(int value) {
    }
    
    public final int getTargetSpo2Temp() {
        return 0;
    }
    
    public final void setMaxPrTemp(int value) {
    }
    
    public final int getMaxPrTemp() {
        return 0;
    }
    
    public final void setDeltaFio2Temp(int value) {
    }
    
    public final int getDeltaFio2Temp() {
        return 0;
    }
    
    public final void setFallRateTemp(int value) {
    }
    
    public final int getFallRateTemp() {
        return 0;
    }
    
    public final void setPlimitTemp(int value) {
    }
    
    public final int getPlimitTemp() {
        return 0;
    }
    
    public final void setRiseRateTemp(int value) {
    }
    
    public final int getRiseRateTemp() {
        return 0;
    }
    
    public final void setTargetPressureTemp(float value) {
    }
    
    public final float getTargetPressureTemp() {
        return 0.0F;
    }
    
    public final void setN2OTemp(int value) {
    }
    
    public final int getN2OTemp() {
        return 0;
    }
    
    public final void setTotalFlowTemp(int value) {
    }
    
    public final int getTotalFlowTemp() {
        return 0;
    }
    
    public final void setVolume(float val) {
    }
    
    public final float readVolume() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.PatientProfile readCurrentUid() {
        return null;
    }
    
    public final void setCurrentUid(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.PatientProfile uid) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Float readBodyWeight() {
        return null;
    }
    
    public final void setBodyWeight(@org.jetbrains.annotations.Nullable
    java.lang.Float val) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Float readBodyHeight() {
        return null;
    }
    
    public final void setBodyHeight(@org.jetbrains.annotations.Nullable
    java.lang.Float val) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Float readAge() {
        return null;
    }
    
    public final void setAge(@org.jetbrains.annotations.Nullable
    java.lang.Float val) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.Gender readGender() {
        return null;
    }
    
    public final void setGender(@org.jetbrains.annotations.NotNull
    com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.Gender gender) {
    }
    
    private final void updateData(java.lang.String key, java.lang.Float val) {
    }
    
    public final void removeAllTempPreferences() {
    }
    
    private final void updateData(java.lang.String key, java.lang.Long val) {
    }
    
    private final void updateData(java.lang.String key, java.lang.String val) {
    }
    
    private final void updateData(java.lang.String key, java.lang.Boolean val) {
    }
    
    private final void updateData(java.lang.String key, java.lang.Integer val) {
    }
    
    private final void updateData(java.lang.String key, java.util.Set<java.lang.String> val) {
    }
}