package com.example.presentation.ui.fragments.auth

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.AuthUserUseCase
import com.example.domain.usecases.GetUserUseCase
import com.example.presentation.model.UserDataUi
import com.example.presentation.model.toDataUi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthUserViewModel @Inject constructor(
    private val authUserUseCase: AuthUserUseCase,
    private val getUserTwoUseCase: GetUserUseCase
): ViewModel(){

    fun authUser(name:String,age:Int, password:String){
        authUserUseCase(name, age, password)
    }
    fun getUser(): UserDataUi {
        return getUserTwoUseCase().toDataUi()
    }
}