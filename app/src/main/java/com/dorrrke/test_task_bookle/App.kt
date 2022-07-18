package com.dorrrke.test_task_bookle

import android.app.Application
import com.dorrrke.test_task_bookle.di.components.AppComponent
import com.dorrrke.test_task_bookle.di.components.DaggerAppComponent
import com.dorrrke.test_task_bookle.di.module.RepositoryModule
import com.dorrrke.test_task_bookle.di.module.RetrofitModule

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .repositoryModule(RepositoryModule())
            .retrofitModule(RetrofitModule())
            .build()
    }
}