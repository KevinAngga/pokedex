package com.id.angga.pokedex.di

import com.id.angga.pokedex.common.MapperOut
import com.id.angga.pokedex.data.remote.mappers.pokemon.AbilityMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.MoveMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonAbilityMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonDetailMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonListItemMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonListResponseMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonMoveMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonStatMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonTypeItemMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonTypeMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.StatMapper
import com.id.angga.pokedex.data.remote.pokemon.AbilityDto
import com.id.angga.pokedex.data.remote.pokemon.MoveDto
import com.id.angga.pokedex.data.remote.pokemon.PokemonAbilityDto
import com.id.angga.pokedex.data.remote.pokemon.PokemonListItemDto
import com.id.angga.pokedex.data.remote.pokemon.PokemonListResponseDto
import com.id.angga.pokedex.data.remote.pokemon.PokemonMoveDto
import com.id.angga.pokedex.data.remote.pokemon.PokemonStatDto
import com.id.angga.pokedex.data.remote.pokemon.PokemonTypeDto
import com.id.angga.pokedex.data.remote.pokemon.PokemonTypeItemDto
import com.id.angga.pokedex.data.remote.pokemon.StatDto
import com.id.angga.pokedex.domain.pokemon.Ability
import com.id.angga.pokedex.domain.pokemon.Move
import com.id.angga.pokedex.domain.pokemon.PokemonAbility
import com.id.angga.pokedex.domain.pokemon.PokemonListItem
import com.id.angga.pokedex.domain.pokemon.PokemonListResponse
import com.id.angga.pokedex.domain.pokemon.PokemonMove
import com.id.angga.pokedex.domain.pokemon.PokemonStat
import com.id.angga.pokedex.domain.pokemon.PokemonType
import com.id.angga.pokedex.domain.pokemon.PokemonTypeItem
import com.id.angga.pokedex.domain.pokemon.Stat
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    fun providePokemonListItem(): MapperOut<PokemonListItemDto, PokemonListItem> {
        return PokemonListItemMapper()
    }

    @Provides
    fun providePokemonListResponse(pokemonListItemMapper: PokemonListItemMapper)
            : MapperOut<PokemonListResponseDto, PokemonListResponse> {
        return PokemonListResponseMapper(pokemonListItemMapper)
    }

    @Provides
    fun providePokemonType(): MapperOut<PokemonTypeDto, PokemonType> {
        return PokemonTypeMapper()
    }

    @Provides
    fun provideAbility(): MapperOut<AbilityDto, Ability> {
        return AbilityMapper()
    }

    @Provides
    fun providePokemonAbility(abilityMapper: AbilityMapper)
            : MapperOut<PokemonAbilityDto, PokemonAbility> {
        return PokemonAbilityMapper(abilityMapper)
    }

    @Provides
    fun provideStat(): MapperOut<StatDto, Stat> {
        return StatMapper()
    }

    @Provides
    fun providePokemonStat(statMapper: StatMapper): MapperOut<PokemonStatDto, PokemonStat> {
        return PokemonStatMapper(statMapper)
    }

    @Provides
    fun provideMove() : MapperOut<MoveDto, Move> {
        return MoveMapper()
    }

    @Provides
    fun providePokemonMove(moveMapper: MoveMapper) : MapperOut<PokemonMoveDto, PokemonMove> {
        return PokemonMoveMapper(moveMapper)
    }

    @Provides
    fun providePokemonDetail(
        pokemonTypeItemMapper: PokemonTypeItemMapper,
        pokemonStatMapper: PokemonStatMapper,
        pokemonAbilityMapper: PokemonAbilityMapper,
        pokemonMoveMapper: PokemonMoveMapper
    ): PokemonDetailMapper {
        return PokemonDetailMapper(
            pokemonTypeItemMapper,
            pokemonStatMapper,
            pokemonAbilityMapper,
            pokemonMoveMapper
        )
    }

    @Provides
    fun providePokemonTypeItem(pokemonTypeMapper: PokemonTypeMapper): MapperOut<PokemonTypeItemDto, PokemonTypeItem> {
        return PokemonTypeItemMapper(pokemonTypeMapper)
    }
}