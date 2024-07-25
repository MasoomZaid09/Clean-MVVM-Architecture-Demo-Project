package com.agvahealthcare.ventilator_ext.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.agvahealthcare.ventilator_ext.R

/* Created Masoom Zaid 1 Dec 2023*/

class RecentPatientAdapter(private var context: Context) : RecyclerView.Adapter<RecentPatientAdapter.RecentPatientViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentPatientViewHolder {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.recent_patient_item_layout, parent, false)
        return RecentPatientViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecentPatientViewHolder, position: Int) {

        if (position % 2 == 0){
            holder.layout?.setBackgroundColor(context.getColor(R.color.light_grey_background_second))
        }else{
            holder.layout?.setBackgroundColor(context.getColor(R.color.light_grey_background))
        }

    }

    override fun getItemCount() = 14


    class RecentPatientViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            var layout: ConstraintLayout? = null


            init {
                layout = view.findViewById(R.id.layout)
            }

    }
}