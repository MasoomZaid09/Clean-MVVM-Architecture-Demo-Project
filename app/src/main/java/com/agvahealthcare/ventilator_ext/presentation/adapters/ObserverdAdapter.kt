package com.agvahealthcare.ventilator_ext.presentation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.presentation.ui.models.ObservedModelClass
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_fio2
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_flow
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_paw
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_target_pressure
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager

/* Created Masoom Zaid 1 Dec 2023*/

class ObserverdAdapter(
    private var context: Context,
    private var dataList: ArrayList<ObservedModelClass>,
    private var preferenceManager: PreferenceManager?
) : RecyclerView.Adapter<ObserverdAdapter.InfoViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(newList: ArrayList<ObservedModelClass>) {
        dataList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.observed_single_layout, parent, false)
        return InfoViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        val data = dataList[position]

        holder.apply {
            txtLabel?.text = data.label
            txtUnit?.text = data.unit
            txtValue?.text = data.value
        }

        holder.apply {

            if (giveConditionOfColoring(
                    data.label,
                    data.value
                )
            ) {
                mainLayout?.setBackgroundResource(R.drawable.red_box_drawables)
                txtLabel?.setTextColor(context.resources.getColor(R.color.white))
                txtUnit?.setTextColor(context.resources.getColor(R.color.white))
            }
            else  {
                mainLayout?.setBackgroundResource(R.drawable.black_box_drawable)
                txtLabel?.setTextColor(context.resources.getColor(R.color.grey_label))
                txtUnit?.setTextColor(context.resources.getColor(R.color.grey_label))

            }
        }
    }


    private fun giveConditionOfColoring(
        label: String,
        actualValue: String
    ): Boolean {
        preferenceManager?.apply {
            if (actualValue != "-") {
                when (label) {
                    lbl_flow -> return actualValue.toInt() < 0
                    lbl_paw -> return actualValue.toFloat() < getPrefPAWLowerLimits()!!.toFloat() || actualValue.toFloat() > getPrefPAWUpperLimits()!!.toFloat()
                    lbl_fio2 -> return actualValue.toInt() < getPrefFio2LowerLimits()!!.toInt() || actualValue.toInt() > getPrefFio2UpperLimits()!!.toInt()
                }
            }
        }
        return false
    }

    override fun getItemCount() = dataList.size


    class InfoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var txtUnit: TextView? = null
        var txtLabel: TextView? = null
        var txtValue: TextView? = null
        var mainLayout: ConstraintLayout? = null

        init {
            txtUnit = view.findViewById(R.id.txtUnit)
            txtLabel = view.findViewById(R.id.txtTitle)
            txtValue = view.findViewById(R.id.txtValue)
            mainLayout = view.findViewById(R.id.mainLayout)
        }

    }
}