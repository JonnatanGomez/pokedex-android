package com.example.domain.usecase

import com.example.data.remote.models.PokemonDetailResponse
import com.example.data.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(idOrName: String): Pair<PokemonDetailResponse, String> {
        return repository.getFullPokemonInfo(idOrName)
    }
}