package com.example.amphibians.data

sealed interface UiState {
    data class Success(val amphibians: List<Amphibian>) : UiState
    object Error : UiState
    object Loading : UiState
}

