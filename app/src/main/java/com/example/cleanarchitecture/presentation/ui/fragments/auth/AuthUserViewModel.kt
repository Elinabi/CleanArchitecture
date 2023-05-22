package com.example.cleanarchitecture.presentation.ui.fragments.auth

import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.usecases.AuthUserUseCase
import com.example.cleanarchitecture.domain.usecases.GetUserUseCase
import com.example.cleanarchitecture.models.UserDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthUserViewModel @Inject constructor(
    private val authUserUseCase: AuthUserUseCase,
    private val getUserUseCase: GetUserUseCase
): ViewModel(){

    fun authUser(name:String,age:Int, password:String){
        authUserUseCase(name, age, password)
    }
    fun getUser(): UserDataModel{
        return getUserUseCase()
    }
}