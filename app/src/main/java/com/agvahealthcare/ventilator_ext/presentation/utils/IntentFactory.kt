package com.agvahealthcare.ventilator_ext.presentation.utils

/**
 * Created by MOHIT MALHOTRA on 24-10-2018.
 */
interface IntentFactory {
    companion object {
        const val ACTION_USB_PERMISSION_VENTILATOR =
            "com.agvahealthcare.ventilator_ext.ACTION_USB_PERMISSION_VENTILATOR"
        const val ACTION_GRAPH_LIMIT_CHANGE =
            "com.agvahealthcare.ventilator_ext.ACTION_GRAPH_LIMIT_CHANGE"
        const val ACTION_HARDWARE_SERIAL_NUMBER =
            "com.agvahealthcare.ventilator_ext.ACTION_HARDWARE_SERIAL_NUMBER"
        const val ACTION_USB_PERMISSION_HID =
            "com.agvahealthcare.ventilator_ext.ACTION_USB_PERMISSION_HID"
        const val ACTION_DEVICE_CONNECTED =
            "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_CONNECTED"
        const val ACTION_TESTING =
            "com.agvahealthcare.ventilator_ext.ACTION_TESTING"
        const val ACTION_DEVICE_FAST_CONNECTED =
            "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_CONNECTED"
        const val ACTION_DEVICE_DISCONNECTED =
            "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_DISCONNECTED"
        const val ACTION_BT_DEVICE_FOUND =
            "com.agvahealthcare.ventilator_ext.ACTION_BT_DEVICE_FOUND"
        const val ACTION_BT_DEVICE_NOT_FOUND =
            "com.agvahealthcare.ventilator_ext.ACTION_BT_DEVICE_NOT_FOUND"
        const val ACTION_GATT_SERVICES_DISCOVERED =
            "com.agvahealthcare.ventilator_ext.ACTION_GATT_SERVICES_DISCOVERED"
        const val ACTION_DATA_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_DATA_AVAILABLE"
        const val ACTION_RAW_DATA_AVAILABLE =
            "com.agvahealthcare.ventilator_ext.ACTION_RAW_DATA_AVAILABLE"
        const val ACTION_SOFTWARE_VERSION_AVAILABLE =
            "com.agvahealthcare.ventilator_ext.ACTION_SOFTWARE_VERSION_AVAILABLE"
        const val ACTION_VENTILATOR_WIFI_CONNECTION_REQUESTED =
            "com.agvahealthcare.ventilator_ext.ACTION_VENTILATOR_WIFI_CONNECTION_REQUESTED"
        const val ACTION_VENTILATOR_WIFI_CONNECTION_RESPONSED =
            "com.agvahealthcare.ventilator_ext.ACTION_VENTILATOR_WIFI_CONNECTION_RESPONSED"
        const val ACTION_ACK_AVAILABLE = "com.agvahealthcare.ventilator_ext.ACTION_ACK_AVAILABLE"
        const val ACTION_BATTERY_STATUS_AVAILABLE =
            "com.agvahealthcare.ventilator_ext.ACTION_BATTERY_STATUS_AVAILABLE"
        const val ACTION_THERAPY_END_AVAILABLE =
            "com.agvahealthcare.ventilator_ext.ACTION_THERAPY_END_AVAILABLE"
        const val ACTION_MOTOR_LIFE_STATUS_AVAILABLE =
            "com.agvahealthcare.ventilator_ext.ACTION_MOTOR_LIFE_STATUS_AVAILABLE"
        const val ACTION_HEATSENSE_STATUS_AVAILABLE =
            "com.agvahealthcare.ventilator_ext.ACTION_HEATSENSE_STATUS_AVAILABLE"

        //intent for the calibration error
        const val ACTION_CALIBRATION_ERROR_DATA =
            "com.agvahealthcare.ventilator_ext.ACTION_CALIBRATION_ERROR_DATA"
        const val ACTION_HANDSHAKE_CALIBRATION_AVAILABLE =
            "com.agvahealthcare.ventilator_ext.ACTION_HANDSHAKE_CALIBRATION_AVAILABLE"
        const val ACTION_SENSOR_AVAILABILITY_RESPONSE =
            "com.agvahealthcare.ventilator_ext.ACTION_SENSOR_AVAILABILITY_RESPONSE"
        const val ACTION_SENSOR_CALIBRATION_RESPONSE =
            "com.agvahealthcare.ventilator_ext.ACTION_SENSOR_CALIBRATION_RESPONSE"
        const val ACTION_STANDBY_STATUS_AVAILABLE =
            "com.agvahealthcare.ventilator_ext.ACTION_STANDBY_STATUS_AVAILABLE"
        const val ACTION_SELF_TEST_STATUS_AVAILABLE =
            "com.agvahealthcare.ventilator_ext.ACTION_SELF_TEST_STATUS_AVAILABLE"
        const val ACTION_DEVICE_NAME_REQUESTED =
            "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_NAME_REQUESTED"
        const val ACTION_DEVICE_NAME_RESPONSED =
            "com.agvahealthcare.ventilator_ext.ACTION_DEVICE_NAME_RESPONSED"
        const val ACTION_DATA_SENT = "com.agvahealthcare.ventilator_ext.ACTION_DATA_SENT"
        const val ACTION_HANDSHAKE_COMPLETED =
            "com.agvahealthcare.ventilator_ext.ACTION_HANDSHAKE_COMPLETED"
        const val ACTION_HANDSHAKE_TIMEOUT =
            "com.agvahealthcare.ventilator_ext.ACTION_HANDSHAKE_TIMEOUT"
        const val ACTION_TUBE_BLOCKAGE_DETECTED =
            "com.agvahealthcare.ventilator_ext.ACTION_TUBE_BLOCKAGE_DETECTED"
        const val ACTION_TUBE_BLOCKAGE_RESOLVED =
            "com.agvahealthcare.ventilator_ext.ACTION_TUBE_BLOCKAGE_RESOLVED"
        const val ACTION_HIGH_LEAK_INACCURACY_DETECTED =
            "com.agvahealthcare.ventilator_ext.ACTION_HIGH_LEAK_INACCURACY_DETECTED"
        const val ACTION_HIGH_LEAK_INACCURACY_RESOLVED =
            "com.agvahealthcare.ventilator_ext.ACTION_HIGH_LEAK_INACCURACY_RESOLVED"
        const val ACTION_LEAK_BASED_ALARM_DETECTED =
            "com.agvahealthcare.ventilator_ext.ACTION_LEAK_BASED_ALARM_DETECTED"
        const val ACTION_LEAK_BASED_ALARM_RESOLVED =
            "com.agvahealthcare.ventilator_ext.ACTION_LEAK_BASED_ALARM_RESOLVED"
        const val ACTION_CUFF_LEAKAGE_DETECTED =
            "com.agvahealthcare.ventilator_ext.ACTION_CUFF_LEAKAGE_DETECTED"
        const val ACTION_CUFF_LEAKAGE_RESOLVED =
            "com.agvahealthcare.ventilator_ext.ACTION_CUFF_LEAKAGE_RESOLVED"

        //    String ACTION_FIO2_DISCONNECT_RESOLVED = "com.agvahealthcare.ventilator_ext.ACTION_FIO2_DISCONNECT_RESOLVED";
        const val ACTION_FLOW_SENSOR_OCCLUSION_DETECTED =
            "agvahealthcare.com.falcon.ACTION_FLOW_SENSOR_OCCLUSION_DETECTED"
        const val ACTION_FLOW_SENSOR_OCCLUSION_RESOLVED =
            "agvahealthcare.com.falcon.ACTION_FLOW_SENSOR_OCCLUSION_RESOLVED"
        const val ACTION_EXPIRE_TIME_OUT_OF_RANGE =
            "com.agvahealthcare.ventilator_ext.ACTION_EXPIRE_TIME_OUT_OF_RANGE"
        const val ACTION_EXPIRE_TIME_UNDER_RANGE =
            "com.agvahealthcare.ventilator_ext.ACTION_EXPIRE_TIME_UNDER_RANGE"
        const val ACTION_MENDOR_SYMLINKING_REQUEST =
            "com.agvahealthcare.ventilator_ext.ACTION_MENDOR_SYMLINKING_REQUEST"
        const val ACTION_MENDOR_SYMLINKING_STARTED =
            "com.agvahealthcare.ventilator_ext.ACTION_MENDOR_SYMLINKING_STARTED"
        const val ACTION_MENDOR_SYMLINKING_FAILED =
            "com.agvahealthcare.ventilator_ext.ACTION_MENDOR_SYMLINKING_FAILED"
        const val ACTION_MENDOR_SYMLINKING_COMPLETED =
            "com.agvahealthcare.ventilator_ext.ACTION_MENDOR_SYMLINKING_COMPLETED"

        //battery connected and disconnected
        const val ACTION_BATTERY_CONNECTED =
            "com.agvahealthcare.ventilator_ext.ACTION_BATTERY_CONNECTED"
        const val ACTION_BATTERY_DISCONNECTED =
            "com.agvahealthcare.ventilator_ext.ACTION_BATTERY_DISCONNECTED"
        const val ACTION_MODE_SET = "com.agvahealthcare.ventilator_ext.ACTION_MODE_SET"
        const val ACTION_MODE_TYPE = "com.agvahealthcare.ventilator_ext.ACTION_MODE_TYPE"
        const val ACTION_SUBMODE_SET = "com.agvahealthcare.ventilator_ext.ACTION_SUBMODE_SET"

        // VENTILATION LIMIT OVERFLOW ALERTS
        const val ACTION_VENT_PARAM_LIMIT_UNDERFLOW =
            "com.agvahealthcare.ventilator_ext.ACTION_LIMIT_UNDERFLOW"
        const val ACTION_VENT_PARAM_LIMIT_OVERFLOW =
            "com.agvahealthcare.ventilator_ext.ACTION_LIMIT_OVERFLOW"

        // LIMITING ALARM
        const val ACTION_LOW_O2 = "com.agvahealthcare.ventilator_ext.ACTION_LOW_O2"
        const val ACTION_INACTIVE = "com.agvahealthcare.ventilator_ext.ACTION_APP_INACTIVE"
        const val ACTION_SF_SHOW_FULL_SCREEN = "com.promobitech.intent.ADD_FULL_SCREEN"
        const val ACTION_SF_HIDE_FULL_SCREEN = "com.promobitech.intent.REMOVE_FULL_SCREEN"
        const val ACTION_ON_SYSTEM_KILL = "com.agvahealthcare.ventilator_ext.ACTION_ON_SYSTEM_KILL"
        const val ACTION_KNOB_CHANGE = "com.agvahealthcare.ventilator_ext.ACTION_KNOB_CHANGE"

        // Quick button hardware integration
        const val ACTION_MUTE_UNMUTE = "com.agvahealthcare.ventilator_ext.ACTION_MUTE_UNMUTE"
        const val ACTION_NEBULISER = "com.agvahealthcare.ventilator_ext.ACTION_NEBULISER"
        const val ACTION_OXYGEN_100 = "com.agvahealthcare.ventilator_ext.ACTION_OXYGEN"
        const val ACTION_INSPIRATORY_HOLD =
            "com.agvahealthcare.ventilator_ext.ACTION_INSPIRATORY_HOLD"
        const val ACTION_EXPIRATORY_HOLD =
            "com.agvahealthcare.ventilator_ext.ACTION_EXPIRATORY_HOLD"
        const val ACTION_MANUAL_BREATH = "com.agvahealthcare.ventilator_ext.ACTION_MANUAL_BREATH"
        const val ACTION_HOME = "com.agvahealthcare.ventilator_ext.ACTION_HOME"
        const val ACTION_LOCK = "com.agvahealthcare.ventilator_ext.ACTION_LOCK"
        const val ACTION_POWER_OFF = "com.agvahealthcare.ventilator_ext.ACTION_POWER_OFF"
        const val ACTION_POWER_ON = "com.agvahealthcare.ventilator_ext.ACTION_POWER_ON"
        const val ACTION_DOWNLOADED_ALREADY_LETS_INSTALL =
            "com.agvahealthcare.ventilator_ext.ACTION_DOWNLOADED_ALREADY_LETS_INSTALL"
        const val ACTION_NEO_SENSOR_CONNECT =
            "com.agvahealthcare.ventilator_ext.ACTION_NEO_SENSOR_CONNECT"
        const val ACTION_NEO_SENSOR_DISCONNECT =
            "com.agvahealthcare.ventilator_ext.ACTION_NEO_SENSOR_DISCONNECT"
        const val ACTION_RESISTANCE_CALIBRATION_RESPONSE =
            "com.agvahealthcare.ventilator_ext.ACTION_RESISTANCE_CALIBRATION_RESPONSE"
        const val ACTION_COMPLIANCE_CALIBRATION_RESPONSE =
            "com.agvahealthcare.ventilator_ext.ACTION_COMPLIANCE_CALIBRATION_RESPONSE"

        // created by masoom 04 jan 2023
        const val ACTION_HFNC_RESPONSE = "com.agvahealthcare.ventilator_ext.ACTION_HFNC_RESPONSE"
        const val ACTION_VENTILATOR_FAILURE_GENERATED =
            "com.agvahealthcare.ventilator_ext.ACTION_VENTILATOR_FAILURE_GENERATED"
        const val ACTION_VENTILATOR_FAILURE_REMOVED =
            "com.agvahealthcare.ventilator_ext.ACTION_VENTILATOR_FAILURE_REMOVED"

        // for diagnostic tool check
        const val ACTION_DIAGNOSTIC_TOOL_CHECK =
            "com.agvahealthcare.ventilator_ext.ACTION_DIAGNOSTIC_TOOL_CHECK"
        const val ACTION_O2_REGILATION_TOOL_CHECK =
            "com.agvahealthcare.ventilator_ext.ACTION_O2_REGILATION_TOOL_CHECK"
        const val ACTION_STARTUP_CHECK = "com.agvahealthcare.ventilator_ext.ACTION_STARTUP_CHECK"
    }
}