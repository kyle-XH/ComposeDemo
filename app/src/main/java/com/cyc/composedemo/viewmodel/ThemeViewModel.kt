package com.cyc.composedemo.viewmodel

import androidx.lifecycle.ViewModel
import com.cyc.composedemo.data.ThemeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ThemeViewModel : ViewModel(){
    private val _themeState = MutableStateFlow(ThemeState())
    val themeState : StateFlow<ThemeState> = _themeState.asStateFlow()

    fun setThemeState(state: ThemeState){
        _themeState.value = state
    }
}