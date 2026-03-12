package com.corecue.fitness.ui.calibration

import android.Manifest
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.corecue.fitness.R
import com.corecue.fitness.audio.SpeechPriority
import com.corecue.fitness.audio.TtsCoach
import com.corecue.fitness.databinding.FragmentCalibrationBinding
import com.corecue.fitness.ui.camera.CameraWorkoutController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CalibrationFragment : Fragment(R.layout.fragment_calibration) {
    private var _binding: FragmentCalibrationBinding? = null
    private val binding get() = _binding!!
    @Inject lateinit var ttsCoach: TtsCoach
    private var cameraController: CameraWorkoutController? = null
    private var checksPassedAt: Long = 0L
    private var bodyVisible = false
    private var visibilityScore = 0f
    private var lastPrompt = ""
    private var useFrontCamera = true
    private val setupRunnable = Runnable { evaluateSetup() }
    private var orientationOk = false
    private var distanceOk = false
    private var bodyOk = false

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        if (requiredPermissions().all { p -> it[p] == true }) {
            bindCamera()
        } else {
            _binding?.promptText?.text = "Camera permission is required for calibration."
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCalibrationBinding.bind(view)

        binding.startWorkoutBtn.setOnClickListener {
            findNavController().navigate(R.id.action_calibration_to_demo)
        }
        binding.switchCameraBtn.setOnClickListener {
            useFrontCamera = !useFrontCamera
            bindCamera()
        }
        binding.statusChip.setOnClickListener {
            evaluateSetup()
            val status = "Landscape=$orientationOk, Distance=$distanceOk, Body=$bodyOk"
            Toast.makeText(requireContext(), status, Toast.LENGTH_SHORT).show()
        }
        binding.startWorkoutBtn.isEnabled = false
        applyEdgeToEdgeInsets()
        requestPermissionsAndBind()
        binding.root.postDelayed(setupRunnable, 600)
    }

    private fun applyEdgeToEdgeInsets() {
        val statusInitialTop = (binding.statusChip.layoutParams as android.view.ViewGroup.MarginLayoutParams).topMargin
        val switchInitialTop = (binding.switchCameraBtn.layoutParams as android.view.ViewGroup.MarginLayoutParams).topMargin
        val switchInitialEnd = (binding.switchCameraBtn.layoutParams as android.view.ViewGroup.MarginLayoutParams).marginEnd
        val startInitialBottom = (binding.startWorkoutBtn.layoutParams as android.view.ViewGroup.MarginLayoutParams).bottomMargin

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.statusChip.updateLayoutParams<android.view.ViewGroup.MarginLayoutParams> {
                topMargin = statusInitialTop + bars.top
            }
            binding.switchCameraBtn.updateLayoutParams<android.view.ViewGroup.MarginLayoutParams> {
                topMargin = switchInitialTop + bars.top
                marginEnd = switchInitialEnd
            }
            binding.startWorkoutBtn.updateLayoutParams<android.view.ViewGroup.MarginLayoutParams> {
                bottomMargin = startInitialBottom + bars.bottom
            }
            insets
        }
    }

    private fun requestPermissionsAndBind() {
        val missing = requiredPermissions().filter {
            androidx.core.content.ContextCompat.checkSelfPermission(
                requireContext(),
                it
            ) != android.content.pm.PackageManager.PERMISSION_GRANTED
        }
        if (missing.isEmpty()) bindCamera() else permissionLauncher.launch(missing.toTypedArray())
    }

    private fun bindCamera() {
        val b = _binding ?: return
        cameraController = CameraWorkoutController(requireContext()).also { controller ->
            controller.bind(
                lifecycleOwner = viewLifecycleOwner,
                previewView = b.previewView,
                useFrontCamera = useFrontCamera,
                onLandmarks = { points -> _binding?.poseOverlay?.updateLandmarks(points) },
                onPoseSignal = { visible, score ->
                    bodyVisible = visible
                    visibilityScore = score
                }
            )
        }
    }

    private fun requiredPermissions(): List<String> {
        return buildList {
            add(Manifest.permission.CAMERA)
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                add(Manifest.permission.RECORD_AUDIO)
            }
        }
    }

    private fun evaluateSetup() {
        val b = _binding ?: return
        orientationOk = isLandscapeNow()
        distanceOk = visibilityScore < 0f || visibilityScore > 0.35f
        bodyOk = visibilityScore < 0f || bodyVisible

        val prompt = when {
            !orientationOk -> "Please rotate your device to landscape."
            visibilityScore < 0f -> "Pose model not found. Running camera-only fallback."
            !distanceOk -> "Step back to fit your full body."
            !bodyOk -> "Align your full body in the silhouette."
            else -> "Hold still... setup almost ready."
        }
        b.promptText.text = prompt
        if (prompt != lastPrompt) {
            ttsCoach.enqueue(prompt, SpeechPriority.NORMAL)
            lastPrompt = prompt
        }

        val allPassed = orientationOk && distanceOk && bodyOk
        if (allPassed) {
            if (checksPassedAt == 0L) checksPassedAt = System.currentTimeMillis()
            val stableFor = System.currentTimeMillis() - checksPassedAt
            b.statusChip.text = "Validating..."
            if (stableFor > 2000) {
                b.statusChip.text = "Ready"
                b.startWorkoutBtn.isEnabled = true
                b.startWorkoutBtn.isVisible = true
                return
            }
        } else {
            checksPassedAt = 0L
            b.statusChip.text = "Adjust setup"
        }
        b.root.postDelayed(setupRunnable, 700)
    }

    private fun isLandscapeNow(): Boolean {
        val b = _binding ?: return false
        val byDimensions = b.root.width > b.root.height && b.root.width > 0 && b.root.height > 0
        if (byDimensions) return true
        return resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    }

    override fun onDestroyView() {
        _binding?.root?.removeCallbacks(setupRunnable)
        cameraController?.release()
        cameraController = null
        _binding = null
        super.onDestroyView()
    }
}
