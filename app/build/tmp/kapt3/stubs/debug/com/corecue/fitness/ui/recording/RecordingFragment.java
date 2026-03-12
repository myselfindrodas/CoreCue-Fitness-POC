package com.corecue.fitness.ui.recording;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020)H\u0016J\u001a\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020)H\u0002J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00020\u001105H\u0002J\b\u00106\u001a\u00020)H\u0002J\b\u00107\u001a\u00020)H\u0002J\b\u00108\u001a\u00020)H\u0002J\b\u00109\u001a\u00020)H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u000e\u0010&\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\'\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/corecue/fitness/ui/recording/RecordingFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/corecue/fitness/databinding/FragmentRecordingBinding;", "binding", "getBinding", "()Lcom/corecue/fitness/databinding/FragmentRecordingBinding;", "cameraController", "Lcom/corecue/fitness/ui/camera/CameraWorkoutController;", "countdownTimer", "Landroid/os/CountDownTimer;", "elapsed", "", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "poseScore", "", "postureVisible", "", "recordingFile", "Ljava/io/File;", "repCount", "ttsCoach", "Lcom/corecue/fitness/audio/TtsCoach;", "getTtsCoach", "()Lcom/corecue/fitness/audio/TtsCoach;", "setTtsCoach", "(Lcom/corecue/fitness/audio/TtsCoach;)V", "useFrontCamera", "viewModel", "Lcom/corecue/fitness/ui/main/MainViewModel;", "getViewModel", "()Lcom/corecue/fitness/ui/main/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "workoutStarted", "workoutTimer", "animateCountdownText", "", "applyEdgeToEdgeInsets", "bindCameraAndStart", "bindCameraOnly", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "requestPermissionsAndStart", "requiredPermissions", "", "startCountdownThenRecording", "startVideoRecording", "startWorkoutTimer", "stopWorkoutTimer", "app_debug"})
public final class RecordingFragment extends androidx.fragment.app.Fragment {
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
    private boolean useFrontCamera = true;
    private boolean workoutStarted = false;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> permissionLauncher = null;
    
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
    
    private final void stopWorkoutTimer() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}