package com.id.angga.pokedex.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.id.angga.pokedex.presentation.ui.pokemon.PokemonListScreen
import com.id.angga.pokedex.presentation.ui.pokemon.PokemonViewModel
import com.id.angga.pokedex.presentation.ui.pokemon.detail.DetailViewModel
import com.id.angga.pokedex.presentation.ui.pokemon.detail.PokemonDetailScreen

@Composable
fun SetUpNavGraph(
    mainViewModel: PokemonViewModel,
    navController : NavHostController
) {

    val detailViewModel: DetailViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.HomePage.route
    ) {
        composable(route = Screen.HomePage.route) {
            PokemonListScreen(
                pokemons = mainViewModel.state.pokemons,
                navController,
                detailViewModel = detailViewModel
            )
        }

        composable(Screen.DetailPage.route) {
            PokemonDetailScreen(
                pokemonDetailResponse = detailViewModel.pokemon
            )
        }
    }
}