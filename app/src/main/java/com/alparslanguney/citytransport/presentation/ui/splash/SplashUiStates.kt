package com.alparslanguney.citytransport.presentation.ui.splash

/**
 * Created by Alparslan Güney 9.04.2023
 * Copyright (c) 2021  Asis Elektronik Bilişim Sis. A.Ş. All rights reserved.
 */
sealed class SplashUiStates {
    object Success : SplashUiStates()
    object Loading : SplashUiStates()
    object RequiredUpdate : SplashUiStates()
    data class Error(val message: String) : SplashUiStates()
}
