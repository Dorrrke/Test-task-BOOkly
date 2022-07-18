package com.dorrrke.test_task_bookle.domain.viewModels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.dorrrke.test_task_bookle.App
import com.dorrrke.test_task_bookle.repository.AppRepository
import com.dorrrke.test_task_bookle.repository.models.*
import javax.inject.Inject

class BooksPageViewModel(application: Application): BaseViewModel(application) {

    private var carouselContentLiveData = MutableLiveData<List<CarouselContentItem>>()
    private var bestSellersContentLiveData = MutableLiveData<List<BestSellersContentItem>>()
    private var similarContentLiveData = MutableLiveData<List<SimilarContentItem>>()

    @Inject
    lateinit var repository: AppRepository

    init {
        (application as App).appComponent.inject(this)
    }

    fun getCarouselContent() {
        repository.getCarouselContentData()
        carouselContentLiveData = repository.getCarouselContent()
    }

    fun postCarouselContent(): MutableLiveData<List<CarouselContentItem>> {
        return carouselContentLiveData
    }

    fun getBestSellerContent() {
        repository.getBestSellersContentData()
        bestSellersContentLiveData = repository.getBestSellersContent()
    }

    fun postBestSellerContent(): MutableLiveData<List<BestSellersContentItem>> {
        return bestSellersContentLiveData
    }
}