package com.dorrrke.test_task_bookle.domain.factories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dorrrke.test_task_bookle.domain.viewModels.BookDetailViewModel
import com.dorrrke.test_task_bookle.domain.viewModels.BooksPageViewModel

class BookDetailViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookDetailViewModel(application) as T
    }
}