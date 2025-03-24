package com.example.pokeapi.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.data.remote.models.PokemonDetailResponse

@Composable
fun PokemonDetailContent(detail: PokemonDetailResponse) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Datos generales
        Text(text = "Datos Generales", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))
        // Foto (usamos la imagen oficial del Pokémon)
        AsyncImage(
            model = detail.sprites.other.officialArtwork.frontDefault,
            contentDescription = "Imagen de ${detail.species.name}",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Peso: ${detail.weight}")
        Text(text = "Altura: ${detail.height}")
        // Si se decide obtener la descripción desde el endpoint species, aquí se mostraría.
        // Por ejemplo: Text(text = "Descripción: ${detail.description}")

        Spacer(modifier = Modifier.height(16.dp))

        // Estadísticas
        Text(text = "Estadísticas", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))
        detail.stats.forEach { stat ->
            // Mapea cada stat. Por ejemplo:
            val statName = stat.stat.name.replaceFirstChar { it.uppercase() }
            Text(text = "$statName: ${stat.baseStat}")
        }
    }
}
