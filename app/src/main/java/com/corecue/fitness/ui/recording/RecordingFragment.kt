package com.corecue.fitness.ui.recording

import android.Manifest
import android.content.pm.ActivityInfo
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.HapticFeedbackConstants
import android.view.WindowManager
import android.view.animation.OvershootInterpolator
import android.view.animation.AnimationUtils
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.video.VideoRecordEvent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.corecue.fitness.R
import com.corecue.fitness.audio.SpeechPriority
import com.corecue.fitness.audio.TtsCoach
import com.corecue.fitness.databinding.FragmentRecordingBinding
import com.corecue.fitness.ui.camera.CameraWorkoutController
import com.corecue.fitness.ui.camera.OverlayPoint
import com.corecue.fitness.ui.main.MainViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import javax.inject.Inject

@AndroidEntryPoint
class RecordingFragment : Fragment(R.layout.fragment_recording) {
    companion object {
        private const val ARG_USE_FRONT_CAMERA = "use_front_camera"
        private const val MSG_REP_NOT_COUNTED = "Rep not counted. Fix posture and re-center."
    }

    private var _binding: FragmentRecordingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()
    @Inject lateinit var ttsCoach: TtsCoach
    private var cameraController: CameraWorkoutController? = null
    private var workoutTimer: CountDownTimer? = null
    private var countdownTimer: CountDownTimer? = null
    private var recordingFile: File? = null
    private var repCount = 0
    private var elapsed = 0
    private var postureVisible = false
    private var poseScore = 0f
    private var latestLandmarks: List<OverlayPoint> = emptyList()
    private var useFrontCamera = true
    private var workoutStarted = false
    private var lastInvalidRepPromptAt: Long = 0L
    private var invalidRepStreakAnnounced = false

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        if (requiredPermissions().all { p -> it[p] == true }) {
            bindCameraAndStart()
        } else {
            binding.feedbackCard.isVisible = true
            binding.feedbackText.text = "Camera and microphone permissions are required."
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRecordingBinding.bind(view)
        useFrontCamera = arguments?.getBoolean(ARG_USE_FRONT_CAMERA, true) ?: true
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        setKeepScreenAwake(true)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            showExitConfirmationDialog()
        }

        binding.pauseBtn.setOnClickListener {
            playControlTapFeedback(binding.pauseBtn)
            stopWorkoutTimer()
            cameraController?.stopRecording()
            ttsCoach.enqueue("Workout paused.", SpeechPriority.NORMAL)
        }
        binding.stopBtn.setOnClickListener {
            playControlTapFeedback(binding.stopBtn)
            stopWorkoutTimer()
            cameraController?.stopRecording()
            ttsCoach.enqueue("Workout stopped.", SpeechPriority.CRITICAL)
        }
        binding.submitBtn.setOnClickListener {
            playControlTapFeedback(binding.submitBtn)
            stopWorkoutTimer()
            cameraController?.stopRecording()
            navigateToReviewPortrait()
        }
        binding.switchCameraBtn.setOnClickListener {
            useFrontCamera = !useFrontCamera
            bindCameraOnly()
        }

