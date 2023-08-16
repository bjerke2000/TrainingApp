package com.example.trainingapp.data.database.tables.tags_table

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TagsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTag(tagsTable: TagsTable)

    @Query("SELECT * FROM tags_table WHERE id = :id")
    suspend fun getTagById(id: Int): TagsTable

    @Query("SELECT * FROM tags_table WHERE category_id = :categoryId")
    suspend fun getTagsByCategoryId(categoryId: Int): List<TagsTable>



}