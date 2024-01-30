package com.id.angga.pokedex.domain.usecase

import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import com.id.angga.pokedex.domain.pokemon.PokemonList
import com.id.angga.pokedex.domain.repository.PokemonRepository
import com.id.angga.pokedex.domain.util.Resource
import javax.inject.Inject

class PokemonListUseCaseImpl @Inject constructor(private val pokemonRepository
                                                 : PokemonRepository) : PokemonListUseCase {
    override suspend fun getPokemonList(limit : Int, offset : Int): Resource<PokemonList> {
        return try {
            val pokemonListResponse = pokemonRepository.getAllPokemon(limit, offset)
            Resource.Success(
                data = pokemonListResponse.data
            )
        } catch (e : Exception) {
            Resource.Error("Failed to fetch Pokemon", null)
        }
    }

    override suspend fun getPokemonDetail(pokemonName: String): Resource<PokemonDetailResponse> {
        return pokemonRepository.getPokemonDetail(pokemonName)
    }
}