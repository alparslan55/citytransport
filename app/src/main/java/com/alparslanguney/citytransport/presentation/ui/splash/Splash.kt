package com.alparslanguney.citytransport.presentation.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
fun Splash(viewModel: SplashViewModel, onSuccess: () -> Unit) {

    val uiState = viewModel.uiState.collectAsState()

    when (uiState.value) {
        is SplashUiStates.Error -> {
            /* no-op */
        }
        SplashUiStates.Loading -> {
            /* no-op */
        }
        SplashUiStates.RequiredUpdate -> {
            /* no-op */
        }
        SplashUiStates.Success -> {
            LaunchedEffect(key1 = Unit) {
                onSuccess()
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.bg_splash),
            contentDescription = null
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
        )
        Text(
            text = "City Transport",
            color = Color.White,
            style = MaterialTheme.typography.headlineLarge,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Splash Preview")
@Composable
fun SplashPreview() {
    Splash(viewModel = SplashViewModel()) {
        /* no-op */
    }
}