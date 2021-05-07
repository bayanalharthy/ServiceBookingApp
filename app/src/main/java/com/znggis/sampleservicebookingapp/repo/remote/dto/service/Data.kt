package com.znggis.sampleservicebookingapp.repo.remote.dto.service


import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Data (

	@SerializedName("titles") val titles : Titles,
	@SerializedName("subTitles") val subTitles : SubTitles,
	@SerializedName("shortDescriptions") val shortDescriptions : ShortDescriptions,
	@SerializedName("isActive") val isActive : Boolean,
	@SerializedName("sort") val sort : Int,
	@SerializedName("isSpecial") val isSpecial : Boolean,
	@SerializedName("_id") val _id : String,
	@SerializedName("slug") val slug : String,
	@SerializedName("coverImageId") val coverImageId : String,
	@SerializedName("categoryId") val categoryId : String,
	@SerializedName("basePrice") val basePrice : Int,
	@SerializedName("listBasePrice") val listBasePrice : Int,
	@SerializedName("coverImage") val coverImage : CoverImage,
	@SerializedName("image") val image : Image,
	@SerializedName("title") val title : String,
	@SerializedName("subTitle") val subTitle : String,
	@SerializedName("shortDescription") val shortDescription : String,
	@SerializedName("hasDiscount") val hasDiscount : Boolean,
	@SerializedName("discountPercentage") val discountPercentage : Int,
	@SerializedName("id") val id : String,
	@SerializedName("description") val description : String,
	@SerializedName("selectItemsModalDescription") val selectItemsModalDescription : String
)