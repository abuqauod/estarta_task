package com.estarta.task.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.estarta.task.BaseApplication
import com.estarta.task.R
import com.estarta.task.databinding.ActivityDetailsBinding
import com.estarta.task.domain.model.ResultsModel
import com.estarta.task.presentation.view.MainActivity.Companion.RESULT_CONSTANT_KEY
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    @Inject
    lateinit var app: BaseApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val results: ResultsModel? = intent.getParcelableExtra(RESULT_CONSTANT_KEY)
        binding = DataBindingUtil.setContentView<ActivityDetailsBinding>(
            this, R.layout.activity_details
        ).apply {
            this.lifecycleOwner = this@DetailsActivity
            this.resultModel = results
        }
        initializeUiContent(results)
    }

    private fun initializeUiContent(results: ResultsModel?) {
        Glide.with(app)
            .load(results?.imageUrls?.first())
            .placeholder(R.drawable.ic_launcher_foreground)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.ivDetailsAvatar)
    }
}