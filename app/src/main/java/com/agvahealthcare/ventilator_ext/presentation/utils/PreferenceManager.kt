package com.agvahealthcare.ventilator_ext.presentation.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.StringRes
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.FIRST_FILTER_NAME
import com.google.gson.Gson


class PreferenceManager(private val context: Context) {
    private val sp: SharedPreferences
    private val gson: Gson
    private val CONFIGURATION_SHARED_PREFERENCES = "sedation.settings"

    private val PREF_PAW_ALARM_LIMITS = "pref_paw_alarm_limits"
    private val PREF_FIO2_ALARM_LIMITS = "pref_fio2_alarm_limits"
    private val PREF_FLOW_ALARM_LIMITS = "pref_flow_alarm_limits"
    private val BLE_SERVICE_STATUS = "service_status.ble"

    private val PREF_CURRENT_UID = "pref_userid"
    private val PREF_VOLUME = "pref_volume"

    private val PREF_TOTAL_FLOW = "pref_total_flow"
    private val PREF_N2O = "pref_n2o"
    private val PREF_TARGET_PRESSURE = "pref_target_pressure"
    private val PREF_RISE_RATE = "pref_rise_rate"
    private val PREF_FALL_RATE = "pref_fall_rate"
    private val PREF_PLIMIT = "pref_plimit"
    private val PREF_MAX_PR = "pref_max_pr"
    private val PREF_TARGET_SPO2 = "pref_target_spo2"
    private val PREF_SEDATION_MODE = "pref_sedation_mode"
    private val PREF_DELTA_FIO2 = "pref_delta_fio2"
    private val PREF_O2_FLUSH_STATUS = "PREF_O2_FLUSH_STATUS"
    private val PREF_THERAPY_END_STATUS = "PREF_THERAPY_END_STATUS"

    private val PREF_UHID = "pref_uhid"


    private val PREF_TOTAL_FLOW_temp = "pref_total_flow_temp"
    private val PREF_N2O_temp = "pref_n2o_temp"
    private val PREF_TARGET_PRESSURE_temp = "pref_target_pressure_temp"
    private val PREF_RISE_RATE_temp = "pref_rise_rate_temp"
    private val PREF_FALL_RATE_temp = "pref_fall_rate_temp"
    private val PREF_PLIMIT_TEMP = "pref_plimit_temp"
    private val PREF_MAX_PR_temp = "pref_max_pr_temp"
    private val PREF_TARGET_SPO2_temp = "pref_target_spo2_temp"
    private val PREF_DELTA_FIO2_temp = "pref_delta_fio2_temp"

    private val PREF_NEO_BODY_WEIGHT = "pref_Neo_body_weight"
    private val PREF_PED_BODY_WEIGHT = "pref_Ped_body_weight"
    private val PREF_AGE = "pref_age"
    private val PREF_NEO_AGE = "pref_Neo_age"
    private val PREF_PED_AGE = "pref_Ped_age"
    private val PREF_BODY_WEIGHT = "pref_body_weight"

    private val PREF_BODY_HEIGHT = "pref_body_height"
    private val PREF_GENDER = "pref_gender"


    private val PREF_NEO_BODY_HEIGHT = "pref_Neo_body_height"

    private val PREF_PED_BODY_HEIGHT = "pref_Ped_body_height"
    private val PREF_PAGE_NO = "pref_page_no"
    private val PREF_ALARM_PAGE_NO = "pref_alarm_page_no"

    private val PREF_FIO2_UPPER_LIMITS = "pref_FIO2_UPPER_limits"
    private val PREF_FIO2_LOWER_LIMITS = "pref_FIO2_LOWER_limits"

    private val PREF_FLOW_UPPER_LIMITS = "pref_FLOW_UPPER_limits"
    private val PREF_FLOW_LOWER_LIMITS = "pref_FLOW_LOWER_limits"

    private val PREF_PAW_UPPER_LIMITS = "pref_PAW_UPPER_limits"
    private val PREF_PAW_LOWER_LIMITS = "pref_PAW_LOWER_limits"

