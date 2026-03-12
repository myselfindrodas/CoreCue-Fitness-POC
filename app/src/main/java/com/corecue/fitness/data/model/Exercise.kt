package com.corecue.fitness.data.model

data class Exercise(
    val id: String,
    val name: String,
    val description: String,
    val youtubeUrl: String,
    val thumbnailUrl: String = "",
    val durationSeconds: Int = 90
)

data class IssueItem(
    val title: String,
    val fixHint: String,
    val severity: Int
)

data class WorkoutReport(
    val sessionId: String,
    val exerciseId: String,
    val overallScore: Int,
    val firstHalfScore: Int,
    val secondHalfScore: Int,
    val issues: List<IssueItem>,
    val bodyParts: List<Pair<String, Int>>,
    val repScores: List<Int>,
    val postureStability: Float
)
