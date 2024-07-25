package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.charts

import androidx.fragment.app.Fragment
import com.scichart.extensions.builders.SciChartBuilder

open class GraphFragment : Fragment() {
    val sciChartBuilder: SciChartBuilder = SciChartBuilder.instance()
}