package com.finedge.feature.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.finedge.feature.auth.presentation.AuthScreen

fun NavGraphBuilder.authGraph(navController: NavHostController) {
    composable(route = "auth"){
        AuthScreen {
            navController.navigate(route = "dashboard"){
                popUpTo("auth"){
                    inclusive = true
                }
            }
        }
    }
}

