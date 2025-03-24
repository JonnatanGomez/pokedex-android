package com.example.pokeapi.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.remote.models.PokemonSpecies
import com.example.domain.usecase.GetPokemonSpeciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonSpeciesUseCase: GetPokemonSpeciesUseCase
) : ViewModel() {

    // Estado para almacenar la lista de Pokémon, el estado de carga y errores.
    var uiState = mutableStateOf(PokemonListUiState())
        private set

    init {
        fetchPokemons()
    }

    private fun fetchPokemons() {
        viewModelScope.launch {
            try {
                // Llama al use case para obtener la lista
                val speciesList: List<PokemonSpecies> = getPokemonSpeciesUseCase().pokemon_species
                println("listado pokemon")
                println(speciesList)
                uiState.value = uiState.value.copy(
                    pokemonList = speciesList,
                    isLoading = false
                )
            } catch (e: Exception) {
                uiState.value = uiState.value.copy(
                    error = e.message ?: "Unknown error",
                    isLoading = false
                )
            }
        }
    }
}

// Estado de la UI para el listado de Pokémon
data class PokemonListUiState(
    val pokemonList: List<PokemonSpecies> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)
