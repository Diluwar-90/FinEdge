package com.finedge.feature.auth.data

import com.finedge.core.common.UiState

data class AuthUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false
) : UiState
