package com.corecue.fitness.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.corecue.fitness.data.model.Exercise
import com.corecue.fitness.R
import com.corecue.fitness.databinding.ItemExerciseBinding

class ExerciseAdapter(
    private val onStart: (Exercise) -> Unit
) : RecyclerView.Adapter<ExerciseAdapter.ExerciseVH>() {

    private val items = mutableListOf<Exercise>()

    fun submitList(newItems: List<Exercise>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseVH {
        val binding = ItemExerciseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExerciseVH(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ExerciseVH, position: Int) {
        holder.bind(items[position])
    }

    inner class ExerciseVH(private val binding: ItemExerciseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Exercise) {
            binding.title.text = item.name
            binding.description.text = item.description
            val localIcon = when (item.id) {
                "pelvic_curl" -> R.drawable.ic_ex_pelvic
                "roll_like_ball" -> R.drawable.ic_ex_roll
                "hamstring_pull" -> R.drawable.ic_ex_hamstring
                else -> R.drawable.ic_illustration_pose
            }
            if (item.thumbnailUrl.isBlank()) {
                binding.thumb.setImageResource(localIcon)
            } else {
                Glide.with(binding.thumb)
                    .load(item.thumbnailUrl)
                    .placeholder(localIcon)
                    .error(localIcon)
                    .centerCrop()
                    .into(binding.thumb)
            }
            binding.startBtn.setOnClickListener { onStart(item) }
        }
    }
}
