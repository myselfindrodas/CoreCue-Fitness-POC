package com.corecue.fitness.ui.camera;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\bJ\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J0\u0010\u0016\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\f\u0010\u001c\u001a\u00020\u0007*\u00020\u001dH\u0002R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/corecue/fitness/ui/camera/PoseLandmarkerAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "context", "Landroid/content/Context;", "onLandmarks", "Lkotlin/Function1;", "", "Lcom/corecue/fitness/ui/camera/OverlayPoint;", "", "onPoseSignal", "Lkotlin/Function2;", "", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "isClosed", "landmarker", "Lcom/google/mediapipe/tasks/vision/poselandmarker/PoseLandmarker;", "analyze", "image", "Landroidx/camera/core/ImageProxy;", "close", "createLandmarker", "detect", "Lkotlin/Triple;", "bitmap", "Landroid/graphics/Bitmap;", "rotationDegrees", "", "toOverlayPoint", "Lcom/google/mediapipe/tasks/components/containers/NormalizedLandmark;", "app_debug"})
public final class PoseLandmarkerAnalyzer implements androidx.camera.core.ImageAnalysis.Analyzer {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.util.List<com.corecue.fitness.ui.camera.OverlayPoint>, kotlin.Unit> onLandmarks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<java.lang.Boolean, java.lang.Float, kotlin.Unit> onPoseSignal = null;
    @org.jetbrains.annotations.Nullable()
    private com.google.mediapipe.tasks.vision.poselandmarker.PoseLandmarker landmarker;
    @kotlin.jvm.Volatile()
    private volatile boolean isClosed = false;
    
    public PoseLandmarkerAnalyzer(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.corecue.fitness.ui.camera.OverlayPoint>, kotlin.Unit> onLandmarks, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Float, kotlin.Unit> onPoseSignal) {
        super();
    }
    
    private final void createLandmarker(android.content.Context context) {
    }
    
    @java.lang.Override()
    public void analyze(@org.jetbrains.annotations.NotNull()
    androidx.camera.core.ImageProxy image) {
    }
    
    private final kotlin.Triple<java.util.List<com.corecue.fitness.ui.camera.OverlayPoint>, java.lang.Boolean, java.lang.Float> detect(android.graphics.Bitmap bitmap, int rotationDegrees) {
        return null;
    }
    
    private final com.corecue.fitness.ui.camera.OverlayPoint toOverlayPoint(com.google.mediapipe.tasks.components.containers.NormalizedLandmark $this$toOverlayPoint) {
        return null;
    }
    
    public final void close() {
    }
}