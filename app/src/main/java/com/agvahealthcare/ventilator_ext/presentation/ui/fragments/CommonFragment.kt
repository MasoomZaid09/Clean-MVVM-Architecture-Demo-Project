package com.agvahealthcare.ventilator_ext.presentation.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.Sedation_App
import com.agvahealthcare.ventilator_ext.data.db.entities.EventDataModel
import com.agvahealthcare.ventilator_ext.databinding.FragmentCommonBinding
import com.agvahealthcare.ventilator_ext.domain.support.service.CommunicationService
import com.agvahealthcare.ventilator_ext.presentation.adapters.AlarmAdapter
import com.agvahealthcare.ventilator_ext.presentation.adapters.ObserverdAdapter
import com.agvahealthcare.ventilator_ext.presentation.adapters.TileAdapter
import com.agvahealthcare.ventilator_ext.presentation.ui.activities.MainActivity
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.charts.FlowChartFragment
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.charts.PressureChartFragment
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments.AlarmLimitsFragment
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.*
import com.agvahealthcare.ventilator_ext.presentation.ui.models.ObservedModelClass
import com.agvahealthcare.ventilator_ext.presentation.ui.models.Tile_Model_Class
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.Mode_IntelliAuto
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.Mode_OnDemand
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.PREFIX_MINUS
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.PREFIX_PLUS
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_N2O
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_fio2
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_flow
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_paw
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_target_pressure
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.lbl_total_flow
import com.agvahealthcare.ventilator_ext.presentation.utils.KnobClass
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager
import com.agvahealthcare.ventilator_ext.presentation.utils.ToastFactory
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.EventViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by MASOOM ZAID on 20-04-2023.
 */

@AndroidEntryPoint
class CommonFragment(private var communicationService: CommunicationService?) : Fragment() , OnTileSelectListener , OnKnobPressListener , OnLimitChangeListener,DialogCloseListener ,OnLimitSelectListener{

    private var _binding: FragmentCommonBinding? = null
    private val binding get() = _binding!!
    private var tileAdapter: TileAdapter? = null
    private var observedAdapter: ObserverdAdapter? = null
    private var dataList = kotlin.collections.ArrayList<Tile_Model_Class>()
    private var observedList = kotlin.collections.ArrayList<ObservedModelClass>()
    private var preferenceManager: PreferenceManager? = null
    private var knobClass: KnobClass? = null
    private var pressureChartFragment :PressureChartFragment?=null
    private var flowChartFragment :FlowChartFragment?=null
    private var currentModeCode = -1

    private val commonViewModel: CommonViewModel by activityViewModels()
    private val eventViewModel: EventViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommonBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preferenceManager = PreferenceManager(requireContext())
        knobClass = KnobClass(this,this,this)
        setupAdapter()
        setupObservedAdapter()
        updateObservedTiles(null, null, null,null)
        setupGraphFragment()

