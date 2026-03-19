package com.corecue.fitness.ui.camera;

/**
 * Classifies whether the current pose matches a given exercise using MediaPipe landmark geometry.
 *
 * MediaPipe landmark indices used:
 *  0  = nose
 *  11 = left shoulder,  12 = right shoulder
 *  13 = left elbow,     14 = right elbow
 *  15 = left wrist,     16 = right wrist
 *  23 = left hip,       24 = right hip
 *  25 = left knee,      26 = right knee
 *  27 = left ankle,     28 = right ankle
 *
 * Coordinate system: x in [0,1] left→right, y in [0,1] top→bottom.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u001c\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0016\u0010\u0011\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0016\u0010\u0012\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/corecue/fitness/ui/camera/ExerciseClassifier;", "", "()V", "MIN_SCORE", "", "avg", "a", "b", "classify", "Lcom/corecue/fitness/ui/camera/ExerciseClassifier$ExerciseMatch;", "points", "", "Lcom/corecue/fitness/ui/camera/OverlayPoint;", "exerciseId", "", "classifyHamstringPull", "p", "classifyPelvicCurl", "classifyRollLikeBall", "dist", "ExerciseMatch", "app_debug"})
public final class ExerciseClassifier {
    private static final float MIN_SCORE = 0.3F;
    @org.jetbrains.annotations.NotNull()
    public static final com.corecue.fitness.ui.camera.ExerciseClassifier INSTANCE = null;
    
    private ExerciseClassifier() {
        super();
    }
    
    /**
     * Returns whether the current landmark pose matches [exerciseId].
     * If the pose is not visible enough to make a determination, returns INSUFFICIENT_VISIBILITY.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.corecue.fitness.ui.camera.ExerciseClassifier.ExerciseMatch classify(@org.jetbrains.annotations.NotNull()
    java.util.List<com.corecue.fitness.ui.camera.OverlayPoint> points, @org.jetbrains.annotations.NotNull()
    java.lang.String exerciseId) {
        return null;
    }
    
    private final com.corecue.fitness.ui.camera.ExerciseClassifier.ExerciseMatch classifyPelvicCurl(java.util.List<com.corecue.fitness.ui.camera.OverlayPoint> p) {
        return null;
    }
    
    private final com.corecue.fitness.ui.camera.ExerciseClassifier.ExerciseMatch classifyRollLikeBall(java.util.List<com.corecue.fitness.ui.camera.OverlayPoint> p) {
        return null;
    }
    
    private final com.corecue.fitness.ui.camera.ExerciseClassifier.ExerciseMatch classifyHamstringPull(java.util.List<com.corecue.fitness.ui.camera.OverlayPoint> p) {
        return null;
    }
    
    private final float avg(float a, float b) {
        return 0.0F;
    }
    
    @kotlin.Suppress(names = {"unused"})
    private final float dist(com.corecue.fitness.ui.camera.OverlayPoint a, com.corecue.fitness.ui.camera.OverlayPoint b) {
        return 0.0F;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/corecue/fitness/ui/camera/ExerciseClassifier$ExerciseMatch;", "", "(Ljava/lang/String;I)V", "CORRECT_EXERCISE", "WRONG_EXERCISE", "INSUFFICIENT_VISIBILITY", "app_debug"})
    public static enum ExerciseMatch {
        /*public static final*/ CORRECT_EXERCISE /* = new CORRECT_EXERCISE() */,
        /*public static final*/ WRONG_EXERCISE /* = new WRONG_EXERCISE() */,
        /*public static final*/ INSUFFICIENT_VISIBILITY /* = new INSUFFICIENT_VISIBILITY() */;
        
        ExerciseMatch() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.corecue.fitness.ui.camera.ExerciseClassifier.ExerciseMatch> getEntries() {
            return null;
        }
    }
}