package com.znggis.sampleservicebookingapp.repo.remote.api

import com.google.common.truth.Truth
import com.znggis.sampleservicebookingapp.BuildConfig
import com.znggis.sampleservicebookingapp.repo.remote.base.RetrofitCreator
import com.znggis.sampleservicebookingapp.repo.remote.mapper.HomeDetailMapper
import com.znggis.sampleservicebookingapp.repo.remote.service.HomeService
import com.znggis.sampleservicebookingapp.util.MockResponseFileReader
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import java.net.HttpURLConnection

const val HOME_PAGE_JSON = "success_resp_home.json"

class HomeApiTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiHome: HomeApi

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        mockWebServer = MockWebServer()
        mockWebServer.start()
        val home = mockWebServer.url("")
        val homeService =
            RetrofitCreator(home.toUrl().toString()).build().create(HomeService::class.java)
        apiHome = HomeApiImpl(homeService, HomeDetailMapper())
    }

    @Test
    fun `read sample success json file`() {
        val reader = MockResponseFileReader(HOME_PAGE_JSON)
        assertNotNull(reader.content)
    }

    @Test
    fun `Given request data, When Status 200Ok, Then check if data is in Network Layer`() =
        runBlocking {

            val response = MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(MockResponseFileReader(HOME_PAGE_JSON).content)
            mockWebServer.enqueue(response)

            val data = apiHome.loadHomeData()
            Truth.assertThat(data.categories.size).isEqualTo(1)
            Truth.assertThat(data.promotions.size).isEqualTo(2)
            Truth.assertThat(data.categories.first().title).isEqualTo("Carwash")
            Truth.assertThat(data.categories.first().subTitle).isEqualTo("4 Packages")
            Truth.assertThat(data.categories.first().image)
                .isEqualTo("https://storage.googleapis.com/rafiji-staging/images/categoryImage/carwash.png")
        }


    @After
    fun finish() {
        mockWebServer.shutdown()
    }
}