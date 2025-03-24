package com.example.data.remote.api

import com.example.data.remote.models.GenerationResponse
import com.example.data.remote.models.PokemonDetailResponse
import com.example.data.remote.models.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {

    // Endpoint para obtener la lista de Pokémon.
    // Para la 1ª generación, se puede usar limit=151 y offset=0.
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 151,
        @Query("offset") offset: Int = 0
    ): PokemonListResponse

    @GET("generation/1")
    suspend fun getPokemonSpecies(): GenerationResponse

    // Endpoint para obtener el detalle de un Pokémon (por id o nombre).
    @GET("pokemon/{idOrName}")
    suspend fun getPokemonDetail(@Path("idOrName") idOrName: String): PokemonDetailResponse
}
