package com.corecue.fitness.ui.splash

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.corecue.fitness.R
import com.corecue.fitness.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSplashBinding.bind(view)
        binding.logo.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up_fade))
        binding.subtitle.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up_fade))
        binding.root.postDelayed({
            findNavController().navigate(R.id.action_splash_to_home)
        }, 1800)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
