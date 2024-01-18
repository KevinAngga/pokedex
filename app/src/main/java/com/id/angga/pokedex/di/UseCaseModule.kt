package com.id.angga.pokedex.di

import com.id.angga.pokedex.domain.repository.PokemonRepository
import com.id.angga.pokedex.domain.usecase.PokemonListUseCase
import com.id.angga.pokedex.domain.usecase.PokemonListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun providesPokemonListUseCase(pokemonRepository: PokemonRepository) : PokemonListUseCase {
        return PokemonListUseCaseImpl(pokemonRepository)
    }
}