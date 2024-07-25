package com.agvahealthcare.ventilator_ext.presentation.ui.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.agvahealthcare.ventilator_ext.R

public class StandByFragmentDirections private constructor() {
  public companion object {
    public fun actionStandByFragmentToGraphFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_standByFragment_to_graphFragment)
  }
}
