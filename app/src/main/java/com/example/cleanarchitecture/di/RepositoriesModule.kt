package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.data.repositories.UserDataRepositoryImpl
import com.example.cleanarchitecture.domain.repositories.UserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindUserDataRepository(repositoryImpl: UserDataRepositoryImpl):UserDataRepository
}