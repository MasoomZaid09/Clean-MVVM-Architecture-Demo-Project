package com.agvahealthcare.ventilator_ext.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnMenuChangeListener

/* Created Masoom Zaid 1 Dec 2023*/

class MenuAdapter(private var context: Context,private var items : ArrayList<String>,private var click : OnMenuChangeListener) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    var selectedIndex = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.menu_options_item_layout, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {

        if (selectedIndex == position){
            holder.layout?.setBackgroundResource(R.drawable.racing_green_box_drawables)
            holder.txtLabel?.setTextColor(context.resources.getColor(R.color.white))
        }else{
            holder.layout?.setBackgroundResource(R.drawable.dolphin_grey_box_drawables)
            holder.txtLabel?.setTextColor(context.resources.getColor(R.color.black))
        }

        holder.txtLabel?.text = items[position]

        holder.layout?.setOnClickListener {
            click.onMenuChange(position)
        }
    }

    override fun getItemCount() = items.size


    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            var layout: ConstraintLayout? = null
            var txtLabel: TextView? = null


            init {
                layout = view.findViewById(R.id.layout)
                txtLabel = view.findViewById(R.id.txtLabel)
            }

    }
}