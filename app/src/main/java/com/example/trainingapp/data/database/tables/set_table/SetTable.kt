package com.example.trainingapp.data.database.tables.set_table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "set_table")
data class SetTable(
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    @ColumnInfo(name = "weight") var weight:Double, //kg
    @ColumnInfo(name = "reps") var reps:Int, //reps
    @ColumnInfo(name = "time") var time:Int, //seconds
    @ColumnInfo(name = "angle") var angle:Int, //degrees
    @ColumnInfo(name = "speed") var speed:Double, //km/h
    @ColumnInfo(name = "distance") var distance:Int, //meters
    @ColumnInfo(name = "rest") var rest:Int, //seconds
    @ColumnInfo(name = "auto_increment") var autoIncrement:Boolean, //true (does not need manual input to continue) or false
)
