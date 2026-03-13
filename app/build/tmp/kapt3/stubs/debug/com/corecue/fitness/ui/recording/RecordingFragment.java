package com.corecue.fitness.ui.recording;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0002J\b\u0010.\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020,H\u0002J\u0016\u00100\u001a\u00020\u00182\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\b\u00102\u001a\u00020\u0018H\u0002J\b\u00103\u001a\u00020,H\u0002J\b\u00104\u001a\u00020,H\u0002J\b\u00105\u001a\u00020,H\u0016J\b\u00106\u001a\u00020,H\u0016J\b\u00107\u001a\u00020,H\u0016J\u001a\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020:H\u0002J\u0010\u0010?\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\rH\u0002J\b\u0010A\u001a\u00020,H\u0002J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fH\u0002J\u0010\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020\u0018H\u0002J\b\u0010E\u001a\u00020,H\u0002J\b\u0010F\u001a\u00020,H\u0002J\b\u0010G\u001a\u00020,H\u0002J\b\u0010H\u001a\u00020,H\u0002J\b\u0010I\u001a\u00020,H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\'\u0010(\u001a\u0004\b%\u0010&R\u000e\u0010)\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006K"}, d2 = {"Lcom/corecue/fitness/ui/recording/RecordingFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/corecue/fitness/databinding/FragmentRecordingBinding;", "binding", "getBinding", "()Lcom/corecue/fitness/databinding/FragmentRecordingBinding;", "cameraController", "Lcom/corecue/fitness/ui/camera/CameraWorkoutController;", "countdownTimer", "Landroid/os/CountDownTimer;", "elapsed", "", "latestLandmarks", "", "Lcom/corecue/fitness/ui/camera/OverlayPoint;", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "poseScore", "", "postureVisible", "", "recordingFile", "Ljava/io/File;", "repCount", "ttsCoach", "Lcom/corecue/fitness/audio/TtsCoach;", "getTtsCoach", "()Lcom/corecue/fitness/audio/TtsCoach;", "setTtsCoach", "(Lcom/corecue/fitness/audio/TtsCoach;)V", "useFrontCamera", "viewModel", "Lcom/corecue/fitness/ui/main/MainViewModel;", "getViewModel", "()Lcom/corecue/fitness/ui/main/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "workoutStarted", "workoutTimer", "animateCountdownText", "", "applyEdgeToEdgeInsets", "bindCameraAndStart", "bindCameraOnly", "hasRequiredRepLandmarks", "points", "isRepPostureValid", "navigateHomePortrait", "navigateToReportPortrait", "onDestroyView", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "playControlTapFeedback", "target", "repCountToWords", "rep", "requestPermissionsAndStart", "requiredPermissions", "setKeepScreenAwake", "enabled", "showExitConfirmationDialog", "startCountdownThenRecording", "startVideoRecording", "startWorkoutTimer", "stopWorkoutTimer", "Companion", "app_debug"})
public final class RecordingFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ARG_USE_FRONT_CAMERA = "use_front_camera";
    @org.jetbrains.annotations.Nullable()
    private com.corecue.fitness.databinding.FragmentRecordingBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject()
    public com.corecue.fitness.audio.TtsCoach ttsCoach;
    @org.jetbrains.annotations.Nullable()
    private com.corecue.fitness.ui.camera.CameraWorkoutController cameraController;
    @org.jetbrains.annotations.Nullable()
    private android.os.CountDownTimer workoutTimer;
    @org.jetbrains.annotations.Nullable()
    private android.os.CountDownTimer countdownTimer;
    @org.jetbrains.annotations.Nullable()
    private java.io.File recordingFile;
    private int repCount = 0;
    private int elapsed = 0;
    private boolean postureVisible = false;
    private float poseScore = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.corecue.fitness.ui.camera.OverlayPoint> latestLandmarks;
    private boolean useFrontCamera = true;
    private boolean workoutStarted = false;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionLauncher = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.corecue.fitness.ui.recording.RecordingFragment.Companion Companion = null;
    
    public RecordingFragment() {
        super();
    }
    
    private final com.corecue.fitness.databinding.FragmentRecordingBinding getBinding() {
        return null;
    }
    
    private final com.corecue.fitness.ui.main.MainViewModel getViewModel() {
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
    
    private final void requestPermissionsAndStart() {
    }
    
    private final java.util.List<java.lang.String> requiredPermissions() {
        return null;
    }
    
    private final void bindCameraAndStart() {
    }
    
    private final void bindCameraOnly() {
    }
    
    private final void startCountdownThenRecording() {
    }
    
    private final void startVideoRecording() {
    }
    
    private final void animateCountdownText() {
    }
    
    private final void startWorkoutTimer() {
    }
    
    private final void showExitConfirmationDialog() {
    }
    
    private final void navigateToReportPortrait() {
    }
    
    private final void navigateHomePortrait() {
    }
    
    private final boolean isRepPostureValid() {
        return false;
    }
    
    private final boolean hasRequiredRepLandmarks(java.util.List<com.corecue.fitness.ui.camera.OverlayPoint> points) {
        return false;
    }
    
    private final java.lang.String repCountToWords(int rep) {
        return null;
    }
    
    private final void playControlTapFeedback(android.view.View target) {
    }
    
    private final void setKeepScreenAwake(boolean enabled) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    private final void stopWorkoutTimer() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/corecue/fitness/ui/recording/RecordingFragment$Companion;", "", "()V", "ARG_USE_FRONT_CAMERA", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}