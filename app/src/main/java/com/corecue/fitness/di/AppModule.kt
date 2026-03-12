package com.corecue.fitness.di

import android.content.Context
import androidx.room.Room
import com.corecue.fitness.data.local.AppDatabase
import com.corecue.fitness.data.local.dao.ExerciseDao
import com.corecue.fitness.data.local.dao.SessionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BASIC)
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://example.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "corecue_poc.db").build()
    }

    @Provides
    fun provideExerciseDao(database: AppDatabase): ExerciseDao = database.exerciseDao()

    @Provides
    fun provideSessionDao(database: AppDatabase): SessionDao = database.sessionDao()
}
