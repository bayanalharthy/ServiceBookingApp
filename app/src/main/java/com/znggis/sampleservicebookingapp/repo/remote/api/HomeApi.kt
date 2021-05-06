package com.znggis.sampleservicebookingapp.repo.remote.api

import com.znggis.sampleservicebookingapp.repo.remote.data.HomeData
import kotlinx.coroutines.flow.Flow

/**
 * Abstraction to fetch Home page info
 */
interface HomeApi {
    fun loadHomeData(): Flow<HomeData>
}