package com.corecue.fitness.ui.calibration;

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
public final class CalibrationFragment_MembersInjector implements MembersInjector<CalibrationFragment> {
  private final Provider<TtsCoach> ttsCoachProvider;

  public CalibrationFragment_MembersInjector(Provider<TtsCoach> ttsCoachProvider) {
    this.ttsCoachProvider = ttsCoachProvider;
  }

  public static MembersInjector<CalibrationFragment> create(Provider<TtsCoach> ttsCoachProvider) {
    return new CalibrationFragment_MembersInjector(ttsCoachProvider);
  }

  @Override
  public void injectMembers(CalibrationFragment instance) {
    injectTtsCoach(instance, ttsCoachProvider.get());
  }

  @InjectedFieldSignature("com.corecue.fitness.ui.calibration.CalibrationFragment.ttsCoach")
  public static void injectTtsCoach(CalibrationFragment instance, TtsCoach ttsCoach) {
    instance.ttsCoach = ttsCoach;
  }
}
