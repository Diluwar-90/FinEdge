package com.finedge.feature.transactions.domain.model

data class Transaction(
    val id: Int = 0,
    val title: String,
    val amount: Double,
    val timestamp: Long
)
