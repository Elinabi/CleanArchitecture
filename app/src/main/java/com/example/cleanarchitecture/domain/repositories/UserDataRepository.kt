package com.example.cleanarchitecture.domain.repositories

import com.example.cleanarchitecture.models.UserDataModel

interface UserDataRepository {

    fun authUser(name:String, age:Int, password:String)

    fun getUser(): UserDataModel
}