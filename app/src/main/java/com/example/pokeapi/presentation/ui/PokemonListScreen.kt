
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokeapi.presentation.component.CustomTopAppBar
import com.example.pokeapi.presentation.component.PokemonGridScreen
import com.example.pokeapi.presentation.ui.SearchInput
import com.example.pokeapi.presentation.viewmodel.PokemonListViewModel
import com.example.pokeapi.ui.theme.titleBold
import com.example.pokeapi.ui.theme.titleRegular

@Composable
fun PokemonListScreen(
    viewModel: PokemonListViewModel = hiltViewModel(),
    onPokemonClick: (String) -> Unit = {}
) {
    // Observa el estado del ViewModel
    val uiState by viewModel.uiState

    // Estado para el campo de búsqueda
    var searchQuery by remember { mutableStateOf("") }

    // Filtra la lista de Pokémon según el valor ingresado
    val filteredList = if (searchQuery.isBlank()) {
        uiState.pokemonList
    } else {
        uiState.pokemonList.filter { pokemon ->
            val id = pokemon.url.split("/").filter { it.isNotBlank() }.lastOrNull() ?: ""
            pokemon.name.contains(searchQuery, ignoreCase = true) || id.contains(searchQuery)
        }
    }

    Scaffold(
        topBar = { CustomTopAppBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Texto de bienvenida
            Box(modifier = Modifier.padding(horizontal = 27.dp, vertical = 20.dp)) {
                Text(
                    text = buildAnnotatedString {
                        append("¡Hola, ")
                        withStyle(style = MaterialTheme.typography.titleBold.toSpanStyle()) {
                            append("bienvenido")
                        }
                        append("!")
                    },
                    style = MaterialTheme.typography.titleRegular,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            // Campo de búsqueda (definido en otro componente, SearchInput)
            Box(modifier = Modifier.padding(horizontal = 27.dp)) {
                SearchInput(
                    value = searchQuery,
                    onValueChange = { searchQuery = it }
                )
            }
            // Grid de fichas de Pokémon
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(27.dp)
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
                        PokemonGridScreen(
                            pokemonList = filteredList,
                            onPokemonClick = onPokemonClick
                        )
                    }
                }
            }
        }
    }
}