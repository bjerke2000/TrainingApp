package com.example.trainingapp.data.database.tables.session_table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "session_table")
data class SessionTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "user_id") var userId : Int,
    @ColumnInfo(name = "date") var date : String,
    @ColumnInfo(name = "start_time") var startTime : String,
    @ColumnInfo(name = "end_time") var endTime : String,
    @ColumnInfo(name = "program_id") var programId : Int,
    @ColumnInfo(name = "coordinate") var coordinate : String,  //Coordinate on session start
    @ColumnInfo(name = "deviance") var deviance : Boolean,
    @ColumnInfo(name = "ex_no") var exNo : Int,
    @ColumnInfo(name = "set_no") var setNo : Int,
    @ColumnInfo(name = "tracked") var tracked : Boolean,
    @ColumnInfo(name = "status") var status : String,

)
