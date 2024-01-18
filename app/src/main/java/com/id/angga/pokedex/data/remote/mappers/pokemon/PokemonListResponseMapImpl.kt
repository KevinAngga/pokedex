package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.data.remote.pokemon.PokemonListResponseDto
import com.id.angga.pokedex.domain.pokemon.PokemonListResponse
import javax.inject.Inject

class PokemonListResponseMapImpl @Inject constructor(private val pokemonListItemMapper
: PokemonListItemMapper) : PokemonListResponseMapper {
    override fun mapDtoToModel(dto: PokemonListResponseDto): PokemonListResponse {
        return PokemonListResponse(
            count = dto.count,
            next = dto.next,
            previous = dto.previous,
            results = dto.results.map {
                pokemonListItemMapper.mapDtoToModel(it)
            }
        )
    }

    override fun mapModelToDto(model: PokemonListResponse): PokemonListResponseDto {
        return PokemonListResponseDto(
            count = model.count,
            next = model.next,
            previous = model.previous,
            results = model.results.map {
                pokemonListItemMapper.mapModelToDto(it)
            }
        )
    }
}