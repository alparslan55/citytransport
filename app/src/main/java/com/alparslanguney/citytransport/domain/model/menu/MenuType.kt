package com.alparslanguney.citytransport.domain.model.menu

/**
 * Created by Alparslan Güney 14.04.2023
 * Copyright (c) 2021  Asis Elektronik Bilişim Sis. A.Ş. All rights reserved.
 */
sealed class MenuType {
    object Lines : MenuType()
    object Stations : MenuType()
    object DepartureTimes : MenuType()
    object CardInquiry : MenuType()
    object SalesPoints : MenuType()
    object Favourites : MenuType()
}
