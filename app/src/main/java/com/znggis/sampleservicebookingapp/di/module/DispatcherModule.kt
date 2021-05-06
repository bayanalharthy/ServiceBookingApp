package com.znggis.sampleservicebookingapp.di.module

import com.znggis.sampleservicebookingapp.di.PostExecutionThread
import com.znggis.sampleservicebookingapp.di.PostExecutionThreadImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
interface DispatcherModule {
    @get:[Binds Singleton]
    val PostExecutionThreadImpl.postExecutionThread: PostExecutionThread
}