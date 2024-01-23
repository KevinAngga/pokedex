package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.common.MapperOut
import com.id.angga.pokedex.data.remote.pokemon.AbilityDto
import com.id.angga.pokedex.domain.pokemon.Ability
import javax.inject.Inject

class AbilityMapper @Inject constructor() : MapperOut<AbilityDto, Ability> {
    override fun mapFrom(from: AbilityDto): Ability {
        return Ability(
            name = from.name
        )
    }
}