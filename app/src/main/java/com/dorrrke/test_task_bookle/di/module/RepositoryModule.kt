package com.dorrrke.test_task_bookle.di.module

import com.dorrrke.test_task_bookle.repository.AppRepository
import com.dorrrke.test_task_bookle.repository.server.ServerApi
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    internal fun providesRepository(serverApi: ServerApi): AppRepository {
        return AppRepository(serverApi)
    }
}