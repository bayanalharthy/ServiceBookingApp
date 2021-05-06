package com.znggis.sampleservicebookingapp.repo

import com.znggis.sampleservicebookingapp.repo.remote.ActionResult
import com.znggis.sampleservicebookingapp.repo.remote.api.HomeApi
import com.znggis.sampleservicebookingapp.repo.remote.data.HomeData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import okhttp3.Dispatcher
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    var homeApi: HomeApi,
    val dispatcher: CoroutineDispatcher
) : HomeRepository {

    override fun getHomeDetail(): Flow<ActionResult<HomeData>> =
        homeApi.loadHomeData()
            .flowOn(dispatcher)
            .map {
                ActionResult.Success(it) as ActionResult<HomeData>
            }.onStart {
                emit(ActionResult.Loading("Loading Data"))
            }.catch { error ->
                emit(ActionResult.Error(error.toString()))
            }
}