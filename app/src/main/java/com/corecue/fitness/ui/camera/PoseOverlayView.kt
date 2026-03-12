package com.corecue.fitness.ui.camera

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.max

data class OverlayPoint(
    val x: Float,
    val y: Float,
    val score: Float
)

class PoseOverlayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val pointPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#89F2F0")
        style = Paint.Style.FILL
    }
    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#7FD7FF")
        strokeWidth = 5f
        style = Paint.Style.STROKE
    }
    private val shadowPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#33253066")
        strokeWidth = 12f
        style = Paint.Style.STROKE
    }

    private var points: List<OverlayPoint> = emptyList()

    private val edges = listOf(
        11 to 12, 11 to 13, 13 to 15, 12 to 14, 14 to 16,
        11 to 23, 12 to 24, 23 to 24, 23 to 25, 25 to 27,
        24 to 26, 26 to 28
    )

    fun updateLandmarks(landmarks: List<OverlayPoint>) {
        points = landmarks
        postInvalidateOnAnimation()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (points.isEmpty()) return
        val radius = max(4f, width * 0.007f)

        for ((start, end) in edges) {
            if (start >= points.size || end >= points.size) continue
            val p1 = points[start]
            val p2 = points[end]
            if (p1.score < 0.3f || p2.score < 0.3f) continue
            canvas.drawLine(p1.x * width, p1.y * height, p2.x * width, p2.y * height, shadowPaint)
            canvas.drawLine(p1.x * width, p1.y * height, p2.x * width, p2.y * height, linePaint)
        }

        points.forEach { p ->
            if (p.score < 0.3f) return@forEach
            canvas.drawCircle(p.x * width, p.y * height, radius, pointPaint)
        }
    }
}
