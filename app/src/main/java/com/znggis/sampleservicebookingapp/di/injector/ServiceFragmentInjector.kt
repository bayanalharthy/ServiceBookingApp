package com.znggis.sampleservicebookingapp.di.injector

import com.znggis.sampleservicebookingapp.di.component.CoreComponent
import com.znggis.sampleservicebookingapp.di.component.DaggerServiceComponent
import com.znggis.sampleservicebookingapp.ui.service.ServiceFragment
import dagger.hilt.android.EntryPointAccessors


internal fun inject(fragment: ServiceFragment) {
    DaggerServiceComponent
        .factory()
        .create(coreComponent(fragment) )
        .inject(fragment)
}

private fun coreComponent(fragment: ServiceFragment): CoreComponent =
    EntryPointAccessors.fromApplication(
        fragment.requireContext().applicationContext,
        CoreComponent::class.java
    )
