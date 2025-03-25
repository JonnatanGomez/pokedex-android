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
import androidx.navigation.NavController
import com.example.pokeapi.presentation.component.DetailTopAppBar
import com.example.pokeapi.presentation.component.PokemonDetailContent
import com.example.pokeapi.presentation.viewmodel.PokemonDetailViewModel

@Composable
fun PokemonDetailScreen(
    idOrName: String,
    navController: NavController,
    viewModel: PokemonDetailViewModel = hiltViewModel()
) {
    LaunchedEffect(idOrName) {
        viewModel.fetchPokemonDetail(idOrName)
    }

    val uiState = viewModel.uiState

    Scaffold(
        topBar = { DetailTopAppBar(
            pokemonName = idOrName.ifEmpty { "Detalle" },
            onBackClick = {
                navController.popBackStack()
            }
        ) }
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
                uiState.error != null -> {
                    Text(
                        text = uiState.error ?: "Error desconocido",
                        color = MaterialTheme.colors.error,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                else -> {
                    uiState.detail?.let { detail ->
                        PokemonDetailContent(detail = detail, description = uiState.description ?: "")
                    }
                }
            }
        }
    }
}
