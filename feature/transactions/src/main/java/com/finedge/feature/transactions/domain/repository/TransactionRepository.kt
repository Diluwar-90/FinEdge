package com.finedge.feature.transactions.domain.repository

import com.finedge.feature.transactions.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    fun getTransactions(): Flow<List<Transaction>>
    suspend fun addTransaction(item: Transaction)
}
