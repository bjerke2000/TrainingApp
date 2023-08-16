package com.example.trainingapp.data.di

import android.content.Context
import com.example.trainingapp.data.database.TrainingRepository
import com.example.trainingapp.data.database.TrainingRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TrainingRoomDatabase {
        return TrainingRoomDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideTrainingRepository(database: TrainingRoomDatabase): TrainingRepository {
        return TrainingRepository(database.categoryDao(), database.exerciseDao(), database.programDao(), database.movementDao(), database.setDao(), database.tagsDao(), database.userDao(), database.sessionDao())
    }
}