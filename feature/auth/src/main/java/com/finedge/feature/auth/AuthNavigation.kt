package com.finedge.feature.auth

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

fun NavGraphBuilder.authGraph(navController: NavHostController) {
    composable(route = "auth"){
        AuthScreen()
    }
}

@Composable
fun AuthScreen() {
    Text("Auth Screen")
}
