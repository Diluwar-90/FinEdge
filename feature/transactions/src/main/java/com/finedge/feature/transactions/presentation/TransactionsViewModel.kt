package com.finedge.feature.transactions.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finedge.feature.transactions.domain.model.Transaction
import com.finedge.feature.transactions.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val repository: TransactionRepository
) : ViewModel() {
    val transactions = repository.getTransactions()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun addDummyTransaction(){
        viewModelScope.launch {
            val item = Transaction(
                title = "Sample Item",
                amount = (50..500).random().toDouble(),
                timestamp = System.currentTimeMillis()
            )
            repository.addTransaction(item)
        }
    }
}