package com.example.trainingapp.data.database.tables.session_gps_data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SessionGpsDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSessionGpsData(sessionGpsDataTable: SessionGpsDataTable)

    @Query("SELECT * FROM session_gps_data_table WHERE session_id = :sessionId AND ex_no = :exNo AND set_no = :setNo ORDER BY coord_no ASC")
    suspend fun getSessionGpsDataBySessionIdAndExNoAndSetNo(sessionId: Int, exNo: Int, setNo: Int): List<SessionGpsDataTable>
}