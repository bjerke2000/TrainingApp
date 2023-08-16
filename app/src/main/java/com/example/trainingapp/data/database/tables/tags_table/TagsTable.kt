package com.example.trainingapp.data.database.tables.tags_table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tags_table")
data class TagsTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "category_id") var categoryId : Int,
)
