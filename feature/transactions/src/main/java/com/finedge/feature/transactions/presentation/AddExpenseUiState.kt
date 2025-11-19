package com.finedge.feature.transactions.presentation

import com.finedge.core.common.UiState

data class AddExpenseUiState(
    val title: String = "",
    val amount: String = "",
    val isSaving: Boolean = false,
    val titleError: String? = null,
    val amountError: String? = null,
    val isSaved: Boolean = false
) : UiState
