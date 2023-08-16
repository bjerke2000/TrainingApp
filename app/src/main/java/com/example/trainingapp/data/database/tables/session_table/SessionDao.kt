package com.example.trainingapp.data.database.tables.session_table

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(sessionTable: SessionTable)

    @Query("SELECT * FROM session_table WHERE id = :id")
    suspend fun getSessionById(id: Int): SessionTable

    @Query("SELECT * FROM session_table WHERE user_id = :userId")
    fun getSessionsByUserIdAsFlow(userId: Int): Flow<List<SessionTable>>



}