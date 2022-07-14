package com.estarta.task.network.entity

import com.google.gson.annotations.SerializedName

data class PaginationDto(
    @SerializedName("key") var key: String? = null
)