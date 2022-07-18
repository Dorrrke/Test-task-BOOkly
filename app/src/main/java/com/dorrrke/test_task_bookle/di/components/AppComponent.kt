package com.dorrrke.test_task_bookle.di.components


import com.dorrrke.test_task_bookle.di.module.RepositoryModule
import com.dorrrke.test_task_bookle.di.module.RetrofitModule
import com.dorrrke.test_task_bookle.domain.viewModels.BookDetailViewModel
import com.dorrrke.test_task_bookle.domain.viewModels.BooksPageViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RetrofitModule::class, RepositoryModule::class])
@Singleton
interface AppComponent {
    fun inject(viewModel: BookDetailViewModel)
    fun inject(viewModel: BooksPageViewModel)
}