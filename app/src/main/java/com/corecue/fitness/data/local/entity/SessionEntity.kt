package com.corecue.fitness.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sessions")
data class SessionEntity(
    @PrimaryKey val sessionId: String,
    val exerciseId: String,
    val timestamp: Long,
    val overallScore: Int,
    val firstHalfScore: Int,
    val secondHalfScore: Int,
    val postureStability: Float,
    val repScoresCsv: String
)
