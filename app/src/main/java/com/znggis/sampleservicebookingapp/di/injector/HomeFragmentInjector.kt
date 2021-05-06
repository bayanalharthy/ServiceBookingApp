package com.znggis.sampleservicebookingapp.di.injector

import com.znggis.sampleservicebookingapp.di.component.CoreComponent
import com.znggis.sampleservicebookingapp.di.component.DaggerHomeComponent
import com.znggis.sampleservicebookingapp.ui.home.HomeFragment
import dagger.hilt.android.EntryPointAccessors

internal fun inject(fragment: HomeFragment) {
    DaggerHomeComponent
        .factory()
        .create(coreComponent(fragment) )
        .inject(fragment)
}

private fun coreComponent(fragment: HomeFragment): CoreComponent =
    EntryPointAccessors.fromApplication(
        fragment.requireContext().applicationContext,
        CoreComponent::class.java
    )
