package com.znggis.sampleservicebookingapp.di.component

import com.znggis.sampleservicebookingapp.repo.HomeRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface CoreComponent {
    val homeRepo: HomeRepository
}