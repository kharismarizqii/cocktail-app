package com.kharismarizqii.cocktail.data.remote.response


import com.google.gson.annotations.SerializedName

data class DetailCocktailResponse(
    @SerializedName("drinks")
    var drinks: List<Drink> = listOf()
) {
    data class Drink(
        @SerializedName("idDrink")
        var idDrink: String = "",
        @SerializedName("strDrink")
        var strDrink: String = "",
        @SerializedName("strCategory")
        var strCategory: String = "",
        @SerializedName("strAlcoholic")
        var strAlcoholic: String = "",
        @SerializedName("strGlass")
        var strGlass: String = "",
        @SerializedName("strInstructions")
        var strInstructions: String = "",
        @SerializedName("strDrinkThumb")
        var strDrinkThumb: String = "",
        @SerializedName("strIngredient1")
        var strIngredient1: String = "",
        @SerializedName("strIngredient2")
        var strIngredient2: String = "",
        @SerializedName("strIngredient3")
        var strIngredient3: String = "",
        @SerializedName("strIngredient4")
        var strIngredient4: String = "",
        @SerializedName("strMeasure1")
        var strMeasure1: String = "",
        @SerializedName("strMeasure2")
        var strMeasure2: String = "",
        @SerializedName("strMeasure3")
        var strMeasure3: String = "",
        @SerializedName("strMeasure4")
        var strMeasure4: String = "",
        @SerializedName("strCreativeCommonsConfirmed")
        var strCreativeCommonsConfirmed: String = "",
        @SerializedName("dateModified")
        var dateModified: String = ""
    )
}