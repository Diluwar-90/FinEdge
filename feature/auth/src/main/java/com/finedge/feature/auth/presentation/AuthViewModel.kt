package com.finedge.feature.auth.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finedge.feature.auth.data.AuthEvent
import com.finedge.feature.auth.data.AuthUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class AuthViewModel @Inject constructor(): ViewModel(){
    var uiState by mutableStateOf(AuthUiState())
        private set

    fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.EmailChanged -> uiState = uiState.copy(email = event.value)
            is AuthEvent.PasswordChanged -> uiState = uiState.copy(password = event.value)
            is AuthEvent.LoginClicked -> login()
        }
    }

    private fun login() {
        uiState = uiState.copy(isLoading = true)

        viewModelScope.launch {
            delay(1500)
            uiState = uiState.copy(isLoading = false, isLoggedIn = true)
        }
    }

}