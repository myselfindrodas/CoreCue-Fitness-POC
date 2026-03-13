package com.corecue.fitness.ui.splash

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.corecue.fitness.R
import com.corecue.fitness.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private var didNavigate = false

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { result ->
        val allGranted = requiredPermissions().all { permission -> result[permission] == true }
        if (allGranted) {
            navigateHomeOnce()
            return@registerForActivityResult
        }
        Toast.makeText(
            requireContext(),
            "Please grant all required permissions to continue.",
            Toast.LENGTH_SHORT
        ).show()
        showPermissionRequiredDialog()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSplashBinding.bind(view)
        binding.logo.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up_fade))
        binding.subtitle.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up_fade))
        binding.root.postDelayed({
            requestAllRuntimePermissions()
        }, 1800)
    }

    override fun onResume() {
        super.onResume()
        if (!didNavigate) {
            requestAllRuntimePermissions()
        }
    }

    private fun requestAllRuntimePermissions() {
        val missing = requiredPermissions().filter { permission ->
            ContextCompat.checkSelfPermission(
                requireContext(),
                permission
            ) != android.content.pm.PackageManager.PERMISSION_GRANTED
        }
        if (missing.isEmpty()) {
            navigateHomeOnce()
        } else {
            permissionLauncher.launch(missing.toTypedArray())
        }
    }

    private fun requiredPermissions(): List<String> {
        return listOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
        )
    }

    private fun navigateHomeOnce() {
        if (didNavigate || !isAdded) return
        didNavigate = true
        findNavController().navigate(R.id.action_splash_to_home)
    }

    private fun showPermissionRequiredDialog() {
        if (!isAdded) return
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Permissions required")
            .setMessage("Camera and microphone permissions are required before entering the app.")
            .setCancelable(false)
            .setNegativeButton("Retry") { _, _ ->
                requestAllRuntimePermissions()
            }
            .setPositiveButton("Open Settings") { _, _ ->
                val intent = Intent(
                    android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", requireContext().packageName, null)
                )
                startActivity(intent)
            }
            .show()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
