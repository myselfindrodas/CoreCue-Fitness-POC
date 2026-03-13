package com.corecue.fitness.ui.camera;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0012J\u0014\u0010\u0019\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\bR \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/corecue/fitness/ui/camera/PoseOverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "edges", "", "Lkotlin/Pair;", "", "linePaint", "Landroid/graphics/Paint;", "pointPaint", "points", "Lcom/corecue/fitness/ui/camera/OverlayPoint;", "shadowPaint", "showErrorPose", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setPoseErrorState", "enabled", "updateLandmarks", "landmarks", "app_debug"})
public final class PoseOverlayView extends android.view.View {
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint pointPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint linePaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint shadowPaint = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.corecue.fitness.ui.camera.OverlayPoint> points;
    private boolean showErrorPose = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<kotlin.Pair<java.lang.Integer, java.lang.Integer>> edges = null;
    
    @kotlin.jvm.JvmOverloads()
    public PoseOverlayView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public PoseOverlayView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public final void updateLandmarks(@org.jetbrains.annotations.NotNull()
    java.util.List<com.corecue.fitness.ui.camera.OverlayPoint> landmarks) {
    }
    
    public final void setPoseErrorState(boolean enabled) {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
}