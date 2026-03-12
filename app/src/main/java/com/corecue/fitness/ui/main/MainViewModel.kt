package com.corecue.fitness.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.corecue.fitness.data.model.Exercise
import com.corecue.fitness.data.model.SessionSummary
import com.corecue.fitness.data.model.SessionTrendPoint
import com.corecue.fitness.data.model.WorkoutReport
import com.corecue.fitness.data.repo.FitnessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: FitnessRepository
) : ViewModel() {

    private val _exercises = MutableStateFlow<List<Exercise>>(emptyList())
    val exercises: StateFlow<List<Exercise>> = _exercises.asStateFlow()

    private val _selectedExercise = MutableStateFlow<Exercise?>(null)
    val selectedExercise: StateFlow<Exercise?> = _selectedExercise.asStateFlow()

    private val _report = MutableStateFlow<WorkoutReport?>(null)
    val report: StateFlow<WorkoutReport?> = _report.asStateFlow()
    private val _sessionSummaries = MutableStateFlow<List<SessionSummary>>(emptyList())
    val sessionSummaries: StateFlow<List<SessionSummary>> = _sessionSummaries.asStateFlow()
    private val _trendPoints = MutableStateFlow<List<SessionTrendPoint>>(emptyList())
    val trendPoints: StateFlow<List<SessionTrendPoint>> = _trendPoints.asStateFlow()

    init {
        bootstrap()
    }

    private fun bootstrap() {
        viewModelScope.launch {
            repository.seedIfNeeded()
            launch {
                repository.observeExercises().collectLatest { _exercises.value = it }
            }
            launch {
                repository.observeSessionSummaries().collectLatest { _sessionSummaries.value = it }
            }
            refreshTrends()
        }
    }

    fun selectExercise(exercise: Exercise) {
        _selectedExercise.value = exercise
    }

    fun loadReport() {
        viewModelScope.launch {
            _report.value = repository.generateAndStoreReport(_selectedExercise.value)
            refreshTrends()
        }
    }

    private suspend fun refreshTrends() {
        _trendPoints.value = repository.getTrendPoints()
    }
}
