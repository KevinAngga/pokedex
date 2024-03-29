package com.id.angga.pokedex.domain.repository

import com.id.angga.pokedex.data.remote.pokemon.PokemonDetailResponseDto
import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import com.id.angga.pokedex.domain.pokemon.PokemonList
import com.id.angga.pokedex.domain.pokemon.PokemonListResponse
import com.id.angga.pokedex.domain.util.Resource
import kotlinx.coroutines.flow.Flow


interface PokemonRepository {
    suspend fun getAllPokemon(limit : Int, offset : Int) : Resource<PokemonList>
    suspend fun getPokemonDetail(pokemonName : String) : Resource<PokemonDetailResponse>
}