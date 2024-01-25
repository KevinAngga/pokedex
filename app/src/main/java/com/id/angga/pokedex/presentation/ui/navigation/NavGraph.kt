package com.id.angga.pokedex.presentation.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.id.angga.pokedex.presentation.ui.pokemon.PokemonListScreen
import com.id.angga.pokedex.presentation.ui.pokemon.PokemonViewModel
import com.id.angga.pokedex.presentation.ui.pokemon.detail.DetailViewModel
import com.id.angga.pokedex.presentation.ui.pokemon.detail.PokemonDetailScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SetUpNavGraph(
    mainViewModel: PokemonViewModel,
    navController : NavHostController
) {

    val detailViewModel: DetailViewModel = viewModel()

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize()
                .navigationBarsPadding(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
    }
}