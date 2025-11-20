package com.finedge.feature.transactions.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExpenseScreen(
    viewModel: AddExpenseViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val state = viewModel.uiState

    if (state.isSaved) {
        onBack()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Expense") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            OutlinedTextField(
                value = state.title,
                onValueChange = { viewModel.onEvent(AddExpenseEvent.TitleChanged(it)) },
                label = { Text("Title") },
                isError = state.titleError != null,
                modifier = Modifier.fillMaxWidth()
            )
            if (state.titleError != null) {
                Text(state.titleError!!, color = Color.Red, fontSize = 12.sp)
            }

            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = state.amount,
                onValueChange = { viewModel.onEvent(AddExpenseEvent.AmountChanged(it)) },
                label = { Text("Amount") },
                isError = state.amountError != null,
                modifier = Modifier.fillMaxWidth()
            )
            if (state.amountError != null) {
                Text(state.amountError!!, color = Color.Red, fontSize = 12.sp)
            }

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = { viewModel.onEvent(AddExpenseEvent.SaveClicked) },
                modifier = Modifier.fillMaxWidth(),
                enabled = !state.isSaving
            ) {
                if (state.isSaving) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(22.dp),
                        strokeWidth = 2.dp
                    )
                } else {
                    Text("Save Expense details")
                }
            }
        }
    }
}
