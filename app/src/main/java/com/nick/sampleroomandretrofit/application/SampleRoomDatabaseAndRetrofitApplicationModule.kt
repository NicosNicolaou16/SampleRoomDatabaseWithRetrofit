package com.nick.sampleroomandretrofit.application

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class, ActivityComponent::class, FragmentComponent::class)
object SampleRoomDatabaseAndRetrofitApplicationModule {

    @Provides
    fun getApplicationInstance() = SampleRoomDatabaseAndRetrofitApplication()
}