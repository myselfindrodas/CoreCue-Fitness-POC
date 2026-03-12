package com.corecue.fitness.data.repo;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u0011J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\r0\u0011J\u000e\u0010\u0014\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/corecue/fitness/data/repo/FitnessRepository;", "", "exerciseDao", "Lcom/corecue/fitness/data/local/dao/ExerciseDao;", "sessionDao", "Lcom/corecue/fitness/data/local/dao/SessionDao;", "(Lcom/corecue/fitness/data/local/dao/ExerciseDao;Lcom/corecue/fitness/data/local/dao/SessionDao;)V", "generateAndStoreReport", "Lcom/corecue/fitness/data/model/WorkoutReport;", "exercise", "Lcom/corecue/fitness/data/model/Exercise;", "(Lcom/corecue/fitness/data/model/Exercise;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrendPoints", "", "Lcom/corecue/fitness/data/model/SessionTrendPoint;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeExercises", "Lkotlinx/coroutines/flow/Flow;", "observeSessionSummaries", "Lcom/corecue/fitness/data/model/SessionSummary;", "seedIfNeeded", "", "app_debug"})
public final class FitnessRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.corecue.fitness.data.local.dao.ExerciseDao exerciseDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.corecue.fitness.data.local.dao.SessionDao sessionDao = null;
    
    @javax.inject.Inject()
    public FitnessRepository(@org.jetbrains.annotations.NotNull()
    com.corecue.fitness.data.local.dao.ExerciseDao exerciseDao, @org.jetbrains.annotations.NotNull()
    com.corecue.fitness.data.local.dao.SessionDao sessionDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object seedIfNeeded(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.corecue.fitness.data.model.Exercise>> observeExercises() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object generateAndStoreReport(@org.jetbrains.annotations.Nullable()
    com.corecue.fitness.data.model.Exercise exercise, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.corecue.fitness.data.model.WorkoutReport> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.corecue.fitness.data.model.SessionSummary>> observeSessionSummaries() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTrendPoints(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.corecue.fitness.data.model.SessionTrendPoint>> $completion) {
        return null;
    }
}