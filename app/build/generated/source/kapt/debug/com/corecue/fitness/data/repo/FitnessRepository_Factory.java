package com.corecue.fitness.data.repo;

import com.corecue.fitness.data.local.dao.ExerciseDao;
import com.corecue.fitness.data.local.dao.SessionDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class FitnessRepository_Factory implements Factory<FitnessRepository> {
  private final Provider<ExerciseDao> exerciseDaoProvider;

  private final Provider<SessionDao> sessionDaoProvider;

  public FitnessRepository_Factory(Provider<ExerciseDao> exerciseDaoProvider,
      Provider<SessionDao> sessionDaoProvider) {
    this.exerciseDaoProvider = exerciseDaoProvider;
    this.sessionDaoProvider = sessionDaoProvider;
  }

  @Override
  public FitnessRepository get() {
    return newInstance(exerciseDaoProvider.get(), sessionDaoProvider.get());
  }

  public static FitnessRepository_Factory create(Provider<ExerciseDao> exerciseDaoProvider,
      Provider<SessionDao> sessionDaoProvider) {
    return new FitnessRepository_Factory(exerciseDaoProvider, sessionDaoProvider);
  }

  public static FitnessRepository newInstance(ExerciseDao exerciseDao, SessionDao sessionDao) {
    return new FitnessRepository(exerciseDao, sessionDao);
  }
}
