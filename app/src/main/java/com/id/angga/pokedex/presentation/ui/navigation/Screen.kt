package com.id.angga.pokedex.presentation.ui.navigation

sealed class Screen(val route : String) {
    object HomePage : Screen("home")
    object DetailPage : Screen("detail")
}