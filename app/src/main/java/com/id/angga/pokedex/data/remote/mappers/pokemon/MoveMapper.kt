package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.common.MapperOut
import com.id.angga.pokedex.data.remote.pokemon.MoveDto
import com.id.angga.pokedex.domain.pokemon.Move
import javax.inject.Inject

class MoveMapper @Inject constructor(): MapperOut<MoveDto, Move> {
    override fun mapFrom(from: MoveDto): Move {
        return Move(
            name = from.name
        )
    }
}