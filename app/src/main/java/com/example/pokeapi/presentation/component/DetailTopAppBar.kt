package com.example.pokeapi.presentation.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokeapi.R

@Composable
fun DetailTopAppBar(
    pokemonName: String,
    onBackClick: () -> Unit
) {
    androidx.compose.material.TopAppBar(
        title = {
            Text(
                text = ""
            )
        },
        navigationIcon = {
            // Botón de retroceso
            androidx.compose.material.IconButton(onClick = onBackClick) {
                androidx.compose.material.Icon(
                    painter = androidx.compose.ui.res.painterResource(id = R.drawable.arrow),
                    contentDescription = "Regresar",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(75.dp).padding(top = 25.dp)
                )
            }
        },
        backgroundColor = Color.White,
        modifier = Modifier.height(106.dp),
        elevation = 4.dp
    )
}
