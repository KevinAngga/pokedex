package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.data.remote.pokemon.PokemonListItemDto
import com.id.angga.pokedex.domain.pokemon.PokemonListItem

interface PokemonListItemMapper {
    fun mapDtoToModel(dto: PokemonListItemDto): PokemonListItem
    fun mapModelToDto(model: PokemonListItem): PokemonListItemDto
}