package com.znggis.sampleservicebookingapp.di.component

import com.znggis.sampleservicebookingapp.repo.HomeRepository
import com.znggis.sampleservicebookingapp.ui.image.ImageLoader
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface CoreComponent {
    val homeRepo: HomeRepository
    val imageLoader: ImageLoader
}