package com.znggis.sampleservicebookingapp.di.component

import androidx.core.app.ActivityCompat
import com.znggis.sampleservicebookingapp.di.PostExecutionThread
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@EntryPoint
@InstallIn(ActivityComponent::class)
interface AppComponent {
    val postExecutionThread: PostExecutionThread
}