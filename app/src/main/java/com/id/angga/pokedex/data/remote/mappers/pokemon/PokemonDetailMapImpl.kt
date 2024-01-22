package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.data.remote.pokemon.PokemonDetailResponseDto
import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import com.id.angga.pokedex.presentation.ui.pokemon.PokemonTypeColour
import javax.inject.Inject

class PokemonDetailMapImpl @Inject constructor(
    private val pokemonTypeListMapper: PokemonTypeItemMapper
) : PokemonDetailMapper {
    override fun mapDtoToModel(dto: PokemonDetailResponseDto): PokemonDetailResponse {
        return PokemonDetailResponse(
            id = dto.id,
            name = dto.name,
            weight = dto.weight,
            types = dto.types.map {
                pokemonTypeListMapper.mapToDto(it)
            }
        )
    }
}