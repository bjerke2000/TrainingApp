package com.example.trainingapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.trainingapp.data.database.tables.category_table.CategoryDao
import com.example.trainingapp.data.database.tables.category_table.CategoryTable
import com.example.trainingapp.data.database.tables.exercise_table.ExerciseDao
import com.example.trainingapp.data.database.tables.exercise_table.ExerciseTable
import com.example.trainingapp.data.database.tables.movement_table.MovementDao
import com.example.trainingapp.data.database.tables.movement_table.MovementTable
import com.example.trainingapp.data.database.tables.mtm_tables.ExerciseSetJoin
import com.example.trainingapp.data.database.tables.mtm_tables.MovementToTag
import com.example.trainingapp.data.database.tables.mtm_tables.SessionToDescdata
import com.example.trainingapp.data.database.tables.program_table.ProgramDao
import com.example.trainingapp.data.database.tables.program_table.ProgramTable
import com.example.trainingapp.data.database.tables.session_table.SessionDao
import com.example.trainingapp.data.database.tables.session_table.SessionTable
import com.example.trainingapp.data.database.tables.set_table.SetDao
import com.example.trainingapp.data.database.tables.set_table.SetTable
import com.example.trainingapp.data.database.tables.tags_table.TagsDao
import com.example.trainingapp.data.database.tables.tags_table.TagsTable
import com.example.trainingapp.data.database.tables.user_table.UserDao
import com.example.trainingapp.data.database.tables.user_table.UserTable


@TypeConverters(Converters::class)
@Database(entities = [
    CategoryTable::class,
    ExerciseTable::class,
    MovementTable::class,
    ProgramTable::class,
    SessionTable::class,
    SetTable::class,
    TagsTable::class,
    UserTable::class,
    SessionToDescdata::class,
    MovementToTag::class,
    ExerciseSetJoin::class
                     ], version=2, exportSchema = false)
abstract class TrainingRoomDatabase: RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun exerciseDao(): ExerciseDao
    abstract fun movementDao(): MovementDao
    abstract fun programDao(): ProgramDao
    abstract fun sessionDao(): SessionDao
    abstract fun setDao(): SetDao
    abstract fun tagsDao(): TagsDao
    abstract fun userDao(): UserDao


    companion object {
        @Volatile
        private var INSTANCE: TrainingRoomDatabase? = null
        fun getDatabase(context: Context): TrainingRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, TrainingRoomDatabase::class.java,
                    "training_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}