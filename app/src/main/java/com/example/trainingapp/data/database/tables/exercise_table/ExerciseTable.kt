package com.example.trainingapp.data.database.tables.exercise_table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_table")
data class ExerciseTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "movement_id") var movementId : Int,
    @ColumnInfo(name = "sets") var sets : Int,
    @ColumnInfo(name = "program_id") var programId : Int,
    @ColumnInfo(name = "ex_no") var exNo : Int,
)
