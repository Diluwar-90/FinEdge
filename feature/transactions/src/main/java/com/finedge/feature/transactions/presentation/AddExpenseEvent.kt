package com.finedge.feature.transactions.presentation

import com.finedge.core.common.UiEvent

sealed class AddExpenseEvent : UiEvent {
    data class TitleChanged(val value: String) : AddExpenseEvent()
    data class AmountChanged(val value: String) : AddExpenseEvent()
    data object SaveClicked : AddExpenseEvent()
}
