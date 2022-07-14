package com.estarta.task.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.estarta.task.BaseApplication
import com.estarta.task.R
import com.estarta.task.databinding.ActivityMainBinding
import com.estarta.task.domain.model.ListingModel
import com.estarta.task.domain.model.ResultsModel
import com.estarta.task.presentation.adapter.ListingItemsAdapter
import com.estarta.task.presentation.callback.ListingItemClickListener
import com.estarta.task.presentation.viewmodel.ListingViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ListingItemClickListener {

    private val mainViewModel: ListingViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var app: BaseApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).apply {
            this.lifecycleOwner = this@MainActivity
            this.viewModel = mainViewModel
        }
        initializeObservers()
    }

    private fun initializeObservers() {
        mainViewModel.updateState(ListingViewModel.State.LOADING)
        mainViewModel.getListingItems()
        mainViewModel.resultsLivedata.observe(this) {
            mainViewModel.updateState(ListingViewModel.State.DONE)
            customizeView(it)
        }
    }

    private fun customizeView(listingModel: ListingModel) {
        binding.rvMain.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = ListingItemsAdapter(app, listingModel.results, this@MainActivity)
        }
    }

    companion object {
        const val RESULT_CONSTANT_KEY = "result_constant_key"
    }

    override fun onClick(results: ResultsModel) {
        startActivity(
            Intent(this@MainActivity, DetailsActivity()::class.java).putExtra(
                RESULT_CONSTANT_KEY,
                results
            )
        )
    }
}