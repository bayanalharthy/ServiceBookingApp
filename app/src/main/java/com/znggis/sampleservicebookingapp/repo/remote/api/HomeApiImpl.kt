package com.znggis.sampleservicebookingapp.repo.remote.api

import com.znggis.sampleservicebookingapp.repo.remote.data.HomeData
import com.znggis.sampleservicebookingapp.repo.remote.mapper.HomeDetailMapper
import com.znggis.sampleservicebookingapp.repo.remote.service.HomeService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeApiImpl @Inject constructor(
    private val service: HomeService,
    private val mapper: HomeDetailMapper
) : HomeApi {

    override fun loadHomeData(): Flow<HomeData> = flow {
        val data = service.loadHomeData()
        emit(mapper.from(data))
    }
}