    fun updatePreferencesOfTiles(label:String, value: Int){
        when(label){
            Constants.lbl_total_flow -> setTotalFlow(value)
            Constants.lbl_N2O -> setN2O(value)
            Constants.lbl_Plimit -> setPlimit(value)
            Constants.lbl_RISE_RATE -> setRiseRate(value)
            Constants.lbl_Fall_RATE -> setFallRate(value)
            Constants.lbl_MAX_PR -> setMaxPr(value)
            Constants.lbl_Delta_Fio2 -> setDeltaFio2(value)
            Constants.lbl_Target_Spo2 -> setTargetSpo2(value)
        }
    }

    fun updatePreferencesOfTiles(label:String, value: Float){
        when(label){
            Constants.lbl_target_pressure -> setTargetPressure(value)
        }
    }

    fun updateAlarmLimits(label: String,value: String,isUpperLimit:Boolean){
        when(label){
            Constants.lbl_fio2 -> if (isUpperLimit) saveFio2UpperLimit(value) else saveFio2LowerLimit(value)
            Constants.lbl_flow -> if (isUpperLimit) saveFLOWUpperLimit(value) else saveFLOWLowerLimit(value)
            Constants.lbl_paw -> if (isUpperLimit) savePAWUpperLimit(value) else savePAWLowerLimit(value)
        }
    }


    fun updateTempPreferecesViaPreferences(){
        setTargetPressureTemp(getTargetPressure())
        setTotalFlowTemp(getTotalFlow())
        setN2OTemp(getN2O())
        setPlimitTemp(getPlimit())
        setRiseRateTemp(getRiseRate())
        setFallRateTemp(getFallRate())
        setMaxPrTemp(getMaxPr())
        setDeltaFio2Temp(getDeltaFio2())
        setTargetSpo2Temp(getTargetSpo2())
    }

    fun updatePreferecesViaTempPreferences(){
            setTargetPressure(getTargetPressureTemp())
            setTotalFlow(getTotalFlowTemp())
            setN2O(getN2OTemp())
            setPlimit(getPlimitTemp())
            setRiseRate(getRiseRateTemp())
            setFallRate(getFallRateTemp())
            setMaxPr(getMaxPrTemp())
            setDeltaFio2(getDeltaFio2Temp())
            setTargetSpo2(getTargetSpo2Temp())
    }

    fun updateTempPreferenceOfTiles(label:String, value: Int){
        when(label){
            Constants.lbl_target_pressure -> setTargetPressureTemp(value.toFloat())
            Constants.lbl_total_flow -> setTotalFlowTemp(value)
            Constants.lbl_N2O -> setN2OTemp(value)
            Constants.lbl_Plimit -> setPlimitTemp(value)
            Constants.lbl_RISE_RATE -> setRiseRateTemp(value)
            Constants.lbl_Fall_RATE -> setFallRateTemp(value)
            Constants.lbl_MAX_PR -> setMaxPrTemp(value)
            Constants.lbl_Delta_Fio2 -> setDeltaFio2Temp(value)
            Constants.lbl_Target_Spo2 -> setTargetSpo2Temp(value)
        }
    }

    fun updateTempPreferenceOfTiles(label:String, value: Float){
        when(label){
            Constants.lbl_target_pressure -> setTargetPressureTemp(value.toFloat())
        }
    }


    init {
        sp = context.getSharedPreferences(
            CONFIGURATION_SHARED_PREFERENCES,
            Context.MODE_PRIVATE
        )
        gson = Gson()
    }
    fun setAlarmPageNo(value: Int){
        updateData( PREF_ALARM_PAGE_NO,value)
    }

    fun getAlarmPageNo() :Int{
        return sp.getInt(PREF_ALARM_PAGE_NO,1)
    }

    fun setEventPageNo(value: Int){
        updateData( PREF_PAGE_NO,value)
    }

    fun getEventPageNo() :Int{
        return sp.getInt(PREF_PAGE_NO,1)
    }


    fun setTherapyEndStatus(value:Boolean){
        updateData(readCurrentUid().toString() + "." + PREF_THERAPY_END_STATUS,value)
    }

    fun getTherapyEndStatus() : Boolean{
        return sp.getBoolean(readCurrentUid().toString() + "." + PREF_THERAPY_END_STATUS,false)
    }

