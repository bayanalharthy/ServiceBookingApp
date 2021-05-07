package com.znggis.sampleservicebookingapp.repo

import com.znggis.sampleservicebookingapp.repo.remote.ActionResult
import com.znggis.sampleservicebookingapp.repo.remote.data.ServiceData
import kotlinx.coroutines.flow.Flow

interface ServicesRepository {
    fun getServices(): Flow<ActionResult<ServiceData>>
}