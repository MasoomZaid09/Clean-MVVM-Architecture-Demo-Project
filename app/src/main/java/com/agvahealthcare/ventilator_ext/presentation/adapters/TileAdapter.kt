package com.agvahealthcare.ventilator_ext.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitSelectListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTileSelectListener
import com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class

/* Created Masoom Zaid 20 April 2023*/

class TileAdapter(private var dataList : ArrayList<Tile_Model_Class>,private var context: Context,var onTileSelectListener: OnTileSelectListener,var onLimitSelectListener: OnLimitSelectListener) : RecyclerView.Adapter<TileAdapter.TileParameterViewHolder>() {

    fun updateAdapter(newList : ArrayList<Tile_Model_Class>){
        dataList = newList
        notifyDataSetChanged()
    }

    var selectedTile = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TileParameterViewHolder {
        return when(viewType){
            R.layout.two_tile_design_layout -> {
                TileParameterViewHolder.TwoTileViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.two_tile_design_layout, parent, false))
            }
            R.layout.tile_design_layout -> {
                TileParameterViewHolder.FourTileViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.tile_design_layout, parent, false))
            }

            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: TileParameterViewHolder, position: Int) {

        when(holder){
            is TileParameterViewHolder.TwoTileViewHolder -> {
                val item = dataList[position]
                holder.apply {
                    txtTitle?.text = item.label
                    txtUnit?.text = item.unit
                    txtValue?.text = item.value

                    if (selectedTile == position){
                        tileLayout?.setBackgroundResource(R.drawable.white_box_drawables)
                        txtValue?.setTextColor(context.resources.getColor(R.color.black))
                    }
                    else{
                        tileLayout?.setBackgroundResource(R.drawable.black_box_drawable)
                        txtValue?.setTextColor(context.resources.getColor(R.color.white))
                    }

                    ccUpButtonLayout?.setOnClickListener {
                        onLimitSelectListener.onLimitSelect(true)
                    }
                    ccDownButtonLayout?.setOnClickListener {
                        onLimitSelectListener.onLimitSelect(false)
                    }


                    tileLayout?.setOnClickListener {
                        selectedTile = position
                        onTileSelectListener.onTileSelect(item)
                    }
                }
            }

            is TileParameterViewHolder.FourTileViewHolder -> {
                val item = dataList[position]
                holder.apply {
                    txtTitle?.text = item.label
                    txtUnit?.text = item.unit
                    txtValue?.text = item.value

                    if (selectedTile == position){
                        tileLayout?.setBackgroundResource(R.drawable.white_box_drawables)
                        txtValue?.setTextColor(context.resources.getColor(R.color.black))
                    }
                    else{
                        tileLayout?.setBackgroundResource(R.drawable.black_box_drawable)
                        txtValue?.setTextColor(context.resources.getColor(R.color.white))
                    }

                    tileLayout?.setOnClickListener {
                        selectedTile = position
                        onTileSelectListener.onTileSelect(item)
                    }

                    ccUpButtonLayout?.setOnClickListener {
                        onLimitSelectListener.onLimitSelect(true)
                    }
                    ccDownButtonLayout?.setOnClickListener {
                        onLimitSelectListener.onLimitSelect(false)
                    }
                }
            }
        }
    }

    override fun getItemCount() = dataList.size

    override fun getItemViewType(position: Int): Int {
        return when(dataList.size){
            2 -> R.layout.two_tile_design_layout
            3 -> R.layout.tile_design_layout
            else -> { 0 }
        }
    }

    sealed class TileParameterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        class TwoTileViewHolder(view: View) : TileParameterViewHolder(view){
            var ccUpButtonLayout: ConstraintLayout? = null
            var ccDownButtonLayout: ConstraintLayout? = null
            var txtTitle: TextView? = null
            var txtValue: TextView? = null
            var txtUnit: TextView? = null
            var tileLayout:ConstraintLayout?=null

            init {
                ccUpButtonLayout = view.findViewById(R.id.ccUpButtonLayout)
                ccDownButtonLayout = view.findViewById(R.id.ccDownButtonLayout)
                txtTitle = view.findViewById(R.id.txtTitle)
                txtValue = view.findViewById(R.id.txtValue)
                txtUnit = view.findViewById(R.id.txtUnit)
                tileLayout=view.findViewById(R.id.valueBodyClick)
            }

        }

        class FourTileViewHolder(view: View) : TileParameterViewHolder(view){
            var ccUpButtonLayout: ConstraintLayout? = null
            var ccDownButtonLayout: ConstraintLayout? = null
            var txtTitle: TextView? = null
            var txtValue: TextView? = null
            var txtUnit: TextView? = null
            var tileLayout:ConstraintLayout?=null

            init {
                ccUpButtonLayout = view.findViewById(R.id.ccUpButtonLayout)
                ccDownButtonLayout = view.findViewById(R.id.ccDownButtonLayout)
                txtTitle = view.findViewById(R.id.txtTitle)
                txtValue = view.findViewById(R.id.txtValue)
                txtUnit = view.findViewById(R.id.txtUnit)
                tileLayout=view.findViewById(R.id.valueBodyClick)

            }

        }

    }
}