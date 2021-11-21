package com.kharismarizqii.cocktail.data.remote.response


import com.google.gson.annotations.SerializedName

data class FilterGlassResponse(
    @SerializedName("drinks")
    var drinks: List<Drink> = listOf()
) {
    data class Drink(
        @SerializedName("strGlass")
        var strGlass: String = ""
    )
}