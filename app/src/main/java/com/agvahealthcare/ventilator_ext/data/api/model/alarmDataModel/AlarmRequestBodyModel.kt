package com.agvahealthcare.ventilator_ext.data.api.model.alarmDataModel

import com.google.gson.annotations.SerializedName


data class AlarmRequestBodyModel (
    @SerializedName("did"  ) var did  : String?        = null,
    @SerializedName("type" ) var type : String?        = null,
    @SerializedName("ack"  ) var ack  : ArrayList<Ack> = arrayListOf(),
    @SerializedName("priority"      ) var priority      : String? = null

)