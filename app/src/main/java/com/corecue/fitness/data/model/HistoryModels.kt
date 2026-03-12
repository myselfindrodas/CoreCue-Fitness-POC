package com.corecue.fitness.data.model

data class SessionTrendPoint(
    val label: String,
    val score: Int
)

data class SessionSummary(
    val sessionId: String,
    val exerciseName: String,
    val score: Int,
    val timestamp: Long
)
