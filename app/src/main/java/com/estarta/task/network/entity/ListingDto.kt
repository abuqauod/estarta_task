package com.estarta.task.network.entity

import com.google.gson.annotations.SerializedName

data class ListingDto(
    @SerializedName("results") var results: ArrayList<ResultsDto> = arrayListOf(),
    @SerializedName("pagination") var paginationDto: PaginationDto? = PaginationDto()
)