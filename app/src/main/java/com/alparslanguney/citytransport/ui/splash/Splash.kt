package com.alparslanguney.citytransport.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.alparslanguney.citytransport.R

/**
 * Created by Alparslan Güney 7.04.2023
 * Copyright (c) 2021  Asis Elektronik Bilişim Sis. A.Ş. All rights reserved.
 */
@Composable
fun Splash() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.bg_splash),
            contentDescription = null
        )
        Box(
            modifier = Modifier.fillMaxSize()
                .background(color = Color(0xBE0075C5)),
        ) {

        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Splash Preview")
@Composable
fun SplashPreview() {
    Splash()
}