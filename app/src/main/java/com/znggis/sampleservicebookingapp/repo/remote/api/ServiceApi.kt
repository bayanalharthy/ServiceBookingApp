package com.znggis.sampleservicebookingapp.repo.remote.api

import com.znggis.sampleservicebookingapp.repo.remote.data.ServiceData
import kotlinx.coroutines.flow.Flow


/**
 * Abstraction to fetch service page info
 */
interface ServiceApi {
    fun loadServices(category: String): Flow<ServiceData>
}