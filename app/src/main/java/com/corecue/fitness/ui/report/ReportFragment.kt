package com.corecue.fitness.ui.report

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.corecue.fitness.R
import com.corecue.fitness.databinding.FragmentReportBinding
import com.corecue.fitness.ui.main.MainViewModel
import kotlinx.coroutines.launch

class ReportFragment : Fragment(R.layout.fragment_report) {
    private var _binding: FragmentReportBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentReportBinding.bind(view)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.homeFragment)
        }

        binding.tryAgainBtn.setOnClickListener {
            findNavController().navigate(R.id.recordingFragment)
        }
        binding.homeBtn.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.report.collect { report ->
                report ?: return@collect
                binding.scoreText.text = "${report.overallScore}"
                binding.halfCompare.text =
                    "Reps 1-5: ${report.firstHalfScore}   |   Reps 6-10: ${report.secondHalfScore}"
                binding.issueList.text = report.issues.joinToString("\n• ", prefix = "• ") {
                    "${it.title}: ${it.fixHint}"
                }
                binding.bodyPartScores.text =
                    report.bodyParts.joinToString("\n") { "${it.first}: ${it.second}%" }
                bindRepChart(report.repScores)
                bindBodyRadar(report.bodyParts)
            }
        }
    }

    private fun bindRepChart(repScores: List<Int>) {
        val entries = repScores.mapIndexed { index, score -> BarEntry((index + 1).toFloat(), score.toFloat()) }
        val dataSet = BarDataSet(entries, "Rep Accuracy").apply {
            color = android.graphics.Color.parseColor("#7FA7FF")
            valueTextColor = android.graphics.Color.WHITE
        }
        binding.repChart.apply {
            description.isEnabled = false
            axisRight.isEnabled = false
            axisLeft.axisMinimum = 0f
            xAxis.valueFormatter = IndexAxisValueFormatter(repScores.indices.map { "R${it + 1}" })
            xAxis.granularity = 1f
            data = BarData(dataSet)
            animateY(600)
            invalidate()
        }
    }

    private fun bindBodyRadar(bodyParts: List<Pair<String, Int>>) {
        val entries = bodyParts.map { RadarEntry(it.second.toFloat()) }
        val dataSet = RadarDataSet(entries, "Body Part Score").apply {
            color = android.graphics.Color.parseColor("#B79CFF")
            fillColor = android.graphics.Color.parseColor("#4CB79CFF")
            setDrawFilled(true)
            valueTextColor = android.graphics.Color.WHITE
        }
        binding.bodyRadarChart.apply {
            description.isEnabled = false
            webColor = android.graphics.Color.parseColor("#445280")
            xAxis.valueFormatter = IndexAxisValueFormatter(bodyParts.map { it.first })
            yAxis.axisMinimum = 0f
            yAxis.axisMaximum = 100f
            data = RadarData(dataSet)
            animateXY(700, 700)
            invalidate()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
