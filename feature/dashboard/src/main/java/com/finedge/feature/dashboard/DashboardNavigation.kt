package com.finedge.feature.dashboard

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.finedge.feature.dashboard.presentation.DashboardScreen


fun NavGraphBuilder.dashboardGraph(navController: NavHostController) {
    composable("dashboard") {
        DashboardScreen()
    }
}

