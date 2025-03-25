package com.example.data.remote.api

import com.example.data.remote.models.GenerationResponse
import com.example.data.remote.models.PokemonDetailResponse
import com.example.data.remote.models.PokemonListResponse
import com.example.data.remote.models.PokemonSpeciesDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {

    //Obtiene pokemons de la primera generacion
    @GET("generation/1")
    suspend fun getPokemonSpecies(): GenerationResponse

    // Endpoint para obtener el detalle de un Pokémon (por id o nombre).
    @GET("pokemon/{idOrName}")
    suspend fun getPokemonDetail(@Path("idOrName") idOrName: String): PokemonDetailResponse

    //Especies
    @GET("pokemon-species/{idOrName}")
    suspend fun getPokemonSpeciesDetail(
        @Path("idOrName") idOrName: String
    ): PokemonSpeciesDetailResponse
}
