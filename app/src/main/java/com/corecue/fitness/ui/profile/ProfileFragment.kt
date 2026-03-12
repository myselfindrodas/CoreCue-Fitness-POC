package com.corecue.fitness.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.corecue.fitness.R
import com.corecue.fitness.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)
        binding.notifySwitch.isChecked = true
        binding.cameraSwitch.isChecked = false
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
