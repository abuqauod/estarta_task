package com.estarta.task.repository

import com.estarta.task.domain.model.ListingModel

interface RecipeRepository {
    suspend fun get(): ListingModel
}
