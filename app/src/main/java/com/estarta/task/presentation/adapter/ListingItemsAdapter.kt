package com.estarta.task.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.estarta.task.BaseApplication
import com.estarta.task.R
import com.estarta.task.databinding.RvListingItemBinding
import com.estarta.task.domain.model.ResultsModel
import com.estarta.task.presentation.callback.ListingItemClickListener
import javax.inject.Singleton

@Singleton
class ListingItemsAdapter(
    private val app: BaseApplication,
    private val items: List<ResultsModel>,
    private val listener: ListingItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding =
            DataBindingUtil.inflate<RvListingItemBinding>(
                layoutInflater,
                R.layout.rv_listing_item, parent, false
            )
        return DealsViewHolder(itemBinding)
    }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int): Int = position

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as DealsViewHolder).bind(items[position])

    inner class DealsViewHolder(private val binding: RvListingItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResultsModel) {
            binding.model = item
            Glide.with(app)
                .load(item.imageUrlsThumbnails.first())
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivListingAvatar)
            binding.listingItemClick = listener
            binding.executePendingBindings()
        }
    }
}
