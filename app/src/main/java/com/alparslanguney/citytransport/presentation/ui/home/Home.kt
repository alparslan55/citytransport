@file:OptIn(ExperimentalMaterial3Api::class)

package com.alparslanguney.citytransport.presentation.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alparslanguney.citytransport.R
import com.alparslanguney.citytransport.domain.usecase.menu.MenuUseCase
import com.alparslanguney.citytransport.presentation.ui.theme.CitytransportTheme
import kotlinx.coroutines.launch

/**
 * Created by Alparslan Güney 9.04.2023
 * Copyright (c) 2021  Asis Elektronik Bilişim Sis. A.Ş. All rights reserved.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(viewModel: HomeViewModel) {
    Column {
        val scrollState = rememberScrollState()

        val topAppBarState = rememberTopAppBarState()

        val tabSelectedIndex = remember { mutableStateOf(0) }

        val drawerState = rememberDrawerState(DrawerValue.Closed)

        val scope = rememberCoroutineScope()

        var topAppBarSpacerAlpha by remember {
            mutableStateOf(0.5f)
        }

        val nestedScrollConnection = remember {
            object : NestedScrollConnection {
                override fun onPreScroll(
                    available: Offset, source: NestedScrollSource
                ): Offset {
                    val delta = available.y
                    topAppBarSpacerAlpha = (topAppBarSpacerAlpha - delta / 500).coerceIn(0.5f, 1f)
                    return Offset.Zero
                }
            }
        }

        ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
            BoxWithConstraints {
                Column(
                    modifier = Modifier
                        .widthIn(min = 300.dp,max = this.maxWidth)
                        .fillMaxHeight()
                        .background(color = MaterialTheme.colorScheme.primary)
                ) {
                    Text(text = "ALPARSLAN")
                }
            }
        }) {
            Scaffold(topBar = {
                HomeTopAppBar(topAppBarState, onDrawerClick = {
                    scope.launch {
                        drawerState.open()
                    }
                })
            }, floatingActionButton = {
                QrReadButton()
            }, floatingActionButtonPosition = FabPosition.Center
            ) {

                BoxWithConstraints(
                    modifier = Modifier.nestedScroll(nestedScrollConnection),
                    content = {
                        Column(modifier = Modifier.verticalScroll(scrollState)) {
                            TopAppBarSpacer(topAppBarState, alpha = topAppBarSpacerAlpha)
                            TopAppBarTabRow(tabSelectedIndex = tabSelectedIndex)
                            when (tabSelectedIndex.value) {
                                0 -> {
                                    HomeGridMenu(
                                        height = this@BoxWithConstraints.maxHeight,
                                        menuItems = viewModel.getMenuItems()
                                    )
                                }
                                1 -> {
                                    /* no-op */
                                }
                                2 -> {
                                    /* no-op */
                                }
                            }
                        }
                    })
            }
        }
    }
}

@Composable
private fun QrReadButton() {
    Box(
        modifier = Modifier
            .wrapContentWidth(Alignment.CenterHorizontally)
            .background(
                color = MaterialTheme.colorScheme.primary, RoundedCornerShape(8.dp)
            )
    ) {
        Row(
            modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(35.dp),
                    tint = Color.White,
                    painter = painterResource(id = R.drawable.ic_qr_icon),
                    contentDescription = "QR Geçiş"
                )
            }
            Column {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "QR GEÇİŞ",
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
            Column {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "256.55 TL",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBarSpacer(topAppBarState: TopAppBarState, alpha: Float) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(topAppBarState.contentOffset.dp + 150.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_splash),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.primary.copy(
                        alpha = alpha
                    )
                )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeTopAppBar(topAppBarState: TopAppBarState, onDrawerClick: () -> Unit) {
    CenterAlignedTopAppBar(scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    ), colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = Color.Transparent,
        navigationIconContentColor = Color.White,
        actionIconContentColor = Color.White,
        titleContentColor = Color.White,
        scrolledContainerColor = MaterialTheme.colorScheme.primary
    ), title = {
        Text(text = stringResource(id = R.string.app_name).uppercase())
    }, navigationIcon = {
        IconButton(onClick = { onDrawerClick() }) {
            Icon(
                imageVector = Icons.Filled.Menu, contentDescription = "Menu"
            )
        }
    }, actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.AccountCircle, contentDescription = "Profile"
            )
        }
    })
}

@Composable
private fun TopAppBarTabRow(tabSelectedIndex: MutableState<Int>) {

    TabRow(modifier = Modifier
        .padding(15.dp)
        .graphicsLayer {
            this.translationY = -35.dp.toPx()
        }
        .shadow(8.dp, RoundedCornerShape(16.dp)),
        containerColor = Color.White,
        selectedTabIndex = tabSelectedIndex.value,
        indicator = {
            TabRowDefaults.Indicator(
                color = Color.Transparent, height = 0.dp
            )
        }) {
        AppBarTabItem(text = stringResource(R.string.home),
            selected = tabSelectedIndex.value == 0,
            onClick = {
                tabSelectedIndex.value = 0
            })
        AppBarTabItem(text = stringResource(R.string.my_cards),
            selected = tabSelectedIndex.value == 1,
            onClick = {
                tabSelectedIndex.value = 1
            })
        AppBarTabItem(text = stringResource(R.string.announcements),
            selected = tabSelectedIndex.value == 2,
            onClick = {
                tabSelectedIndex.value = 2
            })
    }
}

@Composable
fun AppBarTabItem(
    text: String, selected: Boolean, onClick: () -> Unit
) {
    Tab(modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp),
        selected = selected,
        onClick = {
            onClick()
        }) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = if (selected) MaterialTheme.colorScheme.primary else Color.Transparent,
                    shape = RoundedCornerShape(13.dp)
                )
                .padding(5.dp), contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(5.dp),
                color = if (selected) Color.White else Color.DarkGray,
                text = text.uppercase(),
                fontSize = 12.sp
            )
        }
    }
}

@Composable
@Preview(name = "QR Read Button Preview")
fun QrReadButtonPreview() {
    CitytransportTheme {
        QrReadButton()
    }
}

@Composable
@Preview(name = "Home TopAppBarTabRow Preview")
fun HomeTopAppBarTabRowPreview() {
    CitytransportTheme {
        /// TopAppBarTabRow()
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true, name = "Home Preview")
fun HomePreview() {
    CitytransportTheme {
        Home(viewModel = HomeViewModel(MenuUseCase()))
    }
}