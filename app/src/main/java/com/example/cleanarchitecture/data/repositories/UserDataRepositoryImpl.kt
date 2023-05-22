package com.example.cleanarchitecture.data.repositories

import com.example.cleanarchitecture.data.preferences.UserDataPreferencesHelper
import com.example.cleanarchitecture.domain.repositories.UserDataRepository
import com.example.cleanarchitecture.models.UserDataModel
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

    override fun getUser() = UserDataModel(
        userDataPreferencesHelper.name.toString(),
        userDataPreferencesHelper.age,
        userDataPreferencesHelper.password.toString()
    )
}