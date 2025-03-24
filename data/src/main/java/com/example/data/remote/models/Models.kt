package com.example.data.remote.models
import com.google.gson.annotations.SerializedName

// Modelo Lista Pokemon
data class GenerationResponse(
    val id: Int,
    val name: String,
    val pokemon_species: List<PokemonSpecies>
)

data class PokemonSpecies(
    val name: String,
    val url: String
)

data class PokemonListResponse(
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)

// Modelo Detalle Pokemon
data class PokemonDetailResponse(
    val id: Int,
    val weight: Int,
    val height: Int,
    val stats: List<Stat>,
    val sprites: Sprites,
    val species: NamedAPIResource
)

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int,
    val stat: NamedAPIResource
)

data class Sprites(
    @SerializedName("other")
    val other: OtherSprites
)

data class OtherSprites(
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork
)

data class OfficialArtwork(
    @SerializedName("front_default")
    val frontDefault: String?
)

data class NamedAPIResource(
    val name: String,
    val url: String
)