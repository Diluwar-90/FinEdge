package com.finedge

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.finedge.feature.auth.authGraph
import com.finedge.feature.dashboard.dashboardGraph
import com.finedge.feature.transactions.transactionsGraph

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "auth"
    ) {
        authGraph(navController)
        dashboardGraph(navController)
        transactionsGraph(navController)
    }
}
