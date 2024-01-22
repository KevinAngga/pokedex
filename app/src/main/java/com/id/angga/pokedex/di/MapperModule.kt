package com.id.angga.pokedex.di

import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonDetailMapImpl
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonDetailMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonListItemMapImpl
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonListItemMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonListResponseMapImpl
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonListResponseMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonTypeItemMapImpl
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonTypeItemMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonTypeMapImpl
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonTypeMapper
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

    @Provides
    fun providePokemonType() : PokemonTypeMapper {
        return PokemonTypeMapImpl()
    }

    @Provides
    fun providePokemonDetail(pokemonTypeItemMapper: PokemonTypeItemMapper) : PokemonDetailMapper {
        return PokemonDetailMapImpl(pokemonTypeItemMapper)
    }

    @Provides
    fun providePokemonTypeItem(pokemonTypeMapper: PokemonTypeMapper) : PokemonTypeItemMapper {
        return PokemonTypeItemMapImpl(pokemonTypeMapper)
    }
}