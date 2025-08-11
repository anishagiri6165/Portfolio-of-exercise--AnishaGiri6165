package com.example.dessertclicker.data

import androidx.annotation.DrawableRes

class DesertUiState(
    var revenue: Int = 0,
    var dessertsSold: Int = 0,
    var currentDessertIndex: Int = 0,
    var currentDessertPrice: Int = Datasource.dessertList[currentDessertIndex].price,
    @DrawableRes var currentDessertImageId: Int = Datasource.dessertList[currentDessertIndex].imageId
)