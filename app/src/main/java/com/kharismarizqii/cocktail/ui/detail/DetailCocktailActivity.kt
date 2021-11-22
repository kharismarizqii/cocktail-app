package com.kharismarizqii.cocktail.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.kharismarizqii.cocktail.MyApplication
import com.kharismarizqii.cocktail.databinding.ActivityDetailCocktailBinding
import com.kharismarizqii.cocktail.domain.model.DetailCocktail
import com.kharismarizqii.cocktail.utils.extensions.setupTransparentStatusBar
import com.kharismarizqii.core_cocktail.abstraction.BaseActivityBinding
import javax.inject.Inject

class DetailCocktailActivity : BaseActivityBinding<ActivityDetailCocktailBinding>(),
    Observer<DetailCocktailViewModel.DetailCocktailUiState> {

    @Inject
    lateinit var viewModel: DetailCocktailViewModel

    override val bindingInflater: (LayoutInflater) -> ActivityDetailCocktailBinding
        get() = {
            ActivityDetailCocktailBinding.inflate(it)
        }

    override fun setupView() {
        (application as MyApplication).appComponent.inject(this)

        setupTransparentStatusBar(binding)
        binding.btnBack.setOnClickListener {
            finish()
        }
        val id = intent.getStringExtra(EXTRA_ID)
        viewModel.uiState.observe(this, this)
        getDetailCocktail(id)
    }

    private fun getDetailCocktail(id: String?) {
        if (id != null) {
            viewModel.getDetailCocktail(id)
        } else {
            Toast.makeText(this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onChanged(t: DetailCocktailViewModel.DetailCocktailUiState?) {
        when (t) {
            is DetailCocktailViewModel.DetailCocktailUiState.Success -> {
                binding.progressBar.visibility = View.INVISIBLE
                hideAllComponent(false)
                setupViewWithData(t.data)
            }
            is DetailCocktailViewModel.DetailCocktailUiState.Failed -> {
                binding.progressBar.visibility = View.INVISIBLE
                hideAllComponent(false)
                Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
            }
            is DetailCocktailViewModel.DetailCocktailUiState.Loading -> {
                hideAllComponent(true)
                binding.progressBar.visibility = View.VISIBLE
            }
        }
    }

    private fun hideAllComponent(isHidden: Boolean) {
        val visibility = if (isHidden) View.INVISIBLE else View.VISIBLE
        with(binding) {
            btnBack.visibility = visibility
            ivBanner.visibility = visibility
            gradientBanner.visibility = visibility
            cvCocktailDesc.root.visibility = visibility
            cvIngredient.root.visibility = visibility
        }
    }

    private fun setupViewWithData(data: DetailCocktail) {
        with(binding) {
            Glide.with(this@DetailCocktailActivity).load(data.strDrinkThumb).into(ivBanner)
            with(cvCocktailDesc) {
                tvTitleCocktail.text = data.strDrink
                tvAlcoholic.text = data.strAlcoholic
                tvCategory.text = data.strCategory
                tvGlass.text = data.strGlass
                tvInstructCocktail.text = data.strInstructions
            }
            with(cvIngredient) {
                val textIngredients = StringBuilder()
                for (ingredient in data.listIngredients) {
                    if (ingredient.isNotEmpty()) textIngredients.appendLine(ingredient)
                }
                val textMeasure = StringBuilder()
                for (measure in data.listMeasure) {
                    if (measure.isNotEmpty()) textMeasure.appendLine(measure)
                }
                tvIngredient.text = textIngredients
                tvMeasure.text = textMeasure
            }
        }
    }

    companion object {
        const val EXTRA_ID = "extra_id"
    }

}