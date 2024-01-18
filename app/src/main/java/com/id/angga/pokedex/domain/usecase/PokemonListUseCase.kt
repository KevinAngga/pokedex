package com.id.angga.pokedex.domain.usecase

import com.id.angga.pokedex.domain.pokemon.PokemonListResponse
import com.id.angga.pokedex.domain.util.Resource

interface PokemonListUseCase {
    suspend fun getPokemonList() :Resource<PokemonListResponse>
}