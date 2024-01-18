package com.id.angga.pokedex.di

import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonListItemMapImpl
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonListItemMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonListResponseMapImpl
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonListResponseMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    fun providePokemonListItem() : PokemonListItemMapper {
        return PokemonListItemMapImpl()
    }

    @Provides
    fun providePokemonListResponse(pokemonListItemMapper: PokemonListItemMapper) : PokemonListResponseMapper {
        return PokemonListResponseMapImpl(pokemonListItemMapper)
    }
}