package com.corecue.fitness.data.repo

import com.corecue.fitness.data.local.dao.ExerciseDao
import com.corecue.fitness.data.local.dao.SessionDao
import com.corecue.fitness.data.local.entity.ExerciseEntity
import com.corecue.fitness.data.local.entity.SessionEntity
import com.corecue.fitness.data.model.Exercise
import com.corecue.fitness.data.model.IssueItem
import com.corecue.fitness.data.model.SessionSummary
import com.corecue.fitness.data.model.SessionTrendPoint
import com.corecue.fitness.data.model.WorkoutReport
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class FitnessRepository @Inject constructor(
    private val exerciseDao: ExerciseDao,
    private val sessionDao: SessionDao
) {

    suspend fun seedIfNeeded() {
        if (exerciseDao.count() > 0) return
        exerciseDao.upsertAll(
            listOf(
                ExerciseEntity(
                    id = "pelvic_curl",
                    name = "Pelvic Curl",
                    description = "Improve spinal articulation and glute activation.",
                    youtubeUrl = "https://www.youtube.com/watch?v=R36fJxA4G1U",
                    thumbnailUrl = "https://img.youtube.com/vi/R36fJxA4G1U/hqdefault.jpg",
                    durationSeconds = 90
                ),
                ExerciseEntity(
                    id = "roll_like_ball",
                    name = "Roll Like a Ball",
                    description = "Build core control and smooth spinal mobility.",
                    youtubeUrl = "https://www.youtube.com/watch?v=2fP4Yf6M2mA",
                    thumbnailUrl = "https://img.youtube.com/vi/2fP4Yf6M2mA/hqdefault.jpg",
                    durationSeconds = 90
                ),
                ExerciseEntity(
                    id = "hamstring_pull",
                    name = "Hamstring Pull",
                    description = "Challenge hamstring flexibility and pelvic alignment.",
                    youtubeUrl = "https://www.youtube.com/watch?v=6_2Lx5i8m3A",
                    thumbnailUrl = "https://img.youtube.com/vi/6_2Lx5i8m3A/hqdefault.jpg",
                    durationSeconds = 90
                )
            )
        )
    }

    fun observeExercises(): Flow<List<Exercise>> {
        return exerciseDao.observeExercises().map { rows ->
            rows.map {
                Exercise(
                    id = it.id,
                    name = it.name,
                    description = it.description,
                    youtubeUrl = it.youtubeUrl,
                    thumbnailUrl = it.thumbnailUrl,
                    durationSeconds = it.durationSeconds
                )
            }
        }
    }

    suspend fun generateAndStoreReport(exercise: Exercise?): WorkoutReport {
        delay(500)
        val repScores = List(10) { Random.nextInt(60, 91) }
        val first = repScores.take(5).average().toInt()
        val second = repScores.takeLast(5).average().toInt()
        val overall = repScores.average().toInt()
        val report = WorkoutReport(
            sessionId = "S-${System.currentTimeMillis()}",
            exerciseId = exercise?.id ?: "unknown",
            overallScore = overall,
            firstHalfScore = first,
            secondHalfScore = second,
            issues = listOf(
                IssueItem("Neck Alignment", "Keep chin slightly tucked and lengthen the neck.", 2),
                IssueItem("Hip Extension", "Lift hips 8-12% higher during peak bridge.", 3),
                IssueItem("Breath Rhythm", "Exhale fully on effort phase and hold tempo.", 1)
            ),
            bodyParts = listOf(
                "Shoulders" to 72,
                "Core" to (78 + Random.nextInt(0, 10)),
                "Hips" to 76,
                "Knees" to 81,
                "Ankles" to 79
            ),
            repScores = repScores,
            postureStability = (0.72f + Random.nextFloat() * 0.2f)
        )
        sessionDao.insertSession(
            SessionEntity(
                sessionId = report.sessionId,
                exerciseId = exercise?.name ?: "Session",
                timestamp = System.currentTimeMillis(),
                overallScore = report.overallScore,
                firstHalfScore = report.firstHalfScore,
                secondHalfScore = report.secondHalfScore,
                postureStability = report.postureStability,
                repScoresCsv = report.repScores.joinToString(",")
            )
        )
        return report
    }

    fun observeSessionSummaries(): Flow<List<SessionSummary>> {
        return sessionDao.observeRecentSessions().map { rows ->
            rows.map {
                SessionSummary(
                    sessionId = it.sessionId,
                    exerciseName = it.exerciseId,
                    score = it.overallScore,
                    timestamp = it.timestamp
                )
            }
        }
    }

    suspend fun getTrendPoints(): List<SessionTrendPoint> {
        return sessionDao.observeRecentSessions().first().take(10).reversed().mapIndexed { index, session ->
            SessionTrendPoint(label = "S${index + 1}", score = session.overallScore)
        }
    }
}
