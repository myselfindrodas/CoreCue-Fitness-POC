package com.corecue.fitness.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class ExerciseEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val youtubeUrl: String,
    val thumbnailUrl: String,
    val durationSeconds: Int
)
