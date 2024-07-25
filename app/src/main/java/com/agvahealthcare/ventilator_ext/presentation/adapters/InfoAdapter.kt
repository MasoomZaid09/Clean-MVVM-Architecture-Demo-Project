package com.agvahealthcare.ventilator_ext.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.agvahealthcare.ventilator_ext.R

/* Created Masoom Zaid 1 Dec 2023*/

class InfoAdapter(
    private var context: Context,
    private var infoList: ArrayList<String>,
    private var isO2Failure: Boolean
) : RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.info_item_layout, parent, false)
        return InfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {

        if (isO2Failure){
            holder.txtInfoText?.setTextColor(context.resources.getColor(R.color.black))
        }else{
            holder.txtInfoText?.setTextColor(context.resources.getColor(R.color.black))

        }

        holder.apply {
            txtInfoText?.text = infoList[position]
        }
    }

    override fun getItemCount() = infoList.size


    class InfoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            var txtInfoText: TextView? = null
            init {
                txtInfoText = view.findViewById(R.id.txtInfoText)
            }

    }
}