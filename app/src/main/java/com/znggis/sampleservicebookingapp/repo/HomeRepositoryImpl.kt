package com.znggis.sampleservicebookingapp.repo

import com.znggis.sampleservicebookingapp.di.PostExecutionThread
import com.znggis.sampleservicebookingapp.repo.remote.ActionResult
import com.znggis.sampleservicebookingapp.repo.remote.api.HomeApi
import com.znggis.sampleservicebookingapp.repo.remote.data.HomeData
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private var homeApi: HomeApi,
    private val dispatcher: PostExecutionThread
) : HomeRepository {

    override fun getHomeDetail(): Flow<ActionResult<HomeData>> =
        homeApi.loadHomeData()
            .flowOn(dispatcher.io)
            .map {
                ActionResult.Success(it) as ActionResult<HomeData>
            }.onStart {
                emit(ActionResult.Loading("Loading Data"))
            }.catch { error ->
                emit(ActionResult.Error(error.toString()))
            }
}