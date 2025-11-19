package com.finedge.feature.transactions.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finedge.feature.transactions.domain.model.Transaction
import com.finedge.feature.transactions.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class AddExpenseViewModel @Inject constructor(
    private val repository: TransactionRepository
) : ViewModel() {

    var uiState by mutableStateOf(AddExpenseUiState())
        private set

    fun onEvent(event: AddExpenseEvent) {
        when(event) {
            is AddExpenseEvent.TitleChanged -> {
                uiState = uiState.copy(title = event.value, titleError = null)
            }
            is AddExpenseEvent.AmountChanged -> {
                uiState = uiState.copy(amount = event.value, amountError = null)
            }
            AddExpenseEvent.SaveClicked -> save()
        }
    }

    private fun save() {
        if (!validate()) return

        uiState = uiState.copy(isSaving = true)

        viewModelScope.launch {
            val item = Transaction(
                title = uiState.title,
                amount = uiState.amount.toDouble(),
                timestamp = System.currentTimeMillis()
            )

            repository.addTransaction(item)

            uiState = uiState.copy(isSaving = false, isSaved = true)
        }
    }

    private fun validate(): Boolean {
        var valid = true

        if (uiState.title.isBlank()) {
            uiState = uiState.copy(titleError = "Title required")
            valid = false
        }

        if (uiState.amount.isBlank() || uiState.amount.toDoubleOrNull() == null) {
            uiState = uiState.copy(amountError = "Enter valid amount")
            valid = false
        }

        return valid
    }
}
