package com.alparslanguney.citytransport.presentation.ui.routes

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alparslanguney.citytransport.presentation.ui.theme.CitytransportTheme

/**
 * Created by Alparslan Güney 22.04.2023
 * Copyright (c) 2021  Asis Elektronik Bilişim Sis. A.Ş. All rights reserved.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Routes() {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(10.dp),
                title = {
                    Text(
                        color = Color.White,
                        text = "Hatlar"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {

    }
}

@Composable
@Preview(name = "Routres", showSystemUi = true)
fun RoutesPreview() {
    CitytransportTheme {
        Routes()
    }
}