    fun setO2FlushStatus(value:Boolean){
        updateData(readCurrentUid().toString() + "." + PREF_O2_FLUSH_STATUS,value)
    }

    fun getO2FlushStatus() : Boolean{
        return sp.getBoolean(readCurrentUid().toString() + "." + PREF_O2_FLUSH_STATUS,false)
    }

    fun setSedationMode(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_SEDATION_MODE,value)
    }

    fun getSedationMode() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_SEDATION_MODE,-1)
    }


    // fio2
    fun saveFio2UpperLimit(value: String) {
        updateData(
            readCurrentUid().toString() + PREF_FIO2_UPPER_LIMITS,
            value
        )
    }

    fun getPrefFio2UpperLimits(): String? {
        return sp.getString(
            readCurrentUid().toString() + PREF_FIO2_UPPER_LIMITS,
            context.getString(R.string.fio2_default_max)
        )
    }

    fun saveFio2LowerLimit(value: String) {
        updateData(
            readCurrentUid().toString() + PREF_FIO2_LOWER_LIMITS,
            value
        )
    }

    fun getPrefFio2LowerLimits(): String? {
        return sp.getString(
            readCurrentUid().toString() + PREF_FIO2_LOWER_LIMITS,
            context.getString(R.string.fio2_default_min)
        )
    }

    // flow
    fun saveFLOWUpperLimit(value: String) {
        updateData(
            readCurrentUid().toString() + PREF_FLOW_UPPER_LIMITS,
            value
        )
    }

    fun getPrefFLOWUpperLimits(): String? {
        return sp.getString(
            readCurrentUid().toString() + PREF_FLOW_UPPER_LIMITS,
            context.getString(R.string.flow_default_max)
        )
    }

    fun saveFLOWLowerLimit(value: String) {
        updateData(
            readCurrentUid().toString() + PREF_FLOW_LOWER_LIMITS,
            value
        )
    }

    fun getPrefFLOWLowerLimits(): String? {
        return sp.getString(
            readCurrentUid().toString() + PREF_FLOW_LOWER_LIMITS,
            context.getString(R.string.flow_default_min)
        )
    }

    // paw
    fun savePAWUpperLimit(value: String) {
        updateData(
            readCurrentUid().toString() + PREF_PAW_UPPER_LIMITS,
            value
        )
    }

    fun getPrefPAWUpperLimits(): String? {
        return sp.getString(
            readCurrentUid().toString() + PREF_PAW_UPPER_LIMITS,
            context.getString(R.string.paw_default_max)
        )
    }

    fun savePAWLowerLimit(value: String) {
        updateData(
            readCurrentUid().toString() + PREF_PAW_LOWER_LIMITS,
            value
        )
    }

    fun getPrefPAWLowerLimits(): String? {
        return sp.getString(
            readCurrentUid().toString() + PREF_PAW_LOWER_LIMITS,
            context.getString(R.string.paw_default_min)
        )
    }

    fun setUHID(UHID: String?) {
        updateData(
            readCurrentUid().toString() + "." + PREF_UHID,
            UHID
        )
    }

    //ToDo:-Current Task UHID
    fun readUHID(): String? {
        val value = sp.getString(
            readCurrentUid().toString() + "." + PREF_UHID,
            FIRST_FILTER_NAME
        )
        return if (value == "") FIRST_FILTER_NAME else value
    }

    fun readServiceStatus(): Boolean {
        return sp.getBoolean(
            BLE_SERVICE_STATUS,
            false
        )
    }

    fun setServiceStatus(status: Boolean) {
        updateData(
            BLE_SERVICE_STATUS,
            status
        )
    }

    fun setTargetSpo2(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_TARGET_SPO2,value)
    }

    fun getTargetSpo2() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_TARGET_SPO2, context.resources.getString(R.string.default_target_spo2).toInt())
    }


    fun setMaxPr(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_MAX_PR,value)
    }

    fun getMaxPr() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_MAX_PR, context.resources.getString(R.string.default_max_pr).toInt())
    }
    fun setDeltaFio2(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_DELTA_FIO2,value)
    }

    fun getDeltaFio2() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_DELTA_FIO2, context.resources.getString(R.string.default_delta_fio2).toInt())
    }

    fun setFallRate(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_FALL_RATE,value)
    }

    fun getFallRate() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_FALL_RATE, context.resources.getString(R.string.default_fall_rate).toInt())
    }

    fun setPlimit(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_PLIMIT,value)
    }

    fun getPlimit() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_PLIMIT, context.resources.getString(R.string.default_plimit).toInt())
    }


    fun setRiseRate(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_RISE_RATE,value)
    }

    fun getRiseRate() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_RISE_RATE, context.resources.getString(R.string.default_rise_rate).toInt())
    }

    fun setTargetPressure(value:Float){
        updateData(readCurrentUid().toString() + "." + PREF_TARGET_PRESSURE,value)
    }

    fun getTargetPressure() : Float{
        return sp.getFloat(readCurrentUid().toString() + "." + PREF_TARGET_PRESSURE, context.resources.getString(R.string.default_target_pressure).toFloat())
    }

    fun setN2O(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_N2O,value)
    }

    fun getN2O() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_N2O, context.resources.getString(R.string.default_n2o).toInt())
    }

    fun setTotalFlow(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_TOTAL_FLOW,value)
    }

    fun getTotalFlow() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_TOTAL_FLOW, context.resources.getString(R.string.default_total_flow).toInt())
    }

