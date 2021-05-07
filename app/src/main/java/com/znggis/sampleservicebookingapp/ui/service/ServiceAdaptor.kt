package com.znggis.sampleservicebookingapp.ui.service

import android.content.res.Resources
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setMargins
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.znggis.sampleservicebookingapp.R
import com.znggis.sampleservicebookingapp.databinding.ItemServiceBinding
import com.znggis.sampleservicebookingapp.repo.remote.data.Service
import com.znggis.sampleservicebookingapp.ui.image.ImageLoader
import com.znggis.sampleservicebookingapp.ui.inflate
import javax.inject.Inject


class ServiceAdaptor @Inject constructor(
    private val imageLoader: ImageLoader
) : ListAdapter<Service, ServiceAdaptor.ServiceViewHolder>(diffUtilCallback) {

    inner class ServiceViewHolder(
        private val binding: ItemServiceBinding,
        private val imageLoader: ImageLoader
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(service: Service) {
            binding.service = service
            //TODO I could write custom binding
            imageLoader.loadImage(binding.imgServiceIcon, service.image)
        }
    }


    companion object {
        val diffUtilCallback: DiffUtil.ItemCallback<Service>
            get() = object : DiffUtil.ItemCallback<Service>() {
                override fun areItemsTheSame(oldItem: Service, newItem: Service): Boolean {
                    return oldItem === newItem
                }

                override fun areContentsTheSame(
                    oldItem: Service,
                    newItem: Service
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {

        return ServiceViewHolder(
            ItemServiceBinding.bind(parent.inflate(R.layout.item_service)),
            imageLoader
        )
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) =
        holder.bind(getItem(position))


}