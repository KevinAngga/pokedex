package com.id.angga.pokedex.domain.pokemon

data class PokemonList(
    val pokemonList : MutableList<PokemonDetailResponse> = mutableListOf(),
    var totalCount : Int = 0
)
