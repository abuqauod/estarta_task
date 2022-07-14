package com.estarta.task.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultsModel(
    var createdAt: String? = null,
    var price: String? = null,
    var name: String? = null,
    var uid: String? = null,
    var imageIds: ArrayList<String> = arrayListOf(),
    var imageUrls: ArrayList<String> = arrayListOf(),
    var imageUrlsThumbnails: ArrayList<String> = arrayListOf()
) : Parcelable