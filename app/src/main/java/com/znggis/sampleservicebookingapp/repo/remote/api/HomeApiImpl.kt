package com.znggis.sampleservicebookingapp.repo.remote.api

import com.znggis.sampleservicebookingapp.repo.remote.data.HomeData
import com.znggis.sampleservicebookingapp.repo.remote.mapper.HomeDetailMapper
import com.znggis.sampleservicebookingapp.repo.remote.service.HomeService
import javax.inject.Inject

class HomeApiImpl @Inject constructor(
    private val service: HomeService,
    private val mapper: HomeDetailMapper
) : HomeApi {

    override suspend fun loadHomeData(): HomeData {
        val data = service.loadTopStories()
        return mapper.from(data)
    }
}