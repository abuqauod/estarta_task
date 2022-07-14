package com.estarta.task.di

import com.estarta.task.network.RecipeService
import com.estarta.task.domain.util.ListingDtoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideListingMapper(): ListingDtoMapper {
        return ListingDtoMapper()
    }

    @Singleton
    @Provides
    fun provideRetrofitService(): RecipeService {
        return Retrofit.Builder()
            .baseUrl("https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RecipeService::class.java)
    }
}