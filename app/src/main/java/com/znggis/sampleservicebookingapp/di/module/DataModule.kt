package com.znggis.sampleservicebookingapp.di.module

import com.znggis.sampleservicebookingapp.repo.HomeRepository
import com.znggis.sampleservicebookingapp.repo.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @get:[Binds Singleton]
    val HomeRepositoryImpl.homeRepo : HomeRepository
}