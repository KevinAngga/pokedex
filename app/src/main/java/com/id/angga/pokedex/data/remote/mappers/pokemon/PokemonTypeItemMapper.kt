package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.common.MapperOut
import com.id.angga.pokedex.data.remote.pokemon.PokemonTypeItemDto
import com.id.angga.pokedex.domain.pokemon.PokemonTypeItem
import javax.inject.Inject

class PokemonTypeItemMapper @Inject constructor(
    private val pokemonTypeMapper: PokemonTypeMapper) : MapperOut<PokemonTypeItemDto, PokemonTypeItem> {
    override fun mapFrom(from: PokemonTypeItemDto): PokemonTypeItem {
        return PokemonTypeItem(
            slot = from.slot,
            type = pokemonTypeMapper.mapFrom(from.typeDto)
        )
    }
}