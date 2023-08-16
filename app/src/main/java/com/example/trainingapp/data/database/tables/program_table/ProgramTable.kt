package com.example.trainingapp.data.database.tables.program_table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "program_table")
data class ProgramTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "description") var description : String,
    @ColumnInfo(name = "author") var author : String,
    //@ColumnInfo(name = "private") var private : Boolean,
    @ColumnInfo(name = "total_sets") var totalSets : Int,
    @ColumnInfo(name = "date") var date : String,
)
