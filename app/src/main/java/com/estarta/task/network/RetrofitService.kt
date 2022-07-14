package com.estarta.task.network

import com.estarta.task.network.entity.ListingDto
import retrofit2.http.GET

interface RecipeService {
    @GET("default/dynamodb-writer")
    suspend fun get(): ListingDto
}