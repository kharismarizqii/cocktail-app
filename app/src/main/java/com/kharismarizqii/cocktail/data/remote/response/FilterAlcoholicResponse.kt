package com.kharismarizqii.cocktail.data.remote.response


import com.google.gson.annotations.SerializedName

data class FilterAlcoholicResponse(
    @SerializedName("drinks")
    var drinks: List<Drink> = listOf()
) {
    data class Drink(
        @SerializedName("strAlcoholic")
        var strAlcoholic: String = ""
    )
}