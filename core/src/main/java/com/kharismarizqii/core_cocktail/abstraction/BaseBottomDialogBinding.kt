package com.kharismarizqii.core_cocktail.abstraction

import android.annotation.TargetApi
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
abstract class BaseBottomDialogBinding<T: ViewBinding> : BottomSheetDialogFragment() {

    private var _binding: T? = null

    protected abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T

    protected val binding: T
        get() {
            if (_binding == null) {
                throw IllegalArgumentException("View binding is not initialized yet")
            }
            return _binding!!
        }

    override fun onStart() {
        super.onStart()

        dialog?.window?.apply {
            //setLayout(getBetterSize(), ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    protected abstract fun setupView()

    @TargetApi(Build.VERSION_CODES.R)
    private fun getBetterSize(): Int {
        val displayMetrics = DisplayMetrics()
        requireContext().display?.getRealMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val whiteSpaceSize = width / 8
        return width - whiteSpaceSize
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}