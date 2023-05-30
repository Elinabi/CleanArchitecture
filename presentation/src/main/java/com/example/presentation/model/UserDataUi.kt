package com.example.presentation.model

import android.os.Parcelable
import com.example.domain.model.UserDataModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDataUi(

    val name: String,
    val age: Int,
    val password: String
): Parcelable

fun UserDataModel.toDataUi(): UserDataUi {
    return UserDataUi(name, age, password)
}