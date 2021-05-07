package com.znggis.sampleservicebookingapp.repo.remote.data

data class Service(
    val title: String,
    val subtitle: String,
    val shortDescription: String,
    val hasDiscount: Boolean,
    val discountPercentage: Int,
    val image: String,
    val isSpecial: Boolean,
    val sort: Int,
    val price:Int,
    val priceBeforeDis:Int
)