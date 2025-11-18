package com.finedge.feature.dashboard

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable


fun NavGraphBuilder.dashboardGraph(navController: NavHostController) {
    composable("dashboard") {
        DashboardScreen()
    }
}

@Composable
fun DashboardScreen() {
    Text("Dashboard")
}
