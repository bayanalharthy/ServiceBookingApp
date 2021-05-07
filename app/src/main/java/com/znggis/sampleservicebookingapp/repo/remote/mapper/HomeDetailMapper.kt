package com.znggis.sampleservicebookingapp.repo.remote.mapper

import com.znggis.sampleservicebookingapp.repo.remote.data.Category
import com.znggis.sampleservicebookingapp.repo.remote.data.HomeData
import com.znggis.sampleservicebookingapp.repo.remote.data.Promotion
import com.znggis.sampleservicebookingapp.repo.remote.dto.home.HomePageDetail

class HomeDetailMapper : Mapper<HomePageDetail, HomeData>() {
    override fun from(i: HomePageDetail): HomeData {
        val categories = i.categories.map {
            Category(
                it.titles.en,
                it.subTitles.en,
                it.shortDescriptions.en,
                it.image.originalUrl,
                it.slug
            )
        }
        val promotions = i.promotions.map { Promotion(it.image.originalUrl) }
        return HomeData(promotions, categories)
    }
}