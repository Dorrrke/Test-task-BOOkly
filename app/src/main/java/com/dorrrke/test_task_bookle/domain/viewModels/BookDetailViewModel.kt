package com.dorrrke.test_task_bookle.domain.viewModels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.dorrrke.test_task_bookle.App
import com.dorrrke.test_task_bookle.repository.AppRepository
import com.dorrrke.test_task_bookle.repository.models.BestSellersContentItem
import com.dorrrke.test_task_bookle.repository.models.CarouselContentItem
import com.dorrrke.test_task_bookle.repository.models.SimilarContentItem
import javax.inject.Inject

class BookDetailViewModel(application: Application): BaseViewModel(application) {

    private var similarContentLiveData = MutableLiveData<List<SimilarContentItem>>()

    @Inject
    lateinit var repository: AppRepository

    init {
        (application as App).appComponent.inject(this)
    }

    fun getSimilarContent() {
        repository.getSimilarContentData()
        similarContentLiveData = repository.getSimilarContent()
    }

    fun postSimilarContent(): MutableLiveData<List<SimilarContentItem>> {
        return similarContentLiveData
    }

}