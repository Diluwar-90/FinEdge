package com.finedge.feature.transactions.data

import com.finedge.core.data.TransactionEntity
import com.finedge.feature.transactions.domain.model.Transaction


fun TransactionEntity.toDomain(): Transaction {
    return Transaction(
        id = id,
        title = title,
        amount = amount,
        timestamp = timestamp,
    )
}
fun Transaction.toEntity(): TransactionEntity {
        return TransactionEntity(
            id = id,
            title = title,
            amount = amount,
            timestamp = timestamp
        )

}