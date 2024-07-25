package com.agvahealthcare.ventilator_ext.presentation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.FIRST_FILTER_NAME
import java.util.Collections


class EventAdapter( private var dataList: ArrayList<String>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    var selectedIndex: Int = 0

    fun updateDataList(newList : ArrayList<String>){
        dataList = newList
        notifyDataSetChanged()
    }

    fun updateIndex(){
        selectedIndex = dataList.size - 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event_data, parent, false)
        return EventViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        if (dataList.isNotEmpty()){
            val data = dataList[position]

            if ((position) == selectedIndex){
                holder.parentLayout?.setBackgroundResource(R.color.ack_green)
                holder.tvDateTime?.setTextColor(Color.WHITE)
                holder.tvEventData?.setTextColor(Color.WHITE)
                holder.tvTime?.setTextColor(Color.WHITE)
                holder.textViewUHID?.setTextColor(Color.WHITE)
            }
            else{
                if ((position) % 2 == 0){
                    holder.parentLayout?.setBackgroundColor(Color.parseColor("#FFFFFF"))
                    holder.tvDateTime?.setTextColor(Color.BLACK)
                    holder.tvEventData?.setTextColor(Color.BLACK)
                    holder.tvTime?.setTextColor(Color.BLACK)
                    holder.textViewUHID?.setTextColor(Color.BLACK)
                } else {
                    holder.parentLayout?.setBackgroundColor(Color.parseColor("#eeeeee"))
                    holder.tvDateTime?.setTextColor(Color.BLACK)
                    holder.tvEventData?.setTextColor(Color.BLACK)
                    holder.tvTime?.setTextColor(Color.BLACK)
                    holder.textViewUHID?.setTextColor(Color.BLACK)
                }
            }

            if (data.split(",")[0].isNotEmpty()){
                holder.tvDateTime?.text = data.split(",")[0].split("\\s".toRegex())[0]
                holder.tvTime?.text = data.split(",")[0].split("\\s".toRegex())[1]
            }
            //holder.tvDateTime?.text = data.timeStamp
            holder.tvEventData?.text = data.split(",")[1]
            if (data.split(",")[2]== FIRST_FILTER_NAME){
                holder.textViewUHID?.text="-"
            } else{
                holder.textViewUHID?.text=data.split(",")[2]
            }
        }
        if (dataList.isEmpty()){
            holder.tvEventData?.text="There are no events yet generated"
        }
    }

    override fun getItemCount(): Int {
        return dataList.size - 1
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setSelection(pos: Int){
        if(pos in 0 until itemCount) {
            selectedIndex = pos
            notifyDataSetChanged()
        }
    }

    fun getSelection() = selectedIndex

    fun setSelectionDownward() = setSelection(selectedIndex + 1)
    fun setSelectionUpword() = setSelection(selectedIndex - 1)

    class EventViewHolder (view: View) : RecyclerView.ViewHolder(view){

        var tvDateTime: TextView? = null
        var tvEventData: TextView? = null
        var tvTime: TextView?=null
        var parentLayout : LinearLayoutCompat? = null
        var textViewUHID: TextView?=null
        init {
            tvDateTime = view.findViewById(R.id.textViewDateTime)
            tvEventData = view.findViewById(R.id.textViewEventsData)
            parentLayout = view.findViewById(R.id.layoutid)
            tvTime=view.findViewById(R.id.textViewTime)
            textViewUHID=view.findViewById(R.id.textViewUHID)
        }
    }
}