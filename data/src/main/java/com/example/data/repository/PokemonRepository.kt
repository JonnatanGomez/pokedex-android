package com.example.data.repository

import com.example.data.remote.api.PokeApiService
import com.example.data.remote.models.GenerationResponse
import com.example.data.remote.models.PokemonDetailResponse
import com.example.data.remote.models.PokemonResult
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val apiService: PokeApiService
) {

    suspend fun getPokemonSpecies(): GenerationResponse {
        return  apiService.getPokemonSpecies()
    }

    suspend fun getPokemonList(): List<PokemonResult> {
        return apiService.getPokemonList().results
    }

    suspend fun getPokemonDetail(idOrName: String): PokemonDetailResponse {
        return apiService.getPokemonDetail(idOrName)
    }
}
