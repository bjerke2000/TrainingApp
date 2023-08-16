package com.example.trainingapp.data.database.tables.movement_table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movement_table")
data class MovementTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "description") var description : String,
    @ColumnInfo(name = "img_src") var imgSrc : String,
    @ColumnInfo(name = "author") var author : String,
    //@ColumnInfo(name = "private") var private : Boolean = false,
)