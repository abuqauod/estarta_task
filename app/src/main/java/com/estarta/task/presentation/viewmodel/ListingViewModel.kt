package com.estarta.task.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estarta.task.domain.model.ListingModel
import com.estarta.task.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListingViewModel
@Inject
constructor(private val repository: RecipeRepository) : ViewModel() {

    enum class State {
        NOT_STARTED, LOADING, DONE
    }

    private val _state = MutableLiveData<State>().apply { value = State.NOT_STARTED }
    val state: LiveData<State> = _state

    private val _resultsLivedata = MutableLiveData<ListingModel>()
    val resultsLivedata: LiveData<ListingModel> = _resultsLivedata

    fun getListingItems() {
        viewModelScope.launch {
            _resultsLivedata.value = repository.get()
        }
    }

    fun updateState(state: State) {
        _state.value = state
    }
}