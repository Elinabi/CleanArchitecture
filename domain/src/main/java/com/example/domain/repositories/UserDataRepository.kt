package com.example.domain.repositories

import com.example.domain.model.UserDataModel

interface UserDataRepository {

    fun authUser(name: String, age: Int, password: String)

    fun getUser(): UserDataModel
}