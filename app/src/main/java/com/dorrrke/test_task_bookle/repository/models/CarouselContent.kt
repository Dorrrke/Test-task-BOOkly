package com.dorrrke.test_task_bookle.repository.models

import com.google.gson.annotations.SerializedName

data class CarouselContent(

	@field:SerializedName("CarouselContent")
	val carouselContent: List<CarouselContentItem?>? = null
)

data class CarouselContentItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
