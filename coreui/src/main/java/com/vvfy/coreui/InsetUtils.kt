@file:Suppress("DEPRECATION")

package com.vvfy.coreui

import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Px
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import androidx.core.view.updateLayoutParams
import androidx.core.view.updateMargins


fun WindowInsetsCompat.getTopInset() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
    getInsets(WindowInsetsCompat.Type.systemBars()).top
} else {
    systemWindowInsetTop
}

fun WindowInsetsCompat.getBottomInset() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
    getInsets(WindowInsetsCompat.Type.systemBars()).bottom
} else {
    systemWindowInsetBottom
}

fun WindowInsetsCompat.getLeftInset() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
    getInsets(WindowInsetsCompat.Type.systemBars()).left
} else {
    systemWindowInsetBottom
}

fun WindowInsetsCompat.getRightInset() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
    getInsets(WindowInsetsCompat.Type.systemBars()).right
} else {
    systemWindowInsetBottom
}

fun View.applySystemWindowInsetToMargin(
    left: Boolean = false,
    top: Boolean = false,
    right: Boolean = false,
    bottom: Boolean = false
) {
    val (initialLeft, initialTop, initialRight, initialBottom) = listOf(
        marginLeft,
        marginTop,
        marginRight,
        marginBottom
    )

    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        view.updateLayoutParams {
            (this as? ViewGroup.MarginLayoutParams)?.let {
                updateMargins(
                    left = initialLeft + (if (left) insets.getLeftInset() else 0),
                    top = initialTop + (if (top) insets.getTopInset() else 0),
                    right = initialRight + (if (right) insets.getRightInset() else 0),
                    bottom = initialBottom + (if (bottom) insets.getBottomInset() else 0)
                )
            }
        }

        insets
    }
}