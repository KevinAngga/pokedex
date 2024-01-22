package com.id.angga.pokedex.data.repository

import android.util.Log
import com.id.angga.pokedex.data.remote.PokemonApi
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonDetailMapImpl
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonListResponseMapImpl
import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import com.id.angga.pokedex.domain.pokemon.PokemonListResponse
import com.id.angga.pokedex.domain.repository.PokemonRepository
import com.id.angga.pokedex.domain.util.Resource
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi,
    private val pokemonListResponseMapImpl: PokemonListResponseMapImpl,
    private val pokemonDetailMapImpl: PokemonDetailMapImpl
) : PokemonRepository {
    override suspend fun getAllPokemon(): Resource<PokemonListResponse> {
        return try {
            val apiResponse = api.getPokemonList()
            val mappedResponse = pokemonListResponseMapImpl.mapDtoToModel(apiResponse)
            Resource.Success(
                data = mappedResponse
            )

        } catch (e  : Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown Error Occured")
        }
    }

    override suspend fun getPokemonDetail(pokemonName: String): Resource<PokemonDetailResponse> {
        return try {
            val apiResponse = api.getPokemonDetail(pokemonName)
            val mappedResponse = pokemonDetailMapImpl.mapDtoToModel(apiResponse)
            Resource.Success(
                data = mappedResponse
            )
        } catch (e : Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown Error Occured")
        }
    }

}