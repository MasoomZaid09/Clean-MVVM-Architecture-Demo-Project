package com.agvahealthcare.ventilator_ext.presentation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTileSelectListener
import com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants

/* Created Masoom Zaid 1 Dec 2023*/

class ControlParamsAdapter(
    private var context: Context,
    private var dataList: ArrayList<Tile_Model_Class>,
    private var mode: Int,
    private var onTileSelectListener: OnTileSelectListener,
    private var type: Constants.Companion.AllControlType
) : RecyclerView.Adapter<ControlParamsAdapter.ControlParamsViewHolder>() {

    var selectedTile = -1

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(newList : ArrayList<Tile_Model_Class>){
        dataList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ControlParamsViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.control_paras_item_layout, parent, false)
        return ControlParamsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ControlParamsViewHolder, position: Int) {

        val data = dataList[position]

        holder.apply {
            txtLabel?.text = data.label
            txtUnit?.text = data.unit
            txtValue?.text = data.value

            progressBar?.setCurrentProgress(getPercentage(data))

            if (selectedTile == position) {
                progressBar?.background =
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.progresscircle_with_selection_yellow
                    )
                txtValue?.setTextColor(context.resources.getColor(R.color.black))
            } else {
                progressBar?.background =
                    ContextCompat.getDrawable(context, R.drawable.progresscircle)
                txtValue?.setTextColor(context.resources.getColor(R.color.black))
            }

            mainLayoutPanel?.setOnClickListener {
                selectedTile = position
                onTileSelectListener.onTileSelect(data)
            }
        }

    }

    private fun getPercentage(value: Double, min: Double, max: Double): Double {
        return (((value - min) / (max - min)) * 100)
    }

    private fun getPercentage(param: Tile_Model_Class): Double {
        return try {
            var percentage = getPercentage(param.value.toDouble(), param.lowerlimit.toDouble(), param.upperLimit.toDouble());
            if (percentage < 0.0) 0.0
            else percentage
        } catch (e: Exception) {
            0.0
        }
    }

    override fun getItemCount() = dataList.size


    class ControlParamsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtLabel: TextView? = null
        var txtUnit: TextView? = null
        var txtValue: TextView? = null
        var mainLayoutPanel: ConstraintLayout? = null
        var progressBar: CircularProgressIndicator? = null

        init {
            txtLabel = view.findViewById(R.id.txtLabel)
            txtUnit = view.findViewById(R.id.txtUnit)
            txtValue = view.findViewById(R.id.txtValue)
            mainLayoutPanel = view.findViewById(R.id.mainLayoutPanel)
            progressBar = view.findViewById(R.id.param_progress_bar)
        }
    }
}