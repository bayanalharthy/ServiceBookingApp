package com.znggis.sampleservicebookingapp.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.znggis.sampleservicebookingapp.R
import com.znggis.sampleservicebookingapp.databinding.ItemCategoryBinding
import com.znggis.sampleservicebookingapp.repo.remote.data.Category
import com.znggis.sampleservicebookingapp.ui.image.ImageLoader
import com.znggis.sampleservicebookingapp.ui.inflate
import javax.inject.Inject

class CategoriesAdaptor @Inject constructor(
    private val imageLoader: ImageLoader
) : ListAdapter<Category, CategoriesAdaptor.CategoryViewHolder>(diffUtilCallback) {

    var onClickListener: ((Category) -> Unit)? = null

    inner class CategoryViewHolder(
        private val binding: ItemCategoryBinding,
        private val imageLoader: ImageLoader
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.category = category

            //TODO I could write custom binding
            imageLoader.loadImage(binding.imgService, category.image)

            binding.root.setOnClickListener { onClickListener?.let { it(category) } }
        }
    }


    companion object {
        val diffUtilCallback: DiffUtil.ItemCallback<Category>
            get() = object : DiffUtil.ItemCallback<Category>() {
                override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
                    return oldItem === newItem && oldItem.title == newItem.title
                }

                override fun areContentsTheSame(
                    oldItem: Category,
                    newItem: Category
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.bind(parent.inflate(R.layout.item_category)),
            imageLoader
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) =
        holder.bind(getItem(position))


}