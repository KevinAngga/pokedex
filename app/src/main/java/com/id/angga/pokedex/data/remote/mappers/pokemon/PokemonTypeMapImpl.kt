package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.data.remote.pokemon.PokemonTypeDto
import com.id.angga.pokedex.domain.pokemon.PokemonType
import javax.inject.Inject

class PokemonTypeMapImpl @Inject constructor(): PokemonTypeMapper {
    override fun mapDtoToModel(dto: PokemonTypeDto): PokemonType {
        return PokemonType(
            name = dto.name
        )
    }
}