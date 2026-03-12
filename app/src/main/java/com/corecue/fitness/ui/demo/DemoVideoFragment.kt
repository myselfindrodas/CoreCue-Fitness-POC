package com.corecue.fitness.ui.demo

import android.os.Bundle
import android.view.View
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
    private var player: ExoPlayer? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDemoVideoBinding.bind(view)
        initPlayer()

        binding.skipBtn.setOnClickListener {
            findNavController().navigate(R.id.action_demo_to_recording)
        }
        binding.startRecordingBtn.setOnClickListener {
            findNavController().navigate(R.id.action_demo_to_recording)
        }
        binding.watchAgainBtn.setOnClickListener {
            player?.seekTo(0)
            player?.playWhenReady = true
        }
    }

    private fun initPlayer() {
        val exercise = viewModel.selectedExercise.value
        val mediaUrl = exercise?.youtubeUrl ?: "https://www.youtube.com/watch?v=R36fJxA4G1U"
        ttsCoach.pauseForVideo()
        player = ExoPlayer.Builder(requireContext()).build().also { exo ->
            binding.playerView.player = exo
            exo.setMediaItem(MediaItem.fromUri(mediaUrl))
            exo.prepare()
            exo.playWhenReady = true
        }
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
