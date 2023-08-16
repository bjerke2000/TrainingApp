package com.example.trainingapp.data.database.tables.user_table

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userTable: UserTable)

    @Query("SELECT * FROM user_table WHERE id = :id")
    suspend fun getUserById(id: Int): UserTable

    @Query("SELECT * FROM user_table WHERE email = :email")
    suspend fun getUserByEmail(email: String): UserTable

    @Query("SELECT * FROM user_table WHERE email = :email AND password_hash = :passwordHash")
    suspend fun getUserByEmailAndPassword(email: String, passwordHash: String): UserTable

    @Delete
    suspend fun deleteUser(userTable: UserTable)
}