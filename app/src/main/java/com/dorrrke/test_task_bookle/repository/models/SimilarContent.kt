package com.dorrrke.test_task_bookle.repository.models

import com.google.gson.annotations.SerializedName

data class SimilarContent(

	@field:SerializedName("SimilarContent")
	val similarContent: List<SimilarContentItem?>? = null
)

data class SimilarContentItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
