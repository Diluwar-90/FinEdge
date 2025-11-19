package com.finedge.feature.transactions.data

import com.finedge.core.data.TransactionDao
import com.finedge.feature.transactions.domain.model.Transaction
import com.finedge.feature.transactions.domain.repository.TransactionRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TransactionRepositoryImpl @Inject constructor(private val dao: TransactionDao): TransactionRepository {
    override fun getTransactions(): Flow<List<Transaction>> {
        return dao.getAllTransactions().map { list->
            list.map { it.toDomain() }
        }
    }

    override suspend fun addTransaction(item: Transaction) {
        dao.insert(item.toEntity())
    }

}