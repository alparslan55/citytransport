package com.alparslanguney.citytransport.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.alparslanguney.citytransport.R
import com.alparslanguney.citytransport.domain.model.MenuItem
import com.alparslanguney.citytransport.domain.model.menu.MenuType

/**
 * Created by Alparslan Güney 17.04.2023
 * Copyright (c) 2021  Asis Elektronik Bilişim Sis. A.Ş. All rights reserved.
 */
@Composable
fun HomeGridMenu(height: Dp, menuItems: List<MenuItem>) {
    LazyVerticalGrid(modifier = Modifier
        .height(height - 160.dp)
        .padding(horizontal = 18.dp)
        .graphicsLayer {
            translationY = -35.dp.toPx()
        }, columns = GridCells.Fixed(2), content = {
        menuItems.forEach { menuItem ->
            item {
                HomeGridMenuItem(menuItem = menuItem)
            }
        }
    })
}

@Composable
fun HomeGridMenuItem(menuItem: MenuItem) {
    when (menuItem.menuType) {
        MenuType.CardInquiry -> {
            HomeGridMenuButton(
                menuIcon = painterResource(id = R.drawable.ic_menu_card_inquiry),
                menuTitle = stringResource(
                    R.string.home_menu_card_inquiry
                )
            )
        }
        MenuType.DepartureTimes -> {
            HomeGridMenuButton(
                menuIcon = painterResource(id = R.drawable.ic_menu_departure_times),
                menuTitle = stringResource(R.string.home_menu_departure_times)
            )
        }
        MenuType.Favourites -> {
            HomeGridMenuButton(
                menuIcon = painterResource(id = R.drawable.ic_menu_favourites),
                menuTitle = stringResource(R.string.home_menu_favourites)
            )
        }
        MenuType.Lines -> {
            HomeGridMenuButton(
                menuIcon = painterResource(id = R.drawable.ic_menu_bus),
                menuTitle = stringResource(R.string.home_menu_lines)
            )
        }
        MenuType.SalesPoints -> {
            HomeGridMenuButton(
                menuIcon = painterResource(id = R.drawable.ic_menu_sales_point),
                menuTitle = stringResource(R.string.home_menu_sales_point)
            )
        }
        MenuType.Stations -> {
            HomeGridMenuButton(
                menuIcon = painterResource(id = R.drawable.ic_menu_stations),
                menuTitle = stringResource(R.string.home_menu_stations)
            )
        }
    }
}

@Composable
private fun HomeGridMenuButton(
    menuIcon: Painter, menuTitle: String
) {
    Button(colors = ButtonDefaults.buttonColors(
        containerColor = Color.White
    ), modifier = Modifier
        .padding(8.dp)
        .heightIn(min = 130.dp, 130.dp)
        .border(
            1.dp, color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(22.dp)
        )
        .fillMaxWidth(), shape = RoundedCornerShape(8.dp), onClick = { }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .padding(8.dp)
                    .size(32.dp),
                painter = menuIcon,
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(8.dp),
                text = menuTitle,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}