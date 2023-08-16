package com.example.trainingapp.data.database.tables.movement_table

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovementDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovement(movementTable: MovementTable)

    @Query("SELECT * FROM movement_table WHERE id = :id")
    suspend fun getMovementById(id: Int): MovementTable

    @Query("SELECT * FROM movement_table WHERE author = :userId")
    fun getMovementsByAuthorAsFlow(userId: Int): Flow<List<MovementTable>>

    @Query("SELECT * FROM movement_table WHERE author = :userId") // private = 0 AND
    fun getPublicMovementsByAuthorAsFlow(userId: Int): Flow<List<MovementTable>>
}