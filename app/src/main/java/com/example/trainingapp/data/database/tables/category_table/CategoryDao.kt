package com.example.trainingapp.data.database.tables.category_table

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface CategoryDao {

    @Insert
    suspend fun insertCategory(categoryTable: CategoryTable)

}