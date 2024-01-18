package com.id.angga.pokedex.domain.pokemon


data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonListItem>
)
