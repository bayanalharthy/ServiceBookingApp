package com.znggis.sampleservicebookingapp.di.component

import com.znggis.sampleservicebookingapp.di.module.FactoryModule
import com.znggis.sampleservicebookingapp.di.module.ViewModelModule
import com.znggis.sampleservicebookingapp.ui.service.ServiceFragment
import dagger.Component


@Component(
    dependencies = [CoreComponent::class],
    modules = [
        FactoryModule::class,
        ViewModelModule::class
    ]
)
interface ServiceComponent {
    fun inject(serviceFragment: ServiceFragment)

    @Component.Factory
    interface Factory {
        fun create(
            component: CoreComponent
        ): ServiceComponent
    }

}