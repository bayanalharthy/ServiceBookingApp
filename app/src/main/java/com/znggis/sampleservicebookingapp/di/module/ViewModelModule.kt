package com.znggis.sampleservicebookingapp.di.module

import androidx.lifecycle.ViewModel
import com.znggis.sampleservicebookingapp.ui.home.HomeViewModel
import com.znggis.sampleservicebookingapp.ui.service.ServicesViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import dagger.multibindings.IntoMap

@DisableInstallInCheck
@Module
interface ViewModelModule {

    @get:[Binds IntoMap ViewModelKey(HomeViewModel::class)]
    val HomeViewModel.homeViewModel: ViewModel

    @get:[Binds IntoMap ViewModelKey(ServicesViewModel::class)]
    val ServicesViewModel.serviceViewModel: ViewModel
}