        applyEdgeToEdgeInsets()
        requestPermissionsAndStart()
    }

    private fun applyEdgeToEdgeInsets() {
        val topInitial = (binding.topMetrics.layoutParams as android.view.ViewGroup.MarginLayoutParams).topMargin
        val topInitialStart = (binding.topMetrics.layoutParams as android.view.ViewGroup.MarginLayoutParams).marginStart
        val topInitialEnd = (binding.topMetrics.layoutParams as android.view.ViewGroup.MarginLayoutParams).marginEnd
        val switchInitialTop = (binding.switchCameraBtn.layoutParams as android.view.ViewGroup.MarginLayoutParams).topMargin
        val switchInitialEnd = (binding.switchCameraBtn.layoutParams as android.view.ViewGroup.MarginLayoutParams).marginEnd
        val controlsInitialBottom = (binding.controls.layoutParams as android.view.ViewGroup.MarginLayoutParams).bottomMargin
        val controlsInitialStart = (binding.controls.layoutParams as android.view.ViewGroup.MarginLayoutParams).marginStart
        val controlsInitialEnd = (binding.controls.layoutParams as android.view.ViewGroup.MarginLayoutParams).marginEnd

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.topMetrics.updateLayoutParams<android.view.ViewGroup.MarginLayoutParams> {
                topMargin = topInitial + bars.top
                marginStart = topInitialStart + bars.left
                marginEnd = topInitialEnd + bars.right
            }
            binding.switchCameraBtn.updateLayoutParams<android.view.ViewGroup.MarginLayoutParams> {
                topMargin = switchInitialTop + bars.top
                marginEnd = switchInitialEnd + bars.right
            }
            binding.controls.updateLayoutParams<android.view.ViewGroup.MarginLayoutParams> {
                bottomMargin = controlsInitialBottom + bars.bottom
                marginStart = controlsInitialStart + bars.left
                marginEnd = controlsInitialEnd + bars.right
            }
            insets
        }
    }

    private fun requestPermissionsAndStart() {
        val missing = requiredPermissions().filter {
            androidx.core.content.ContextCompat.checkSelfPermission(
                requireContext(),
                it
            ) != android.content.pm.PackageManager.PERMISSION_GRANTED
        }
        if (missing.isEmpty()) {
            bindCameraAndStart()
        } else {
            binding.feedbackCard.isVisible = true
            binding.feedbackText.text = "Permissions are required. Please allow camera and microphone in splash."
        }
    }

    private fun requiredPermissions(): List<String> {
        return listOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
        )
    }

    private fun bindCameraAndStart() {
        bindCameraOnly()
        if (!workoutStarted) startCountdownThenRecording()
    }

    private fun bindCameraOnly() {
        if (cameraController == null) cameraController = CameraWorkoutController(requireContext())
        cameraController?.bind(
            lifecycleOwner = viewLifecycleOwner,
            previewView = binding.previewView,
            useFrontCamera = useFrontCamera,
            onLandmarks = { points ->
                latestLandmarks = points
                _binding?.poseOverlay?.updateLandmarks(points)
                _binding?.poseOverlay?.setPoseErrorState(!isRepPostureValid())
            },
            onPoseSignal = { bodyVisible, score ->
                postureVisible = bodyVisible
                poseScore = score
                val repPostureValidNow = isRepPostureValid()
                _binding?.poseOverlay?.setPoseErrorState(!repPostureValidNow)
                if (repPostureValidNow) {
                    invalidRepStreakAnnounced = false
                    val b = _binding
                    if (b != null &&
                        b.feedbackCard.isVisible &&
                        b.feedbackText.text.toString() == MSG_REP_NOT_COUNTED
                    ) {
                        b.feedbackCard.isVisible = false
                    }
                }
            }
        )
    }

    private fun startCountdownThenRecording() {
        workoutStarted = true
        binding.countdownText.isVisible = true
        countdownTimer = object : CountDownTimer(3000, 1000) {
            override fun onTick(ms: Long) {
                val value = (ms / 1000).toInt() + 1
                binding.countdownText.text = value.toString()
                animateCountdownText()
                ttsCoach.enqueue(value.toString(), SpeechPriority.AMBIENT)
            }

            override fun onFinish() {
                binding.countdownText.isVisible = false
                startVideoRecording()
                startWorkoutTimer()
            }
        }.start()
    }

    private fun startVideoRecording() {
        val file = File(requireContext().cacheDir, "session_${System.currentTimeMillis()}.mp4")
        recordingFile = file
        cameraController?.startRecording(
            outputFile = file,
            withAudio = true
        ) { event ->
            when (event) {
                is VideoRecordEvent.Start -> {
                    ttsCoach.enqueue("Start moving now.", SpeechPriority.CRITICAL)
                }
                is VideoRecordEvent.Finalize -> {
                    if (event.hasError()) {
                        binding.feedbackCard.isVisible = true
                        binding.feedbackText.text = "Recording failed: ${event.error}"
                    }
                }
            }
        }
    }

    private fun animateCountdownText() {
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            binding.countdownText,
            PropertyValuesHolder.ofFloat(View.SCALE_X, 0.5f, 1.2f, 1f),
            PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.5f, 1.2f, 1f),
            PropertyValuesHolder.ofFloat(View.ALPHA, 0.3f, 1f)
        )
        animator.duration = 650
        animator.interpolator = OvershootInterpolator()
        animator.start()
    }

    private fun startWorkoutTimer() {
        workoutTimer = object : CountDownTimer(90000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                elapsed += 1
                binding.timerText.text = "00:${elapsed.toString().padStart(2, '0')}"
                if (elapsed % 8 == 0 && repCount < 10) {
                    val repValid = isRepPostureValid()
                    if (repValid) {
                        repCount += 1
                        binding.repCounter.text = "Rep $repCount / 10"
                        ttsCoach.enqueue("Good. ${repCountToWords(repCount)}.", SpeechPriority.NORMAL)
                        if (binding.feedbackCard.isVisible &&
                            binding.feedbackText.text.toString() == MSG_REP_NOT_COUNTED
                        ) {
                            binding.feedbackCard.isVisible = false
                        }
                    } else {
                        binding.feedbackCard.isVisible = true
                        binding.feedbackText.text = MSG_REP_NOT_COUNTED
                        val now = System.currentTimeMillis()
                        if (!invalidRepStreakAnnounced || now - lastInvalidRepPromptAt > 12000L) {
                            ttsCoach.enqueue(
                                "Rep not counted. I cannot see your full posture clearly. Please re-center.",
                                SpeechPriority.CRITICAL
                            )
                            lastInvalidRepPromptAt = now
                            invalidRepStreakAnnounced = true
                        }
                    }
                    if (repCount == 5) {
                        binding.feedbackCard.isVisible = true
                        binding.feedbackText.text = "Great pace. Lift hips slightly higher for better alignment."
                        binding.feedbackCard.startAnimation(
                            AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up_fade)
                        )
                        ttsCoach.enqueue("Great job. Lift hips slightly higher for alignment.", SpeechPriority.NORMAL)
                    }
                }
                if (repCount >= 10) {
                    cancel()
                    cameraController?.stopRecording()
                    navigateToReviewPortrait()
                }
            }

            override fun onFinish() {
                if (repCount >= 10) {
                    cameraController?.stopRecording()
                    navigateToReviewPortrait()
                } else {
                    binding.feedbackCard.isVisible = true
                    binding.feedbackText.text = "Workout still ongoing. Complete all 10 reps."
                    ttsCoach.enqueue("Keep going. Complete ten reps.", SpeechPriority.NORMAL)
                    startWorkoutTimer()
                }
            }
        }.start()
    }

    private fun showExitConfirmationDialog() {
        if (!isAdded) return
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Exit workout?")
            .setMessage("If you go back now, your recorded footage will be lost.")
            .setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
            .setPositiveButton("Yes") { _, _ ->
                stopWorkoutTimer()
                countdownTimer?.cancel()
                cameraController?.stopRecording()
                recordingFile?.let { file ->
                    if (file.exists()) file.delete()
                }
                navigateHomePortrait()
            }
            .show()
    }

    private fun navigateToReportPortrait() {
        if (!isAdded) return
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        findNavController().navigate(R.id.action_recording_to_report)
    }

    private fun navigateToReviewPortrait() {
        if (!isAdded) return
        val filePath = recordingFile?.absolutePath.orEmpty()
        if (filePath.isBlank()) {
            binding.feedbackCard.isVisible = true
            binding.feedbackText.text = "No recorded video found. Please retake."
            return
        }
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        findNavController().navigate(
            R.id.action_recording_to_review,
            bundleOf("recorded_video_path" to filePath)
        )
    }

    private fun navigateHomePortrait() {
        if (!isAdded) return
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val navController = findNavController()
        val poppedToHome = navController.popBackStack(R.id.homeFragment, false)
        if (!poppedToHome) {
            navController.navigate(
                R.id.homeFragment,
                null,
                NavOptions.Builder()
                    .setLaunchSingleTop(true)
                    .build()
            )
        }
    }

    private fun isRepPostureValid(): Boolean {
        if (poseScore < 0f) return true
        if (postureVisible) return true
        if (poseScore >= 0.32f) return true
        return hasRequiredRepLandmarks(latestLandmarks)
    }

    private fun hasRequiredRepLandmarks(points: List<OverlayPoint>): Boolean {
        if (points.size <= 28) return false
        val required = listOf(11, 12, 23, 24, 27, 28)
        return required.all { index ->
            val p = points[index]
            p.score >= 0.28f && p.x in 0.01f..0.99f && p.y in 0.01f..0.99f
        }
    }

    private fun repCountToWords(rep: Int): String {
        return when (rep) {
            1 -> "one"
            2 -> "two"
            3 -> "three"
            4 -> "four"
            5 -> "five"
            6 -> "six"
            7 -> "seven"
            8 -> "eight"
            9 -> "nine"
            10 -> "ten"
            else -> rep.toString()
        }
    }

    private fun playControlTapFeedback(target: View) {
        target.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP)
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            target,
            PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, 0.9f, 1f),
            PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f, 0.9f, 1f)
        )
        animator.duration = 150
        animator.start()
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

    private fun stopWorkoutTimer() {
        workoutTimer?.cancel()
    }

    override fun onDestroyView() {
        countdownTimer?.cancel()
        stopWorkoutTimer()
        workoutStarted = false
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setKeepScreenAwake(false)
        cameraController?.release()
        cameraController = null
        _binding = null
        super.onDestroyView()
    }
}
