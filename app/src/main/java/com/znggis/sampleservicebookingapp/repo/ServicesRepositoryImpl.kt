package com.znggis.sampleservicebookingapp.repo

import com.znggis.sampleservicebookingapp.di.PostExecutionThread
import com.znggis.sampleservicebookingapp.repo.remote.ActionResult
import com.znggis.sampleservicebookingapp.repo.remote.api.ServiceApi
import com.znggis.sampleservicebookingapp.repo.remote.data.ServiceData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ServicesRepositoryImpl @Inject constructor(
    private var serviceApi: ServiceApi,
    private val dispatcher: PostExecutionThread
) : ServicesRepository {
    override fun getServices(): Flow<ActionResult<ServiceData>> {
        TODO("Not yet implemented")
    }
}