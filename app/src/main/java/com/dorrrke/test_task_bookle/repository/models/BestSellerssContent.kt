package com.dorrrke.test_task_bookle.repository.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BestSellersContent(

	@field:SerializedName("BestSellersContent")
	val bestSellersContent: List<BestSellersContentItem?>? = null
): Parcelable
@Parcelize
data class BestSellersContentItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("rate")
	val rate: Rate? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("price")
	val price: Double? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
): Parcelable

@Parcelize
data class Rate(

	@field:SerializedName("score")
	val score: Double? = null,

	@field:SerializedName("amount")
	val amount: Int? = null
): Parcelable
