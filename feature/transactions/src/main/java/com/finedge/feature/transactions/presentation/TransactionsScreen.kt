package com.finedge.feature.transactions.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.finedge.core.common.formatDate

@Composable
fun TransactionsScreen(
    viewModel: TransactionsViewModel = hiltViewModel()
) {
    val mockList = viewModel.transactions.collectAsState().value

    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = { viewModel.addDummyTransaction() },
            modifier = Modifier
                .fillMaxWidth().padding(16.dp)
        ) {
            Text(text = "Fetch Transactions")
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(mockList) { item ->
            Text(item.title, style = MaterialTheme.typography.bodyLarge)
            Text("₹ ${item.amount}", style = MaterialTheme.typography.bodyLarge)
            Text(formatDate(item.timestamp), style = MaterialTheme.typography.bodySmall)
            HorizontalDivider()
        }
    }
}
