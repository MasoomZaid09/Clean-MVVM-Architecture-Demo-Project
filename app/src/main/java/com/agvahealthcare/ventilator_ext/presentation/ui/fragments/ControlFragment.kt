package com.agvahealthcare.ventilator_ext.presentation.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.Sedation_App
import com.agvahealthcare.ventilator_ext.databinding.FragmentControlBinding
import com.agvahealthcare.ventilator_ext.presentation.adapters.ControlAdapter
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.controlSettingFragments.AdvancedFragment
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.controlSettingFragments.BasicFragment
import com.agvahealthcare.ventilator_ext.presentation.ui.fragments.controlSettingFragments.IntelliFragment
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnMenuChangeListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnStartSedationListener
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.Mode_IntelliAuto
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_MODES
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.getModeNameViaCode
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */

@AndroidEntryPoint
class ControlFragment(private var closeListener: DialogCloseListener?,private var onStartSedation: OnStartSedationListener) : Fragment(),OnMenuChangeListener{

    private var _binding: FragmentControlBinding? = null
    private val binding get() = _binding!!
    private var controlAdapter : ControlAdapter? = null
    private var basicFragment : BasicFragment? = null
    private var advancedFragment : AdvancedFragment? = null
    private var intelliFragment : IntelliFragment? = null
    private var dataList = ArrayList<String>()
    private val commonViewModel : CommonViewModel by activityViewModels()
    private var preferenceManager : PreferenceManager? = null
    var mode = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentControlBinding.inflate(layoutInflater, container, false)
        arguments?.getInt(VENTILATOR_MODES)?.let {
            mode = it
        }
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preferenceManager = PreferenceManager(requireContext())

        if (Sedation_App.isFromStandBy){
            binding.btnStartSedation.visibility = View.VISIBLE
        }
        else {
            binding.btnStartSedation.visibility = View.GONE
        }

        setupAdapter()
        setupDefaultView()

        binding.txtMode.text = getModeNameViaCode(requireContext(),mode)

        binding.imgCross.setOnClickListener {
            closeListener?.onHandleDialogClose()
        }

        binding.btnStartSedation.setOnClickListener {
            onStartSedation.onStartSedation(mode)
        }
    }

    fun updateKnobData(value :String){
        if (basicFragment?.isVisible == true) basicFragment?.updateKnobData(value)
        else if (advancedFragment?.isVisible == true) advancedFragment?.updateKnobData(value)
        else if (intelliFragment?.isVisible == true) intelliFragment?.updateKnobData(value)
    }

    private fun showBasicFragment(){
        closeFragment()
        basicFragment = BasicFragment()
        basicFragment?.let {
            val bundle = Bundle()
            bundle.putInt(VENTILATOR_MODES,mode)
            it.arguments = bundle
            childFragmentManager.beginTransaction().replace(R.id.container,it).commit()
        }
    }

    private fun showAdvancedFragment(){
        closeFragment()
        advancedFragment = AdvancedFragment()
        advancedFragment?.let {
            val bundle = Bundle()
            bundle.putInt(VENTILATOR_MODES,mode)
            it.arguments = bundle
            childFragmentManager.beginTransaction().replace(R.id.container,it).commit()
        }
    }

    private fun showIntelliFragment(){
        closeFragment()
        intelliFragment = IntelliFragment()
        intelliFragment?.let {
            val bundle = Bundle()
            bundle.putInt(VENTILATOR_MODES,mode)
            it.arguments = bundle
            childFragmentManager.beginTransaction().replace(R.id.container,it).commit()
        }
    }

    private fun closeFragment(){
        binding.container.removeAllViews()
    }

    private fun setupAdapter(){

        if (mode == Mode_IntelliAuto) {
            dataList.add(requireContext().getString(R.string.basic))
            dataList.add(requireContext().getString(R.string.advanced))
            dataList.add(requireContext().getString(R.string.intelli))
        }else {
            dataList.add(requireContext().getString(R.string.basic))
            dataList.add(requireContext().getString(R.string.advanced))
        }

        controlAdapter = ControlAdapter(requireContext(),dataList,this)
        binding.controlOptionsRecyclerView.let {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.adapter = controlAdapter
        }
    }

    private fun setupDefaultView(){
        showBasicFragment()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onMenuChange(position: Int) {
        controlAdapter?.selectedIndex = position
        controlAdapter?.notifyDataSetChanged()

        when(position) {
            0->{ setupDefaultView() }
            1->{ showAdvancedFragment() }
            2 ->{ showIntelliFragment() }
        }

    }
}