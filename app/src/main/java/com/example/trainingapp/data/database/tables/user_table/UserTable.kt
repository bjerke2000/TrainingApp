package com.example.trainingapp.data.database.tables.user_table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "first_name") var firstName : String,
    @ColumnInfo(name = "last_name") var lastName : String,
    @ColumnInfo(name = "email") var email : String,
    @ColumnInfo(name = "password_hash") var passwordHash : String,
    @ColumnInfo(name = "date_of_birth") var dateOfBirth : String,
    @ColumnInfo(name = "telephone") var telephone : String,
    @ColumnInfo(name = "country") var country : String,
)
