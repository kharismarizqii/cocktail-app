package com.kharismarizqii.cocktail.data.remote.response


import com.google.gson.annotations.SerializedName

data class CocktailResponse(
    @SerializedName("drinks")
    var drinks: List<Drink> = listOf()
) {
    data class Drink(
        @SerializedName("idDrink")
        var idDrink: String = "",
        @SerializedName("strDrink")
        var strDrink: String = "",
        @SerializedName("strDrinkThumb")
        var strDrinkThumb: String = "",
    )
}