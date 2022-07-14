package com.estarta.task.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListingModel(
    var results: ArrayList<ResultsModel> = arrayListOf(),
    var paginationModel: PaginationModel? = PaginationModel()
) : Parcelable