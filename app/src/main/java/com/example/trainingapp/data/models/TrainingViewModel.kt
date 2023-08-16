package com.example.trainingapp.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.work.WorkManager
import com.example.trainingapp.data.database.TrainingRepository
import com.example.trainingapp.data.database.tables.session_table.SessionTable
import com.example.trainingapp.data.database.tables.user_table.UserTable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

const val TAG = "TrainingViewModel"

@HiltViewModel
class TrainingViewModel @Inject constructor(
    private val trainingRepository: TrainingRepository,
    private val workManager: WorkManager
    ): ViewModel() {
        private val currentUser = MutableLiveData<UserTable?>()
        val sessions : LiveData<List<SessionTable>> = trainingRepository.getAllUserSessionsAsFlow(1).asLiveData()


    suspend fun populateTestData() {
        trainingRepository.populateTestData()
    }

    suspend fun loginUser(email: String) {
        currentUser.value = withContext(Dispatchers.IO) {
            trainingRepository.getUser(email)
        }

    }


}