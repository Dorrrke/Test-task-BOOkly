package com.dorrrke.test_task_bookle.repository.server


import com.dorrrke.test_task_bookle.repository.models.*
import io.reactivex.Single
import retrofit2.http.GET

interface ServerApi {

    @GET("carousel")
    fun getCarouselContent() : Single<List<CarouselContentItem>>

    @GET("best")
    fun getBestSellersContent(): Single<List<BestSellersContentItem>>

    @GET("similar")
    fun getSimilarContent(): Single<List<SimilarContentItem>>
}