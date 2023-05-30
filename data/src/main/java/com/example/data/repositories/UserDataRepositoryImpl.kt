package com.example.data.repositories

import com.example.data.local.dtos.UserDataDtos
import com.example.data.local.dtos.toDomain
import com.example.data.local.preferences.UserDataPreferencesHelper
import com.example.domain.repositories.UserDataRepository
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val userDataPreferencesHelper: UserDataPreferencesHelper,
) : UserDataRepository {

    override fun authUser(name: String, age: Int, password: String) {
        userDataPreferencesHelper.apply {
            this.name = name
            this.age = age
            this.password = password
        }
    }

    override fun getUser() = UserDataDtos(
        userDataPreferencesHelper.name.toString(),
        userDataPreferencesHelper.age,
        userDataPreferencesHelper.password.toString()
    ).toDomain()
}