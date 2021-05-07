package com.znggis.sampleservicebookingapp.repo.remote.mapper

import com.znggis.sampleservicebookingapp.repo.remote.data.Service
import com.znggis.sampleservicebookingapp.repo.remote.data.ServiceData
import com.znggis.sampleservicebookingapp.repo.remote.dto.service.ServicePageData

class ServiceDataMapper : Mapper<ServicePageData, ServiceData>() {
    override fun from(i: ServicePageData): ServiceData {
        val services = i.data.map {
            Service(
                it.title,
                it.subTitle,
                it.shortDescription,
                it.hasDiscount,
                it.discountPercentage,
                it.image.originalUrl,
                it.isSpecial,
                it.sort,
                it.listBasePrice,
                it.basePrice
            )
        }
        return ServiceData(
            slogan = i.slogan,
            title = i.title,
            image = i.image.originalUrl3x,
            description = i.description,
            services = services,
        )
    }
}