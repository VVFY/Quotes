package com.vvfy.coreui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

open class BaseFragment(@LayoutRes layoutResId: Int) : Fragment(layoutResId) {

    private val snackBar: Snackbar by lazy {
        Snackbar.make(requireView(), "", Snackbar.LENGTH_SHORT)
    }

    protected fun Event<String>.showSnackBar() {
        this.use { snackBar.setText(it).show() }
    }

}