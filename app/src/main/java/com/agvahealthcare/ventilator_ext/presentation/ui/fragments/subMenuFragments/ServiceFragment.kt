package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.subMenuFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.agvahealthcare.ventilator_ext.databinding.FragmentServiceBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by MASOOM ZAID on 01-Dec-2023.
 */

@AndroidEntryPoint
class ServiceFragment : Fragment(){

    private var _binding: FragmentServiceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentServiceBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}