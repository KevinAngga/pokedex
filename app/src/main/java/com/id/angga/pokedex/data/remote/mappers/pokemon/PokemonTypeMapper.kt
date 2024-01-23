package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.common.MapperOut
import com.id.angga.pokedex.data.remote.pokemon.PokemonTypeDto
import com.id.angga.pokedex.domain.pokemon.PokemonType
import javax.inject.Inject

class PokemonTypeMapper @Inject constructor(): MapperOut<PokemonTypeDto, PokemonType> {
    override fun mapFrom(from: PokemonTypeDto): PokemonType {
        return PokemonType(
            name = from.name
        )
    }
}