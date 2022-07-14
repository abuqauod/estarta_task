package com.estarta.task.presentation.callback

import com.estarta.task.domain.model.ResultsModel

interface ListingItemClickListener {
    fun onClick(results: ResultsModel)
}