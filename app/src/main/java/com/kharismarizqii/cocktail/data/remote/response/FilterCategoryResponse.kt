package com.kharismarizqii.cocktail.data.remote.response


import com.google.gson.annotations.SerializedName

data class FilterCategoryResponse(
    @SerializedName("drinks")
    var drinks: List<Drink> = listOf()
) {
    data class Drink(
        @SerializedName("strCategory")
        var strCategory: String = ""
    )
}