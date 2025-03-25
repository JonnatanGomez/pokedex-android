package com.example.pokeapi.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.data.remote.models.PokemonDetailResponse
import com.example.data.remote.models.Stat
import com.example.pokeapi.ui.theme.textRecular
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState


@Composable
fun PokemonDetailContent(detail: PokemonDetailResponse, description: String) {
    val pokemonName = detail.species.name.replaceFirstChar { it.uppercase() }
    val pokemonId = "#${detail.id.toString().padStart(3, '0')}"

    //TODO: Pulir diseño para apegarse mas a figma, en estilo de fondo, iconos y barra de estadisticas.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // Habilita el scroll vertical
    ) {
        HeaderSection(pokemonName, pokemonId)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(top = 32.dp)
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        color = Color.Black,
                        shape = RoundedCornerShape(16.dp)
                    )
            )
            AsyncImage(
                model = detail.sprites.other.home.frontDefault,
                contentDescription = "Imagen de $pokemonName",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(270.dp)
            )
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                detail.types.forEach { typeEntry ->
                    TypeChip(typeName = typeEntry.type.name, typeUrl = typeEntry.type.url)
                }
            }
        }
        BasicInfoSection(weight = detail.weight, height = detail.height)
        DescriptionSection(description = description)
        StatsSection(detail.stats)
    }
}

@Composable
fun HeaderSection(name: String, id: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.h5
        )
        Text(
            text = id,
            style = MaterialTheme.typography.subtitle1,
            color = Color.Gray
        )
    }
}

@Composable
fun TypeChip(typeName: String, typeUrl: String) {

    //Traduccion de tipos
    //TODO:Construir api para obtener tipos e iconos.
    val displayedName = when (typeName.lowercase()) {
        "grass" -> "Planta"
        "poison" -> "Veneno"
        "fire" -> "Fuego"
        "water" -> "Agua"
        "electric" -> "Electrico"
        else -> typeName.replaceFirstChar { it.uppercase() }
    }
    val displayedImage = when (typeName.lowercase()) {
        "grass" -> "\uD83C\uDF3F"
        "poison" -> "\uD83D\uDC0D"
        "fire" -> "\uD83D\uDD25"
        "water" -> "\uD83D\uDCA7"
        "electric" -> "\uD83C\uDF29\uFE0F"
        else -> typeName.replaceFirstChar { it.uppercase() }
    }

    Box(
        modifier = Modifier
            .background(
                color = Color(0xFFBBF7D0), //Todo:Cambia color dependiendo del pokemon
                shape = RoundedCornerShape(50) // Chip redondeado
            )
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                append(displayedName)
                append(" $displayedImage")
            },
            style = MaterialTheme.typography.textRecular
        )
    }
}

@Composable
fun BasicInfoSection(weight: Int, height: Int) {
    val weightInKg = weight / 10f
    val heightInM = height / 10f

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        //Suponiendo que son kilogramos
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "${weightInKg} kg", style = MaterialTheme.typography.subtitle1)
            Text(text = "Peso", style = MaterialTheme.typography.caption)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "${heightInM} m", style = MaterialTheme.typography.subtitle1)
            Text(text = "Altura", style = MaterialTheme.typography.caption)
        }
    }
}

@Composable
fun DescriptionSection(description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(27.dp)
    ) {
        Text(text = "Descripción", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = description, style = MaterialTheme.typography.body1)
    }
}


@Composable
fun StatsSection(stats: List<Stat>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(27.dp)
    ) {
        Text(
            text = "Estadísticas",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        stats.forEach { stat ->
            val statName = stat.stat.name.replaceFirstChar { it.uppercaseChar() }
            // Se asume que la estadística base está entre 0 y 200 aprox.
            StatItem(statName, stat.baseStat)
        }
    }
}

@Composable
fun StatItem(statName: String, baseValue: Int) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = statName)
        // Uso de LinearProgressIndicator para ejemplificar barras
        LinearProgressIndicator(
            progress = (baseValue.coerceIn(0, 200)) / 200f,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = Color(0xFF00C853) // verde ejemplo
        )
        Text(
            text = baseValue.toString(),
            style = MaterialTheme.typography.caption,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}
