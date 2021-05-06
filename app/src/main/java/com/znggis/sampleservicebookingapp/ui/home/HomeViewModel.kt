package com.znggis.sampleservicebookingapp.ui.home

import androidx.lifecycle.ViewModel
import com.znggis.sampleservicebookingapp.repo.HomeRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val homeRepo: HomeRepository
) : ViewModel() {
}