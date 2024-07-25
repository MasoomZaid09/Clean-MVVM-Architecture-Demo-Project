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
import androidx.compose.ui.res.stringArrayResource
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.Sedation_App
import com.agvahealthcare.ventilator_ext.Sedation_App.Companion.uhidDataListAlarm
import com.agvahealthcare.ventilator_ext.Sedation_App.Companion.uhidDataListEvent
import com.agvahealthcare.ventilator_ext.databinding.FragmentErrorLogsBinding
import com.agvahealthcare.ventilator_ext.databinding.FragmentEventBinding
import com.agvahealthcare.ventilator_ext.presentation.adapters.*
import com.agvahealthcare.ventilator_ext.presentation.utils.FileLogger
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager
import com.agvahealthcare.ventilator_ext.presentation.utils.ToastFactory
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */

@AndroidEntryPoint
class EventFragment : Fragment(), View.OnClickListener {

    var mAdapter: EventAdapter? = null
    lateinit var mLayoutManager: LinearLayoutManager
    private var dataList = ArrayList<String>()
    private var uhid = ""
    private var startIndex = 0
    private var endIndex = 10
    private var pageNo = 1
    private val commonViewModel: CommonViewModel by viewModels()
    private var preferenceManager: PreferenceManager? = null

    private var _binding: FragmentEventBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun setupSpinnerAdapter() {

        if (uhidDataListEvent.isEmpty()) binding.btnLayout.visibility = View.GONE
        else binding.btnLayout.visibility = View.VISIBLE

        val eventScrollAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            uhidDataListEvent
        )

        binding.spinnerEvent.apply {

            adapter = eventScrollAdapter
            this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Log.i("data_addedn", "asdawd")
                    uhid = uhidDataListEvent[position]
                    setupDataDefault(uhid)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        }
    }


    override fun onResume() {
        super.onResume()

        commonViewModel.updateIsEventsFragmentVisible(true)
    }

    override fun onPause() {
        super.onPause()

        commonViewModel.updateIsEventsFragmentVisible(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.topButton.setOnClickListener(this)
        binding.bottomButton.setOnClickListener(this)
        preferenceManager = PreferenceManager(requireContext())
        Log.i("eventTesting", preferenceManager?.getEventPageNo().toString())

        setDataForEvents()
        setupSpinnerAdapter()
    }

    override fun onClick(view: View) {

        when (view.id) {

            R.id.topButton -> {
                mAdapter?.apply {
                    mLayoutManager.apply {
                        var firstVisibleItemIndex = findFirstVisibleItemPosition()
                        setSelectionUpword()
                        if (getSelection() == firstVisibleItemIndex) {
                            var data = FileLogger.readEventFile(++startIndex, ++endIndex,"Increment")

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

            R.id.bottomButton -> {

                mAdapter?.apply {
                    mLayoutManager.apply {
                        var lastVisibleItemIndex = findLastCompletelyVisibleItemPosition()

                        if (getSelection() != dataList.size - 1) {
                            setSelectionDownward()
                            if (getSelection() == lastVisibleItemIndex) {
                                var data = FileLogger.readEventFile(--startIndex, --endIndex,"Increment")

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

        var data = FileLogger.readEventFile(startIndex, endIndex,"Default")

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


    fun scrollForward() = binding.bottomButton.callOnClick()
    fun scrollBack() = binding.topButton.callOnClick()

    private fun setDataForEvents() {
        mAdapter = EventAdapter(dataList)
        mLayoutManager = LinearLayoutManager(requireContext())

        binding.recyclerViewEvents.apply {
            adapter = mAdapter
            layoutManager = mLayoutManager
            isVerticalScrollBarEnabled = true
            itemAnimator = null
        }

    }

}