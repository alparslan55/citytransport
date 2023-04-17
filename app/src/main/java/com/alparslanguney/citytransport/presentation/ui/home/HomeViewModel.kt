package com.alparslanguney.citytransport.presentation.ui.home

import androidx.lifecycle.ViewModel
import com.alparslanguney.citytransport.domain.usecase.menu.MenuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Alparslan Güney 14.04.2023
 * Copyright (c) 2021  Asis Elektronik Bilişim Sis. A.Ş. All rights reserved.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val menuUseCase: MenuUseCase
) : ViewModel() {

    fun getMenuItems() = menuUseCase()

}