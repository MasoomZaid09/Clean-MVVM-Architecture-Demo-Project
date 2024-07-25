package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.databinding.FragmentAdvancedCalibrationBinding
import com.agvahealthcare.ventilator_ext.presentation.adapters.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */

@AndroidEntryPoint
class AdvancedCalibrationFragment : Fragment(){

    private var _binding: FragmentAdvancedCalibrationBinding? = null
    private val binding get() = _binding!!
    private var infoAdapter : InfoAdapter? = null
    private var infoList  =ArrayList<String>()
    private var o2CalibrationCount = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdvancedCalibrationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpOnClickListener()
        setupInfoAdapter()
    }



    @SuppressLint("SetTextI18n")
    private fun setUpOnClickListener(){
        binding.btnCalibrationStart.recoveryRootInclude?.setOnClickListener {
            it.visibility =View.GONE
            binding.calibrationProgressLayout?.visibility =View.VISIBLE
        }

        binding.btnCancelCalibration?.recoveryRootInclude?.setOnClickListener {

            binding.btnCalibrationStart?.recoveryRootInclude?.visibility =View.VISIBLE
            binding.calibrationProgressLayout?.visibility =View.GONE
        }
    }

    private fun setupInfoAdapter() {

        binding.btnCalibrationStart.includeRecoveryBtn?.text = "Start Calibration"
        binding.btnCalibrationStart.includeRecoveryBtn?.setTextColor(
            requireContext().getColor(
                R.color.white
            )
        )
        binding.btnCalibrationStart.recoveryRootInclude?.setBackgroundResource(R.drawable.auto_tv_background_green)


        binding.btnCancelCalibration.includeRecoveryBtn?.text = "Cancel"
        binding.btnCancelCalibration.includeRecoveryBtn?.setTextColor(
            requireContext().getColor(
                R.color.black
            )
        )
        binding.btnCancelCalibration.recoveryRootInclude?.setBackgroundResource(R.drawable.auto_tv_background_yellow)



        infoList.add(requireContext().getString(R.string.flow_calib1))
        infoList.add(requireContext().getString(R.string.flow_calib2))
        infoList.add(requireContext().getString(R.string.flow_calib3))

        infoAdapter = InfoAdapter(requireContext(),infoList, true)
        binding.InfoRecycler.apply {
            layoutManager = LinearLayoutManager(
                requireContext())
            this.adapter = infoAdapter
        }
    }


}