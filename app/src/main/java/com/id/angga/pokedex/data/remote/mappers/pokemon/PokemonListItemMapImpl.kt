package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.data.remote.pokemon.PokemonListItemDto
import com.id.angga.pokedex.domain.pokemon.PokemonListItem
import javax.inject.Inject

class PokemonListItemMapImpl @Inject constructor() : PokemonListItemMapper {
    override fun mapDtoToModel(dto: PokemonListItemDto): PokemonListItem {
        return PokemonListItem(
            name = dto.name,
            url = dto.url
        )
    }

    override fun mapModelToDto(model: PokemonListItem): PokemonListItemDto {
        return PokemonListItemDto(
            name = model.name,
            url = model.url
        )
    }
}