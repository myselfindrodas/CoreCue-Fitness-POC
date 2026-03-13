package com.corecue.fitness.ui.camera

import android.content.Context
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.video.FileOutputOptions
import androidx.camera.video.PendingRecording
import androidx.camera.video.Quality
import androidx.camera.video.QualitySelector
import androidx.camera.video.Recorder
import androidx.camera.video.Recording
import androidx.camera.video.VideoCapture
import androidx.camera.video.VideoRecordEvent
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CameraWorkoutController(
    private val context: Context
) {
    private val cameraExecutor: ExecutorService = Executors.newSingleThreadExecutor()
    private var cameraProvider: ProcessCameraProvider? = null
    private var videoCapture: VideoCapture<Recorder>? = null
    private var recording: Recording? = null
    private var analyzer: PoseLandmarkerAnalyzer? = null

    fun bind(
        lifecycleOwner: LifecycleOwner,
        previewView: PreviewView,
        useFrontCamera: Boolean = true,
        onLandmarks: (List<OverlayPoint>) -> Unit,
        onPoseSignal: (Boolean, Float) -> Unit
    ) {
        val providerFuture = ProcessCameraProvider.getInstance(context)
        providerFuture.addListener({
            cameraProvider = providerFuture.get()
            val preview = Preview.Builder().build().also {
                it.surfaceProvider = previewView.surfaceProvider
            }
            val recorder = Recorder.Builder()
                .setQualitySelector(QualitySelector.from(Quality.HD))
                .build()
            videoCapture = VideoCapture.withOutput(recorder)

            cameraProvider?.unbindAll()
            analyzer?.close()
            analyzer = PoseLandmarkerAnalyzer(context, onLandmarks, onPoseSignal)
            val analysis = ImageAnalysis.Builder()
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build().also {
                    it.setAnalyzer(cameraExecutor, analyzer!!)
                }

            val selector = if (useFrontCamera) CameraSelector.DEFAULT_FRONT_CAMERA
            else CameraSelector.DEFAULT_BACK_CAMERA

            cameraProvider?.bindToLifecycle(
                lifecycleOwner,
                selector,
                preview,
                analysis,
                videoCapture
            )
        }, ContextCompat.getMainExecutor(context))
    }

    fun startRecording(outputFile: File, withAudio: Boolean, onEvent: (VideoRecordEvent) -> Unit) {
        val capture = videoCapture ?: return
        val outputOptions = FileOutputOptions.Builder(outputFile).build()
        var pending: PendingRecording = capture.output.prepareRecording(context, outputOptions)
        if (withAudio) pending = pending.withAudioEnabled()
        recording = pending.start(ContextCompat.getMainExecutor(context), onEvent)
    }

    fun stopRecording() {
        recording?.stop()
        recording = null
    }

    fun release() {
        stopRecording()
        analyzer?.close()
        analyzer = null
        cameraProvider?.unbindAll()
        cameraExecutor.shutdown()
    }
}
