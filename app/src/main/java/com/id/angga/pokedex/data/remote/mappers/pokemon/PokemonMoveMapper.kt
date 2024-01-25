package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.common.MapperOut
import com.id.angga.pokedex.data.remote.pokemon.PokemonMoveDto
import com.id.angga.pokedex.domain.pokemon.PokemonMove
import javax.inject.Inject

class PokemonMoveMapper @Inject constructor(
    val moveMapper: MoveMapper
): MapperOut<PokemonMoveDto, PokemonMove> {
    override fun mapFrom(from: PokemonMoveDto): PokemonMove {
        return PokemonMove(
            move = moveMapper.mapFrom(from.move)
        )
    }
}