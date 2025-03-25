package com.example.domain.usecase

import com.example.data.repository.PokemonRepository
import javax.inject.Inject

class GetFullPokemonDetailUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(idOrName: String): Pair<com.example.data.remote.models.PokemonDetailResponse, String> {
        // Llama al método del repositorio que combina el detalle y la descripción
        return repository.getFullPokemonInfo(idOrName)
    }
}
