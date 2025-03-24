package com.example.domain.usecase

import com.example.data.repository.PokemonRepository
import com.example.data.remote.models.PokemonResult
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    // Hace que la clase se pueda invocar como una función
    suspend operator fun invoke(): List<PokemonResult> {
        return repository.getPokemonList()
    }
}
