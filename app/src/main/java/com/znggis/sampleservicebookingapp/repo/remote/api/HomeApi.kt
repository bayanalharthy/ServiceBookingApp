package com.znggis.sampleservicebookingapp.repo.remote.api

import com.znggis.sampleservicebookingapp.repo.remote.data.HomeData

/**
 * Abstraction to fetch Home page info
 */
interface HomeApi {
    suspend fun loadHomeData(): HomeData
}