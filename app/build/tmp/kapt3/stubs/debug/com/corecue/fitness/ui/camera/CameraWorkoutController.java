package com.corecue.fitness.ui.camera;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JT\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u00110\u00192\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00110\u001dJ\u0006\u0010\u001f\u001a\u00020\u0011J*\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00172\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00110\u0019J\u0006\u0010&\u001a\u00020\u0011R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/corecue/fitness/ui/camera/CameraWorkoutController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "analyzer", "Lcom/corecue/fitness/ui/camera/PoseLandmarkerAnalyzer;", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "recording", "Landroidx/camera/video/Recording;", "videoCapture", "Landroidx/camera/video/VideoCapture;", "Landroidx/camera/video/Recorder;", "bind", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "previewView", "Landroidx/camera/view/PreviewView;", "useFrontCamera", "", "onLandmarks", "Lkotlin/Function1;", "", "Lcom/corecue/fitness/ui/camera/OverlayPoint;", "onPoseSignal", "Lkotlin/Function2;", "", "release", "startRecording", "outputFile", "Ljava/io/File;", "withAudio", "onEvent", "Landroidx/camera/video/VideoRecordEvent;", "stopRecording", "app_debug"})
public final class CameraWorkoutController {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ExecutorService cameraExecutor = null;
    @org.jetbrains.annotations.Nullable()
    private androidx.camera.lifecycle.ProcessCameraProvider cameraProvider;
    @org.jetbrains.annotations.Nullable()
    private androidx.camera.video.VideoCapture<androidx.camera.video.Recorder> videoCapture;
    @org.jetbrains.annotations.Nullable()
    private androidx.camera.video.Recording recording;
    @org.jetbrains.annotations.Nullable()
    private com.corecue.fitness.ui.camera.PoseLandmarkerAnalyzer analyzer;
    
    public CameraWorkoutController(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void bind(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner lifecycleOwner, @org.jetbrains.annotations.NotNull()
    androidx.camera.view.PreviewView previewView, boolean useFrontCamera, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.corecue.fitness.ui.camera.OverlayPoint>, kotlin.Unit> onLandmarks, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Float, kotlin.Unit> onPoseSignal) {
    }
    
    public final void startRecording(@org.jetbrains.annotations.NotNull()
    java.io.File outputFile, boolean withAudio, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super androidx.camera.video.VideoRecordEvent, kotlin.Unit> onEvent) {
    }
    
    public final void stopRecording() {
    }
    
    public final void release() {
    }
}