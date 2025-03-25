package com.example.domain.usecase

import com.example.data.repository.PokemonRepository
import com.example.data.remote.models.PokemonResult
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    // TODO:Posible implementacion futura de obtencion de toda la lista de pokemos
}
