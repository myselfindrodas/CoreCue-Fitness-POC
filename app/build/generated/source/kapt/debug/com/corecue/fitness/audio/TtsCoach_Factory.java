package com.corecue.fitness.audio;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class TtsCoach_Factory implements Factory<TtsCoach> {
  private final Provider<Context> appContextProvider;

  public TtsCoach_Factory(Provider<Context> appContextProvider) {
    this.appContextProvider = appContextProvider;
  }

  @Override
  public TtsCoach get() {
    return newInstance(appContextProvider.get());
  }

  public static TtsCoach_Factory create(Provider<Context> appContextProvider) {
    return new TtsCoach_Factory(appContextProvider);
  }

  public static TtsCoach newInstance(Context appContext) {
    return new TtsCoach(appContext);
  }
}
