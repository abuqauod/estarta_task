package  com.estarta.task.repository

import com.estarta.task.domain.model.ListingModel
import com.estarta.task.network.RecipeService
import com.estarta.task.domain.util.ListingDtoMapper

class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val mapper: ListingDtoMapper,
) : RecipeRepository {
    override suspend fun get(): ListingModel {
        return mapper.mapToModel(recipeService.get())
    }

}