package com.agvahealthcare.ventilator_ext.presentation.utils

import android.content.Context
import android.net.Uri
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.Sedation_App
import com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class

/**
 * Created by MASOOM ZAID on 20-04-2023.
 */


class Constants {
    companion object {


        var RUNNING_STATUS_ACTIVE = "ACTIVE"
        var RUNNING_STATUS_INACTIVE = "INACTIVE"

        enum class TraceArc {
            TraceA,
            TraceB
        }

        enum class Gender {
            TYPE_MALE, TYPE_FEMALE
        }


        //acknowlegement priority
        enum class AlarmType {
            ALARM_NO_LEVEL, ALARM_LOW_LEVEL, ALARM_MEDIUM_LEVEL, ALARM_HIGH_LEVEL, ALARM_CRITICAL_LEVEL
        }


        enum class AckType {
            INVALID_ACK, ACK, NACK, OP_ACK
        }

        enum class PatientProfile {
            TYPE_ADULT, TYPE_PED
        }

        enum class KnobSelectedType {
            tileType,
            TargetPressureType,
            BodyParams,
            AlarmTileType,
            AlarmTileTypePressure,
        }


        enum class BodyParamsType {
            Weight,
            Age,
            Height
        }

        enum class AllMenuType {
            Controls,
            Mode,
            o2_flush,
            stop_o2_flush,
            thearpy_end,
            stop_thearpy_end,
            Menu,
            Lock,
            Unlock,
            Continuous_Sedation,
            Intelli_Auto,
            Stop_Auto_N2o,
            On_Demand,
            Recovery,
            Stop_Recovery
        }

        enum class AllSubMenuType {
            EventLogs,
            ErrorLogs,
            AlarmLimits,
            RecoveryMode,
            Calibrations,
            Settings,
            ServiceWindow,
            AdvancedCalibration
        }

        enum class AllControlType {
            Basic,
            Advanced,
            Intelli
        }
        const val FIRST_FILTER_NAME = "All"
        const val LIMITTER_ALARM_PRIORITY = "Z,"
        const val DELIMETER_ALARM_PRIORITY = ",#"

        //Alarms LEVEL for the alarms of different priority
        var URI_ALARM_HIGH_LEVEL = Uri.parse(
            "android.resource://" + Sedation_App.Companion.getInstance()?.getPackageName()
                .toString() + "/raw/warning_high_level"
        )
        var URI_ALARM_MEDIUM_LEVEL = Uri.parse(
            "android.resource://" + Sedation_App.Companion.getInstance()?.getPackageName()
                .toString() + "/raw/warning_high_level"
        )
        var URI_ALARM_CRITICAL_LEVEL = Uri.parse(
            "android.resource://" + Sedation_App.Companion.getInstance()?.getPackageName()
                .toString() + "/raw/warning_high_level"
        )
        var URI_ALARM_LOW_LEVEL = Uri.parse(
            "android.resource://" + Sedation_App.Companion.getInstance()?.getPackageName()
                .toString() + "/raw/warning_low_level"
        )
        var URI_ALARM_BATTERY_LOW = Uri.parse(
            "android.resource://" + Sedation_App.Companion.getInstance()?.getPackageName()
                .toString() + "/raw/warning_battery_low"
        )
        var URI_BEEP = Uri.parse(
            "android.resource://" + Sedation_App.Companion.getInstance()?.getPackageName()
                .toString() + "/raw/beep"
        )
        var URI_LONG_BEEP = Uri.parse(
            "android.resource://" + Sedation_App.Companion.getInstance()?.getPackageName()
                .toString() + "/raw/long_tune_beep"
        )


        fun getModeNameViaCode(context: Context, mode: Int): String {
            var modeName = ""
            when (mode) {
                Mode_ContinuousSedation -> modeName = context.getString(R.string.continuos_sedation)
                Mode_OnDemand -> modeName = context.getString(R.string.on_demand)
                Mode_IntelliAuto -> modeName = context.getString(R.string.intelli_auto)
            }
            return modeName
        }

        fun getAckMessage(ctx: Context?, code: String?, readSedationMode: Int?): String? {
            when (code) {
                // low


                // medium
                ACK_CODE_321 -> return ctx?.getString(R.string.o2_cylinder_low_msg)
                ACK_CODE_322 -> return ctx?.getString(R.string.n2o_cylinder_low_msg)
                ACK_CODE_323 -> return ctx?.getString(R.string.battery_low_msg)
                ACK_CODE_324 -> return ctx?.getString(R.string.battery_critical_low_msg)

                // HIGH LOW PR & SPO2 NEED TO BE DONE FROM SOFTWARE SIDE
                ACK_CODE_325 -> return ctx?.getString(R.string.low_spo2_msg)
                ACK_CODE_326 -> return ctx?.getString(R.string.high_pr_msg)
                ACK_CODE_327 -> return ctx?.getString(R.string.low_pr_msg)

                // high
                ACK_CODE_641 -> return ctx?.getString(R.string.high_airway_pressure_msg)
                ACK_CODE_642 -> return ctx?.getString(R.string.low_n2o_inlet_pressure_msg)
                ACK_CODE_643 -> return ctx?.getString(R.string.low_o2_inlet_pressure_msg)


                ACK_CODE_644 -> return ctx?.getString(R.string.o2_cylinder_empty_msg)
                ACK_CODE_645 -> return ctx?.getString(R.string.n2o_cylinder_empty_msg)
                ACK_CODE_646 -> return ctx?.getString(R.string.on_battery_msg)
                ACK_CODE_647 -> return ctx?.getString(R.string.o2_cell_change_msg)

                ACK_CODE_746 -> return ctx?.getString(R.string.standby_activated)

                else -> return "ERROR $code"
            }
        }


        fun getControlTilesViaPreferences(
            context: Context,
            preferenceManager: PreferenceManager?,
            mode: Int
        ): Pair<ArrayList<Tile_Model_Class>, Pair<ArrayList<Tile_Model_Class>, ArrayList<Tile_Model_Class>>> {

            val basicTiles = ArrayList<Tile_Model_Class>()
            val advancedTiles = ArrayList<Tile_Model_Class>()
            val intelliTiles = ArrayList<Tile_Model_Class>()

            preferenceManager?.apply {

                if (readCurrentUid() == PatientProfile.TYPE_ADULT) {
                    when (mode) {
                        Mode_ContinuousSedation -> {
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_total_flow,
                                    context.getString(R.string.unit_total_flow),
                                    getTotalFlow().toString(),
                                    context.getString(R.string.max_total_flow),
                                    context.getString(R.string.min_total_flow),
                                    context.getString(R.string.step_total_flow),
                                )
                            )
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_N2O,
                                    context.getString(R.string.unit_n2o),
                                    getN2O().toString(),
                                    context.getString(R.string.max_n2o),
                                    context.getString(R.string.min_n2o),
                                    context.getString(R.string.step_n2o),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_RISE_RATE,
                                    context.getString(R.string.unit_rise_rate),
                                    getRiseRate().toString(),
                                    context.getString(R.string.max_rise_rate),
                                    context.getString(R.string.min_rise_rate),
                                    context.getString(R.string.step_rise_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Fall_RATE,
                                    context.getString(R.string.unit_fall_rate),
                                    getFallRate().toString(),
                                    context.getString(R.string.max_fall_rate),
                                    context.getString(R.string.min_fall_rate),
                                    context.getString(R.string.step_fall_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Plimit,
                                    context.getString(R.string.unit_plimit),
                                    getPlimit().toString(),
                                    context.getString(R.string.max_plimit),
                                    context.getString(R.string.min_plimit),
                                    context.getString(R.string.step_plimit),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_MAX_PR,
                                    context.getString(R.string.unit_max_pr),
                                    getMaxPr().toString(),
                                    context.getString(R.string.max_max_pr),
                                    context.getString(R.string.min_max_pr),
                                    context.getString(R.string.step_max_pr),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Target_Spo2,
                                    context.getString(R.string.unit_target_spo2),
                                    getTargetSpo2().toString(),
                                    context.getString(R.string.max_target_spo2),
                                    context.getString(R.string.min_target_spo2),
                                    context.getString(R.string.step_target_spo2),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Delta_Fio2,
                                    context.getString(R.string.unit_delta_fio2),
                                    getDeltaFio2().toString(),
                                    context.getString(R.string.max_delta_fio2),
                                    context.getString(R.string.min_delta_fio2),
                                    context.getString(R.string.step_delta_fio2),
                                )
                            )
                        }
                        Mode_OnDemand -> {
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_total_flow,
                                    context.getString(R.string.unit_total_flow),
                                    getTotalFlow().toString(),
                                    context.getString(R.string.max_total_flow),
                                    context.getString(R.string.min_total_flow),
                                    context.getString(R.string.step_total_flow),
                                )
                            )
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_N2O,
                                    context.getString(R.string.unit_n2o),
                                    getN2O().toString(),
                                    context.getString(R.string.max_n2o),
                                    context.getString(R.string.min_n2o),
                                    context.getString(R.string.step_n2o),
                                )
                            )

                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_target_pressure,
                                    context.getString(R.string.unit_target_pressure),
                                    getTargetPressure().toString(),
                                    context.getString(R.string.max_target_pressure),
                                    context.getString(R.string.min_target_pressure),
                                    context.getString(R.string.step_target_pressure),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_RISE_RATE,
                                    context.getString(R.string.unit_rise_rate),
                                    getRiseRate().toString(),
                                    context.getString(R.string.max_rise_rate),
                                    context.getString(R.string.min_rise_rate),
                                    context.getString(R.string.step_rise_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Fall_RATE,
                                    context.getString(R.string.unit_fall_rate),
                                    getFallRate().toString(),
                                    context.getString(R.string.max_fall_rate),
                                    context.getString(R.string.min_fall_rate),
                                    context.getString(R.string.step_fall_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Plimit,
                                    context.getString(R.string.unit_plimit),
                                    getPlimit().toString(),
                                    context.getString(R.string.max_plimit),
                                    context.getString(R.string.min_plimit),
                                    context.getString(R.string.step_plimit),
                                )
                            )


                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_MAX_PR,
                                    context.getString(R.string.unit_max_pr),
                                    getMaxPr().toString(),
                                    context.getString(R.string.max_max_pr),
                                    context.getString(R.string.min_max_pr),
                                    context.getString(R.string.step_max_pr),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Target_Spo2,
                                    context.getString(R.string.unit_target_spo2),
                                    getTargetSpo2().toString(),
                                    context.getString(R.string.max_target_spo2),
                                    context.getString(R.string.min_target_spo2),
                                    context.getString(R.string.step_target_spo2),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Delta_Fio2,
                                    context.getString(R.string.unit_delta_fio2),
                                    getDeltaFio2().toString(),
                                    context.getString(R.string.max_delta_fio2),
                                    context.getString(R.string.min_delta_fio2),
                                    context.getString(R.string.step_delta_fio2),
                                )
                            )
                        }
                        Mode_IntelliAuto -> {
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_total_flow,
                                    context.getString(R.string.unit_total_flow),
                                    getTotalFlow().toString(),
                                    context.getString(R.string.max_total_flow),
                                    context.getString(R.string.min_total_flow),
                                    context.getString(R.string.step_total_flow),
                                )
                            )
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_N2O,
                                    context.getString(R.string.unit_n2o),
                                    getN2O().toString(),
                                    context.getString(R.string.max_n2o),
                                    context.getString(R.string.min_n2o),
                                    context.getString(R.string.step_n2o),
                                )
                            )

                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_target_pressure,
                                    context.getString(R.string.unit_target_pressure),
                                    getTargetPressure().toString(),
                                    context.getString(R.string.max_target_pressure),
                                    context.getString(R.string.min_target_pressure),
                                    context.getString(R.string.step_target_pressure),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_RISE_RATE,
                                    context.getString(R.string.unit_rise_rate),
                                    getRiseRate().toString(),
                                    context.getString(R.string.max_rise_rate),
                                    context.getString(R.string.min_rise_rate),
                                    context.getString(R.string.step_rise_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Fall_RATE,
                                    context.getString(R.string.unit_fall_rate),
                                    getFallRate().toString(),
                                    context.getString(R.string.max_fall_rate),
                                    context.getString(R.string.min_fall_rate),
                                    context.getString(R.string.step_fall_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Plimit,
                                    context.getString(R.string.unit_plimit),
                                    getPlimit().toString(),
                                    context.getString(R.string.max_plimit),
                                    context.getString(R.string.min_plimit),
                                    context.getString(R.string.step_plimit),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_MAX_PR,
                                    context.getString(R.string.unit_max_pr),
                                    getMaxPr().toString(),
                                    context.getString(R.string.max_max_pr),
                                    context.getString(R.string.min_max_pr),
                                    context.getString(R.string.step_max_pr),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Target_Spo2,
                                    context.getString(R.string.unit_target_spo2),
                                    getTargetSpo2().toString(),
                                    context.getString(R.string.max_target_spo2),
                                    context.getString(R.string.min_target_spo2),
                                    context.getString(R.string.step_target_spo2),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Delta_Fio2,
                                    context.getString(R.string.unit_delta_fio2),
                                    getDeltaFio2().toString(),
                                    context.getString(R.string.max_delta_fio2),
                                    context.getString(R.string.min_delta_fio2),
                                    context.getString(R.string.step_delta_fio2),
                                )
                            )
                        }
                    }
                } else {
                    when (mode) {
                        Mode_ContinuousSedation -> {
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_total_flow,
                                    context.getString(R.string.unit_total_flow),
                                    getTotalFlow().toString(),
                                    context.getString(R.string.max_total_flow),
                                    context.getString(R.string.min_total_flow),
                                    context.getString(R.string.step_total_flow),
                                )
                            )
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_N2O,
                                    context.getString(R.string.unit_n2o),
                                    getN2O().toString(),
                                    context.getString(R.string.max_n2o),
                                    context.getString(R.string.min_n2o),
                                    context.getString(R.string.step_n2o),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_RISE_RATE,
                                    context.getString(R.string.unit_rise_rate),
                                    getRiseRate().toString(),
                                    context.getString(R.string.max_rise_rate),
                                    context.getString(R.string.min_rise_rate),
                                    context.getString(R.string.step_rise_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Fall_RATE,
                                    context.getString(R.string.unit_fall_rate),
                                    getFallRate().toString(),
                                    context.getString(R.string.max_fall_rate),
                                    context.getString(R.string.min_fall_rate),
                                    context.getString(R.string.step_fall_rate),
                                )
                            )
                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Plimit,
                                    context.getString(R.string.unit_plimit),
                                    getPlimit().toString(),
                                    context.getString(R.string.max_plimit),
                                    context.getString(R.string.min_plimit),
                                    context.getString(R.string.step_plimit),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_MAX_PR,
                                    context.getString(R.string.unit_max_pr),
                                    getMaxPr().toString(),
                                    context.getString(R.string.max_max_pr),
                                    context.getString(R.string.min_max_pr),
                                    context.getString(R.string.step_max_pr),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Target_Spo2,
                                    context.getString(R.string.unit_target_spo2),
                                    getTargetSpo2().toString(),
                                    context.getString(R.string.max_target_spo2),
                                    context.getString(R.string.min_target_spo2),
                                    context.getString(R.string.step_target_spo2),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Delta_Fio2,
                                    context.getString(R.string.unit_delta_fio2),
                                    getDeltaFio2().toString(),
                                    context.getString(R.string.max_delta_fio2),
                                    context.getString(R.string.min_delta_fio2),
                                    context.getString(R.string.step_delta_fio2),
                                )
                            )
                        }
                        Mode_OnDemand -> {
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_total_flow,
                                    context.getString(R.string.unit_total_flow),
                                    getTotalFlow().toString(),
                                    context.getString(R.string.max_total_flow),
                                    context.getString(R.string.min_total_flow),
                                    context.getString(R.string.step_total_flow),
                                )
                            )
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_N2O,
                                    context.getString(R.string.unit_n2o),
                                    getN2O().toString(),
                                    context.getString(R.string.max_n2o),
                                    context.getString(R.string.min_n2o),
                                    context.getString(R.string.step_n2o),
                                )
                            )

                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_target_pressure,
                                    context.getString(R.string.unit_target_pressure),
                                    getTargetPressure().toString(),
                                    context.getString(R.string.max_target_pressure),
                                    context.getString(R.string.min_target_pressure),
                                    context.getString(R.string.step_target_pressure),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_RISE_RATE,
                                    context.getString(R.string.unit_rise_rate),
                                    getRiseRate().toString(),
                                    context.getString(R.string.max_rise_rate),
                                    context.getString(R.string.min_rise_rate),
                                    context.getString(R.string.step_rise_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Fall_RATE,
                                    context.getString(R.string.unit_fall_rate),
                                    getFallRate().toString(),
                                    context.getString(R.string.max_fall_rate),
                                    context.getString(R.string.min_fall_rate),
                                    context.getString(R.string.step_fall_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Plimit,
                                    context.getString(R.string.unit_plimit),
                                    getPlimit().toString(),
                                    context.getString(R.string.max_plimit),
                                    context.getString(R.string.min_plimit),
                                    context.getString(R.string.step_plimit),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_MAX_PR,
                                    context.getString(R.string.unit_max_pr),
                                    getMaxPr().toString(),
                                    context.getString(R.string.max_max_pr),
                                    context.getString(R.string.min_max_pr),
                                    context.getString(R.string.step_max_pr),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Target_Spo2,
                                    context.getString(R.string.unit_target_spo2),
                                    getTargetSpo2().toString(),
                                    context.getString(R.string.max_target_spo2),
                                    context.getString(R.string.min_target_spo2),
                                    context.getString(R.string.step_target_spo2),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Delta_Fio2,
                                    context.getString(R.string.unit_delta_fio2),
                                    getDeltaFio2().toString(),
                                    context.getString(R.string.max_delta_fio2),
                                    context.getString(R.string.min_delta_fio2),
                                    context.getString(R.string.step_delta_fio2),
                                )
                            )
                        }
                        Mode_IntelliAuto -> {
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_total_flow,
                                    context.getString(R.string.unit_total_flow),
                                    getTotalFlow().toString(),
                                    context.getString(R.string.max_total_flow),
                                    context.getString(R.string.min_total_flow),
                                    context.getString(R.string.step_total_flow),
                                )
                            )
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_N2O,
                                    context.getString(R.string.unit_n2o),
                                    getN2O().toString(),
                                    context.getString(R.string.max_n2o),
                                    context.getString(R.string.min_n2o),
                                    context.getString(R.string.step_n2o),
                                )
                            )

                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_target_pressure,
                                    context.getString(R.string.unit_target_pressure),
                                    getTargetPressure().toString(),
                                    context.getString(R.string.max_target_pressure),
                                    context.getString(R.string.min_target_pressure),
                                    context.getString(R.string.step_target_pressure),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_RISE_RATE,
                                    context.getString(R.string.unit_rise_rate),
                                    getRiseRate().toString(),
                                    context.getString(R.string.max_rise_rate),
                                    context.getString(R.string.min_rise_rate),
                                    context.getString(R.string.step_rise_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Fall_RATE,
                                    context.getString(R.string.unit_fall_rate),
                                    getFallRate().toString(),
                                    context.getString(R.string.max_fall_rate),
                                    context.getString(R.string.min_fall_rate),
                                    context.getString(R.string.step_fall_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Plimit,
                                    context.getString(R.string.unit_plimit),
                                    getPlimit().toString(),
                                    context.getString(R.string.max_plimit),
                                    context.getString(R.string.min_plimit),
                                    context.getString(R.string.step_plimit),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_MAX_PR,
                                    context.getString(R.string.unit_max_pr),
                                    getMaxPr().toString(),
                                    context.getString(R.string.max_max_pr),
                                    context.getString(R.string.min_max_pr),
                                    context.getString(R.string.step_max_pr),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Target_Spo2,
                                    context.getString(R.string.unit_target_spo2),
                                    getTargetSpo2().toString(),
                                    context.getString(R.string.max_target_spo2),
                                    context.getString(R.string.min_target_spo2),
                                    context.getString(R.string.step_target_spo2),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Delta_Fio2,
                                    context.getString(R.string.unit_delta_fio2),
                                    getDeltaFio2().toString(),
                                    context.getString(R.string.max_delta_fio2),
                                    context.getString(R.string.min_delta_fio2),
                                    context.getString(R.string.step_delta_fio2),
                                )
                            )
                        }
                    }
                }
            }
            return Pair(basicTiles, Pair(advancedTiles, intelliTiles))
        }

        fun getControlTilesViaTempPreferences(
            context: Context,
            preferenceManager: PreferenceManager?,
            mode: Int
        ): Pair<ArrayList<Tile_Model_Class>, Pair<ArrayList<Tile_Model_Class>, ArrayList<Tile_Model_Class>>> {

            val basicTiles = ArrayList<Tile_Model_Class>()
            val advancedTiles = ArrayList<Tile_Model_Class>()
            val intelliTiles = ArrayList<Tile_Model_Class>()

            preferenceManager?.apply {

                if (readCurrentUid() == PatientProfile.TYPE_ADULT) {
                    when (mode) {
                        Mode_ContinuousSedation -> {
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_total_flow,
                                    context.getString(R.string.unit_total_flow),
                                    getTotalFlowTemp().toString(),
                                    context.getString(R.string.max_total_flow),
                                    context.getString(R.string.min_total_flow),
                                    context.getString(R.string.step_total_flow),
                                )
                            )
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_N2O,
                                    context.getString(R.string.unit_n2o),
                                    getN2OTemp().toString(),
                                    context.getString(R.string.max_n2o),
                                    context.getString(R.string.min_n2o),
                                    context.getString(R.string.step_n2o),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_RISE_RATE,
                                    context.getString(R.string.unit_rise_rate),
                                    getRiseRateTemp().toString(),
                                    context.getString(R.string.max_rise_rate),
                                    context.getString(R.string.min_rise_rate),
                                    context.getString(R.string.step_rise_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Fall_RATE,
                                    context.getString(R.string.unit_fall_rate),
                                    getFallRateTemp().toString(),
                                    context.getString(R.string.max_fall_rate),
                                    context.getString(R.string.min_fall_rate),
                                    context.getString(R.string.step_fall_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Plimit,
                                    context.getString(R.string.unit_plimit),
                                    getPlimitTemp().toString(),
                                    context.getString(R.string.max_plimit),
                                    context.getString(R.string.min_plimit),
                                    context.getString(R.string.step_plimit),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_MAX_PR,
                                    context.getString(R.string.unit_max_pr),
                                    getMaxPrTemp().toString(),
                                    context.getString(R.string.max_max_pr),
                                    context.getString(R.string.min_max_pr),
                                    context.getString(R.string.step_max_pr),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Target_Spo2,
                                    context.getString(R.string.unit_target_spo2),
                                    getTargetSpo2Temp().toString(),
                                    context.getString(R.string.max_target_spo2),
                                    context.getString(R.string.min_target_spo2),
                                    context.getString(R.string.step_target_spo2),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Delta_Fio2,
                                    context.getString(R.string.unit_delta_fio2),
                                    getDeltaFio2Temp().toString(),
                                    context.getString(R.string.max_delta_fio2),
                                    context.getString(R.string.min_delta_fio2),
                                    context.getString(R.string.step_delta_fio2),
                                )
                            )
                        }
                        Mode_OnDemand -> {
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_total_flow,
                                    context.getString(R.string.unit_total_flow),
                                    getTotalFlowTemp().toString(),
                                    context.getString(R.string.max_total_flow),
                                    context.getString(R.string.min_total_flow),
                                    context.getString(R.string.step_total_flow),
                                )
                            )
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_N2O,
                                    context.getString(R.string.unit_n2o),
                                    getN2OTemp().toString(),
                                    context.getString(R.string.max_n2o),
                                    context.getString(R.string.min_n2o),
                                    context.getString(R.string.step_n2o),
                                )
                            )

                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_target_pressure,
                                    context.getString(R.string.unit_target_pressure),
                                    getTargetPressureTemp().toString(),
                                    context.getString(R.string.max_target_pressure),
                                    context.getString(R.string.min_target_pressure),
                                    context.getString(R.string.step_target_pressure),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_RISE_RATE,
                                    context.getString(R.string.unit_rise_rate),
                                    getRiseRateTemp().toString(),
                                    context.getString(R.string.max_rise_rate),
                                    context.getString(R.string.min_rise_rate),
                                    context.getString(R.string.step_rise_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Fall_RATE,
                                    context.getString(R.string.unit_fall_rate),
                                    getFallRateTemp().toString(),
                                    context.getString(R.string.max_fall_rate),
                                    context.getString(R.string.min_fall_rate),
                                    context.getString(R.string.step_fall_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Plimit,
                                    context.getString(R.string.unit_plimit),
                                    getPlimitTemp().toString(),
                                    context.getString(R.string.max_plimit),
                                    context.getString(R.string.min_plimit),
                                    context.getString(R.string.step_plimit),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_MAX_PR,
                                    context.getString(R.string.unit_max_pr),
                                    getMaxPrTemp().toString(),
                                    context.getString(R.string.max_max_pr),
                                    context.getString(R.string.min_max_pr),
                                    context.getString(R.string.step_max_pr),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Target_Spo2,
                                    context.getString(R.string.unit_target_spo2),
                                    getTargetSpo2Temp().toString(),
                                    context.getString(R.string.max_target_spo2),
                                    context.getString(R.string.min_target_spo2),
                                    context.getString(R.string.step_target_spo2),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Delta_Fio2,
                                    context.getString(R.string.unit_delta_fio2),
                                    getDeltaFio2Temp().toString(),
                                    context.getString(R.string.max_delta_fio2),
                                    context.getString(R.string.min_delta_fio2),
                                    context.getString(R.string.step_delta_fio2),
                                )
                            )
                        }
                        Mode_IntelliAuto -> {
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_total_flow,
                                    context.getString(R.string.unit_total_flow),
                                    getTotalFlowTemp().toString(),
                                    context.getString(R.string.max_total_flow),
                                    context.getString(R.string.min_total_flow),
                                    context.getString(R.string.step_total_flow),
                                )
                            )
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_N2O,
                                    context.getString(R.string.unit_n2o),
                                    getN2OTemp().toString(),
                                    context.getString(R.string.max_n2o),
                                    context.getString(R.string.min_n2o),
                                    context.getString(R.string.step_n2o),
                                )
                            )

                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_target_pressure,
                                    context.getString(R.string.unit_target_pressure),
                                    getTargetPressureTemp().toString(),
                                    context.getString(R.string.max_target_pressure),
                                    context.getString(R.string.min_target_pressure),
                                    context.getString(R.string.step_target_pressure),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_RISE_RATE,
                                    context.getString(R.string.unit_rise_rate),
                                    getRiseRateTemp().toString(),
                                    context.getString(R.string.max_rise_rate),
                                    context.getString(R.string.min_rise_rate),
                                    context.getString(R.string.step_rise_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Fall_RATE,
                                    context.getString(R.string.unit_fall_rate),
                                    getFallRateTemp().toString(),
                                    context.getString(R.string.max_fall_rate),
                                    context.getString(R.string.min_fall_rate),
                                    context.getString(R.string.step_fall_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Plimit,
                                    context.getString(R.string.unit_plimit),
                                    getPlimitTemp().toString(),
                                    context.getString(R.string.max_plimit),
                                    context.getString(R.string.min_plimit),
                                    context.getString(R.string.step_plimit),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_MAX_PR,
                                    context.getString(R.string.unit_max_pr),
                                    getMaxPrTemp().toString(),
                                    context.getString(R.string.max_max_pr),
                                    context.getString(R.string.min_max_pr),
                                    context.getString(R.string.step_max_pr),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Target_Spo2,
                                    context.getString(R.string.unit_target_spo2),
                                    getTargetSpo2Temp().toString(),
                                    context.getString(R.string.max_target_spo2),
                                    context.getString(R.string.min_target_spo2),
                                    context.getString(R.string.step_target_spo2),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Delta_Fio2,
                                    context.getString(R.string.unit_delta_fio2),
                                    getDeltaFio2Temp().toString(),
                                    context.getString(R.string.max_delta_fio2),
                                    context.getString(R.string.min_delta_fio2),
                                    context.getString(R.string.step_delta_fio2),
                                )
                            )
                        }
                    }
                } else {
                    when (mode) {
                        Mode_ContinuousSedation -> {
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_total_flow,
                                    context.getString(R.string.unit_total_flow),
                                    getTotalFlowTemp().toString(),
                                    context.getString(R.string.max_total_flow),
                                    context.getString(R.string.min_total_flow),
                                    context.getString(R.string.step_total_flow),
                                )
                            )
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_N2O,
                                    context.getString(R.string.unit_n2o),
                                    getN2OTemp().toString(),
                                    context.getString(R.string.max_n2o),
                                    context.getString(R.string.min_n2o),
                                    context.getString(R.string.step_n2o),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_RISE_RATE,
                                    context.getString(R.string.unit_rise_rate),
                                    getRiseRateTemp().toString(),
                                    context.getString(R.string.max_rise_rate),
                                    context.getString(R.string.min_rise_rate),
                                    context.getString(R.string.step_rise_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Fall_RATE,
                                    context.getString(R.string.unit_fall_rate),
                                    getFallRateTemp().toString(),
                                    context.getString(R.string.max_fall_rate),
                                    context.getString(R.string.min_fall_rate),
                                    context.getString(R.string.step_fall_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Plimit,
                                    context.getString(R.string.unit_plimit),
                                    getPlimitTemp().toString(),
                                    context.getString(R.string.max_plimit),
                                    context.getString(R.string.min_plimit),
                                    context.getString(R.string.step_plimit),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_MAX_PR,
                                    context.getString(R.string.unit_max_pr),
                                    getMaxPrTemp().toString(),
                                    context.getString(R.string.max_max_pr),
                                    context.getString(R.string.min_max_pr),
                                    context.getString(R.string.step_max_pr),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Target_Spo2,
                                    context.getString(R.string.unit_target_spo2),
                                    getTargetSpo2Temp().toString(),
                                    context.getString(R.string.max_target_spo2),
                                    context.getString(R.string.min_target_spo2),
                                    context.getString(R.string.step_target_spo2),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Delta_Fio2,
                                    context.getString(R.string.unit_delta_fio2),
                                    getDeltaFio2Temp().toString(),
                                    context.getString(R.string.max_delta_fio2),
                                    context.getString(R.string.min_delta_fio2),
                                    context.getString(R.string.step_delta_fio2),
                                )
                            )
                        }
                        Mode_OnDemand -> {
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_total_flow,
                                    context.getString(R.string.unit_total_flow),
                                    getTotalFlowTemp().toString(),
                                    context.getString(R.string.max_total_flow),
                                    context.getString(R.string.min_total_flow),
                                    context.getString(R.string.step_total_flow),
                                )
                            )
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_N2O,
                                    context.getString(R.string.unit_n2o),
                                    getN2OTemp().toString(),
                                    context.getString(R.string.max_n2o),
                                    context.getString(R.string.min_n2o),
                                    context.getString(R.string.step_n2o),
                                )
                            )

                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_target_pressure,
                                    context.getString(R.string.unit_target_pressure),
                                    getTargetPressureTemp().toString(),
                                    context.getString(R.string.max_target_pressure),
                                    context.getString(R.string.min_target_pressure),
                                    context.getString(R.string.step_target_pressure),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_RISE_RATE,
                                    context.getString(R.string.unit_rise_rate),
                                    getRiseRateTemp().toString(),
                                    context.getString(R.string.max_rise_rate),
                                    context.getString(R.string.min_rise_rate),
                                    context.getString(R.string.step_rise_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Fall_RATE,
                                    context.getString(R.string.unit_fall_rate),
                                    getFallRateTemp().toString(),
                                    context.getString(R.string.max_fall_rate),
                                    context.getString(R.string.min_fall_rate),
                                    context.getString(R.string.step_fall_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Plimit,
                                    context.getString(R.string.unit_plimit),
                                    getPlimitTemp().toString(),
                                    context.getString(R.string.max_plimit),
                                    context.getString(R.string.min_plimit),
                                    context.getString(R.string.step_plimit),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_MAX_PR,
                                    context.getString(R.string.unit_max_pr),
                                    getMaxPrTemp().toString(),
                                    context.getString(R.string.max_max_pr),
                                    context.getString(R.string.min_max_pr),
                                    context.getString(R.string.step_max_pr),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Target_Spo2,
                                    context.getString(R.string.unit_target_spo2),
                                    getTargetSpo2Temp().toString(),
                                    context.getString(R.string.max_target_spo2),
                                    context.getString(R.string.min_target_spo2),
                                    context.getString(R.string.step_target_spo2),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Delta_Fio2,
                                    context.getString(R.string.unit_delta_fio2),
                                    getDeltaFio2Temp().toString(),
                                    context.getString(R.string.max_delta_fio2),
                                    context.getString(R.string.min_delta_fio2),
                                    context.getString(R.string.step_delta_fio2),
                                )
                            )
                        }
                        Mode_IntelliAuto -> {
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_total_flow,
                                    context.getString(R.string.unit_total_flow),
                                    getTotalFlowTemp().toString(),
                                    context.getString(R.string.max_total_flow),
                                    context.getString(R.string.min_total_flow),
                                    context.getString(R.string.step_total_flow),
                                )
                            )
                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_N2O,
                                    context.getString(R.string.unit_n2o),
                                    getN2OTemp().toString(),
                                    context.getString(R.string.max_n2o),
                                    context.getString(R.string.min_n2o),
                                    context.getString(R.string.step_n2o),
                                )
                            )

                            basicTiles.add(
                                Tile_Model_Class(
                                    lbl_target_pressure,
                                    context.getString(R.string.unit_target_pressure),
                                    getTargetPressureTemp().toString(),
                                    context.getString(R.string.max_target_pressure),
                                    context.getString(R.string.min_target_pressure),
                                    context.getString(R.string.step_target_pressure),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_RISE_RATE,
                                    context.getString(R.string.unit_rise_rate),
                                    getRiseRateTemp().toString(),
                                    context.getString(R.string.max_rise_rate),
                                    context.getString(R.string.min_rise_rate),
                                    context.getString(R.string.step_rise_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Fall_RATE,
                                    context.getString(R.string.unit_fall_rate),
                                    getFallRateTemp().toString(),
                                    context.getString(R.string.max_fall_rate),
                                    context.getString(R.string.min_fall_rate),
                                    context.getString(R.string.step_fall_rate),
                                )
                            )

                            advancedTiles.add(
                                Tile_Model_Class(
                                    lbl_Plimit,
                                    context.getString(R.string.unit_plimit),
                                    getPlimitTemp().toString(),
                                    context.getString(R.string.max_plimit),
                                    context.getString(R.string.min_plimit),
                                    context.getString(R.string.step_plimit),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_MAX_PR,
                                    context.getString(R.string.unit_max_pr),
                                    getMaxPrTemp().toString(),
                                    context.getString(R.string.max_max_pr),
                                    context.getString(R.string.min_max_pr),
                                    context.getString(R.string.step_max_pr),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Target_Spo2,
                                    context.getString(R.string.unit_target_spo2),
                                    getTargetSpo2Temp().toString(),
                                    context.getString(R.string.max_target_spo2),
                                    context.getString(R.string.min_target_spo2),
                                    context.getString(R.string.step_target_spo2),
                                )
                            )

                            intelliTiles.add(
                                Tile_Model_Class(
                                    lbl_Delta_Fio2,
                                    context.getString(R.string.unit_delta_fio2),
                                    getDeltaFio2Temp().toString(),
                                    context.getString(R.string.max_delta_fio2),
                                    context.getString(R.string.min_delta_fio2),
                                    context.getString(R.string.step_delta_fio2),
                                )
                            )
                        }
                    }

                }
            }
            return Pair(basicTiles, Pair(advancedTiles, intelliTiles))
        }

        enum class ChartType {
            PressureChart_Type, FlowChart_Type
        }

        const val MIN_RANGE_Y_AXIS_COMMON : Double = 0.0
        // constants for graph range
        const val MIN_RANGE_VOLUME_ADULT_PEDIA : Double = 500.0
        const val MID_RANGE_VOLUME_ADULT_PEDIA : Double = 1000.0
        const val MAX_RANGE_VOLUME_ADULT_PEDIA : Double = 2000.0


        //Changed for testing
        const val LIMIT_FOR_ALARM_DELETION = 130

        const val MAX_RANGE_PRESSURE_ADULT_PEDIA : Double = 70.0
        const val MID_RANGE_PRESSURE_ADULT_PEDIA : Double = 60.0
        const val MIN_RANGE_PRESSURE_ADULT_PEDIA : Double = 30.0


        const val MAX_RANGE_ETCO2_ADULT_PEDIA : Double = 150.0
        const val MID_RANGE_ETCO2_ADULT_PEDIA : Double = 100.0
        const val MIN_RANGE_ETCO2_ADULT_PEDIA : Double = 50.0

        const val NEGATIVE_MIN_RANGE_FLOW_ADULT_PEDIA : Double = 0.0
        const val NEGATIVE_MID_RANGE_FLOW_ADULT_PEDIA : Double = -100.0
        const val NEGATIVE_MAX_RANGE_FLOW_ADULT_PEDIA : Double = -200.0

        const val POSITIVE_MIN_RANGE_FLOW_ADULT_PEDIA : Double = 50.0
        const val POSITIVE_MID_RANGE_FLOW_ADULT_PEDIA : Double = 100.0
        const val POSITIVE_MAX_RANGE_FLOW_ADULT_PEDIA : Double = 200.0

        const val TAG_SENSOR_LENGTH = 1
        const val TAG_SENSOR_N2O_FLOW = "1"
        const val TAG_SENSOR_O2_FLOW = "2"
        const val PREFIX_SENSOR_CALIBRATION = "SC"

        // method for dashboard chart y-axis range
        // Modified by masoom on 04 jan 2023
        fun getRangeOfYAxisChart(
            ctx: Context?,
            chartType: ChartType?
        ): android.util.Pair<Double, Double>? {
            val prefManager = PreferenceManager(ctx!!)
            // Pair for ranges of y-axis of dashboard chart
            var range = android.util.Pair(0.0, 0.0)
            when (prefManager.readCurrentUid()) {
                PatientProfile.TYPE_ADULT -> when (chartType) {
                    ChartType.PressureChart_Type -> range = android.util.Pair(
                        MIN_RANGE_Y_AXIS_COMMON,
                        MIN_RANGE_PRESSURE_ADULT_PEDIA
                    )
                    ChartType.FlowChart_Type -> range = android.util.Pair(
                        NEGATIVE_MIN_RANGE_FLOW_ADULT_PEDIA,
                        POSITIVE_MIN_RANGE_FLOW_ADULT_PEDIA
                    )

                    else -> {}
                }
                PatientProfile.TYPE_PED -> when (chartType) {
                    ChartType.PressureChart_Type -> range = android.util.Pair(
                        MIN_RANGE_Y_AXIS_COMMON,
                        MIN_RANGE_PRESSURE_ADULT_PEDIA
                    )
                    ChartType.FlowChart_Type -> range = android.util.Pair(
                        NEGATIVE_MIN_RANGE_FLOW_ADULT_PEDIA,
                        POSITIVE_MIN_RANGE_FLOW_ADULT_PEDIA
                    )

                    else -> {}
                }

                else -> {}
            }
            return range
        }


        const val SCHICHART_API =
            "8H9hpavUwqd9Mztro3n+84T1iR9GBhyQLlBGF3Q+RmOEsnzkBF23dzKup+t9djIiu7ChkOkadMNcu3GlIKtNlUKX9UFlnMadFopZgl/Nd2NMCzr7GN9WGYbO+z8qbm6D3kFkQ0J49/EXEryao1b7HIEKvNIqtwD/qUT8nAtEHv35xoE3EAi/KlbB9X0HAv2DpI0UPk5bSjeS+Qorwnw61NiL6zayqmeNGCtJWXtbeSEAvjXYLTiIs3nWHJg9RA5f7+R6GVV163/k2llweaiC8Zxg1gCjLiSGZLvrUBzpvPmlpkz3jQJcnq4zTKUVr9y8cFF4+ioLIBhTQutCxiD3rCYMNTjF+Ov3SErw+vTJz/DOUUHJXn/n71bSwsJrRRtx3MGPl61YV6tSiS524a2+Ig25Xop7KkLurjoTSXM0Vy0XoSlu7Zs0DVkUF1RdjWK2YovW7zeQ3+nvOXsl8fXZx8muefSlVWA3nYHlN0s7RqClafuZAgXAokracbSEBkza6fJCBarwOlo\\="

        const val BASE_URL = ""
        const val VENTILATOR_ACK = "vent_ack"
        const val VENTILATOR_MODES = "vent_mode"
        const val VENTILATOR_DATA = "vent_data"
        const val VENTILATOR_BATTERY_LEVEL = "vent_battery_volt"
        const val VENTILATOR_O2_PRESSURE = "vent_o2_pressure"
        const val VENTILATOR_O2_THERAPY = "VENTILATOR_O2_THERAPY"
        const val VENTILATOR_n2o_THERAPY = "VENTILATOR_n2o_THERAPY"
        const val VENTILATOR_time_THERAPY = "VENTILATOR_time_THERAPY"
        const val VENTILATOR_N2O_PRESSURE = "vent_n2o_pressure"
        const val VENTILATOR_CONTROL_KNOB = "control_sub_knob"
        const val MUTE_UNMUTE_RESPONSE = "mute_unmute_response"
        const val PREFIX_BATTERY = "BTRY@"
        const val PREFIX_THERAPY = "TE~"

        const val DELIMITER_BATTERY = "#"
        const val DELIMITER_THERAPY = "`"

        const val PREFIX_PLUS = "+"
        const val PREFIX_MINUS = "-"
        const val PREFIX_AND = "&"
        const val KNOB_LENGTH = 1
        const val command_to_start_therapy_end = "CM+T1"
        const val command_to_end_therapy_end = "CM+T2"
        const val command_to_standby = "CM+STANDBY"

        const val MIN_RANGE = 0.0
        const val MAX_RANGE = 50.0

        const val WEIGHT_LOWER: Int = 30
        const val WEIGHT_UPPER: Int = 200

        const val HEIGHT_LOWER: Int = 80
        const val HEIGHT_UPPER: Int = 250

        const val AGE_LOWER: Int = 1
        const val AGE_UPPER: Int = 100

        const val VOLUME_MIN_VALUE = 2
        const val VOLUME_MAX_VALUE = 10

        const val FIFO_CAPACITY = 340
        const val GRAPH_THRESHOLD = FIFO_CAPACITY + 10

        var ALARM_Fio2 = "Alarm Fio2"
        var ALARM_Flow = "Alarm Flow"
        var ALARM_Paw = "Alarm Paw"

        const val ALERT_MSG ="alert_msg"
        const val ALERT_LABEL ="alert_label"

        const val lbl_averarge_leak = "Average Leak"
        const val lbl_flow = "Flow"
        const val lbl_paw = "Paw"
        const val lbl_fio2 = "Fio₂"
        const val lbl_total_flow = "Flow"
        const val lbl_Maximum = "Maximum"
        const val lbl_Rate_Of_Increase = "Rate of increase"
        const val lbl_Tinsp = "Tinsp"
        const val lbl_Time = "Time"
        const val lbl_N2O = "N₂O"
        const val lbl_RISE_RATE = "Rise Rate"
        const val lbl_Fall_RATE = "Fall Rate"
        const val lbl_Plimit = "Plimit"
        const val lbl_MAX_PR = "Max PR"
        const val lbl_Target_Spo2 = "Tg. Spo₂"
        const val lbl_Delta_Fio2 = "Δ Fio₂"
        const val lbl_target_pressure = "Pressure"
        const val lbl_PTrigger = "Ptrigger"


        //Flags
        const val IS_STAND_BY = "IS_STAND_BY"

        ///

        //Alarms

        const val ACK_CODE_5003 = "ACK5003"
        const val ACK_CODE_5004 = "ACK5004"
        const val ACK_CODE_5005 = "ACK5005"
        const val ACK_CODE_5006 = "ACK5006"
        const val ACK_CODE_5010 = "ACK5010"
        const val ACK_CODE_5012 = "ACK5012"
        const val ACK_CODE_5013 = "ACK5013"
        const val ACK_CODE_5014 = "ACK5014"
        const val ACK_CODE_5015 = "ACK5015"
        const val ACK_CODE_5016 = "ACK5016"
        const val ACK_CODE_5017 = "ACK5017"
        const val ACK_CODE_5018 = "ACK5018"

        //Low priority Alarms
        // ACKNOWLEDGEMENT CODES
        var ACK_CODE_0 = "ACK0000"
        var ACK_CODE_1 = "ACK0001"
        var ACK_CODE_2 = "ACK0002"
        var ACK_CODE_3 = "ACK0003"
        var ACK_CODE_4 = "ACK0004"
        var ACK_CODE_5 = "ACK0005"
        var ACK_CODE_6 = "ACK0006"
        var ACK_CODE_7 = "ACK0007"
        var ACK_CODE_8 = "ACK0008"
        var ACK_CODE_9 = "ACK0009"
        var ACK_CODE_10 = "ACK0010"
        var ACK_CODE_11 = "ACK0011"
        var ACK_CODE_12 = "ACK0012"
        var ACK_CODE_13 = "ACK0013"
        var ACK_CODE_14 = "ACK0014"
        var ACK_CODE_15 = "ACK0015"
        var ACK_CODE_16 = "ACK0016"
        var ACK_CODE_17 = "ACK0017"
        var ACK_CODE_18 = "ACK0018"
        var ACK_CODE_19 = "ACK0019"
        var ACK_CODE_20 = "ACK0020"
        var ACK_CODE_21 = "ACK0021"
        var ACK_CODE_22 = "ACK0022"
        var ACK_CODE_23 = "ACK0023"
        var ACK_CODE_24 = "ACK0024"
        var ACK_CODE_25 = "ACK0025"
        var ACK_CODE_26 = "ACK0026"
        var ACK_CODE_27 = "ACK0027"
        var ACK_CODE_28 = "ACK0028"
        var ACK_CODE_29 = "ACK0029"
        var ACK_CODE_30 = "ACK0030"
        var ACK_CODE_31 = "ACK0031"
        var ACK_CODE_32 = "ACK0032"
        var ACK_CODE_33 = "ACK0033"
        var ACK_CODE_34 = "ACK0034"
        var ACK_CODE_35 = "ACK0035"
        var ACK_CODE_36 = "ACK0036"
        var ACK_CODE_37 = "ACK0037"
        var ACK_CODE_38 = "ACK0038"
        var ACK_CODE_39 = "ACK0039"
        var ACK_CODE_40 = "ACK0040"
        var ACK_CODE_41 = "ACK0041"
        var ACK_CODE_42 = "ACK0042"
        var ACK_CODE_43 = "ACK0043"
        var ACK_CODE_44 = "ACK0044"
        var ACK_CODE_45 = "ACK0045"
        var ACK_CODE_46 = "ACK0046"
        var ACK_CODE_47 = "ACK0047"
        var ACK_CODE_48 = "ACK0048"

        var ACK_CODE_49 = "ACK0049"
        var ACK_CODE_50 = "ACK0050"
        var ACK_CODE_51 = "ACK0051"
        var ACK_CODE_52 = "ACK0052"
        var ACK_CODE_53 = "ACK0053"
        var ACK_CODE_54 = "ACK0054"
        var ACK_CODE_55 = "ACK0055"
        var ACK_CODE_56 = "ACK0056"
        var ACK_CODE_57 = "ACK0057"
        var ACK_CODE_58 = "ACK0058"
        var ACK_CODE_59 = "ACK0059"
        var ACK_CODE_60 = "ACK0060"
        var ACK_CODE_61 = "ACK0061"
        var ACK_CODE_62 = "ACK0062"
        var ACK_CODE_63 = "ACK0063"
        var ACK_CODE_64 = "ACK0064"
        var ACK_CODE_65 = "ACK0065"
        var ACK_CODE_66 = "ACK0066"
        var ACK_CODE_67 = "ACK0067"
        var ACK_CODE_68 = "ACK0068"
        var ACK_CODE_69 = "ACK0069"
        var ACK_CODE_70 = "ACK0070"
        var ACK_CODE_71 = "ACK0071"
        var ACK_CODE_72 = "ACK0072"
        var ACK_CODE_73 = "ACK0073"
        var ACK_CODE_74 = "ACK0074"
        var ACK_CODE_75 = "ACK0075"
        var ACK_CODE_76 = "ACK0076"
        var ACK_CODE_77 = "ACK0077"
        var ACK_CODE_78 = "ACK0078"
        var ACK_CODE_79 = "ACK0079"
        var ACK_CODE_80 = "ACK0080"
        var ACK_CODE_81 = "ACK0081"
        var ACK_CODE_82 = "ACK0082"
        var ACK_CODE_83 = "ACK0083"
        var ACK_CODE_84 = "ACK0084"
        var ACK_CODE_90 = "ACK0090"
        var ACK_CODE_91 = "ACK0091"
        var ACK_CODE_92 = "ACK0092"
        var ACK_CODE_93 = "ACK0093"
        var ACK_CODE_94 = "ACK0094"


        //Medium priority alarms
        var ACK_CODE_320 = "ACK0320"
        var ACK_CODE_321 = "ACK0321"
        var ACK_CODE_322 = "ACK0322"
        var ACK_CODE_323 = "ACK0323"
        var ACK_CODE_324 = "ACK0324"
        var ACK_CODE_325 = "ACK0325"
        var ACK_CODE_326 = "ACK0326"
        var ACK_CODE_327 = "ACK0327"
        var ACK_CODE_328 = "ACK0328"
        var ACK_CODE_329 = "ACK0329"
        var ACK_CODE_330 = "ACK0330"
        var ACK_CODE_331 = "ACK0331"
        var ACK_CODE_332 = "ACK0332"
        var ACK_CODE_333 = "ACK0333"
        var ACK_CODE_334 = "ACK0334"
        var ACK_CODE_335 = "ACK0335"
        var ACK_CODE_336 = "ACK0336"
        var ACK_CODE_337 = "ACK0337"
        var ACK_CODE_338 = "ACK0338"
        var ACK_CODE_339 = "ACK0339"
        var ACK_CODE_340 = "ACK0340"
        var ACK_CODE_341 = "ACK0341"
        var ACK_CODE_342 = "ACK0342"
        var ACK_CODE_343 = "ACK0343"
        var ACK_CODE_344 = "ACK0344"
        var ACK_CODE_345 = "ACK0345"
        var ACK_CODE_346 = "ACK0346"
        var ACK_CODE_347 = "ACK0347"
        var ACK_CODE_348 = "ACK0348"
        var ACK_CODE_349 = "ACK0349"
        var ACK_CODE_350 = "ACK0350"
        var ACK_CODE_351 = "ACK0351"
        var ACK_CODE_352 = "ACK0352"
        var ACK_CODE_353 = "ACK0353"
        var ACK_CODE_354 = "ACK0354"
        var ACK_CODE_355 = "ACK0355"
        var ACK_CODE_356 = "ACK0356"
        var ACK_CODE_357 = "ACK0357"
        var ACK_CODE_358 = "ACK0358"
        var ACK_CODE_359 = "ACK0359"
        var ACK_CODE_360 = "ACK0360"
        var ACK_CODE_361 = "ACK0361"
        var ACK_CODE_362 = "ACK0362"
        var ACK_CODE_363 = "ACK0363"
        var ACK_CODE_364 = "ACK0364"
        var ACK_CODE_365 = "ACK0365"
        var ACK_CODE_366 = "ACK0366"
        var ACK_CODE_367 = "ACK0367"
        var ACK_CODE_368 = "ACK0368"
        var ACK_CODE_369 = "ACK0369"
        var ACK_CODE_370 = "ACK0370"
        var ACK_CODE_371 = "ACK0371"
        var ACK_CODE_372 = "ACK0372"
        var ACK_CODE_373 = "ACK0373"
        var ACK_CODE_374 = "ACK0374"
        var ACK_CODE_375 = "ACK0375"
        var ACK_CODE_376 = "ACK0376"
        var ACK_CODE_377 = "ACK0377"
        var ACK_CODE_378 = "ACK0378"
        var ACK_CODE_379 = "ACK0379"
        var ACK_CODE_380 = "ACK0380"
        var ACK_CODE_381 = "ACK0381"
        var ACK_CODE_382 = "ACK0382"
        var ACK_CODE_383 = "ACK0383"
        var ACK_CODE_384 = "ACK0384"
        var ACK_CODE_385 = "ACK0385"
        var ACK_CODE_386 = "ACK0386"
        var ACK_CODE_387 = "ACK0387"
        var ACK_CODE_388 = "ACK0388"
        var ACK_CODE_389 = "ACK0389"
        var ACK_CODE_390 = "ACK0390"
        var ACK_CODE_391 = "ACK0391"
        var ACK_CODE_392 = "ACK0392"
        var ACK_CODE_393 = "ACK0393"
        var ACK_CODE_394 = "ACK0394"
        var ACK_CODE_395 = "ACK0395"
        var ACK_CODE_396 = "ACK0396"
        var ACK_CODE_397 = "ACK0397"
        var ACK_CODE_398 = "ACK0398"
        var ACK_CODE_399 = "ACK0399"
        var ACK_CODE_400 = "ACK0400"
        var ACK_CODE_401 = "ACK0401"
        var ACK_CODE_402 = "ACK0402"
        var ACK_CODE_403 = "ACK0403"
        var ACK_CODE_404 = "ACK0404"
        var ACK_CODE_405 = "ACK0405"
        var ACK_CODE_406 = "ACK0406"
        var ACK_CODE_407 = "ACK0407"
        var ACK_CODE_408 = "ACK0408"
        var ACK_CODE_409 = "ACK0409"
        var ACK_CODE_410 = "ACK0410"
        var ACK_CODE_411 = "ACK0411"
        var ACK_CODE_412 = "ACK0412"
        var ACK_CODE_413 = "ACK0413"
        var ACK_CODE_414 = "ACK0414"
        var ACK_CODE_415 = "ACK0415"
        var ACK_CODE_416 = "ACK0416"
        var ACK_CODE_417 = "ACK0417"
        var ACK_CODE_418 = "ACK0418"
        var ACK_CODE_419 = "ACK0419"
        var ACK_CODE_420 = "ACK0420"
        var ACK_CODE_421 = "ACK0421"
        var ACK_CODE_422 = "ACK0422"
        var ACK_CODE_423 = "ACK0423"
        var ACK_CODE_424 = "ACK0424"
        var ACK_CODE_425 = "ACK0425"
        var ACK_CODE_426 = "ACK0426"
        var ACK_CODE_427 = "ACK0427"
        var ACK_CODE_428 = "ACK0428"

        var ACK_CODE_430 = "ACK0430"
        var ACK_CODE_431 = "ACK0431"
        var ACK_CODE_432 = "ACK0432"
        var ACK_CODE_433 = "ACK0433"
        var ACK_CODE_434 = "ACK0434"
        var ACK_CODE_435 = "ACK0435"
        var ACK_CODE_436 = "ACK0436"
        var ACK_CODE_437 = "ACK0437"
        var ACK_CODE_438 = "ACK0438"


        //high priority alarm
        var ACK_CODE_640 = "ACK0640"
        var ACK_CODE_641 = "ACK0641"
        var ACK_CODE_642 = "ACK0642"
        var ACK_CODE_643 = "ACK0643"
        var ACK_CODE_644 = "ACK0644"
        var ACK_CODE_645 = "ACK0645"
        var ACK_CODE_646 = "ACK0646"
        var ACK_CODE_647 = "ACK0647"
        var ACK_CODE_648 = "ACK0648"
        var ACK_CODE_649 = "ACK0649"
        var ACK_CODE_650 = "ACK0650"
        var ACK_CODE_651 = "ACK0651"
        var ACK_CODE_652 = "ACK0652"
        var ACK_CODE_653 = "ACK0653"
        var ACK_CODE_654 = "ACK0654"
        var ACK_CODE_655 = "ACK0655"
        var ACK_CODE_656 = "ACK0656"
        var ACK_CODE_657 = "ACK0657"
        var ACK_CODE_658 = "ACK0658"
        var ACK_CODE_659 = "ACK0659"
        var ACK_CODE_660 = "ACK0660"
        var ACK_CODE_661 = "ACK0661"
        var ACK_CODE_662 = "ACK0662"
        var ACK_CODE_663 = "ACK0663"
        var ACK_CODE_664 = "ACK0664"
        var ACK_CODE_665 = "ACK0665"
        var ACK_CODE_666 = "ACK0666"
        var ACK_CODE_667 = "ACK0667"
        var ACK_CODE_668 = "ACK0668"
        var ACK_CODE_669 = "ACK0669"
        var ACK_CODE_670 = "ACK0670"
        var ACK_CODE_671 = "ACK0671"
        var ACK_CODE_672 = "ACK0672"
        var ACK_CODE_673 = "ACK0673"
        var ACK_CODE_674 = "ACK0674"
        var ACK_CODE_675 = "ACK0675"
        var ACK_CODE_676 = "ACK0676"
        var ACK_CODE_677 = "ACK0677"
        var ACK_CODE_678 = "ACK0678"
        var ACK_CODE_679 = "ACK0679"
        var ACK_CODE_680 = "ACK0680"
        var ACK_CODE_681 = "ACK0681"
        var ACK_CODE_682 = "ACK0682"
        var ACK_CODE_683 = "ACK0683"
        var ACK_CODE_684 = "ACK0684"
        var ACK_CODE_685 = "ACK0685"
        var ACK_CODE_686 = "ACK0686"
        var ACK_CODE_687 = "ACK0687"
        var ACK_CODE_688 = "ACK0688"
        var ACK_CODE_689 = "ACK0689"
        var ACK_CODE_690 = "ACK0690"
        var ACK_CODE_691 = "ACK0691"
        var ACK_CODE_692 = "ACK0692"
        var ACK_CODE_693 = "ACK0693"
        var ACK_CODE_694 = "ACK0694"
        var ACK_CODE_695 = "ACK0695"
        var ACK_CODE_696 = "ACK0696"
        var ACK_CODE_697 = "ACK0697"
        var ACK_CODE_698 = "ACK0698"
        var ACK_CODE_699 = "ACK0699"
        var ACK_CODE_700 = "ACK0700"
        var ACK_CODE_701 = "ACK0701"
        var ACK_CODE_702 = "ACK0702"
        var ACK_CODE_703 = "ACK0703"
        var ACK_CODE_704 = "ACK0704"
        var ACK_CODE_705 = "ACK0705"
        var ACK_CODE_706 = "ACK0706"
        var ACK_CODE_707 = "ACK0707"
        var ACK_CODE_708 = "ACK0708"
        var ACK_CODE_709 = "ACK0709"
        var ACK_CODE_710 = "ACK0710"
        var ACK_CODE_711 = "ACK0711"
        var ACK_CODE_712 = "ACK0712"
        var ACK_CODE_713 = "ACK0713"
        var ACK_CODE_714 = "ACK0714"
        var ACK_CODE_715 = "ACK0715"
        var ACK_CODE_716 = "ACK0716"
        var ACK_CODE_717 = "ACK0717"
        var ACK_CODE_718 = "ACK0718"
        var ACK_CODE_719 = "ACK0719"
        var ACK_CODE_720 = "ACK0720"
        var ACK_CODE_721 = "ACK0721"
        var ACK_CODE_722 = "ACK0722"
        var ACK_CODE_723 = "ACK0723"
        var ACK_CODE_724 = "ACK0724"
        var ACK_CODE_725 = "ACK0725"
        var ACK_CODE_726 = "ACK0726"
        var ACK_CODE_727 = "ACK0727"
        var ACK_CODE_728 = "ACK0728"
        var ACK_CODE_729 = "ACK0729"
        var ACK_CODE_730 = "ACK0730"
        var ACK_CODE_731 = "ACK0731"
        var ACK_CODE_732 = "ACK0732"
        var ACK_CODE_733 = "ACK0733"
        var ACK_CODE_734 = "ACK0734"
        var ACK_CODE_735 = "ACK0735"
        var ACK_CODE_736 = "ACK0736"
        var ACK_CODE_737 = "ACK0737"
        var ACK_CODE_738 = "ACK0738"
        var ACK_CODE_739 = "ACK0739"
        var ACK_CODE_740 = "ACK0740"
        var ACK_CODE_741 = "ACK0741"
        var ACK_CODE_742 = "ACK0742"
        var ACK_CODE_743 = "ACK0743"
        var ACK_CODE_744 = "ACK0744"
        var ACK_CODE_745 = "ACK0745"
        var ACK_CODE_746 = "ACK0746"
        var ACK_CODE_747 = "ACK0747"
        var ACK_CODE_748 = "ACK0748"
        var ACK_CODE_749 = "ACK0749"
        var ACK_CODE_750 = "ACK0750"
        var ACK_CODE_751 = "ACK0751"
        var ACK_CODE_752 = "ACK0752"
        var ACK_CODE_753 = "ACK0753"
        var ACK_CODE_754 = "ACK0754"
        var ACK_CODE_755 = "ACK0755"
        var ACK_CODE_756 = "ACK0756"
        var ACK_CODE_757 = "ACK0757"
        var ACK_CODE_758 = "ACK0758"
        var ACK_CODE_759 = "ACK0759"
        var ACK_CODE_760 = "ACK0760"
        var ACK_CODE_761 = "ACK0761"
        var ACK_CODE_762 = "ACK0762"
        var ACK_CODE_763 = "ACK0763"
        var ACK_CODE_764 = "ACK0764"
        var ACK_CODE_765 = "ACK0765"
        var ACK_CODE_766 = "ACK0766"
        var ACK_CODE_767 = "ACK0767"
        var ACK_CODE_768 = "ACK0768"
        var ACK_CODE_769 = "ACK0769"
        var ACK_CODE_770 = "ACK0770"
        var ACK_CODE_771 = "ACK0771"
        var ACK_CODE_772 = "ACK0772"
        var ACK_CODE_773 = "ACK0773"
        var ACK_CODE_774 = "ACK0774"
        var ACK_CODE_775 = "ACK0775"
        var ACK_CODE_776 = "ACK0776"
        var ACK_CODE_777 = "ACK0777"
        var ACK_CODE_778 = "ACK0778"
        var ACK_CODE_779 = "ACK0779"
        var ACK_CODE_780 = "ACK0780"
        var ACK_CODE_781 = "ACK0781"
        var ACK_CODE_782 = "ACK0782"
        var ACK_CODE_783 = "ACK0783"
        var ACK_CODE_784 = "ACK0784"
        var ACK_CODE_785 = "ACK0785"
        var ACK_CODE_786 = "ACK0786"
        var ACK_CODE_787 = "ACK0787"
        var ACK_CODE_788 = "ACK0788" //for ShutDown Alert Add

        var ACK_CODE_789 = "ACK0789"
        var ACK_CODE_790 = "ACK0790"
        var ACK_CODE_791 = "ACK0791"
        var ACK_CODE_792 = "ACK0792"
        var ACK_CODE_793 = "ACK0793"
        var ACK_CODE_794 = "ACK0794"
        var ACK_CODE_795 = "ACK0795"
        var ACK_CODE_796 = "ACK0796"
        var ACK_CODE_797 = "ACK0797"
        var ACK_CODE_798 = "ACK0798" //AntiACK for ShutDown Alert Removal

        var ACK_CODE_799 = "ACK0799"
        var ACK_CODE_800 = "ACK0800"
        var ACK_CODE_801 = "ACK0801"
        var ACK_CODE_802 = "ACK0802"
        var ACK_CODE_803 = "ACK0803"

        var ACK_CODE_804 = "ACK0804"
        var ACK_CODE_805 = "ACK0805"
        var ACK_CODE_806 = "ACK0806"
        var ACK_CODE_807 = "ACK0807"
        var ACK_CODE_809 = "ACK0809"

        var ACK_CODE_810 = "ACK0810"
        var ACK_CODE_811 = "ACK0811"
        var ACK_CODE_812 = "ACK0812"
        var ACK_CODE_813 = "ACK0813"
        var ACK_CODE_814 = "ACK0814"
        var ACK_CODE_815 = "ACK0815"
        var ACK_CODE_816 = "ACK0816"
        var ACK_CODE_817 = "ACK0817"
        var ACK_CODE_819 = "ACK0819"
        var ACK_CODE_821 = "ACK0821"
        var ACK_CODE_822 = "ACK0822"
        var ACK_CODE_823 = "ACK0823"

        var ACK_CODE_831 = "ACK0831"
        var ACK_CODE_832 = "ACK0832"

        const val INFORM_HANDSHAKE = "HS"
        const val PREFIX_HANDSHAKE_CALIBRATE = "CALIB"
        const val HANDSHAKE_CALIBRATE_LENGTH = 5


        const val PREFIX_ACK = "ACK"
        const val SUFFIX_ACK = "}"
        const val ACK_CODE_LENGTH = 4

        const val VENTILATOR_HANDSHAKE_CALIBRATION = "vent_handshake_calibrated"


        const val lbl_weight = "Weight"
        const val lbl_height = "Height"
        const val lbl_age = "Age"

        const val step_total_flow = 1.0
        const val step_set_flow = 1.0
        const val step_flow = 1.0
        const val step_n2o = 1.0
        const val step_time = 1
        const val step_maximum = 1
        const val step_rate_of_increase = 1
        const val step_tinsp = 1.0
        const val step_ptrigger = 1.0

        const val Mode_ContinuousSedation = 11
        const val Mode_OnDemand = 12
        const val Mode_IntelliAuto = 13
    }


}