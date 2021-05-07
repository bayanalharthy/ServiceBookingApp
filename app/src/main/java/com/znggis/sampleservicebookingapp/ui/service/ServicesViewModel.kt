package com.znggis.sampleservicebookingapp.ui.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.znggis.sampleservicebookingapp.repo.ServicesRepository
import com.znggis.sampleservicebookingapp.repo.remote.ActionResult
import com.znggis.sampleservicebookingapp.repo.remote.data.ServiceData
import com.znggis.sampleservicebookingapp.ui.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ServicesViewModel @Inject constructor(
    private val repo: ServicesRepository
) : ViewModel() {

    private var _data = MutableLiveData<ServiceData>()
    val data: LiveData<ServiceData>
        get() = _data

    private var _error = MutableLiveData<Event<String>>()
    val error: LiveData<Event<String>>
        get() = _error

    private var _loading = MutableLiveData(Event(false))
    val loading: LiveData<Event<Boolean>>
        get() = _loading


    fun fetchServices(category: String) {
        viewModelScope.launch {
            repo.getServices(category).collect { result ->
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