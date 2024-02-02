package com.id.angga.pokedex.presentation.ui.pokemon.detail

import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse

data class PokemonDetailUiState (
    val pokemon : PokemonDetailResponse = PokemonDetailResponse(),
    val isLoading : Boolean = false,
    val error : String? = null
)