//    ........................... temp preferences

    fun setTargetSpo2Temp(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_TARGET_SPO2_temp,value)
    }

    fun getTargetSpo2Temp() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_TARGET_SPO2_temp, getTargetSpo2())
    }

    fun setMaxPrTemp(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_MAX_PR_temp,value)
    }

    fun getMaxPrTemp() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_MAX_PR_temp, getMaxPr())
    }
    fun setDeltaFio2Temp(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_DELTA_FIO2,value)
    }

    fun getDeltaFio2Temp() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_DELTA_FIO2_temp, getDeltaFio2())
    }

    fun setFallRateTemp(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_FALL_RATE_temp,value)
    }

    fun getFallRateTemp() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_FALL_RATE_temp, getFallRate())
    }

    fun setPlimitTemp(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_PLIMIT_TEMP,value)
    }

    fun getPlimitTemp() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_PLIMIT_TEMP, getPlimit())
    }

    fun setRiseRateTemp(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_RISE_RATE_temp,value)
    }

    fun getRiseRateTemp() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_RISE_RATE_temp, getRiseRate())
    }

    fun setTargetPressureTemp(value:Float){
        updateData(readCurrentUid().toString() + "." + PREF_TARGET_PRESSURE_temp,value)
    }

    fun getTargetPressureTemp() : Float{
        return sp.getFloat(readCurrentUid().toString() + "." + PREF_TARGET_PRESSURE_temp, getTargetPressure())
    }

    fun setN2OTemp(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_N2O_temp,value)
    }

    fun getN2OTemp() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_N2O_temp, getN2O())
    }

    fun setTotalFlowTemp(value:Int){
        updateData(readCurrentUid().toString() + "." + PREF_TOTAL_FLOW_temp,value)
    }

    fun getTotalFlowTemp() : Int{
        return sp.getInt(readCurrentUid().toString() + "." + PREF_TOTAL_FLOW_temp, getTotalFlow())
    }

    fun setVolume(`val`: Float) {
        updateData(PREF_VOLUME, `val`)
    }

    fun readVolume(): Float {
        return sp.getFloat(PREF_VOLUME,
            10f
        )
    }



    fun readCurrentUid(): Constants.Companion.PatientProfile? {
        return try {
            sp.getString(
                PREF_CURRENT_UID,
                Constants.Companion.PatientProfile.TYPE_ADULT.toString()
            )?.let {
                Constants.Companion.PatientProfile.valueOf(
                    it
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Constants.Companion.PatientProfile.TYPE_ADULT
        }
    }

    fun setCurrentUid(uid: Constants.Companion.PatientProfile) {
        updateData(
            PREF_CURRENT_UID,
            uid.toString()
        )
    }


    fun readBodyWeight(): Float? {
        @StringRes val defaultvalue: Int = when (readCurrentUid()) {
            Constants.Companion.PatientProfile.TYPE_ADULT -> R.string.default_adult_body_weight
            Constants.Companion.PatientProfile.TYPE_PED -> R.string.default_ped_body_weight
            else -> R.string.default_adult_body_weight
        }
        return sp.getFloat(
            readCurrentUid().toString() + "." + PREF_BODY_WEIGHT,
            context.getString(defaultvalue).toFloat()
        )
    }

    fun setBodyWeight(`val`: Float?) {
        updateData(
            readCurrentUid().toString() + "." + PREF_BODY_WEIGHT,
            `val`
        )
    }

    fun readBodyHeight(): Float? {
        @StringRes val defaultvalue: Int = when (readCurrentUid()) {
            Constants.Companion.PatientProfile.TYPE_ADULT -> R.string.default_adult_body_height
            Constants.Companion.PatientProfile.TYPE_PED -> R.string.default_ped_body_height
            else -> R.string.default_adult_body_height
        }
        return sp.getFloat(
            readCurrentUid().toString() + "." + PREF_BODY_HEIGHT,
            context.getString(defaultvalue).toFloat()
        )
    }

    fun setBodyHeight(`val`: Float?) {
        updateData(
            readCurrentUid().toString() + "." + PREF_BODY_HEIGHT,
            `val`
        )
    }

    fun readAge(): Float? {
        @StringRes val defaultvalue: Int = when (readCurrentUid()) {
            Constants.Companion.PatientProfile.TYPE_ADULT -> R.string.default_adult_age
            Constants.Companion.PatientProfile.TYPE_PED -> R.string.default_ped_age
            else -> R.string.default_adult_age
        }
        return sp.getFloat(
            readCurrentUid().toString() + "." + PREF_AGE,
            context.getString(defaultvalue).toFloat()
        )
    }

    fun setAge(`val`: Float?) {
        updateData(
            readCurrentUid().toString() + "." + PREF_AGE,
            `val`
        )
    }

    fun readGender(): Constants.Companion.Gender? {
        return try {
            sp.getString(
                readCurrentUid().toString() + "." + PREF_GENDER,
                Constants.Companion.Gender.TYPE_MALE.toString()
            )?.let {
                Constants.Companion.Gender.valueOf(
                    it
                )
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            Constants.Companion.Gender.TYPE_MALE
        }
    }

    fun setGender(gender: Constants.Companion.Gender) {
        updateData(
            readCurrentUid().toString() + "." + PREF_GENDER,
            gender.toString()
        )
    }

    //    UPDATING SHARED PREFERENCES
    private fun updateData(key: String, `val`: Float?) {
        if (`val` != null) {
            val editor = sp.edit()
            editor.putFloat(key, `val`)
            editor.apply()
        }
    }

    fun removeAllTempPreferences(){
        val editor = sp.edit()
        editor.remove(PREF_DELTA_FIO2_temp)
        editor.remove(PREF_MAX_PR_temp)
        editor.remove(PREF_TARGET_PRESSURE_temp)
        editor.remove(PREF_TOTAL_FLOW_temp)
        editor.remove(PREF_FALL_RATE_temp)
        editor.remove(PREF_RISE_RATE_temp)
        editor.remove(PREF_N2O_temp)
        editor.remove(PREF_TARGET_SPO2_temp)
        editor.apply()
    }

    private fun updateData(key: String, `val`: Long?) {
        if (`val` != null) {
            val editor = sp.edit()
            editor.putLong(key, `val`)
            editor.apply()
        }
    }

    private fun updateData(key: String?, `val`: String?) {
        if (key != null && `val` != null) {
            val editor = sp.edit()
            editor.putString(key, `val`)
            editor.apply()
        }
    }

    private fun updateData(key: String?, `val`: Boolean?) {
        if (key != null && `val` != null) {
            val editor = sp.edit()
            editor.putBoolean(key, `val`)
            editor.apply()
        }
    }

    private fun updateData(key: String?, `val`: Int?) {
        if (key != null && `val` != null) {
            val editor = sp.edit()
            editor.putInt(key, `val`)
            editor.apply()
        }
    }

    private fun updateData(key: String?, `val`: Set<String>?) {
        if (key != null && `val` != null) {
            val editor = sp.edit()
            editor.putStringSet(key, `val`)
            editor.apply()
        }
    }


}
