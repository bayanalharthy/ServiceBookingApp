package com.znggis.sampleservicebookingapp.repo.remote.data

data class ServiceData(
    val slogan: String,
    val image: String,
    val description: String,
    val title: String,
    val services: List<Service>
)