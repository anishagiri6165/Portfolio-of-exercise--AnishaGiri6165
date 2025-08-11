package com.example.dessertclicker.model

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.DesertUiState
import com.example.dessertclicker.data.Datasource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DesertViewModel : ViewModel() {

    private val _dessertUiState = MutableStateFlow(DesertUiState())
    val dessertUiState: StateFlow<DesertUiState> = _dessertUiState.asStateFlow()

    fun onDessertClicked() {
        _dessertUiState.update { currentUiState  ->
            val dessertsSold = currentUiState.dessertsSold + 1
            val nextDessertIndex = determineDessertIndex(dessertsSold)
            val nextDessert = dessertList[nextDessertIndex]
            val newRevenue = currentUiState.revenue + nextDessert.price
            DesertUiState(
                currentDessertIndex = nextDessertIndex,
                revenue = newRevenue,
                dessertsSold = dessertsSold,
                currentDessertImageId = nextDessert.imageId,
                currentDessertPrice = nextDessert.price
            )
        }
    }

    private fun determineDessertIndex(dessertsSold: Int): Int {
        var dessertIndex = 0
        for (index in dessertList.indices) {
            if (dessertsSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            } else {
                break
            }
        }
        return dessertIndex
    }
}