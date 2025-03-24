package com.example.domain.usecase

import com.example.data.remote.models.GenerationResponse
import com.example.data.remote.models.PokemonSpecies
import com.example.data.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonSpeciesUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(): GenerationResponse {
        return repository.getPokemonSpecies()
    }
}
