package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.Sedation_App
import com.agvahealthcare.ventilator_ext.Sedation_App.Companion.uhidDataListAlarm
import com.agvahealthcare.ventilator_ext.databinding.FragmentErrorLogsBinding
import com.agvahealthcare.ventilator_ext.presentation.adapters.*
import com.agvahealthcare.ventilator_ext.presentation.utils.FileLogger
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager
import com.agvahealthcare.ventilator_ext.presentation.utils.ToastFactory
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */

@AndroidEntryPoint
class ErrorLogsFragment : Fragment(), View.OnClickListener {

    private lateinit var buttonLayout: LinearLayoutCompat
    private var mAdapter: AlarmAdapter? = null
    lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var spinnerAlarm: Spinner
    private var dataList = ArrayList<String>()
    private var uhid = ""
    private var startIndex = 0
    private var endIndex = 10
    private var pageNo = 1
    private val commonViewModel: CommonViewModel by viewModels()
    private var preferenceManager: PreferenceManager? = null

    private var _binding: FragmentErrorLogsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentErrorLogsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        commonViewModel.updateIsAlarmsFragmentVisible(false)
    }

    override fun onResume() {
        super.onResume()
        commonViewModel.updateIsAlarmsFragmentVisible(true)
    }

    private fun setupAdapter() {

        Log.i("ad989", "hsdg" + uhidDataListAlarm.size.toString())

        if (uhidDataListAlarm.isEmpty()) buttonLayout.visibility = View.GONE
        else buttonLayout.visibility = View.VISIBLE

        val alarmScrollAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, uhidDataListAlarm)
        spinnerAlarm.apply {
            adapter = alarmScrollAdapter
            this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    uhid = uhidDataListAlarm[position]
                    setupDataDefault(uhid)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spinnerAlarm = view.findViewById<Spinner>(R.id.spinnerAlarm)
        buttonLayout = view.findViewById(R.id.btnLayout)
        preferenceManager = PreferenceManager(requireContext())
        binding.topButtonAlarm.setOnClickListener(this)
        binding.bottomButtonAlarm.setOnClickListener(this)
        setUpAlarmsData()
        setupAdapter()
    }

    override fun onClick(view: View) {

        when (view.id) {

            R.id.topButtonAlarm -> {
                mAdapter?.apply {
                    mLayoutManager.apply {
                        var firstVisibleItemIndex = findFirstVisibleItemPosition()
                        setSelectionUpward()
                        if (getSelection() == firstVisibleItemIndex) {
                            var data = FileLogger.readAlarmFile(++startIndex, ++endIndex,"Increment")

                            if (data != "Data Not Found") {
                                val indexes  = data.split("#")[1]
                                data = data.split("#")[0]
                                startIndex = indexes.split(",")[0].toInt()
                                endIndex = indexes.split(",")[1].toInt()

                                Log.i("valueData","$startIndex ,, $endIndex")

                                val listData = data.split("|") as java.util.ArrayList<String>
                                mAdapter?.updateDataList(listData)
                            } else {
                                --startIndex
                                --endIndex
                                ToastFactory.custom(requireContext(), data)
                            }
                        }
                    }
                }
            }

            R.id.bottomButtonAlarm -> {

                mAdapter?.apply {
                    mLayoutManager.apply {
                        var lastVisibleItemIndex = findLastCompletelyVisibleItemPosition()

                        if (getSelection() != dataList.size - 1) {
                            setSelectionDownward()
                            if (getSelection() == lastVisibleItemIndex) {
                                var data = FileLogger.readAlarmFile(--startIndex, --endIndex,"Increment")

                                if (data != "Data Not Found") {
                                    val indexes  = data.split("#")[1]
                                    data = data.split("#")[0]
                                    startIndex = indexes.split(",")[0].toInt()
                                    endIndex = indexes.split(",")[1].toInt()

                                    Log.i("valueData","$startIndex ,, $endIndex")

                                    val listData = data.split("|") as java.util.ArrayList<String>
                                    mAdapter?.updateDataList(listData)
                                } else {
                                    ++startIndex
                                    ++endIndex
                                    ToastFactory.custom(requireContext(), data)
                                }
                            }
                        }
                    }
                }

            }
        }
    }


    private fun setupDataDefault(uhid: String) {

        var data = FileLogger.readAlarmFile(startIndex, endIndex,"Default")

        if (data != "Data Not Found") {
            val indexes  = data.split("#")[1]
            data = data.split("#")[0]
            startIndex = indexes.split(",")[0].toInt()
            endIndex = indexes.split(",")[1].toInt()

            Log.i("valueData","$startIndex ,, $endIndex")

            val listData = data.split("|") as java.util.ArrayList<String>
            mAdapter?.updateDataList(listData)
        } else {
            ToastFactory.custom(requireContext(), data)
        }


    }


    private fun setUpAlarmsData() {
        mAdapter = AlarmAdapter(dataList)
        mLayoutManager = LinearLayoutManager(requireContext())

        binding.recyclerViewAlarm.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
            isVerticalScrollBarEnabled = true
            itemAnimator = null
        }
    }

    fun scrollForward() = binding.bottomButtonAlarm.callOnClick()
    fun scrollBack() = binding.topButtonAlarm.callOnClick()

}