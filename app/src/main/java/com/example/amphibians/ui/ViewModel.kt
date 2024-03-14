package com.example.amphibians.ui


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.data.Amphibian
import com.example.amphibians.data.NetworkRepository
import com.example.amphibians.data.Repository
import com.example.amphibians.data.UiState
import com.example.amphibians.network.ApiService
import kotlinx.coroutines.launch
import com.example.amphibians.network.Api
import retrofit2.HttpException
import java.io.IOException


class ViewModel : ViewModel() {

    var uiState: UiState by mutableStateOf(UiState.Loading)
        private set

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            uiState = try {
                val repository = NetworkRepository()
                val listResult = repository.getAmphibians()
                UiState.Success(listResult)
            } catch (e: IOException) {
                UiState.Error
            }

        }
    }
}