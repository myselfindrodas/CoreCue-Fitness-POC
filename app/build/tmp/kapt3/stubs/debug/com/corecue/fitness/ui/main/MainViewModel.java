package com.corecue.fitness.ui.main;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\u001f\u001a\u00020\u001dH\u0082@\u00a2\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013\u00a8\u0006#"}, d2 = {"Lcom/corecue/fitness/ui/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/corecue/fitness/data/repo/FitnessRepository;", "(Lcom/corecue/fitness/data/repo/FitnessRepository;)V", "_exercises", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/corecue/fitness/data/model/Exercise;", "_report", "Lcom/corecue/fitness/data/model/WorkoutReport;", "_selectedExercise", "_sessionSummaries", "Lcom/corecue/fitness/data/model/SessionSummary;", "_trendPoints", "Lcom/corecue/fitness/data/model/SessionTrendPoint;", "exercises", "Lkotlinx/coroutines/flow/StateFlow;", "getExercises", "()Lkotlinx/coroutines/flow/StateFlow;", "report", "getReport", "selectedExercise", "getSelectedExercise", "sessionSummaries", "getSessionSummaries", "trendPoints", "getTrendPoints", "bootstrap", "", "loadReport", "refreshTrends", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectExercise", "exercise", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.corecue.fitness.data.repo.FitnessRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.corecue.fitness.data.model.Exercise>> _exercises = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.corecue.fitness.data.model.Exercise>> exercises = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.corecue.fitness.data.model.Exercise> _selectedExercise = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.corecue.fitness.data.model.Exercise> selectedExercise = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.corecue.fitness.data.model.WorkoutReport> _report = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.corecue.fitness.data.model.WorkoutReport> report = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.corecue.fitness.data.model.SessionSummary>> _sessionSummaries = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.corecue.fitness.data.model.SessionSummary>> sessionSummaries = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.corecue.fitness.data.model.SessionTrendPoint>> _trendPoints = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.corecue.fitness.data.model.SessionTrendPoint>> trendPoints = null;
    
    @javax.inject.Inject()
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.corecue.fitness.data.repo.FitnessRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.corecue.fitness.data.model.Exercise>> getExercises() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.corecue.fitness.data.model.Exercise> getSelectedExercise() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.corecue.fitness.data.model.WorkoutReport> getReport() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.corecue.fitness.data.model.SessionSummary>> getSessionSummaries() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.corecue.fitness.data.model.SessionTrendPoint>> getTrendPoints() {
        return null;
    }
    
    private final void bootstrap() {
    }
    
    public final void selectExercise(@org.jetbrains.annotations.NotNull()
    com.corecue.fitness.data.model.Exercise exercise) {
    }
    
    public final void loadReport() {
    }
    
    private final java.lang.Object refreshTrends(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}