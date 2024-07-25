package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.controlSettingFragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.agvahealthcare.ventilator_ext.Sedation_App.Companion.isFromStandBy
import com.agvahealthcare.ventilator_ext.databinding.FragmentBasicBinding
import com.agvahealthcare.ventilator_ext.presentation.adapters.*
import com.agvahealthcare.ventilator_ext.presentation.ui.activities.MainActivity
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnKnobPressListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnLimitChangeListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTileSelectListener
import com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_MODES
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.getControlTilesViaPreferences
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.getControlTilesViaTempPreferences
import com.agvahealthcare.ventilator_ext.presentation.utils.KnobClass
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */

@AndroidEntryPoint
class BasicFragment : Fragment(), OnTileSelectListener, OnKnobPressListener, OnLimitChangeListener,
    DialogCloseListener {

    private var _binding: FragmentBasicBinding? = null
    private val binding get() = _binding!!
    private var adapter : ControlParamsAdapter? = null
    private var dataList = ArrayList<Tile_Model_Class>()
    private var mode = -1
    private var preferenceManager: PreferenceManager? = null
    private var knobClass: KnobClass? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBasicBinding.inflate(layoutInflater, container, false)

        preferenceManager = PreferenceManager(requireContext())
        knobClass = KnobClass(this,this,this)

        arguments?.getInt(VENTILATOR_MODES)?.let {
            mode = it
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataList = getControlTilesViaPreferences(requireContext(),preferenceManager,mode).first

        setupAdapter()
    }

    fun updateKnobData(value :String){
        knobClass?.updateWithTimeoutDebounce(value)
    }

    private fun setupAdapter() {

        adapter = ControlParamsAdapter(requireContext(),dataList, mode,this, Constants.Companion.AllControlType.Basic)
        binding.recyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.recyclerView.adapter = adapter
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

        if (!isFromStandBy){
            preferenceManager?.updatePreferencesOfTiles(label,newValue)
            try {
                (requireActivity() as MainActivity).sendConfigurationToVentilatorWithWatchDog()
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        else preferenceManager?.updateTempPreferenceOfTiles(label,newValue)
        onHandleDialogClose()
    }

    override fun onKnobPress(label: String, newValue: Int) {

        if (!isFromStandBy){
            preferenceManager?.updatePreferencesOfTiles(label,newValue)
            try {
                (requireActivity() as MainActivity).sendConfigurationToVentilatorWithWatchDog()
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        else  preferenceManager?.updateTempPreferenceOfTiles(label,newValue)
        onHandleDialogClose()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun notifyAdapter(){
        adapter?.notifyDataSetChanged()
    }

    override fun onHandleDialogClose() {
        adapter?.selectedTile = -1
        dataList = if (!isFromStandBy) getControlTilesViaPreferences(requireContext(),preferenceManager,mode).first
        else getControlTilesViaTempPreferences(requireContext(),preferenceManager,mode).first
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