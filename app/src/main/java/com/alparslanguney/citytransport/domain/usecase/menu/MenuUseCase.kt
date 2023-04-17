package com.alparslanguney.citytransport.domain.usecase.menu

import com.alparslanguney.citytransport.domain.model.MenuItem
import com.alparslanguney.citytransport.domain.model.menu.MenuType
import javax.inject.Inject

/**
 * Created by Alparslan Güney 14.04.2023
 * Copyright (c) 2021  Asis Elektronik Bilişim Sis. A.Ş. All rights reserved.
 */
class MenuUseCase @Inject constructor(

) {

    operator fun invoke(): List<MenuItem> {
        return listOf(
            MenuItem(
                MenuType.Lines
            ), MenuItem(
                MenuType.Stations
            ), MenuItem(
                MenuType.DepartureTimes
            ), MenuItem(
                MenuType.CardInquiry
            ), MenuItem(
                MenuType.SalesPoints
            ), MenuItem(
                MenuType.Favourites
            )
        )
    }

}