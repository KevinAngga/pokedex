package com.id.angga.pokedex.domain.repository

import com.id.angga.pokedex.data.remote.pokemon.PokemonDetailResponseDto
import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import com.id.angga.pokedex.domain.pokemon.PokemonListResponse
import com.id.angga.pokedex.domain.util.Resource
import kotlinx.coroutines.flow.Flow


interface PokemonRepository {
    suspend fun getAllPokemon() : Resource<List<PokemonDetailResponse>>
    suspend fun getPokemonDetail(pokemonName : String) : Resource<PokemonDetailResponse>
}