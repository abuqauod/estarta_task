package com.estarta.task.domain.util

import com.estarta.task.domain.model.ListingModel
import com.estarta.task.domain.model.PaginationModel
import com.estarta.task.domain.model.ResultsModel
import com.estarta.task.network.entity.ListingDto

class ListingDtoMapper : DomainMapper<ListingDto, ListingModel> {

    override fun mapToModel(dto: ListingDto): ListingModel {
        val listing = ListingModel()

        val results = arrayListOf<ResultsModel>()
        dto.results.forEach {
            val items = ResultsModel()
            items.createdAt = it.createdAt
            items.price = it.price
            items.name = it.name
            items.uid = it.uid
            items.imageIds = it.imageIds
            items.imageUrls = it.imageUrls
            items.imageUrlsThumbnails = it.imageUrlsThumbnails
            results.add(items)
        }

        val pagination = PaginationModel()
        pagination.key = dto.paginationDto?.key

        listing.results = results
        listing.paginationModel = pagination
        return listing
    }
}
