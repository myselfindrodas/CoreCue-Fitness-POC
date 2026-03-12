package com.corecue.fitness.ui.camera

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Matrix
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mediapipe.framework.image.BitmapImageBuilder
import com.google.mediapipe.tasks.components.containers.NormalizedLandmark
import com.google.mediapipe.tasks.core.BaseOptions
import com.google.mediapipe.tasks.vision.core.RunningMode
import com.google.mediapipe.tasks.vision.poselandmarker.PoseLandmarker
import com.google.mediapipe.tasks.vision.poselandmarker.PoseLandmarkerResult

class PoseLandmarkerAnalyzer(
    context: Context,
    private val onLandmarks: (List<OverlayPoint>) -> Unit,
    private val onPoseSignal: (Boolean, Float) -> Unit
) : ImageAnalysis.Analyzer {

    private var landmarker: PoseLandmarker? = null

    init {
        createLandmarker(context)
    }

    private fun createLandmarker(context: Context) {
        try {
            val baseOptions = BaseOptions.builder()
                .setModelAssetPath("pose_landmarker_lite.task")
                .build()

            val options = PoseLandmarker.PoseLandmarkerOptions.builder()
                .setBaseOptions(baseOptions)
                .setRunningMode(RunningMode.IMAGE)
                .setNumPoses(1)
                .setMinPoseDetectionConfidence(0.5f)
                .setMinTrackingConfidence(0.5f)
                .setMinPosePresenceConfidence(0.5f)
                .build()
            landmarker = PoseLandmarker.createFromOptions(context, options)
        } catch (_: Exception) {
            landmarker = null
        }
    }

    override fun analyze(image: ImageProxy) {
        val bitmap = image.toBitmap()
        val result = detect(bitmap, image.imageInfo.rotationDegrees)
        onLandmarks(result.first)
        onPoseSignal(result.second, result.third)
        image.close()
    }

    private fun detect(bitmap: Bitmap, rotationDegrees: Int): Triple<List<OverlayPoint>, Boolean, Float> {
        val oriented = if (rotationDegrees == 0) bitmap else {
            val matrix = Matrix().apply { postRotate(rotationDegrees.toFloat()) }
            Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
        }
        val detector = landmarker
        if (detector == null) return Triple(emptyList(), true, -1f)

        val mpImage = BitmapImageBuilder(oriented).build()
        val output: PoseLandmarkerResult = detector.detect(mpImage)
        val pose = output.landmarks().firstOrNull() ?: return Triple(emptyList(), false, 0f)
        val points = pose.map { it.toOverlayPoint() }

        val visibilityAvg = points.map { it.score }.average().toFloat()
        val bodyVisible = points.size >= 29 && visibilityAvg > 0.45f
        return Triple(points, bodyVisible, visibilityAvg)
    }

    private fun NormalizedLandmark.toOverlayPoint(): OverlayPoint {
        return OverlayPoint(x(), y(), visibility().orElse(0.7f))
    }

    fun close() {
        landmarker?.close()
    }
}
