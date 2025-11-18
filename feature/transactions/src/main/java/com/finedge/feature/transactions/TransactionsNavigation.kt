package com.finedge.feature.transactions

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

fun NavGraphBuilder.transactionsGraph(navController: NavHostController) {
    composable("transactions") {
        TransactionsScreen()
    }
}

@Composable
fun TransactionsScreen() {
    Text("Transactions")
}
