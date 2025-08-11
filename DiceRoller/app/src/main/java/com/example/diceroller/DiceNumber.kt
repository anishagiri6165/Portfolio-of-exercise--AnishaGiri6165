package com.example.diceroller

import androidx.annotation.DrawableRes

enum class DiceNumber(@DrawableRes val imageResource:Int) {
    One(R.drawable.dice_1),
    Two(R.drawable.dice_2),
    Three(R.drawable.dice_3),
    Four(R.drawable.dice_4),
    Five(R.drawable.dice_5),
    Six(R.drawable.dice_6)
}