package com.id.angga.pokedex.domain.usecase

import com.id.angga.pokedex.domain.pokemon.PokemonListResponse
import com.id.angga.pokedex.domain.repository.PokemonRepository
import com.id.angga.pokedex.domain.util.Resource
import javax.inject.Inject

class PokemonListUseCaseImpl @Inject constructor(private val pokemonRepository
                                                 : PokemonRepository) : PokemonListUseCase {
    override suspend fun getPokemonList(): Resource<PokemonListResponse> {
        return pokemonRepository.getAllPokemon()
    }

}