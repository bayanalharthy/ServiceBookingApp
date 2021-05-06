package com.znggis.sampleservicebookingapp.repo

import com.znggis.sampleservicebookingapp.repo.remote.ActionResult
import com.znggis.sampleservicebookingapp.repo.remote.data.HomeData
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getHomeDetail(): Flow<ActionResult<HomeData>>
}