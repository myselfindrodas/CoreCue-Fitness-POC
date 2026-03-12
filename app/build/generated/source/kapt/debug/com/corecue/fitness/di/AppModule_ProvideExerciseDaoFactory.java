package com.corecue.fitness.di;

import com.corecue.fitness.data.local.AppDatabase;
import com.corecue.fitness.data.local.dao.ExerciseDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class AppModule_ProvideExerciseDaoFactory implements Factory<ExerciseDao> {
  private final Provider<AppDatabase> databaseProvider;

  public AppModule_ProvideExerciseDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ExerciseDao get() {
    return provideExerciseDao(databaseProvider.get());
  }

  public static AppModule_ProvideExerciseDaoFactory create(Provider<AppDatabase> databaseProvider) {
    return new AppModule_ProvideExerciseDaoFactory(databaseProvider);
  }

  public static ExerciseDao provideExerciseDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideExerciseDao(database));
  }
}
