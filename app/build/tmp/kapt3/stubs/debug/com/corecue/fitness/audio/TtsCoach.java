package com.corecue.fitness.audio;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\rJ\b\u0010\u001c\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/corecue/fitness/audio/TtsCoach;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isReady", "", "isSpeaking", "queue", "Ljava/util/PriorityQueue;", "Lcom/corecue/fitness/audio/SpeechItem;", "queueSignal", "Lkotlinx/coroutines/channels/Channel;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "tts", "Landroid/speech/tts/TextToSpeech;", "enqueue", "text", "", "priority", "Lcom/corecue/fitness/audio/SpeechPriority;", "onInit", "status", "", "pauseForVideo", "release", "speakNext", "app_debug"})
public final class TtsCoach implements android.speech.tts.TextToSpeech.OnInitListener {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<kotlin.Unit> queueSignal = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.PriorityQueue<com.corecue.fitness.audio.SpeechItem> queue = null;
    private boolean isReady = false;
    private boolean isSpeaking = false;
    @org.jetbrains.annotations.NotNull()
    private final android.speech.tts.TextToSpeech tts = null;
    
    @javax.inject.Inject()
    public TtsCoach(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context appContext) {
        super();
    }
    
    @java.lang.Override()
    public void onInit(int status) {
    }
    
    public final void enqueue(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    com.corecue.fitness.audio.SpeechPriority priority) {
    }
    
    public final void pauseForVideo() {
    }
    
    private final void speakNext() {
    }
    
    public final void release() {
    }
}