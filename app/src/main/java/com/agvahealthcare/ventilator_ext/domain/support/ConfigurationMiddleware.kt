package com.agvahealthcare.ventilator_ext.domain.support

class ConfigurationArrayList : ArrayList<String?>() {

    override fun toString(): String {
        val sb = StringBuilder()
        var count = 0
        for (s in this) {
            sb.append(s)
            if (count < size - 1) sb.append(",")
            count++
        }
        return sb.toString()
    }
}