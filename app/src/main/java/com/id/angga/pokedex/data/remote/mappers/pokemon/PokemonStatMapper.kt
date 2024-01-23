package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.common.MapperOut
import com.id.angga.pokedex.data.remote.pokemon.PokemonStatDto
import com.id.angga.pokedex.domain.pokemon.PokemonStat
import javax.inject.Inject

class PokemonStatMapper @Inject constructor(val statMapper: StatMapper): MapperOut<PokemonStatDto, PokemonStat> {
    override fun mapFrom(from: PokemonStatDto): PokemonStat {
        return PokemonStat(
            baseStat = from.baseStat,
            stat = statMapper.mapFrom(from.stat)
        )
    }
}