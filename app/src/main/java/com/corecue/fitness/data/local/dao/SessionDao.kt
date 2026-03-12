package com.corecue.fitness.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.corecue.fitness.data.local.entity.SessionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SessionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(sessionEntity: SessionEntity)

    @Query("SELECT * FROM sessions ORDER BY timestamp DESC LIMIT 20")
    fun observeRecentSessions(): Flow<List<SessionEntity>>
}
