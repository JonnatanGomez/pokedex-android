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

    suspend fun getPokemonDetail(idOrName: String): PokemonDetailResponse {
        return apiService.getPokemonDetail(idOrName)
    }

    suspend fun getPokemonSpeciesDescription(
        idOrName: String,
        languageCode: String = "es"
    ): String {
        val speciesDetail = apiService.getPokemonSpeciesDetail(idOrName)
        // Filtra el primer flavor text en español
        val flavorText = speciesDetail.flavorTextEntries.firstOrNull {
            it.language.name == languageCode
        }?.flavorText
        return flavorText
            ?.replace("\n", " ")
            ?.replace("\u000C", " ")
            ?: "Descripción no disponible"
    }

    suspend fun getFullPokemonInfo(idOrName: String): Pair<PokemonDetailResponse, String> {
        val detail = apiService.getPokemonDetail(idOrName)
        // Llamar a la especie para obtener la descripción
        val description = getPokemonSpeciesDescription(idOrName, "es")
        // Retornar ambos
        return Pair(detail, description)
    }

}
