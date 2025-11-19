package com.finedge.feature.transactions.data

import com.finedge.core.data.TransactionDao
import com.finedge.feature.transactions.domain.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideTransactionRepository(
        dao: TransactionDao
    ): TransactionRepository {
        return TransactionRepositoryImpl(dao)
    }
}