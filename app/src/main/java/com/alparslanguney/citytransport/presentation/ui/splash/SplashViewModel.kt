package com.alparslanguney.citytransport.presentation.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Alparslan Güney 7.04.2023
 * Copyright (c) 2021  Asis Elektronik Bilişim Sis. A.Ş. All rights reserved.
 */
@HiltViewModel
class SplashViewModel @Inject constructor(): ViewModel() {

    private val _uiState = MutableStateFlow<SplashUiStates>(SplashUiStates.Loading)
    val uiState = _uiState

    init {
        viewModelScope.launch {
            delay(100)
            _uiState.value = SplashUiStates.Success
        }
    }

}