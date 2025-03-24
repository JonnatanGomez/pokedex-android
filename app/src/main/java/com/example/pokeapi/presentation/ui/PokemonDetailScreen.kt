package com.example.pokeapi.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokeapi.presentation.component.CustomTopAppBar
import com.example.pokeapi.presentation.component.PokemonDetailContent
import com.example.pokeapi.presentation.viewmodel.PokemonDetailViewModel

@Composable
fun PokemonDetailScreen(
    idOrName: String,
    viewModel: PokemonDetailViewModel = hiltViewModel()
) {
    LaunchedEffect(idOrName) {
        viewModel.fetchPokemonDetail(idOrName)
    }

    val uiState = viewModel.uiState

    Scaffold(
        topBar = { CustomTopAppBar() }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                uiState.isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                uiState.detail != null -> {
                    PokemonDetailContent(detail = uiState.detail)
                }
                else -> {
                    // Si no hay detalle y no se está cargando, mostramos un error.
                    Text(
                        text = uiState.error ?: "No se pudo cargar el detalle",
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colors.error
                    )
                }
            }
        }
    }
}
