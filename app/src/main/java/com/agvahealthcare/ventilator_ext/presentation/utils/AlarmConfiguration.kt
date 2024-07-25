package com.agvahealthcare.ventilator_ext.utility.utils

import android.net.Uri
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants

class AlarmConfiguration {
    companion object{

        private val cycleCheckedAcks = listOf<String>(

        )

      /*  @Deprecated("Deprecated medium level alarm list")
        var mediumLevelAck = listOf(
            Configs.ACK_CODE_12,
            Configs.ACK_CODE_13,
            Configs.ACK_CODE_16,
            Configs.ACK_CODE_17,
            Configs.ACK_CODE_18,
            Configs.ACK_CODE_19,
            Configs.ACK_CODE_30
        )

        @Deprecated("Deprecated low level alarm list")
        private var lowLevelAck = listOf(

            Configs.ACK_CODE_10,
            Configs.ACK_CODE_11,
            Configs.ACK_CODE_14,
            Configs.ACK_CODE_15,
            Configs.ACK_CODE_35,
            Configs.ACK_CODE_50,
            Configs.ACK_CODE_62,
            Configs.ACK_CODE_68,
            Configs.ACK_CODE_80,
        )

        @Deprecated("Deprecated high level alarm list")
        var highLevelAck = listOf<String>()

        @Deprecated("Deprecated critical level alarm list")
        var criticalLevelAck = listOf(
            Configs.ACK_CODE_0,
            Configs.ACK_CODE_5,
        )*/

        private val controlLimitAlarms= listOf(
            Constants.ALARM_Flow,
            Constants.ALARM_Fio2,
            Constants.ALARM_Paw,

            )

        private val lowLimitAlarms = listOf(
            Constants.lbl_averarge_leak
        )


        private fun isAckValid(ack: String) = ack.startsWith(Constants.PREFIX_ACK)
                && ack.replace(Constants.PREFIX_ACK, "").toIntOrNull()?.let { it in 0..6000 } == true

        @JvmStatic
        fun getColor(alarm: String): Int{
            if(alarm.startsWith(Constants.PREFIX_ACK)) {
                alarm.replace(Constants.PREFIX_ACK, "").toIntOrNull()?.let {
                    return when (it) {
                        in 0..320 -> {
                            R.color.preCalib_amber
                        }
                        in 320..640 -> {
                            R.color.preCalib_amber
                        }
                        in 640..960 -> {
                            R.color.ack_red
                        }
                        else -> R.color.ack_red
                    }

                }

            } else{
                if(alarm in controlLimitAlarms) return  R.color.black
            }

            return R.color.black
        }


        @JvmStatic
        fun getPriority(alarm:String): Constants.Companion.AlarmType{

            if(alarm.startsWith(Constants.PREFIX_ACK)) {
                 alarm.replace(Constants.PREFIX_ACK, "").toIntOrNull()?.let {
                     return when (it) {
                        786 -> Constants.Companion.AlarmType.ALARM_CRITICAL_LEVEL
                         821 -> Constants.Companion.AlarmType.ALARM_CRITICAL_LEVEL
                        in 0..320 -> {
                            Constants.Companion.AlarmType.ALARM_LOW_LEVEL
                        }
                        in 320..640 -> {
                            Constants.Companion.AlarmType.ALARM_MEDIUM_LEVEL
                        }
                        in 640..960  -> {
                            Constants.Companion.AlarmType.ALARM_HIGH_LEVEL
                        }

                        else -> Constants.Companion.AlarmType.ALARM_NO_LEVEL
                    }
               /*      if(it.equals(786)) {
                         Configs.AlarmType.ALARM_CRITICAL_LEVEL
                 }*/
                }

            }else if(alarm in lowLimitAlarms){
                return Constants.Companion.AlarmType.ALARM_LOW_LEVEL
            }
            else {
                if(alarm in controlLimitAlarms) return Constants.Companion.AlarmType.ALARM_MEDIUM_LEVEL
            }


            return Constants.Companion.AlarmType.ALARM_NO_LEVEL
        }




        @JvmStatic
        fun getAckType(ack: String): Constants.Companion.AckType {
            return ack.takeIf { isAckValid(it) }?.replace(Constants.PREFIX_ACK, "")?.toIntOrNull()?.let {
                   return if (it < 5000){
                       val tensDigit = (it %  100) / 10
                       if(tensDigit % 2 == 0)  Constants.Companion.AckType.ACK
                       else Constants.Companion.AckType.NACK
                   } else Constants.Companion.AckType.OP_ACK
                } ?: Constants.Companion.AckType.INVALID_ACK
        }

        @JvmStatic
        fun getAckFor(ack: String): String?{
            val mainAck=ack.substring(0,ack.length-2)+ack[ack.length-2].minus(1)+ack[ack.length-1]
            return mainAck
        }

        @JvmStatic
        fun getNackFor(ack: String): String?{
            return ack.replace(Constants.PREFIX_ACK, "").toIntOrNull()?.let {
                Constants.PREFIX_ACK + (it + 10)
            }
        }



        @JvmStatic
        fun getAlarmUri(priority: Constants.Companion.AlarmType): Int? {
            return when (priority) {

                Constants.Companion.AlarmType.ALARM_NO_LEVEL -> null
                Constants.Companion.AlarmType.ALARM_LOW_LEVEL -> 0
                Constants.Companion.AlarmType.ALARM_MEDIUM_LEVEL -> 1
                Constants.Companion.AlarmType.ALARM_HIGH_LEVEL -> 1
                else -> null
            }
        }


        @JvmStatic
        fun isCycleCheckRequired(ack: String) = cycleCheckedAcks.contains(ack)
    }
}
