package com.corecue.fitness.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.corecue.fitness.data.local.dao.ExerciseDao
import com.corecue.fitness.data.local.dao.SessionDao
import com.corecue.fitness.data.local.entity.ExerciseEntity
import com.corecue.fitness.data.local.entity.SessionEntity

@Database(
    entities = [ExerciseEntity::class, SessionEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao
    abstract fun sessionDao(): SessionDao
}
