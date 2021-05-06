package com.znggis.sampleservicebookingapp.repo.remote

sealed class ActionResult<out T> {
    data class Loading<T>(val message: String) : ActionResult<T>()
    data class Success<out T>(val data: T) : ActionResult<T>()
    data class Error<T>(val error: String) : ActionResult<T>()
}