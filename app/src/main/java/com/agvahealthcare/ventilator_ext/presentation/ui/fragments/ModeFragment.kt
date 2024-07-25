package com.agvahealthcare.ventilator_ext.presentation.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.databinding.FragmentModeBinding
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.DialogCloseListener
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.Mode_ContinuousSedation
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.Mode_IntelliAuto
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.Mode_OnDemand
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.VENTILATOR_MODES
import com.agvahealthcare.ventilator_ext.presentation.utils.IntentFactory
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ModeFragment(private var closeListener: DialogCloseListener?) : Fragment() {


    private var _binding: FragmentModeBinding? = null
    private val binding get() = _binding!!
    private var preferenceManager: PreferenceManager? = null
    private var selectedLayout : View? = null
    private var selectedTextView : TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentModeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preferenceManager = PreferenceManager(requireContext())

        initView()
        binding.modeContinuesSedation.root.setOnClickListener {
            highlightTile(it,binding.modeContinuesSedation.modeText)
            sendModeBroadcast(Mode_ContinuousSedation)
        }
        binding.modeOnDemand.root.setOnClickListener {
            highlightTile(it,binding.modeOnDemand.modeText)
            sendModeBroadcast(Mode_OnDemand)
        }
        binding.modeIntelliAuto.root.setOnClickListener {
            highlightTile(it,binding.modeIntelliAuto.modeText)
            sendModeBroadcast(Mode_IntelliAuto)
        }
        binding.imgCross.setOnClickListener {
            closeListener?.onHandleDialogClose()
        }
    }

    private fun initView(){
        binding.modeOnDemand.modeText.text = requireContext().resources.getString(R.string.on_demand)
        binding.modeContinuesSedation.modeText.text = requireContext().resources.getString(R.string.continuos_sedation)
        binding.modeIntelliAuto.modeText.text = requireContext().resources.getString(R.string.intelli_auto)

        when(preferenceManager?.getSedationMode()){
            Mode_ContinuousSedation -> highlightTile(binding.modeContinuesSedation.root,binding.modeContinuesSedation.modeText)
            Mode_OnDemand -> highlightTile(binding.modeOnDemand.root,binding.modeOnDemand.modeText)
            Mode_IntelliAuto -> highlightTile(binding.modeIntelliAuto.root,binding.modeIntelliAuto.modeText)
        }

    }

    private fun highlightTile(view:View,textView: TextView){
        normaliseTile(selectedLayout,selectedTextView)
        view.setBackgroundResource(R.drawable.racing_green_box_drawables)
        textView.setTextColor(requireContext().resources.getColor(R.color.white))

        selectedLayout = view
        selectedTextView = textView
    }

    private fun normaliseTile(view: View?,textView: TextView?){
        view?.setBackgroundResource(R.drawable.mode_box_drawable)
        textView?.setTextColor(requireContext().resources.getColor(R.color.white))
    }

    private fun sendModeBroadcast(mode:Int) {
        val i = Intent(IntentFactory.ACTION_MODE_SET)
        i.putExtra(VENTILATOR_MODES, mode)
        requireContext().sendBroadcast(i)
    }

}