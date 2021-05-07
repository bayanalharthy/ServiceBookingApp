package com.znggis.sampleservicebookingapp.ui.service

import androidx.lifecycle.ViewModel
import com.znggis.sampleservicebookingapp.repo.ServicesRepository
import javax.inject.Inject

class ServicesViewModel @Inject constructor(
    val repo: ServicesRepository
) : ViewModel() {

}