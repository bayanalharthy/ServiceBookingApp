package com.znggis.sampleservicebookingapp.repo.remote.service

import com.znggis.sampleservicebookingapp.repo.remote.dto.home.HomePageDetail
import retrofit2.http.GET

interface HomeService {
    @GET("home")
    suspend fun loadHomeData(): HomePageDetail
}