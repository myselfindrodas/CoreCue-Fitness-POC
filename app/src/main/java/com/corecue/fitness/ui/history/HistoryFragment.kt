package com.corecue.fitness.ui.history

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.corecue.fitness.R
import com.corecue.fitness.databinding.FragmentHistoryBinding
import com.corecue.fitness.ui.main.MainViewModel
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.coroutines.launch

class HistoryFragment : Fragment(R.layout.fragment_history) {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHistoryBinding.bind(view)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.sessionSummaries.collect { sessions ->
                binding.historyText.text = buildString {
                    appendLine("Last Sessions")
                    sessions.forEach {
                        appendLine("• ${it.exerciseName} - Score ${it.score}")
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.trendPoints.collect { points ->
                val entries = points.mapIndexed { idx, p -> Entry(idx.toFloat(), p.score.toFloat()) }
                val dataSet = LineDataSet(entries, "Score Trend").apply {
                    color = android.graphics.Color.parseColor("#7FA7FF")
                    lineWidth = 2.6f
                    setDrawCircles(true)
                    circleRadius = 3f
                    valueTextColor = android.graphics.Color.WHITE
                }
                binding.trendChart.apply {
                    description.isEnabled = false
                    axisRight.isEnabled = false
                    axisLeft.axisMinimum = 0f
                    axisLeft.axisMaximum = 100f
                    data = LineData(dataSet)
                    animateX(600)
                    invalidate()
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
