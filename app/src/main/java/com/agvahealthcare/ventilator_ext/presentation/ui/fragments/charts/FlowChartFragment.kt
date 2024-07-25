package com.agvahealthcare.ventilator_ext.presentation.ui.fragments.charts

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.scichart.charting.model.dataSeries.IXyDataSeries
import com.scichart.charting.visuals.annotations.AnnotationCoordinateMode
import com.scichart.charting.visuals.axes.AutoRange
import com.scichart.charting.visuals.axes.AxisAlignment
import com.scichart.charting.visuals.axes.IAxis
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries
import com.scichart.core.framework.UpdateSuspender
import com.scichart.data.model.DoubleRange
import com.scichart.drawing.common.FontStyle
import com.scichart.drawing.utility.ColorUtil
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.databinding.FragmentChartBinding
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants
import com.agvahealthcare.ventilator_ext.presentation.utils.Constants.Companion.GRAPH_THRESHOLD
import com.agvahealthcare.ventilator_ext.presentation.utils.PreferenceManager
import com.agvahealthcare.ventilator_ext.presentation.viewmodels.CommonViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.math.abs

@AndroidEntryPoint
class FlowChartFragment : GraphFragment() {

    private var _binding: FragmentChartBinding? = null
    private val binding get() = _binding!!
    private lateinit var dataSeries0: IXyDataSeries<Int, Float>
    private lateinit var dataSeries1: IXyDataSeries<Int, Float>
    private var prefManager: PreferenceManager? = null
    private var whichTrace = Constants.Companion.TraceArc.TraceA
    val titleStyle = FontStyle(14.0f, ColorUtil.White)
    private var mCommonViewModel: CommonViewModel? = null
    private var minRange = 0.0
    private var maxRange = 0.0
    private var timePeek = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentChartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefManager = PreferenceManager(requireContext())
        mCommonViewModel = ViewModelProvider(requireActivity()).get(CommonViewModel::class.java)
        binding.textViewChartType.text = requireContext().getString(R.string.flow_l_min)
        binding.txtMaxLabel.text = "12"

        // added at 20 jan 2023
        minRange = Constants.getRangeOfYAxisChart(
            requireContext(),
            Constants.Companion.ChartType.FlowChart_Type
        )!!.first
        maxRange = Constants.getRangeOfYAxisChart(
            requireContext(),
            Constants.Companion.ChartType.FlowChart_Type
        )!!.second

