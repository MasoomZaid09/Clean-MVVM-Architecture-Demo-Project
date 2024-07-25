package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.agvahealthcare.ventilator_ext.databinding.FragmentRecentPatientBinding
import com.agvahealthcare.ventilator_ext.presentation.adapters.*
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */

@AndroidEntryPoint
class RecentPatientsFragment : Fragment(){

    private var _binding: FragmentRecentPatientBinding? = null
    private val binding get() = _binding!!
    private var recentPatientAdapter : RecentPatientAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecentPatientBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecentAdapter()
    }


    private fun setupRecentAdapter(){
        recentPatientAdapter = RecentPatientAdapter(requireContext())
        binding.recentPatientRecyclerView.let {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.adapter = recentPatientAdapter
        }
    }

}