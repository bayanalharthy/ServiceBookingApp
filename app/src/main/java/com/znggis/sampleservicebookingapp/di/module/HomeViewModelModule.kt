package com.znggis.sampleservicebookingapp.di.module

import androidx.lifecycle.ViewModel
import com.znggis.sampleservicebookingapp.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import dagger.multibindings.IntoMap

@DisableInstallInCheck
@Module
interface HomeViewModelModule {

    @get:[Binds IntoMap ViewModelKey(HomeViewModel::class)]
    val HomeViewModel.homeViewModel: ViewModel
}