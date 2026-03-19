package com.corecue.fitness.ui.review

import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.corecue.fitness.R
import com.corecue.fitness.databinding.FragmentReviewVideoBinding
import com.corecue.fitness.ui.main.MainViewModel
import java.io.File

class ReviewVideoFragment : Fragment(R.layout.fragment_review_video) {
    companion object {
        private const val ARG_VIDEO_PATH = "recorded_video_path"
    }

    private var _binding: FragmentReviewVideoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()
    private var player: ExoPlayer? = null
    private var recordedFile: File? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentReviewVideoBinding.bind(view)
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            navigateToCalibrationAndDiscardVideo()
        }
        val path = arguments?.getString(ARG_VIDEO_PATH).orEmpty()
        if (path.isBlank()) {
            findNavController().navigate(R.id.homeFragment)
            return
        }
        recordedFile = File(path)
        initPlayer(recordedFile!!)

        binding.retakeBtn.setOnClickListener { navigateToCalibrationAndDiscardVideo() }
        binding.submitBtn.setOnClickListener {
            requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            viewModel.loadReport()
            findNavController().navigate(
                R.id.action_review_to_report,
                bundleOf(ARG_VIDEO_PATH to recordedFile?.absolutePath.orEmpty())
            )
        }
    }

    @UnstableApi
    private fun initPlayer(file: File) {
        player = ExoPlayer.Builder(requireContext()).build().also { exo ->
            binding.playerView.player = exo
            exo.setMediaItem(MediaItem.fromUri(Uri.fromFile(file)))
            exo.seekTo(0L)
            exo.repeatMode = Player.REPEAT_MODE_OFF
            exo.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            exo.prepare()
            exo.playWhenReady = true
            exo.play()
        }
    }

    private fun navigateToCalibrationAndDiscardVideo() {
        player?.pause()
        recordedFile?.let { file ->
            if (file.exists()) file.delete()
        }
        findNavController().navigate(
            R.id.action_review_to_calibration,
            null,
            NavOptions.Builder()
                .setPopUpTo(R.id.reviewVideoFragment, true)
                .setLaunchSingleTop(true)
                .build()
        )
    }

    override fun onStart() {
        super.onStart()
        player?.playWhenReady = true
        player?.play()
    }

    override fun onStop() {
        player?.pause()
        super.onStop()
    }

    override fun onDestroyView() {
        player?.release()
        player = null
        _binding = null
        super.onDestroyView()
    }
}
