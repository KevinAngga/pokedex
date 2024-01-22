package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.data.remote.pokemon.PokemonTypeItemDto
import com.id.angga.pokedex.domain.pokemon.PokemonTypeItem

interface PokemonTypeItemMapper {
    fun mapToDto(dto : PokemonTypeItemDto) : PokemonTypeItem
}