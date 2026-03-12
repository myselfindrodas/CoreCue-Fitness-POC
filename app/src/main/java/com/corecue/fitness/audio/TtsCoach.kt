package com.corecue.fitness.audio

import android.content.Context
import android.speech.tts.TextToSpeech
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import java.util.Locale
import java.util.PriorityQueue
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

enum class SpeechPriority { AMBIENT, NORMAL, CRITICAL }

data class SpeechItem(
    val text: String,
    val priority: SpeechPriority,
    val utteranceId: String = "${System.nanoTime()}"
)

@Singleton
class TtsCoach @Inject constructor(
    @ApplicationContext
    appContext: Context
) : TextToSpeech.OnInitListener {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private val queueSignal = Channel<Unit>(Channel.CONFLATED)
    private val queue = PriorityQueue<SpeechItem> { a, b -> b.priority.ordinal - a.priority.ordinal }
    private var isReady = false
    private var isSpeaking = false
    private val tts = TextToSpeech(appContext, this)

    init {
        tts.setOnUtteranceProgressListener(object : android.speech.tts.UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                isSpeaking = true
            }

            override fun onDone(utteranceId: String?) {
                isSpeaking = false
                scope.launch { queueSignal.send(Unit) }
            }

            override fun onError(utteranceId: String?) {
                isSpeaking = false
                scope.launch { queueSignal.send(Unit) }
            }
        })

        scope.launch {
            for (ignored in queueSignal) {
                speakNext()
            }
        }
    }

    override fun onInit(status: Int) {
        isReady = status == TextToSpeech.SUCCESS
        if (isReady) {
            tts.language = Locale.US
            scope.launch { queueSignal.send(Unit) }
        }
    }

    fun enqueue(text: String, priority: SpeechPriority = SpeechPriority.NORMAL) {
        if (text.isBlank()) return
        queue.offer(SpeechItem(text, priority))
        if (priority == SpeechPriority.CRITICAL) {
            tts.stop()
            isSpeaking = false
        }
        scope.launch { queueSignal.send(Unit) }
    }

    fun pauseForVideo() {
        tts.stop()
        isSpeaking = false
    }

    private fun speakNext() {
        if (!isReady || isSpeaking || queue.isEmpty()) return
        val item = queue.poll() ?: return
        val mode = if (item.priority == SpeechPriority.CRITICAL) TextToSpeech.QUEUE_FLUSH
        else TextToSpeech.QUEUE_ADD
        tts.speak(item.text, mode, null, item.utteranceId)
    }

    fun release() {
        tts.stop()
        tts.shutdown()
    }
}
