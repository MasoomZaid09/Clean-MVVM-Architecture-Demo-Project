package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.controlSettingFragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.agvahealthcare.ventilator_ext.Sedation_App
import com.agvahealthcare.ventilator_ext.databinding.FragmentAdvancedBinding
import com.agvahealthcare.ventilator_ext.presentation.adapters.*
import com.agvahealthcare.ventilator_ext.presentation.ui.activities.MainActivity
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnKnobPressListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitChangeListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTileSelectListener
import com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants
import com.agvahealthcare.ventilator_ext.presentation.utils.KnobClass
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */

@AndroidEntryPoint
class AdvancedFragment : Fragment(), OnTileSelectListener, OnKnobPressListener,
    OnLimitChangeListener, DialogCloseListener {

    private var _binding: FragmentAdvancedBinding? = null
    private val binding get() = _binding!!
    private var adapter: ControlParamsAdapter? = null
    private var mode = -1
    private var dataList = ArrayList<Tile_Model_Class>()
    private var preferenceManager : PreferenceManager? = null
    private var knobClass: KnobClass? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdvancedBinding.inflate(layoutInflater, container, false)

        preferenceManager = PreferenceManager(requireContext())
        knobClass = KnobClass(this,this,this)

        arguments?.getInt(Constants.VENTILATOR_MODES)?.let {
            mode = it
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataList = Constants.getControlTilesViaPreferences(
            requireContext(),
            preferenceManager,
            mode
        ).second.first
        setupAdapter()
    }


    private fun setupAdapter() {
        adapter = ControlParamsAdapter(requireContext(),dataList, mode,this,Constants.Companion.AllControlType.Advanced)
        binding.recyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.recyclerView.adapter = adapter
    }

    fun updateKnobData(value :String){
        knobClass?.updateWithTimeoutDebounce(value)
    }

    override fun onTileSelect(data: Tile_Model_Class) {

        if (data.label == Constants.lbl_target_pressure){
            knobClass?.getAllParams(data,Constants.Companion.KnobSelectedType.TargetPressureType)
        }else{
            knobClass?.getAllParams(data,Constants.Companion.KnobSelectedType.tileType)
        }
        notifyAdapter()
    }



    override fun onKnobPress(label: String, newValue: Float) {

        if (!Sedation_App.isFromStandBy){
            preferenceManager?.updatePreferencesOfTiles(label,newValue.toInt())
            try {
                (requireActivity() as MainActivity).sendConfigurationToVentilatorWithWatchDog()
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        else  preferenceManager?.updateTempPreferenceOfTiles(label,newValue.toInt())


        onHandleDialogClose()
    }

    override fun onKnobPress(label: String, newValue: Int) {

        if (!Sedation_App.isFromStandBy){
            preferenceManager?.updatePreferencesOfTiles(label,newValue.toInt())
            try {
                (requireActivity() as MainActivity).sendConfigurationToVentilatorWithWatchDog()
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        else  preferenceManager?.updateTempPreferenceOfTiles(label,newValue.toInt())


        onHandleDialogClose()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun notifyAdapter(){
        adapter?.notifyDataSetChanged()
    }

    override fun onHandleDialogClose() {
        adapter?.selectedTile = -1
        dataList = if (!Sedation_App.isFromStandBy) Constants.getControlTilesViaPreferences(
            requireContext(),
            preferenceManager,
            mode
        ).second.first
        else Constants.getControlTilesViaTempPreferences(requireContext(), preferenceManager, mode).second.first

        adapter?.updateAdapter(dataList)
    }

    override fun onLimitChange(type: Constants.Companion.KnobSelectedType,label: String, newValue: Int) {
        when(type){
            Constants.Companion.KnobSelectedType.tileType -> {
                dataList.forEach { item ->
                    item.apply {
                        if(this.label == label) item.value = newValue.toString()
                    }
                }
            }
            else -> {}
        }

        adapter?.updateAdapter(dataList)
    }

    override fun onLimitChange(type: Constants.Companion.KnobSelectedType,label: String, newValue: Float) {
        when(type){
            Constants.Companion.KnobSelectedType.TargetPressureType -> {
                dataList.forEach { item ->
                    item.apply {
                        if(this.label == label) item.value = String.format("%.1f",newValue)
                    }
                }
            }
            else -> {}
        }
        adapter?.updateAdapter(dataList)
    }


}