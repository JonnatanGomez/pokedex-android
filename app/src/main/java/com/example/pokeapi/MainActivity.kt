package com.example.pokeapi

import PokemonListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokeapi.presentation.ui.PokemonDetailScreen
import com.example.pokeapi.ui.theme.PokeApiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeApiTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "pokemon_list"
                ) {
                    composable("pokemon_list") {
                        PokemonListScreen(
                            onPokemonClick = { idOrName ->
                                navController.navigate("pokemon_detail/$idOrName")
                            }
                        )
                    }
                    composable("pokemon_detail/{idOrName}") { backStackEntry ->
                        val idOrName = backStackEntry.arguments?.getString("idOrName")
                        PokemonDetailScreen(idOrName = idOrName ?: "",navController = navController,)
                    }
                }
            }
        }
    }
}
