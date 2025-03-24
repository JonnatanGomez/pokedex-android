package com.example.pokeapi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.remote.models.PokemonDetailResponse
import com.example.domain.usecase.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel() {

    var uiState by mutableStateOf(PokemonDetailUiState())
        private set

    fun fetchPokemonDetail(idOrName: String) {
        viewModelScope.launch {
            try {
                val detail = getPokemonDetailUseCase(idOrName)
                uiState = uiState.copy(detail = detail, isLoading = false)
            } catch (e: Exception) {
                uiState = uiState.copy(
                    error = e.message ?: "Error desconocido",
                    isLoading = false
                )
            }
        }
    }
}

data class PokemonDetailUiState(
    val detail: PokemonDetailResponse? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)