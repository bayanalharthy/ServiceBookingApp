package com.znggis.sampleservicebookingapp.ui.home

import androidx.arch.core.util.Function
import androidx.lifecycle.*
import com.znggis.sampleservicebookingapp.repo.HomeRepository
import com.znggis.sampleservicebookingapp.repo.remote.ActionResult
import com.znggis.sampleservicebookingapp.repo.remote.data.HomeData
import com.znggis.sampleservicebookingapp.ui.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val homeRepo: HomeRepository
) : ViewModel() {


    private var _data = MutableLiveData<HomeData>()
    val data: LiveData<HomeData>
        get() = _data

    private var _error = MutableLiveData<Event<String>>()
    val error: LiveData<Event<String>>
        get() = _error

    private var _loading = MutableLiveData(Event(false))
    val loading: LiveData<Event<Boolean>>
        get() = _loading


    fun fetch() {
        viewModelScope.launch {
            homeRepo.getHomeDetail().collect { result ->
                when (result) {
                    is ActionResult.Loading -> _loading.value = Event(true)
                    is ActionResult.Error -> {
                        _loading.value = Event(false)
                        _error.value = Event(result.error)
                    }
                    is ActionResult.Success -> {
                        _data.value = result.data
                        _loading.value = Event(false)
                    }
                }
            }

        }
    }

}