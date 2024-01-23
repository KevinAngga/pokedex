package com.id.angga.pokedex.data.remote.mappers.pokemon


import com.id.angga.pokedex.common.MapperOut
import com.id.angga.pokedex.data.remote.pokemon.PokemonAbilityDto
import com.id.angga.pokedex.domain.pokemon.PokemonAbility
import javax.inject.Inject

class PokemonAbilityMapper @Inject constructor(
    val abilityMapper: AbilityMapper) : MapperOut<PokemonAbilityDto, PokemonAbility> {
    override fun mapFrom(from: PokemonAbilityDto): PokemonAbility {
        return PokemonAbility(
            ability = abilityMapper.mapFrom(from.ability),
            isHidden = from.isHidden
        )
    }

}