package com.corecue.fitness.ui.demo

import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.fragment.findNavController
import com.corecue.fitness.R
import com.corecue.fitness.audio.TtsCoach
import com.corecue.fitness.databinding.FragmentDemoVideoBinding
import com.corecue.fitness.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DemoVideoFragment : Fragment(R.layout.fragment_demo_video) {
    private var _binding: FragmentDemoVideoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()
    @Inject lateinit var ttsCoach: TtsCoach
    private var lastUrl: String = ""
    private var insetsController: WindowInsetsControllerCompat? = null
    private var player: ExoPlayer? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDemoVideoBinding.bind(view)
        initDriveEmbed()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        insetsController = WindowInsetsControllerCompat(requireActivity().window, binding.root).apply {
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            hide(WindowInsetsCompat.Type.systemBars())
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            exitToPortrait()
            findNavController().navigateUp()
        }

        binding.skipBtn.setOnClickListener {
            exitToPortrait()
            findNavController().navigate(R.id.calibrationFragment)
        }
        binding.watchAgainBtn.setOnClickListener {
            player?.seekTo(0)
            player?.playWhenReady = true
        }
    }

    private fun initDriveEmbed() {
        val exercise = viewModel.selectedExercise.value
        val mediaUrl = when (exercise?.id) {
            "hamstring_pull" -> "https://drive.google.com/file/d/1uo3ILa9umJCGq55nR7qhT_YTidbvGhTl/view?t=8"
            "pelvic_curl" -> "https://drive.google.com/file/d/1kSH_Jfv4TlgIiTOimTHM2cqMqOxT9Bdl/view"
            "roll_like_ball" -> "https://drive.google.com/file/d/1peJElVsz_4HG28et8s8oeWkL_uMzqc9-/view?t=4"
            else -> exercise?.youtubeUrl.orEmpty()
        }
        ttsCoach.pauseForVideo()
        val url = toDriveStreamUrl(mediaUrl)
        lastUrl = url
        player = ExoPlayer.Builder(requireContext()).build().also { exo ->
            binding.playerView.player = exo
            exo.setMediaItem(MediaItem.fromUri(Uri.parse(url)))
            exo.prepare()
            exo.playWhenReady = true
        }
    }

    private fun toDriveStreamUrl(input: String): String {
        // Convert Drive share links to a direct download/stream URL playable by ExoPlayer.
        if (input.contains("uc?export=download")) return input
        val uri = runCatching { Uri.parse(input) }.getOrNull() ?: return input
        val path = uri.path.orEmpty()
        val fileId = Regex("/d/([^/]+)").find(path)?.groupValues?.getOrNull(1)
        if (!fileId.isNullOrBlank()) {
            return "https://drive.google.com/uc?export=download&id=$fileId"
        }
        val idFromQuery = uri.getQueryParameter("id")
        if (!idFromQuery.isNullOrBlank()) {
            return "https://drive.google.com/uc?export=download&id=$idFromQuery"
        }
        return input
    }

    private fun exitToPortrait() {
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        insetsController?.show(WindowInsetsCompat.Type.systemBars())
    }

    override fun onDestroyView() {
        exitToPortrait()
        player?.release()
        player = null
        insetsController = null
        _binding = null
        super.onDestroyView()
    }
}
