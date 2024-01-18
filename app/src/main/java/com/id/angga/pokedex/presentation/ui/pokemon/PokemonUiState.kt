package com.id.angga.pokedex.presentation.ui.pokemon

import com.id.angga.pokedex.domain.pokemon.PokemonListItem

data class PokemonUiState(
    val pokemons : List<PokemonListItem> = emptyList(),
    val isLoading : Boolean = false,
    val error :String? = null
)
