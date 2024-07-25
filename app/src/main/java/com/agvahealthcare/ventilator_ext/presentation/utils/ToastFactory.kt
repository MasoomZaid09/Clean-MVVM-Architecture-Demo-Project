package com.agvahealthcare.ventilator_ext.presentation.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by MASOOM ZAID on 23-04-2023.
 */

object ToastFactory {

    fun custom(context: Context?, msg: String?) {
        if (context != null) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }

}