        initGraph()

    }


    private fun initGraph() {
        val xPrimaryAxis: IAxis = sciChartBuilder.newNumericAxis()
            .withVisibleRange(DoubleRange(0.0, GRAPH_THRESHOLD.toDouble()))
            .withMaxAutoTicks(30)
            .withTickLabelStyle(titleStyle)
            .withAxisId("Visible Axis")
            .withAutoRangeMode(AutoRange.Never)
            .build()

        val xSecondaryAxis: IAxis = sciChartBuilder.newNumericAxis()
            .withVisibleRange(DoubleRange(0.0, 12.0))
            .withMaxAutoTicks(1)
            .withTickLabelStyle(titleStyle)
            .withAxisId("HiddenXAxis")
            .withAutoRangeMode(AutoRange.Never)
            .build()

        val yAxis: IAxis = sciChartBuilder.newNumericAxis()
            .withAxisAlignment(AxisAlignment.Left)
            .withVisibleRange(minRange, maxRange)
            .withMaxAutoTicks(1)
            .withTickLabelStyle(titleStyle)
            .withAutoRangeMode(AutoRange.Never)
            .build()

        binding.chartSurface.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.black))
        binding.chartSurface.renderableSeriesAreaBorderStyle =
            sciChartBuilder.newPen().withColor(ColorUtil.Transparent).build()
        xPrimaryAxis.visibility = View.GONE
        xSecondaryAxis.visibility = View.VISIBLE

        xPrimaryAxis.drawMajorGridLines = false
        xPrimaryAxis.drawMinorGridLines = false
        xPrimaryAxis.drawMajorBands = false
        xPrimaryAxis.drawMajorTicks = false
        xPrimaryAxis.drawMinorTicks = false

        yAxis.drawMajorGridLines = false
        yAxis.drawMinorGridLines = false
        yAxis.drawMajorBands = false
        yAxis.drawMajorTicks = false
        yAxis.drawMajorTicks = false

        dataSeries0 = sciChartBuilder.newXyDataSeries(
            Int::class.javaObjectType,
            Float::class.javaObjectType
        ).withFifoCapacity(GRAPH_THRESHOLD).build()

        dataSeries1 = sciChartBuilder.newXyDataSeries(
            Int::class.javaObjectType,
            Float::class.javaObjectType
        ).withFifoCapacity(GRAPH_THRESHOLD).build()

        val rs1: IRenderableSeries = sciChartBuilder.newMountainSeries()
            .withDataSeries(dataSeries0)
            .withXAxisId("Visible Axis")
            .withStrokeStyle(
                sciChartBuilder.newPen().withColor(Color.parseColor("#FFFFFF")).withThickness(1f)
                    .build()
            )
            .withAreaFillColor(Color.parseColor("#FFFFFF"))
            .build()

        // RM scichart
        val rs2: IRenderableSeries = sciChartBuilder.newMountainSeries()
            .withDataSeries(dataSeries1)
            .withXAxisId("Visible Axis")
            .withAreaFillColor(Color.parseColor("#FFFFFF"))
            .withStrokeStyle(
                sciChartBuilder.newPen().withColor(Color.parseColor("#FFFFFF")).withThickness(1f)
                    .build()
            )
            .build()

        val verticalLine = sciChartBuilder.newLineAnnotation()
            .withPosition(0.0, 0.0, 0.0, 1.0)
            .withCoordinateMode(AnnotationCoordinateMode.Relative)
            .withIsEditable(true)
            .withStroke(1f, Color.WHITE)
            .build()

        val horizontalLine = sciChartBuilder.newLineAnnotation()
            .withPosition(0.0, 1.0, 1.0, 1.0)
            .withCoordinateMode(AnnotationCoordinateMode.Relative)
            .withIsEditable(true)
            .withStroke(1f, Color.WHITE)
            .build()


        Collections.addAll(binding.chartSurface.annotations, horizontalLine, verticalLine)

        UpdateSuspender.using(binding.chartSurface) {
            Collections.addAll(binding.chartSurface.xAxes, xPrimaryAxis)
            Collections.addAll(binding.chartSurface.xAxes, xSecondaryAxis)
            Collections.addAll(binding.chartSurface.yAxes, yAxis)
            Collections.addAll(binding.chartSurface.renderableSeries ,rs1,rs2)
        }
    }

//    // created at 20 jan 2023
//    private fun changeGraphRangeAtRunTime(y: Float, x: Int, trigger: String?) {
//
//        if (x == timePeek) {
//            binding.chartSurface.yAxes.default.visibleRange = DoubleRange(minRange, maxRange)
//            timePeek = -1
//        } else {
//
//            if (mCommonViewModel?.graphPeekValue?.value == "A") {
//
//                if (y < 25.0) {
//                    maxRange = Constants.POSITIVE_MIN_RANGE_FLOW_ADULT_PEDIA
//
//                    setTimePeekValue(setXToChangeGraphDown(x))
//                } else {
//                    maxRange = Constants.POSITIVE_MAX_RANGE_FLOW_ADULT_PEDIA
//
//                    binding.chartSurface.yAxes.default.visibleRange = DoubleRange(minRange, maxRange)
//                    timePeek = -1
//                }
//            }
//        }
//    }
//
//    private fun setXToChangeGraphDown(x: Int): Int {
//        if (x + 340 > 350) {
//            return abs((x + 340) - 350)
//        }
//        return x + 340
//    }
//
//    private fun setTimePeekValue(value: Int) {
//        if (timePeek == -1) {
//            timePeek = value
//        }
//    }


    // modified at 20 jan 2023
    fun addEntry(x: Int, y: Float) {
        val xAxis = x % (GRAPH_THRESHOLD + 1)
        Log.i("Flow Chart", "x = $xAxis , Y = $y")

        if (whichTrace == Constants.Companion.TraceArc.TraceA) {
            dataSeries0.append(xAxis, y)
            dataSeries1.append(xAxis, Float.NaN)

        } else {
            dataSeries0.append(xAxis, Float.NaN)
            dataSeries1.append(xAxis, y)
        }

        if (xAxis % GRAPH_THRESHOLD == 0) {
            whichTrace =
                if (whichTrace == Constants.Companion.TraceArc.TraceA) Constants.Companion.TraceArc.TraceB else Constants.Companion.TraceArc.TraceA
            Log.i("FLOW_CHART_VALUE", "x = $xAxis")
        }
    }

}

