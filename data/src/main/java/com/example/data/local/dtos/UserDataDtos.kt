package com.example.data.local.dtos

import com.example.domain.model.UserDataModel

data class UserDataDtos(

    val name: String,
    val age: Int,
    val password: String
)

fun UserDataDtos.toDomain(): UserDataModel {
    return UserDataModel(name, age, password)
}