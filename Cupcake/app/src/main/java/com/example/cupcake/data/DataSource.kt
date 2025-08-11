package com.example.cupcake.data

import com.example.cupcake.R

object DataSource {
    val flavors = listOf(
        R.string.vanilla,
        R.string.chocolate,
        R.string.red_velvet,
        R.string.salted_caramel,
        R.string.coffee
    )
    val topping = listOf(
        Pair(R.string.plain, 1.00),
        Pair(R.string.topping_cherry, 0.30),
        Pair(R.string.topping_powder_sugar, 0.30),
        Pair(R.string.topping_sprinkles, 0.50)
    )
    val quantityOptions = listOf(
        Pair(R.string.one_cupcake, 1),
        Pair(R.string.six_cupcakes, 6),
        Pair(R.string.twelve_cupcakes, 12)
    )
}
