package com.estarta.task.di

import com.estarta.task.network.RecipeService
import com.estarta.task.domain.util.ListingDtoMapper
import com.estarta.task.repository.RecipeRepository
import com.estarta.task.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeMapper: ListingDtoMapper,
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            recipeService = recipeService,
            mapper = recipeMapper
        )
    }
}

