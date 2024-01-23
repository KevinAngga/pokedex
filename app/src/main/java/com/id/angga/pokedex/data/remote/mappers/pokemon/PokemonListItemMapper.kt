package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.common.MapperOut
import com.id.angga.pokedex.data.remote.pokemon.PokemonListItemDto
import com.id.angga.pokedex.domain.pokemon.PokemonListItem
import javax.inject.Inject

class PokemonListItemMapper @Inject constructor() : MapperOut<PokemonListItemDto, PokemonListItem> {
    override fun mapFrom(from: PokemonListItemDto): PokemonListItem {
        return PokemonListItem(
            name = from.name,
            url = from.url
        )
    }
}