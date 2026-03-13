package com.corecue.fitness.ui.calibration

import android.Manifest
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.addCallback
import androidx.core.os.bundleOf
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
import com.corecue.fitness.ui.camera.OverlayPoint
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CalibrationFragment : Fragment(R.layout.fragment_calibration) {
    private var _binding: FragmentCalibrationBinding? = null
    private val binding get() = _binding!!
    @Inject lateinit var ttsCoach: TtsCoach
    private var cameraController: CameraWorkoutController? = null
    private var useFrontCamera = true
    private var latestLandmarks: List<OverlayPoint> = emptyList()
    private var holdStartAt: Long = 0L
    private var lastFullBodySeenAt: Long = 0L
    private var isCalibrationCompleted = false
    private var currentStep: Step = Step.ORIENTATION
    private var bodyState: BodyState = BodyState.SEARCHING
    private val checkOrientationRunnable = Runnable { waitForLandscape() }
    private val checkPoseRunnable = Runnable { evaluateFullBodyStep() }

    private enum class Step {
        ORIENTATION,
        FULL_BODY,
        READY
    }

    private enum class BodyState {
        SEARCHING,
        HOLDING
    }

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
        setKeepScreenAwake(true)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            findNavController().navigateUp()
        }

        binding.startWorkoutBtn.isVisible = false
        binding.startWorkoutBtn.isEnabled = false
        binding.switchCameraBtn.setOnClickListener {
            useFrontCamera = !useFrontCamera
            bindCamera()
        }
        applyEdgeToEdgeInsets()
        initStepOneUi()
        showOrientationStepDialog()
    }

    private fun applyEdgeToEdgeInsets() {
        val statusInitialTop = (binding.statusChip.layoutParams as android.view.ViewGroup.MarginLayoutParams).topMargin
        val statusInitialStart = (binding.statusChip.layoutParams as android.view.ViewGroup.MarginLayoutParams).marginStart
        val statusInitialEnd = (binding.statusChip.layoutParams as android.view.ViewGroup.MarginLayoutParams).marginEnd
        val switchInitialTop = (binding.switchCameraBtn.layoutParams as android.view.ViewGroup.MarginLayoutParams).topMargin
        val switchInitialStart = (binding.switchCameraBtn.layoutParams as android.view.ViewGroup.MarginLayoutParams).marginStart
        val switchInitialEnd = (binding.switchCameraBtn.layoutParams as android.view.ViewGroup.MarginLayoutParams).marginEnd
        val startInitialBottom = (binding.startWorkoutBtn.layoutParams as android.view.ViewGroup.MarginLayoutParams).bottomMargin
        val startInitialStart = (binding.startWorkoutBtn.layoutParams as android.view.ViewGroup.MarginLayoutParams).marginStart
        val startInitialEnd = (binding.startWorkoutBtn.layoutParams as android.view.ViewGroup.MarginLayoutParams).marginEnd
        val promptInitialBottom = (binding.promptText.layoutParams as android.view.ViewGroup.MarginLayoutParams).bottomMargin
        val promptInitialStart = (binding.promptText.layoutParams as android.view.ViewGroup.MarginLayoutParams).marginStart
        val promptInitialEnd = (binding.promptText.layoutParams as android.view.ViewGroup.MarginLayoutParams).marginEnd

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.statusChip.updateLayoutParams<android.view.ViewGroup.MarginLayoutParams> {
                topMargin = statusInitialTop + bars.top
                marginStart = statusInitialStart + bars.left
                marginEnd = statusInitialEnd + bars.right
            }
            binding.switchCameraBtn.updateLayoutParams<android.view.ViewGroup.MarginLayoutParams> {
                topMargin = switchInitialTop + bars.top
                marginStart = switchInitialStart + bars.left
                marginEnd = switchInitialEnd + bars.right
            }
            binding.promptText.updateLayoutParams<android.view.ViewGroup.MarginLayoutParams> {
                bottomMargin = promptInitialBottom + bars.bottom
                marginStart = promptInitialStart + bars.left
                marginEnd = promptInitialEnd + bars.right
            }
            binding.startWorkoutBtn.updateLayoutParams<android.view.ViewGroup.MarginLayoutParams> {
                bottomMargin = startInitialBottom + bars.bottom
                marginStart = startInitialStart + bars.left
                marginEnd = startInitialEnd + bars.right
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
        if (missing.isEmpty()) {
            bindCamera()
        } else {
            _binding?.promptText?.text = "Permissions are required. Please allow camera and microphone in splash."
        }
    }

    private fun bindCamera() {
        val b = _binding ?: return
        if (cameraController == null) {
            cameraController = CameraWorkoutController(requireContext())
        }
        cameraController?.bind(
            lifecycleOwner = viewLifecycleOwner,
            previewView = b.previewView,
            useFrontCamera = useFrontCamera,
            onLandmarks = { points ->
                latestLandmarks = points
                _binding?.poseOverlay?.updateLandmarks(points)
            },
            onPoseSignal = { _, _ -> }
        )
    }

    private fun requiredPermissions(): List<String> {
        return listOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
        )
    }

    private fun initStepOneUi() {
        val b = _binding ?: return
        b.switchCameraBtn.isVisible = false
        b.statusChip.text = "Step 1/2: Orientation"
        b.promptText.text = "Rotate phone horizontally to continue."
        b.silhouette.background?.mutate()?.setTint(Color.parseColor("#99FFFFFF"))
    }

    private fun showOrientationStepDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Rotate phone")
            .setMessage("Please rotate your phone horizontally to continue.")
            .setCancelable(false)
            .setPositiveButton("Rotate & Continue") { _, _ ->
                requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
                waitForLandscape()
            }
            .show()
    }

    private fun waitForLandscape() {
        val b = _binding ?: return
        if (isLandscapeNow()) {
            currentStep = Step.FULL_BODY
            b.statusChip.text = "✔ Phone orientation horizontal"
            b.promptText.text = "Step 2/2: Stand back until full body is visible. Hold still for 3 seconds."
            b.switchCameraBtn.isVisible = true
            Snackbar.make(b.root, "✔ Phone orientation horizontal", Snackbar.LENGTH_SHORT).show()
            ttsCoach.enqueue("Phone orientation horizontal.", SpeechPriority.NORMAL)
            requestPermissionsAndBind()
            b.root.postDelayed(checkPoseRunnable, 200)
            return
        }
        b.statusChip.text = "Waiting for landscape..."
        b.root.removeCallbacks(checkOrientationRunnable)
        b.root.postDelayed(checkOrientationRunnable, 250)
    }

    private fun evaluateFullBodyStep() {
        val b = _binding ?: return
        if (isCalibrationCompleted || currentStep != Step.FULL_BODY) return

        val now = System.currentTimeMillis()
        val hasFullBody = isFullBodyInFrame(latestLandmarks)
        if (hasFullBody) lastFullBodySeenAt = now
        val validWithGrace = hasFullBody || (now - lastFullBodySeenAt) <= 700L

        if (validWithGrace) {
            b.silhouette.background?.mutate()?.setTint(Color.parseColor("#AA1EB980"))
            if (holdStartAt == 0L) {
                holdStartAt = now
            }
            val holdMs = now - holdStartAt
            val remaining = (((3000L - holdMs).coerceAtLeast(0L) + 999L) / 1000L).toInt()
            val msg = "Perfect! Hold that position... ${remaining}s"
            b.promptText.text = msg
            if (bodyState != BodyState.HOLDING) {
                ttsCoach.enqueue("Perfect. Hold that position.", SpeechPriority.AMBIENT)
                bodyState = BodyState.HOLDING
            }
            if (holdMs >= 3000) {
                onCalibrationReady()
                return
            }
        } else {
            holdStartAt = 0L
            b.silhouette.background?.mutate()?.setTint(Color.parseColor("#99FFFFFF"))
            val msg = "Step back to fit your full body in the frame."
            b.promptText.text = msg
            if (bodyState != BodyState.SEARCHING) {
                ttsCoach.enqueue(msg, SpeechPriority.NORMAL)
                bodyState = BodyState.SEARCHING
            }
        }
        b.statusChip.text = "Step 2/2: Detecting full body..."
        b.root.removeCallbacks(checkPoseRunnable)
        b.root.postDelayed(checkPoseRunnable, 200)
    }

    private fun isFullBodyInFrame(points: List<OverlayPoint>): Boolean {
        if (points.size <= 28) return false
        val required = listOf(0, 11, 12, 23, 24, 27, 28)
        val minScore = 0.55f
        val edge = 0.03f
        return required.all { index ->
            val p = points[index]
            p.score >= minScore &&
                p.x in edge..(1f - edge) &&
                p.y in edge..(1f - edge)
        }
    }

    private fun onCalibrationReady() {
        val b = _binding ?: return
        isCalibrationCompleted = true
        currentStep = Step.READY
        b.root.removeCallbacks(checkPoseRunnable)
        b.statusChip.text = "✔ Ready for Exercise"
        b.promptText.text = "Calibration complete. Starting workout setup..."
        ttsCoach.enqueue("Ready for exercise.", SpeechPriority.CRITICAL)
        Snackbar.make(b.root, "✔ Ready for Exercise", Snackbar.LENGTH_SHORT).show()
        b.root.postDelayed({
            if (isAdded) {
                findNavController().navigate(
                    R.id.action_calibration_to_recording,
                    bundleOf("use_front_camera" to useFrontCamera)
                )
            }
        }, 450)
    }

    private fun isLandscapeNow(): Boolean {
        val b = _binding ?: return false
        val byDimensions = b.root.width > b.root.height && b.root.width > 0 && b.root.height > 0
        if (byDimensions) return true
        return resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    }

    private fun setKeepScreenAwake(enabled: Boolean) {
        _binding?.root?.keepScreenOn = enabled
        _binding?.previewView?.keepScreenOn = enabled
        if (enabled) {
            requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        } else {
            requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }
    }

    override fun onResume() {
        super.onResume()
        setKeepScreenAwake(true)
    }

    override fun onPause() {
        setKeepScreenAwake(false)
        super.onPause()
    }

    override fun onDestroyView() {
        _binding?.root?.removeCallbacks(checkOrientationRunnable)
        _binding?.root?.removeCallbacks(checkPoseRunnable)
        setKeepScreenAwake(false)
        cameraController?.release()
        cameraController = null
        _binding = null
        super.onDestroyView()
    }
}
