package com.example.trainingapp.data.database.tables.set_table

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSet(setTable: SetTable)

    @Query("SELECT * FROM set_table WHERE id = :id")
    suspend fun getSetById(id: Int): SetTable

    @Query("DELETE FROM set_table WHERE id = :id")
    suspend fun deleteSetById(id: Int)

    @Query("""SELECT set_table.* FROM set_table JOIN session_to_descdata ON set_table.id = session_to_descdata.set_id WHERE session_to_descdata.session_id = :sessionId AND session_to_descdata.ex_no = :exNo AND session_to_descdata.set_no = :setNo """)
    fun getSetBySessionExerciseAndSetNumber(sessionId: Int, exNo: Int, setNo: Int): SetTable

    @Delete
    suspend fun deleteSet(setTable: SetTable)

}