        commonViewModel.currentModeCode.observe(viewLifecycleOwner) {
            onHandleDialogClose()
            currentModeCode = it
            when (it) {
                Mode_OnDemand -> {
                    dataList = Constants.getControlTilesViaPreferences(
                        requireContext(),
                        preferenceManager,
                        it
                    ).first
                }

                Mode_IntelliAuto -> {
                    dataList = Constants.getControlTilesViaPreferences(
                        requireContext(),
                        preferenceManager,
                        it
                    ).first
                }

                else -> {
                    dataList = Constants.getControlTilesViaPreferences(
                        requireContext(),
                        preferenceManager,
                        it
                    ).first

                }
            }

            tileAdapter?.updateAdapter(dataList)
        }
    }

    private fun addEvents(eventMsg: String, uhid: String) {

        val eventDataModel = EventDataModel(
            eventMsg, uhid
        )
        eventViewModel.addEvent(requireContext(),eventDataModel)
    }

    private fun setupGraphFragment(){

        pressureChartFragment = PressureChartFragment()
        pressureChartFragment?.let {
            childFragmentManager.beginTransaction().replace(R.id.pressureContainer,it).commit()
        }

        flowChartFragment = FlowChartFragment()
        flowChartFragment?.let {
            childFragmentManager.beginTransaction().replace(R.id.flowContainer,it).commit()
        }
    }

    fun updatePressureGraph(x:Int,pressure:Float){
        pressureChartFragment?.addEntry(x,pressure)
    }

    fun updateFlowGraph(x: Int,flow:Float){
        flowChartFragment?.addEntry(x,flow)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateObservedTherapyEnd(n2o :Int, o2:Int){

        if (Sedation_App.therapyEndStarted) binding.o2NonSetParamValue.text = o2.toString()
        preferenceManager?.updatePreferencesOfTiles(lbl_N2O,n2o)
        tileAdapter?.notifyDataSetChanged()
    }

    fun updateObservedTiles(flow_value: Int?, paw_value: Float?, fio2_value: Int?,o2: Int?) {
        observedList.clear()

        if(!Sedation_App.therapyEndStarted){
            o2?.let {
                binding.o2NonSetParamValue.text = it.toString()
            }
        }


        observedList.add(
            ObservedModelClass(
                lbl_flow,
                requireContext().getString(R.string.flow_tile_unit),
                flow_value?.toString() ?: kotlin.run {
                    "-"
                }
            )
        )
        observedList.add(
            ObservedModelClass(
                lbl_paw,
                requireContext().getString(R.string.paw_tile_unit),
                paw_value?.let {  String.format("%.1f",it) } ?: kotlin.run {
                    "-"
                }
            )
        )
        observedList.add(
            ObservedModelClass(
                lbl_fio2,
                requireContext().getString(R.string.fio2_tile_unit),
                fio2_value?.toString() ?: kotlin.run {
                    "-"
                }
            )
        )
        observedAdapter?.updateAdapter(observedList)
    }

    private fun setupAdapter() {
        tileAdapter = TileAdapter(dataList,requireContext(), this,this)
        binding.tileRecycler.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            );
            this.adapter = tileAdapter
        }
    }

    fun updateKnobData(value :String){
        knobClass?.updateWithTimeoutDebounce(value)
    }

    override fun onLimitSelect(value: Boolean) {
        if (Sedation_App.tileClicked == true){
            if (value) updateKnobData(PREFIX_PLUS)
            else updateKnobData(PREFIX_MINUS)
        }
    }

    private fun setupObservedAdapter() {
        observedAdapter = ObserverdAdapter(requireContext(),observedList,preferenceManager)
        binding.observedRecycler.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            );
            this.adapter = observedAdapter
        }
    }

    override fun onTileSelect(data: Tile_Model_Class) {
        if (!Sedation_App.therapyEndStarted) {
            if (data.label == lbl_target_pressure) {
                knobClass?.getAllParams(
                    data,
                    Constants.Companion.KnobSelectedType.TargetPressureType
                )
            } else {
                knobClass?.getAllParams(data, Constants.Companion.KnobSelectedType.tileType)
            }
            notifyAdapter()
        }else{
            ToastFactory.custom(requireContext(), "Therapy end in progress..")
        }
    }

    override fun onKnobPress(label: String, newValue: Float) {
        Log.i("value_knob_pressure",newValue.toString())
        preferenceManager?.updatePreferencesOfTiles(label,newValue)
        (requireActivity() as MainActivity).sendConfigurationToVentilatorWithWatchDog()

        when(label){
            lbl_target_pressure ->{
                addEvents("Set $label from ${preferenceManager?.getTargetPressure()}  ${requireContext().getString(R.string.unit_target_pressure)} to $newValue ${requireContext().getString(R.string.unit_target_pressure)}", preferenceManager?.readUHID().toString())
            }
        }

        onHandleDialogClose()
    }

    override fun onKnobPress(label: String, newValue: Int) {
        Log.i("value_knob_pressure",newValue.toString() + "aswd")
        preferenceManager?.updatePreferencesOfTiles(label,newValue)
        (requireActivity() as MainActivity).sendConfigurationToVentilatorWithWatchDog()

        when(label){
            lbl_total_flow -> {
                addEvents(
                    "Set $label from ${preferenceManager?.getTotalFlow()}  ${requireContext().getString(R.string.unit_total_flow)} to $newValue ${requireContext().getString(R.string.unit_total_flow)}", preferenceManager?.readUHID().toString()
                )
            }

            lbl_N2O ->{
                addEvents(
                    "Set $label from ${preferenceManager?.getN2O()}  ${requireContext().getString(R.string.unit_n2o)} to $newValue ${requireContext().getString(R.string.unit_n2o)}", preferenceManager?.readUHID().toString()
                )
            }
        }

        onHandleDialogClose()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun notifyAdapter(){
        tileAdapter?.notifyDataSetChanged()
    }

    override fun onHandleDialogClose() {
        tileAdapter?.selectedTile = -1
        dataList = Constants.getControlTilesViaPreferences(
            requireContext(),
            preferenceManager,
            currentModeCode
        ).first

        tileAdapter?.updateAdapter(dataList)
    }

    override fun onLimitChange(type: Constants.Companion.KnobSelectedType,label: String, newValue: Int) {

        Log.i("valueNEwDt","$newValue")
        when(type){
            Constants.Companion.KnobSelectedType.tileType -> {
                dataList.forEach { item ->
                    if(item.label == label) item.value = newValue.toString()
                }
            }
            else -> {}
        }
        tileAdapter?.updateAdapter(dataList)

    }

    override fun onLimitChange(type: Constants.Companion.KnobSelectedType,label: String, newValue: Float) {
        when(type){
            Constants.Companion.KnobSelectedType.TargetPressureType -> {
                dataList.forEach { item ->
                    if(item.label == label) item.value = String.format("%.1f",newValue)
                }
            }
            else -> {}
        }
        tileAdapter?.updateAdapter(dataList)
    }

}
