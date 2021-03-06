package com.estarta.task.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PaginationModel(
    var key: String? = null
) : Parcelable