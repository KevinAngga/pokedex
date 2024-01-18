package com.id.angga.pokedex.domain.repository

import com.id.angga.pokedex.domain.pokemon.PokemonListResponse
import com.id.angga.pokedex.domain.util.Resource
import kotlinx.coroutines.flow.Flow


interface PokemonRepository {
    suspend fun getAllPokemon() : Resource<PokemonListResponse>
}