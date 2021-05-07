package com.znggis.sampleservicebookingapp.repo.remote.service

import com.znggis.sampleservicebookingapp.repo.remote.dto.service.ServicePageData
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceService {
    @GET("categories/{category}/services")
    suspend fun fetchServices(@Path("category") category: String): ServicePageData
}