package com.id.angga.pokedex.domain.usecase

import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import com.id.angga.pokedex.domain.util.Resource

interface PokemonListUseCase {
    suspend fun getPokemonList() :Resource<List<PokemonDetailResponse>>
    suspend fun getPokemonDetail(pokemonName : String) : Resource<PokemonDetailResponse>
}