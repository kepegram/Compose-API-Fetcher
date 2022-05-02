package edu.towson.cosc435.pegram.assignment4.restapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userService: UserService
) : ViewModel() {
    val userState = MutableStateFlow<UserState>(UserState.StartState)
    init {
        fetchUser()
    }
    private fun fetchUser() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val user = userService.fetchUser()
                userState.tryEmit(UserState.Success(user))
            }
        }
    }
}

sealed class UserState {
    object StartState : UserState()
    data class Success(val users: List<Photos>) : UserState()
}