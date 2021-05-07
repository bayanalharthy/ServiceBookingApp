package com.znggis.sampleservicebookingapp.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.znggis.sampleservicebookingapp.R
import com.znggis.sampleservicebookingapp.databinding.ItemPromotionBinding
import com.znggis.sampleservicebookingapp.repo.remote.data.Promotion
import com.znggis.sampleservicebookingapp.ui.image.ImageLoader
import com.znggis.sampleservicebookingapp.ui.inflate
import javax.inject.Inject

class PromotionsAdaptor @Inject constructor(
    private val imageLoader: ImageLoader
) : ListAdapter<Promotion, PromotionsAdaptor.PromotionViewHolder>(diffUtilCallback) {

    inner class PromotionViewHolder(
        private val binding: ItemPromotionBinding,
        private val imageLoader: ImageLoader
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(promotion: Promotion) {
            //TODO I could write custom binding
            imageLoader.loadImage(binding.imgPromotion, promotion.image)
        }
    }


    companion object {
        val diffUtilCallback: DiffUtil.ItemCallback<Promotion>
            get() = object : DiffUtil.ItemCallback<Promotion>() {
                override fun areItemsTheSame(oldItem: Promotion, newItem: Promotion): Boolean {
                    return oldItem === newItem && oldItem.image == newItem.image
                }

                override fun areContentsTheSame(
                    oldItem: Promotion,
                    newItem: Promotion
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionViewHolder {
        return PromotionViewHolder(
            ItemPromotionBinding.bind(parent.inflate(R.layout.item_promotion)),
            imageLoader
        )
    }

    override fun onBindViewHolder(holder: PromotionViewHolder, position: Int) =
        holder.bind(getItem(position))


}