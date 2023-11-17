package com.example.formulirskripsi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.formulirskripsi.data.DataSources
import com.example.formulirskripsi.data.FormUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FormViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(FormUIState())
    val stateUI: StateFlow<FormUIState> = _stateUI.asStateFlow()

    fun setFormulir(listData: MutableList<String>) {
        _stateUI.update { currentState ->
            currentState.copy(
                nama = listData[0],
                nim = listData[1],
                konsen = listData[2],
                judul = listData[0],
                dobing1 = listData[1],
                dobing2 = listData[2],
            )
        }
    }

    fun setDosbing1(sdosbing1: String) {
        _stateUI.update { currentState -> currentState.copy(dobing1 = sdosbing1) }
    }

    fun setDosbing2(sdosbing2: String) {
        _stateUI.update { currentState -> currentState.copy(dobing2 = sdosbing2) }
    }
    fun resetForm() {
        _stateUI.value = FormUIState()
    }
}