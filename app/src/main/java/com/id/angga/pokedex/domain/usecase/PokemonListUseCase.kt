package com.id.angga.pokedex.domain.usecase

import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import com.id.angga.pokedex.domain.pokemon.PokemonList
import com.id.angga.pokedex.domain.pokemon.PokemonListResponse
import com.id.angga.pokedex.domain.util.Resource

interface PokemonListUseCase {
    suspend fun getPokemonList(limit : Int, offset : Int) :Resource<PokemonListResponse>
    suspend fun getPokemonDetail(pokemonName : String) : Resource<PokemonDetailResponse>
}