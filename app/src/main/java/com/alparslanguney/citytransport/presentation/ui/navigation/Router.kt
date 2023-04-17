package com.alparslanguney.citytransport.presentation.ui.navigation

/**
 * Created by Alparslan Güney 9.04.2023
 * Copyright (c) 2021  Asis Elektronik Bilişim Sis. A.Ş. All rights reserved.
 */
sealed class Router(val route : String) {
    object Home : Router("home")
    object Splash : Router("splash")
}
