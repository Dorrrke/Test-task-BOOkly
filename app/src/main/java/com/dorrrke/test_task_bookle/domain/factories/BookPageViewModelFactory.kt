package com.dorrrke.test_task_bookle.domain.factories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dorrrke.test_task_bookle.domain.viewModels.BooksPageViewModel

class BookPageViewModelFactory (private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BooksPageViewModel(application) as T
    }
}