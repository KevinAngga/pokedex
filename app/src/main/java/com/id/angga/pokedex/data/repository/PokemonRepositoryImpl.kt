package com.id.angga.pokedex.data.repository

import com.id.angga.pokedex.data.remote.PokemonApi
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonDetailMapper
import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import com.id.angga.pokedex.domain.repository.PokemonRepository
import com.id.angga.pokedex.domain.util.Resource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi,
    private val pokemonDetailMapper: PokemonDetailMapper
) : PokemonRepository {
    override suspend fun getAllPokemon(): Resource<List<PokemonDetailResponse>> {
        return try {
            val listResponse = api.getPokemonList()
            val pokemonList = mutableListOf<PokemonDetailResponse>()
            coroutineScope {
                listResponse.results.map {
                    launch {
                        val pokemonDetail = getPokemonDetail(it.name).data
                        if (pokemonDetail != null) {
                            pokemonList.add(pokemonDetail)
                        }
                    }
                }
            }
            Resource.Success(
                data = pokemonList
            )
        } catch (e  : Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown Error Occured")
        }
    }

    override suspend fun getPokemonDetail(pokemonName: String): Resource<PokemonDetailResponse> {
        return try {
            val apiResponse = api.getPokemonDetail(pokemonName)
            val mappedResponse = pokemonDetailMapper.mapFrom(apiResponse)
            Resource.Success(
                data = mappedResponse
            )
        } catch (e : Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown Error Occured")
        }
    }

}