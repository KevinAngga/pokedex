package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.data.remote.pokemon.PokemonTypeDto
import com.id.angga.pokedex.domain.pokemon.PokemonType

interface PokemonTypeMapper {
    fun mapDtoToModel(dto : PokemonTypeDto) : PokemonType
}