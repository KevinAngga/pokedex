package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.common.MapperOut
import com.id.angga.pokedex.data.remote.pokemon.PokemonListResponseDto
import com.id.angga.pokedex.domain.pokemon.PokemonListResponse
import javax.inject.Inject

class PokemonListResponseMapper @Inject constructor(private val pokemonListItemMapper
: PokemonListItemMapper) : MapperOut<PokemonListResponseDto, PokemonListResponse> {
    override fun mapFrom(from: PokemonListResponseDto): PokemonListResponse {
        return PokemonListResponse(
            count = from.count,
            next = from.next,
            previous = from.previous,
            results = from.results.map {
                pokemonListItemMapper.mapFrom(it)
            }
        )
    }
}