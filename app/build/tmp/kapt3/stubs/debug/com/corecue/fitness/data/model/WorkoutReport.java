package com.corecue.fitness.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\r0\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0006H\u00c6\u0003J\t\u0010#\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J\u001b\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\r0\nH\u00c6\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u00c6\u0003J\t\u0010\'\u001a\u00020\u0010H\u00c6\u0003J\u0081\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\r0\n2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\u0006H\u00d6\u0001J\t\u0010-\u001a\u00020\u0003H\u00d6\u0001R#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\r0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015\u00a8\u0006."}, d2 = {"Lcom/corecue/fitness/data/model/WorkoutReport;", "", "sessionId", "", "exerciseId", "overallScore", "", "firstHalfScore", "secondHalfScore", "issues", "", "Lcom/corecue/fitness/data/model/IssueItem;", "bodyParts", "Lkotlin/Pair;", "repScores", "postureStability", "", "(Ljava/lang/String;Ljava/lang/String;IIILjava/util/List;Ljava/util/List;Ljava/util/List;F)V", "getBodyParts", "()Ljava/util/List;", "getExerciseId", "()Ljava/lang/String;", "getFirstHalfScore", "()I", "getIssues", "getOverallScore", "getPostureStability", "()F", "getRepScores", "getSecondHalfScore", "getSessionId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class WorkoutReport {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String sessionId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String exerciseId = null;
    private final int overallScore = 0;
    private final int firstHalfScore = 0;
    private final int secondHalfScore = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.corecue.fitness.data.model.IssueItem> issues = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> bodyParts = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Integer> repScores = null;
    private final float postureStability = 0.0F;
    
    public WorkoutReport(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    java.lang.String exerciseId, int overallScore, int firstHalfScore, int secondHalfScore, @org.jetbrains.annotations.NotNull()
    java.util.List<com.corecue.fitness.data.model.IssueItem> issues, @org.jetbrains.annotations.NotNull()
    java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> bodyParts, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> repScores, float postureStability) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSessionId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getExerciseId() {
        return null;
    }
    
    public final int getOverallScore() {
        return 0;
    }
    
    public final int getFirstHalfScore() {
        return 0;
    }
    
    public final int getSecondHalfScore() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.corecue.fitness.data.model.IssueItem> getIssues() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> getBodyParts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getRepScores() {
        return null;
    }
    
    public final float getPostureStability() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.corecue.fitness.data.model.IssueItem> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> component8() {
        return null;
    }
    
    public final float component9() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.corecue.fitness.data.model.WorkoutReport copy(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    java.lang.String exerciseId, int overallScore, int firstHalfScore, int secondHalfScore, @org.jetbrains.annotations.NotNull()
    java.util.List<com.corecue.fitness.data.model.IssueItem> issues, @org.jetbrains.annotations.NotNull()
    java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> bodyParts, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> repScores, float postureStability) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}