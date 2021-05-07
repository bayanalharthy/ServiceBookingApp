package com.znggis.sampleservicebookingapp.repo.remote.api

import com.znggis.sampleservicebookingapp.repo.remote.data.ServiceData
import com.znggis.sampleservicebookingapp.repo.remote.mapper.ServiceDataMapper
import com.znggis.sampleservicebookingapp.repo.remote.service.ServiceService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ServiceApiImpl @Inject constructor(
    private val service: ServiceService,
    private val mapper: ServiceDataMapper
) : ServiceApi {
    override fun loadServices(category: String): Flow<ServiceData> = flow {
        val data = service.fetchServices(category)
        emit(mapper.from(data))
    }
}