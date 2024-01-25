package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.common.MapperOut
import com.id.angga.pokedex.data.remote.pokemon.StatDto
import com.id.angga.pokedex.domain.pokemon.Stat
import javax.inject.Inject

class StatMapper @Inject constructor(): MapperOut<StatDto, Stat> {
    override fun mapFrom(from: StatDto): Stat {
        return Stat(
            name = changeStatName(from.name),
            url = from.url
        )
    }

    private fun changeStatName(stat : String) : String {
        return when (stat) {
            "special-attack" -> "sp.Atk"
            "special-defense" -> "sp.Def"
            else -> stat
        }
    }
}