package com.corecue.fitness.ui.calibration;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0002;<B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010\'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0002J\u0016\u0010)\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\b\u0010+\u001a\u00020\u0014H\u0002J\b\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020%H\u0016J\b\u0010.\u001a\u00020%H\u0016J\b\u0010/\u001a\u00020%H\u0016J\u001a\u00100\u001a\u00020%2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020%H\u0002J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017H\u0002J\u0010\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020\u0014H\u0002J\b\u00109\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020%H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lcom/corecue/fitness/ui/calibration/CalibrationFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/corecue/fitness/databinding/FragmentCalibrationBinding;", "binding", "getBinding", "()Lcom/corecue/fitness/databinding/FragmentCalibrationBinding;", "bodyState", "Lcom/corecue/fitness/ui/calibration/CalibrationFragment$BodyState;", "cameraController", "Lcom/corecue/fitness/ui/camera/CameraWorkoutController;", "checkOrientationRunnable", "Ljava/lang/Runnable;", "checkPoseRunnable", "currentStep", "Lcom/corecue/fitness/ui/calibration/CalibrationFragment$Step;", "holdStartAt", "", "isCalibrationCompleted", "", "lastFullBodySeenAt", "latestLandmarks", "", "Lcom/corecue/fitness/ui/camera/OverlayPoint;", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "ttsCoach", "Lcom/corecue/fitness/audio/TtsCoach;", "getTtsCoach", "()Lcom/corecue/fitness/audio/TtsCoach;", "setTtsCoach", "(Lcom/corecue/fitness/audio/TtsCoach;)V", "useFrontCamera", "applyEdgeToEdgeInsets", "", "bindCamera", "evaluateFullBodyStep", "initStepOneUi", "isFullBodyInFrame", "points", "isLandscapeNow", "onCalibrationReady", "onDestroyView", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "requestPermissionsAndBind", "requiredPermissions", "setKeepScreenAwake", "enabled", "showOrientationStepDialog", "waitForLandscape", "BodyState", "Step", "app_debug"})
public final class CalibrationFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.corecue.fitness.databinding.FragmentCalibrationBinding _binding;
    @javax.inject.Inject()
    public com.corecue.fitness.audio.TtsCoach ttsCoach;
    @org.jetbrains.annotations.Nullable()
    private com.corecue.fitness.ui.camera.CameraWorkoutController cameraController;
    private boolean useFrontCamera = true;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.corecue.fitness.ui.camera.OverlayPoint> latestLandmarks;
    private long holdStartAt = 0L;
    private long lastFullBodySeenAt = 0L;
    private boolean isCalibrationCompleted = false;
    @org.jetbrains.annotations.NotNull()
    private com.corecue.fitness.ui.calibration.CalibrationFragment.Step currentStep = com.corecue.fitness.ui.calibration.CalibrationFragment.Step.ORIENTATION;
    @org.jetbrains.annotations.NotNull()
    private com.corecue.fitness.ui.calibration.CalibrationFragment.BodyState bodyState = com.corecue.fitness.ui.calibration.CalibrationFragment.BodyState.SEARCHING;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable checkOrientationRunnable = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable checkPoseRunnable = null;
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
    
    private final void initStepOneUi() {
    }
    
    private final void showOrientationStepDialog() {
    }
    
    private final void waitForLandscape() {
    }
    
    private final void evaluateFullBodyStep() {
    }
    
    private final boolean isFullBodyInFrame(java.util.List<com.corecue.fitness.ui.camera.OverlayPoint> points) {
        return false;
    }
    
    private final void onCalibrationReady() {
    }
    
    private final boolean isLandscapeNow() {
        return false;
    }
    
    private final void setKeepScreenAwake(boolean enabled) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/corecue/fitness/ui/calibration/CalibrationFragment$BodyState;", "", "(Ljava/lang/String;I)V", "SEARCHING", "HOLDING", "app_debug"})
    static enum BodyState {
        /*public static final*/ SEARCHING /* = new SEARCHING() */,
        /*public static final*/ HOLDING /* = new HOLDING() */;
        
        BodyState() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.corecue.fitness.ui.calibration.CalibrationFragment.BodyState> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/corecue/fitness/ui/calibration/CalibrationFragment$Step;", "", "(Ljava/lang/String;I)V", "ORIENTATION", "FULL_BODY", "READY", "app_debug"})
    static enum Step {
        /*public static final*/ ORIENTATION /* = new ORIENTATION() */,
        /*public static final*/ FULL_BODY /* = new FULL_BODY() */,
        /*public static final*/ READY /* = new READY() */;
        
        Step() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.corecue.fitness.ui.calibration.CalibrationFragment.Step> getEntries() {
            return null;
        }
    }
}