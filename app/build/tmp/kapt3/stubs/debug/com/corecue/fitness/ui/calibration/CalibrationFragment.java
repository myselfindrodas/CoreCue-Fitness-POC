package com.corecue.fitness.ui.calibration;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\tH\u0002J\b\u0010&\u001a\u00020\"H\u0016J\u001a\u0010\'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\"H\u0002J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110.H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/corecue/fitness/ui/calibration/CalibrationFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/corecue/fitness/databinding/FragmentCalibrationBinding;", "binding", "getBinding", "()Lcom/corecue/fitness/databinding/FragmentCalibrationBinding;", "bodyOk", "", "bodyVisible", "cameraController", "Lcom/corecue/fitness/ui/camera/CameraWorkoutController;", "checksPassedAt", "", "distanceOk", "lastPrompt", "", "orientationOk", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "setupRunnable", "Ljava/lang/Runnable;", "ttsCoach", "Lcom/corecue/fitness/audio/TtsCoach;", "getTtsCoach", "()Lcom/corecue/fitness/audio/TtsCoach;", "setTtsCoach", "(Lcom/corecue/fitness/audio/TtsCoach;)V", "useFrontCamera", "visibilityScore", "", "applyEdgeToEdgeInsets", "", "bindCamera", "evaluateSetup", "isLandscapeNow", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "requestPermissionsAndBind", "requiredPermissions", "", "app_debug"})
public final class CalibrationFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.corecue.fitness.databinding.FragmentCalibrationBinding _binding;
    @javax.inject.Inject()
    public com.corecue.fitness.audio.TtsCoach ttsCoach;
    @org.jetbrains.annotations.Nullable()
    private com.corecue.fitness.ui.camera.CameraWorkoutController cameraController;
    private long checksPassedAt = 0L;
    private boolean bodyVisible = false;
    private float visibilityScore = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String lastPrompt = "";
    private boolean useFrontCamera = true;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable setupRunnable = null;
    private boolean orientationOk = false;
    private boolean distanceOk = false;
    private boolean bodyOk = false;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionLauncher = null;
    
    public CalibrationFragment() {
        super();
    }
    
    private final com.corecue.fitness.databinding.FragmentCalibrationBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.corecue.fitness.audio.TtsCoach getTtsCoach() {
        return null;
    }
    
    public final void setTtsCoach(@org.jetbrains.annotations.NotNull()
    com.corecue.fitness.audio.TtsCoach p0) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void applyEdgeToEdgeInsets() {
    }
    
    private final void requestPermissionsAndBind() {
    }
    
    private final void bindCamera() {
    }
    
    private final java.util.List<java.lang.String> requiredPermissions() {
        return null;
    }
    
    private final void evaluateSetup() {
    }
    
    private final boolean isLandscapeNow() {
        return false;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}