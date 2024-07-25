package com.agvahealthcare.ventilator_ext.presentation.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.Sedation_App.Companion.tileClicked
import com.agvahealthcare.ventilator_ext.databinding.FragmentMenuBinding
import com.agvahealthcare.ventilator_ext.databinding.ItemAlarmDataBinding
import com.agvahealthcare.ventilator_ext.presentation.adapters.MenuAdapter
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnMenuChangeListener
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */

@AndroidEntryPoint
class MenuFragment(
    private var closeListener: DialogCloseListener?,
    private var fromStandby: Boolean
) : Fragment(), OnMenuChangeListener {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private var menuAdapter: MenuAdapter? = null
    private var commonSubMenuFragment: CommonSubMenuFragment? = null
    private var dataList = ArrayList<String>()
    private val commonViewModel: CommonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        setupDefaultView()

        binding.imgCross.setOnClickListener {
            closeListener?.onHandleDialogClose()
        }
    }

    fun updateViaKnob(data : String){
        commonSubMenuFragment?.updateViaKnob(data)
    }

    private fun showCommonSubMenuFragment() {
        closeFragment()
        commonSubMenuFragment = CommonSubMenuFragment()
        commonSubMenuFragment?.let {
            childFragmentManager.beginTransaction().replace(R.id.container, it).commit()
        }
    }

    private fun closeFragment() {
        binding.container.removeAllViews()
    }

    private fun setupAdapter() {

        dataList.add(requireContext().getString(R.string.info))
        dataList.add(requireContext().getString(R.string.recentPatient))
        dataList.add(requireContext().getString(R.string.errorLogs))
        dataList.add(requireContext().getString(R.string.alarmLimits))
        if (fromStandby) dataList.add(requireContext().getString(R.string.calibration)) else dataList.add(requireContext().getString(R.string.serviceWindow))
        if (fromStandby) dataList.add(requireContext().getString(R.string.advancedCalibration))

        menuAdapter = MenuAdapter(requireContext(), dataList, this)
        binding.menuOptionsRecyclerView.let {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.adapter = menuAdapter
        }
    }

    private fun setupDefaultView() {
        showCommonSubMenuFragment()
        commonViewModel.clickedSubMenuItem.postValue(Constants.Companion.AllSubMenuType.Settings)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onMenuChange(position: Int) {
        menuAdapter?.selectedIndex = position
        menuAdapter?.notifyDataSetChanged()


        when (position) {

            0 -> {
                setupDefaultView()
            }

            1 -> {
                showCommonSubMenuFragment()
                commonViewModel.clickedSubMenuItem.postValue(Constants.Companion.AllSubMenuType.EventLogs)
            }

            2 -> {
                showCommonSubMenuFragment()
                commonViewModel.clickedSubMenuItem.postValue(Constants.Companion.AllSubMenuType.ErrorLogs)
            }

            3 -> {
                showCommonSubMenuFragment()
                commonViewModel.clickedSubMenuItem.postValue(Constants.Companion.AllSubMenuType.AlarmLimits)
            }

            4 -> {
                if (fromStandby) {
                    showCommonSubMenuFragment()
                    commonViewModel.clickedSubMenuItem.postValue(Constants.Companion.AllSubMenuType.Calibrations)
                } else {
                    showCommonSubMenuFragment()
                    commonViewModel.clickedSubMenuItem.postValue(Constants.Companion.AllSubMenuType.ServiceWindow)
                }
            }

            5 -> {
                showCommonSubMenuFragment()
                commonViewModel.clickedSubMenuItem.postValue(Constants.Companion.AllSubMenuType.AdvancedCalibration)
            }


        }

    }
}