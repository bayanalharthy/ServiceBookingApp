package com.znggis.sampleservicebookingapp.repo

import com.znggis.sampleservicebookingapp.di.PostExecutionThread
import com.znggis.sampleservicebookingapp.repo.remote.ActionResult
import com.znggis.sampleservicebookingapp.repo.remote.api.ServiceApi
import com.znggis.sampleservicebookingapp.repo.remote.data.ServiceData
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class ServicesRepositoryImpl @Inject constructor(
    private var serviceApi: ServiceApi,
    private val dispatcher: PostExecutionThread
) : ServicesRepository {

    override fun getServices(category: String): Flow<ActionResult<ServiceData>> =
        serviceApi.loadServices(category)
            .flowOn(dispatcher.io)
            .map {
                ActionResult.Success(it) as ActionResult<ServiceData>
            }.onStart {
                emit(ActionResult.Loading("Loading Data"))
            }.catch { error ->
                emit(ActionResult.Error(error.toString()))
            }
}