package com.example.trainingapp.data.database.tables.program_table

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProgramDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProgram(programTable: ProgramTable)

    @Query("SELECT * FROM program_table WHERE id = :id")
    suspend fun getProgramById(id: Int): ProgramTable

    @Query("SELECT * FROM program_table WHERE author = :userId")
    suspend fun getProgramsByAuthor(userId: Int): List<ProgramTable>

    @Query("SELECT * FROM program_table WHERE 1 ORDER BY id DESC") // private = 0
    suspend fun getPublicPrograms(): List<ProgramTable>






}