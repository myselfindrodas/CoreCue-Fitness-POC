package com.corecue.fitness.ui.recording;

import com.corecue.fitness.audio.TtsCoach;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class RecordingFragment_MembersInjector implements MembersInjector<RecordingFragment> {
  private final Provider<TtsCoach> ttsCoachProvider;

  public RecordingFragment_MembersInjector(Provider<TtsCoach> ttsCoachProvider) {
    this.ttsCoachProvider = ttsCoachProvider;
  }

  public static MembersInjector<RecordingFragment> create(Provider<TtsCoach> ttsCoachProvider) {
    return new RecordingFragment_MembersInjector(ttsCoachProvider);
  }

  @Override
  public void injectMembers(RecordingFragment instance) {
    injectTtsCoach(instance, ttsCoachProvider.get());
  }

  @InjectedFieldSignature("com.corecue.fitness.ui.recording.RecordingFragment.ttsCoach")
  public static void injectTtsCoach(RecordingFragment instance, TtsCoach ttsCoach) {
    instance.ttsCoach = ttsCoach;
  }
}
