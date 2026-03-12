package com.corecue.fitness.ui.demo;

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
public final class DemoVideoFragment_MembersInjector implements MembersInjector<DemoVideoFragment> {
  private final Provider<TtsCoach> ttsCoachProvider;

  public DemoVideoFragment_MembersInjector(Provider<TtsCoach> ttsCoachProvider) {
    this.ttsCoachProvider = ttsCoachProvider;
  }

  public static MembersInjector<DemoVideoFragment> create(Provider<TtsCoach> ttsCoachProvider) {
    return new DemoVideoFragment_MembersInjector(ttsCoachProvider);
  }

  @Override
  public void injectMembers(DemoVideoFragment instance) {
    injectTtsCoach(instance, ttsCoachProvider.get());
  }

  @InjectedFieldSignature("com.corecue.fitness.ui.demo.DemoVideoFragment.ttsCoach")
  public static void injectTtsCoach(DemoVideoFragment instance, TtsCoach ttsCoach) {
    instance.ttsCoach = ttsCoach;
  }
}
