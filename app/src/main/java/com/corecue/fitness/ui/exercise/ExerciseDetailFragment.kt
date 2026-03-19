package com.corecue.fitness.ui.exercise

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.corecue.fitness.R
import com.corecue.fitness.databinding.FragmentExerciseDetailBinding
import com.corecue.fitness.ui.main.MainViewModel
import kotlinx.coroutines.launch

class ExerciseDetailFragment : Fragment(R.layout.fragment_exercise_detail) {
    private var _binding: FragmentExerciseDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentExerciseDetailBinding.bind(view)

        binding.playDemoBtn.setOnClickListener {
            findNavController().navigate(R.id.action_exerciseDetail_to_demo)
        }
        binding.startCalibrationBtn.setOnClickListener {
            findNavController().navigate(R.id.action_exerciseDetail_to_calibration)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.selectedExercise.collect { exercise ->
                if (exercise == null) {
                    findNavController().navigateUp()
                    return@collect
                }
                binding.title.text = exercise.name
                binding.description.text = exercise.description
                binding.exerciseImage.setImageResource(exerciseImageFor(exercise.id))
                binding.criteria.text = buildCriteriaText(exercise.id)
            }
        }
    }

    private fun exerciseImageFor(exerciseId: String): Int {
        return when (exerciseId) {
            "pelvic_curl" -> R.drawable.ic_ex_pelvic
            "roll_like_ball" -> R.drawable.ic_ex_roll
            "hamstring_pull" -> R.drawable.ic_ex_hamstring
            else -> R.drawable.ic_illustration_pose
        }
    }

    private fun buildCriteriaText(exerciseId: String): String {
        return when (exerciseId) {
            "hamstring_pull" -> """
1) Spine floor contact (5% error margin)
   • Tailbone, lower back, mid spine, and top spine
   • Up to the bottom of the shoulder should stay on floor

2) Resting toe direction (5% error margin)
   • Toe resting on floor should be parallel to ground
            """.trim()
            "pelvic_curl" -> """
1) Floor contact baseline (essentially 0 degree)
   • Back of head, back of shoulders, rib cage, tailbone, glutes, feet touching floor
   • Toes, heel, and ball of foot touching floor

2) Lumbar spacing
   • Lower back around 10 degrees away from floor
   • Palm-space check under lower back is acceptable

3) Alignment line (4% error margin)
   • Toes inline with heels
   • Heels inline with knees
   • Knees inline with hips
            """.trim()
            "roll_like_ball" -> """
1) Floor and curve setup
   • Back of head, back of shoulders, rib cage, tailbone, glutes, feet touching floor
   • Toes, heel, and ball of foot touching floor
   • Lumbar spine around 5 degrees away from floor
   • Keep back in a smooth curve

2) Shin to eye-line angle
   • Shin around 30 degrees from straight eye line

3) Toe position
   • Toes lifted high in the air

4) Shin to floor angle
   • Shin around 45 degrees to the floor
            """.trim()
            else -> "No criteria available."
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}

