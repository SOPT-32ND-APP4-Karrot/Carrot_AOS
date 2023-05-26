package com.sumin.android.carrot_aos.presentation

sealed interface UiState {
    object Success: UiState
    object Failure: UiState
    object Error: UiState
}