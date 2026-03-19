package com.corecue.fitness.ui.report;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\u0011H\u0002J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u0006 "}, d2 = {"Lcom/corecue/fitness/ui/report/ReportFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/corecue/fitness/databinding/FragmentReportBinding;", "binding", "getBinding", "()Lcom/corecue/fitness/databinding/FragmentReportBinding;", "viewModel", "Lcom/corecue/fitness/ui/main/MainViewModel;", "getViewModel", "()Lcom/corecue/fitness/ui/main/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bindBodyRadar", "", "bodyParts", "", "Lkotlin/Pair;", "", "", "bindRepChart", "repScores", "navigateCalibrationAndDiscardVideo", "navigateHome", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class ReportFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ARG_VIDEO_PATH = "recorded_video_path";
    @org.jetbrains.annotations.Nullable()
    private com.corecue.fitness.databinding.FragmentReportBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.corecue.fitness.ui.report.ReportFragment.Companion Companion = null;
    
    public ReportFragment() {
        super();
    }
    
    private final com.corecue.fitness.databinding.FragmentReportBinding getBinding() {
        return null;
    }
    
    private final com.corecue.fitness.ui.main.MainViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void bindRepChart(java.util.List<java.lang.Integer> repScores) {
    }
    
    private final void bindBodyRadar(java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> bodyParts) {
    }
    
    private final void navigateHome() {
    }
    
    private final void navigateCalibrationAndDiscardVideo() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/corecue/fitness/ui/report/ReportFragment$Companion;", "", "()V", "ARG_VIDEO_PATH", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}