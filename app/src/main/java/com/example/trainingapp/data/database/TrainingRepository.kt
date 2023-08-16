package com.example.trainingapp.data.database

import com.example.trainingapp.data.database.tables.category_table.CategoryDao
import com.example.trainingapp.data.database.tables.category_table.CategoryTable
import com.example.trainingapp.data.database.tables.exercise_table.ExerciseDao
import com.example.trainingapp.data.database.tables.exercise_table.ExerciseTable
import com.example.trainingapp.data.database.tables.movement_table.MovementDao
import com.example.trainingapp.data.database.tables.movement_table.MovementTable
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
import javax.inject.Inject

class TrainingRepository @Inject constructor(
    private val CategoryDao: CategoryDao,
    private val ExerciseDao: ExerciseDao,
    private val ProgramDao: ProgramDao,
    private val MovementDao: MovementDao,
    private val SetDao: SetDao,
    private val TagsDao: TagsDao,
    private val UserDao: UserDao,
    private val sessionDao: SessionDao
    ){

    fun getAllUserSessionsAsFlow(userId: Int) = sessionDao.getSessionsByUserIdAsFlow(userId)

    suspend fun populateTestData() {
        // CategoryTable test data
        val categories = listOf(
            CategoryTable(id = 0, name = "Cardio", color = "#FF5733"),
            CategoryTable(id = 0, name = "Strength", color = "#33FF57")
        )
        for (category in categories) {
            CategoryDao.insertCategory(category)
        }

        // MovementTable test data
        val movements = listOf(
            MovementTable(id = 0, name = "Running", description = "Running on a flat surface", imgSrc = "url_to_image1", author = "Author1"),
            MovementTable(id = 0, name = "Push up", description = "Push up with hands shoulder-width apart", imgSrc = "url_to_image2", author = "Author2")
        )
        for (movement in movements) {
            MovementDao.insertMovement(movement)
        }

        // UserTable test data
        val users = listOf(
            UserTable(id = 0, firstName = "John", lastName = "Doe", email = "johndoe@example.com", passwordHash = "hashed_password1", dateOfBirth = "1990-01-01", telephone = "1234567890", country = "US"),
            UserTable(id = 0, firstName = "Jane", lastName = "Smith", email = "janesmith@example.com", passwordHash = "hashed_password2", dateOfBirth = "1992-02-02", telephone = "0987654321", country = "UK")
        )
        for (user in users) {
            UserDao.insertUser(user)
        }

        // ExerciseTable test data
        val exercises = listOf(
            ExerciseTable(id = 0, movementId = 1, sets = 3, programId = 1, exNo = 1),
            ExerciseTable(id = 0, movementId = 2, sets = 4, programId = 2, exNo = 2)
        )
        for (exercise in exercises) {
            ExerciseDao.insertExercise(exercise)
        }

        // ProgramTable test data
        val programs = listOf(
            ProgramTable(id = 0, name = "Beginner Running", description = "A beginner's guide to running", author = "John Doe", totalSets = 5, date = "2023-01-01"),
            ProgramTable(id = 0, name = "Advanced Push-ups", description = "Advanced push-up variations and routine", author = "Jane Smith", totalSets = 6, date = "2023-01-15")
        )
        for (program in programs) {
            ProgramDao.insertProgram(program)
        }

        // SessionTable test data
        val sessions = listOf(
            SessionTable(id = 0, userId = 1, date = "2023-02-01", startTime = "08:00", endTime = "09:00", programId = 1, coordinate = "52.5200° N, 13.4050° E", deviance = false, exNo = 1, setNo = 2, tracked = true, status = "Completed"),
            SessionTable(id = 0, userId = 2, date = "2023-02-05", startTime = "10:00", endTime = "11:30", programId = 2, coordinate = "40.7128° N, 74.0060° W", deviance = true, exNo = 2, setNo = 3, tracked = false, status = "Pending")
        )
        for (session in sessions) {
            sessionDao.insertSession(session)
        }

        // SetTable test data
        val sets = listOf(
            SetTable(id = 0, weight = 0.0, reps = 15, time = 30, angle = 0, speed = 10.0, distance = 1000, rest = 60, autoIncrement = true),
            SetTable(id = 0, weight = 50.0, reps = 10, time = 0, angle = 0, speed = 0.0, distance = 0, rest = 90, autoIncrement = false)
        )
        for (set in sets) {
            SetDao.insertSet(set)
        }

        // TagsTable test data
        val tags = listOf(
            TagsTable(id = 0, name = "Outdoor", categoryId = 1),
            TagsTable(id = 0, name = "Strength", categoryId = 2)
        )
        for (tag in tags) {
            TagsDao.insertTag(tag)
        }
    }

    suspend fun getUser(email: String) = UserDao.getUserByEmail(email)

}