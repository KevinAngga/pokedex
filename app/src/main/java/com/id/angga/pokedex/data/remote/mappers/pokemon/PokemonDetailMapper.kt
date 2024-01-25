package com.id.angga.pokedex.data.remote.mappers.pokemon

import com.id.angga.pokedex.common.MapperOut
import com.id.angga.pokedex.data.remote.pokemon.PokemonDetailResponseDto
import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import javax.inject.Inject

class PokemonDetailMapper @Inject constructor(
    private val pokemonTypeListMapper: PokemonTypeItemMapper,
    private val pokemonStatMapper: PokemonStatMapper,
    private val pokemonAbilityMapper: PokemonAbilityMapper,
    private val pokemonMoveMapper: PokemonMoveMapper
) : MapperOut<PokemonDetailResponseDto, PokemonDetailResponse> {
    override fun mapFrom(from: PokemonDetailResponseDto): PokemonDetailResponse {
        return PokemonDetailResponse(
            id = from.id,
            name = from.name,
            weight = from.weight,
            height = from.height,
            types = from.types.map {
                pokemonTypeListMapper.mapFrom(it)
            },
            stat = from.stats.map {
                pokemonStatMapper.mapFrom(it)
            },
            abilities = from.abilities.map {
                pokemonAbilityMapper.mapFrom(it)
            },
            moves = from.moves.map {
                pokemonMoveMapper.mapFrom(it)
            }
        )
    }
}