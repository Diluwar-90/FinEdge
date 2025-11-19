package com.finedge.feature.transactions

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.finedge.feature.transactions.presentation.AddExpenseScreen
import com.finedge.feature.transactions.presentation.TransactionsScreen

fun NavGraphBuilder.transactionsGraph(navController: NavHostController) {
    composable("transactions") {
        TransactionsScreen(
            onAddClick = { navController.navigate("add_expense") }
        )
    }

    composable("add_expense") {
        AddExpenseScreen(onBack = { navController.popBackStack() })
    }
}

