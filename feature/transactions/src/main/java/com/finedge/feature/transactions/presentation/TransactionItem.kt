package com.finedge.feature.transactions.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.finedge.core.common.formatDate
import com.finedge.feature.transactions.domain.model.Transaction

@Composable
fun TransactionItem(item: Transaction) {
    Column(modifier = Modifier.padding(12.dp)) {
        Text(item.title, style = MaterialTheme.typography.titleMedium)
        Text("₹ ${item.amount}", style = MaterialTheme.typography.bodyLarge)
        Text(formatDate(item.timestamp), style = MaterialTheme.typography.bodySmall)
    }
}
