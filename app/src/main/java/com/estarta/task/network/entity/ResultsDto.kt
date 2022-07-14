package com.estarta.task.network.entity

import com.google.gson.annotations.SerializedName

data class ResultsDto(
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("price") var price: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("uid") var uid: String? = null,
    @SerializedName("image_ids") var imageIds: ArrayList<String> = arrayListOf(),
    @SerializedName("image_urls") var imageUrls: ArrayList<String> = arrayListOf(),
    @SerializedName("image_urls_thumbnails") var imageUrlsThumbnails: ArrayList<String> = arrayListOf()
)