package com.corecue.fitness.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.corecue.fitness.R
import com.corecue.fitness.databinding.FragmentHomeBinding
import com.corecue.fitness.ui.main.MainViewModel
import kotlinx.coroutines.launch

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        val adapter = ExerciseAdapter { exercise ->
            viewModel.selectExercise(exercise)
            findNavController().navigate(R.id.action_home_to_calibration)
        }
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.exercises.collect { exercises ->
                adapter.submitList(exercises)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
