package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.data.remote.pokemon.PokemonTypeItemDto
import com.id.angga.pokedex.domain.pokemon.PokemonTypeItem
import javax.inject.Inject

class PokemonTypeItemMapImpl @Inject constructor(
    private val pokemonTypeMapper
: PokemonTypeMapper) : PokemonTypeItemMapper {
    override fun mapToDto(dto: PokemonTypeItemDto): PokemonTypeItem {
        return PokemonTypeItem(
            slot = dto.slot,
            type = pokemonTypeMapper.mapDtoToModel(dto.typeDto)
        )
    }
}