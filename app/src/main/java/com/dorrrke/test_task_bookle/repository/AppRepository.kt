package com.dorrrke.test_task_bookle.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dorrrke.test_task_bookle.repository.models.*
import com.dorrrke.test_task_bookle.repository.server.ServerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AppRepository(private val serverApi: ServerApi) {
    private val compositeDisposable = CompositeDisposable()
    private var carouselContentLiveData = MutableLiveData<List<CarouselContentItem>>()
    private var bestSellersContentLiveData = MutableLiveData<List<BestSellersContentItem>>()
    private var similarContentLiveData = MutableLiveData<List<SimilarContentItem>>()

    fun getCarouselContentData() {
        compositeDisposable.add(serverApi.getCarouselContent()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable ->
                Log.d(
                    "ServerCommunicator: Carousel content - ",
                    t.stackTrace.toString()
                )
            }
            .subscribe { it -> carouselContentLiveData.value = it })
    }

    fun getBestSellersContentData() {
        compositeDisposable.add(serverApi.getBestSellersContent()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable ->
                Log.d(
                    "ServerCommunicator: Best Sellers content - ",
                    t.stackTrace.toString()
                )
            }
            .subscribe { it -> bestSellersContentLiveData.value = it })
    }

    fun getSimilarContentData() {
        compositeDisposable.add(serverApi.getSimilarContent()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable ->
                Log.d(
                    "ServerCommunicator: Similar content - ",
                    t.stackTrace.toString()
                )
            }
            .subscribe { it -> similarContentLiveData.value = it })
    }

    fun getCarouselContent(): MutableLiveData<List<CarouselContentItem>> {
        return carouselContentLiveData
    }

    fun getBestSellersContent(): MutableLiveData<List<BestSellersContentItem>> {
        return bestSellersContentLiveData
    }

    fun getSimilarContent(): MutableLiveData<List<SimilarContentItem>> {
        return similarContentLiveData
    }
}