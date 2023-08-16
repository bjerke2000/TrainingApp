package com.example.trainingapp.data.database.tables.session_gps_data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng

@Entity(tableName = "session_gps_data_table")
data class SessionGpsDataTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "session_id") var sessionId : Int,
    @ColumnInfo(name = "ex_no") var exNo : Int,
    @ColumnInfo(name = "set_no") var setNo : Int,
    @ColumnInfo(name = "coord_no") var coordNo : Int,
    @ColumnInfo(name = "coordinate") var coordinate : LatLng,
)
