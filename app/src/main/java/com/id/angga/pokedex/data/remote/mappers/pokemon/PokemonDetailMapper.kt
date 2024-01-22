package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.data.remote.pokemon.PokemonDetailResponseDto
import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse

interface PokemonDetailMapper {
    fun mapDtoToModel(dto: PokemonDetailResponseDto) : PokemonDetailResponse
}