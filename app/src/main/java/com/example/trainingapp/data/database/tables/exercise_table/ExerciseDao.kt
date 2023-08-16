package com.example.trainingapp.data.database.tables.exercise_table

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.trainingapp.data.database.tables.set_table.SetTable

@Dao
interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exerciseTable: ExerciseTable)

    @Query("SELECT * FROM exercise_table WHERE id = :id")
    suspend fun getExerciseById(id: Int): ExerciseTable

    @Query("SELECT * FROM exercise_table WHERE program_id = :programId ORDER BY ex_no ASC")
    suspend fun getExercisesByProgramId(programId: Int): List<ExerciseTable>

    @Query("SELECT * FROM exercise_table WHERE program_id = :programId AND ex_no = :exNo")
    suspend fun getExerciseByProgramIdAndExNo(programId: Int, exNo: Int): ExerciseTable

    @Query("SELECT * FROM set_table INNER JOIN exercise_set_join ON set_table.id = exercise_set_join.setId WHERE exercise_set_join.exerciseId = :exerciseId ORDER BY exercise_set_join.setOrderId ASC")
    fun getSetsForExercise(exerciseId: Int): List<SetTable>

}