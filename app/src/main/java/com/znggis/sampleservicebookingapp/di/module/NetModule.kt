package com.znggis.sampleservicebookingapp.di.module

import com.znggis.sampleservicebookingapp.BuildConfig
import com.znggis.sampleservicebookingapp.repo.remote.api.HomeApi
import com.znggis.sampleservicebookingapp.repo.remote.api.HomeApiImpl
import com.znggis.sampleservicebookingapp.repo.remote.api.ServiceApi
import com.znggis.sampleservicebookingapp.repo.remote.api.ServiceApiImpl
import com.znggis.sampleservicebookingapp.repo.remote.base.RetrofitCreator
import com.znggis.sampleservicebookingapp.repo.remote.mapper.HomeDetailMapper
import com.znggis.sampleservicebookingapp.repo.remote.mapper.ServiceDataMapper
import com.znggis.sampleservicebookingapp.repo.remote.service.HomeService
import com.znggis.sampleservicebookingapp.repo.remote.service.ServiceService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
interface NetModule {

    @get:[Binds Singleton]
    val HomeApiImpl.homeApi: HomeApi


    @get:[Binds Singleton]
    val ServiceApiImpl.serviceApi: ServiceApi


    companion object {
        @Singleton
        @Provides
        fun provideHomeService(): HomeService =
            RetrofitCreator(BuildConfig.END_POINT)
                .build().create(HomeService::class.java)


        @Singleton
        @Provides
        fun provideServiceService(): ServiceService =
            RetrofitCreator(BuildConfig.END_POINT)
                .build().create(ServiceService::class.java)

        @Singleton
        @Provides
        fun provideHomeMapper(): HomeDetailMapper =
            HomeDetailMapper()

        @Singleton
        @Provides
        fun provideServiceDataMapper(): ServiceDataMapper =
            ServiceDataMapper()
    }
}