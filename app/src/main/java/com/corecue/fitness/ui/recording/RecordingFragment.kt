package com.corecue.fitness.ui.recording

import android.Manifest
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.OvershootInterpolator
import android.view.animation.AnimationUtils
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.video.VideoRecordEvent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.corecue.fitness.R
import com.corecue.fitness.audio.SpeechPriority
import com.corecue.fitness.audio.TtsCoach
import com.corecue.fitness.databinding.FragmentRecordingBinding
import com.corecue.fitness.ui.camera.CameraWorkoutController
import com.corecue.fitness.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import javax.inject.Inject

@AndroidEntryPoint
class RecordingFragment : Fragment(R.layout.fragment_recording) {
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
    private var useFrontCamera = true
    private var workoutStarted = false

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

        binding.pauseBtn.setOnClickListener {
            stopWorkoutTimer()
            cameraController?.stopRecording()
            ttsCoach.enqueue("Workout paused.", SpeechPriority.NORMAL)
        }
        binding.stopBtn.setOnClickListener {
            stopWorkoutTimer()
            cameraController?.stopRecording()
            ttsCoach.enqueue("Workout stopped.", SpeechPriority.CRITICAL)
        }
        binding.submitBtn.setOnClickListener {
            cameraController?.stopRecording()
            viewModel.loadReport()
            findNavController().navigate(R.id.action_recording_to_report)
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
        val switchInitialTop = (binding.switchCameraBtn.layoutParams as android.view.ViewGroup.MarginLayoutParams).topMargin
        val controlsInitialBottom = (binding.controls.layoutParams as android.view.ViewGroup.MarginLayoutParams).bottomMargin

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.topMetrics.updateLayoutParams<android.view.ViewGroup.MarginLayoutParams> {
                topMargin = topInitial + bars.top
            }
            binding.switchCameraBtn.updateLayoutParams<android.view.ViewGroup.MarginLayoutParams> {
                topMargin = switchInitialTop + bars.top
            }
            binding.controls.updateLayoutParams<android.view.ViewGroup.MarginLayoutParams> {
                bottomMargin = controlsInitialBottom + bars.bottom
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
        if (missing.isEmpty()) bindCameraAndStart() else permissionLauncher.launch(missing.toTypedArray())
    }

    private fun requiredPermissions(): List<String> {
        return buildList {
            add(Manifest.permission.CAMERA)
            add(Manifest.permission.RECORD_AUDIO)
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }
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
                _binding?.poseOverlay?.updateLandmarks(points)
            },
            onPoseSignal = { bodyVisible, score ->
                postureVisible = bodyVisible
                poseScore = score
            }
        )
    }

    private fun startCountdownThenRecording() {
        workoutStarted = true
        binding.countdownText.isVisible = true
        countdownTimer = object : CountDownTimer(5000, 1000) {
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
                    repCount += 1
                    binding.repCounter.text = "Rep $repCount / 10"
                    if (!postureVisible && poseScore >= 0f) {
                        ttsCoach.enqueue(
                            "I cannot see your full posture clearly. Please re-center.",
                            SpeechPriority.CRITICAL
                        )
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
                    viewModel.loadReport()
                    findNavController().navigate(R.id.action_recording_to_report)
                }
            }

            override fun onFinish() {
                cameraController?.stopRecording()
                viewModel.loadReport()
                findNavController().navigate(R.id.action_recording_to_report)
            }
        }.start()
    }

    private fun stopWorkoutTimer() {
        workoutTimer?.cancel()
    }

    override fun onDestroyView() {
        countdownTimer?.cancel()
        stopWorkoutTimer()
        workoutStarted = false
        cameraController?.release()
        cameraController = null
        _binding = null
        super.onDestroyView()
    }
}
