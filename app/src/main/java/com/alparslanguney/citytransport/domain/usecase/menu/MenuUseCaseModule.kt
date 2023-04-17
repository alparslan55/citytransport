package com.alparslanguney.citytransport.domain.usecase.menu

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Alparslan Güney 14.04.2023
 * Copyright (c) 2021  Asis Elektronik Bilişim Sis. A.Ş. All rights reserved.
 */
@Module
@InstallIn(SingletonComponent::class)
object MenuUseCaseModule {
    @Provides
    fun provideMenuUseCase() = MenuUseCase()
}