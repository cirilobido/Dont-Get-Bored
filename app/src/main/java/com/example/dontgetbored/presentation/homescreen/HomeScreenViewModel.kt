package com.example.dontgetbored.presentation.homescreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dontgetbored.domain.usecases.GetBoredActivityUseCase
import com.example.dontgetbored.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getBoredActivityUseCase: GetBoredActivityUseCase
): ViewModel() {

    var homeState by mutableStateOf(HomeState())
        private set

    init {
        loadActivityData()
    }

    fun getNewActivity(){
        loadActivityData()
    }

    private fun loadActivityData() {
        getBoredActivityUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    homeState = HomeState(
                        boredActivity = result.data,
                    )
                }
                is Resource.Error -> {
                    homeState = HomeState(
                        error = result.message
                    )
                }
                is Resource.Loading -> {
                    homeState = HomeState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}