package com.example.pokeapi.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.remote.models.PokemonDetailResponse
import com.example.domain.usecase.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PokemonDetailUiState(
    val detail: PokemonDetailResponse? = null,
    val description: String? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel() {

    var uiState by mutableStateOf(PokemonDetailUiState())
        private set

    fun fetchPokemonDetail(idOrName: String) {
        viewModelScope.launch {
            try {
                // Se retorna un Pair con el detalle y la descripción
                val (detail, description) = getPokemonDetailUseCase(idOrName)
                uiState = uiState.copy(detail = detail, description = description, isLoading = false)
            } catch (e: Exception) {
                uiState = uiState.copy(error = e.message ?: "Error desconocido", isLoading = false)
            }
        }
    }
}
