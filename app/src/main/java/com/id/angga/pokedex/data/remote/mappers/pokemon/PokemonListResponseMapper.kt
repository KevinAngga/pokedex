package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.data.remote.pokemon.PokemonListResponseDto
import com.id.angga.pokedex.domain.pokemon.PokemonListResponse

interface PokemonListResponseMapper {
    fun mapDtoToModel(dto: PokemonListResponseDto): PokemonListResponse
    fun mapModelToDto(model: PokemonListResponse): PokemonListResponseDto
}