package com.znggis.sampleservicebookingapp.repo.remote.base

import android.content.Context
import com.znggis.sampleservicebookingapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Interceptor to add auth token to requests
 */
class AuthInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest: Request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${BuildConfig.API_TOKEN}")
            .build()
        return chain.proceed(newRequest)
    }
}