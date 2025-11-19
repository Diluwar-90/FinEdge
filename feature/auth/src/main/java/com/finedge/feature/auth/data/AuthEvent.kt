package com.finedge.feature.auth.data

import com.finedge.core.common.UiEvent

sealed class AuthEvent : UiEvent {
    data class EmailChanged(val value: String) : AuthEvent()
    data class PasswordChanged(val value: String) : AuthEvent()
    data object LoginClicked : AuthEvent()
}