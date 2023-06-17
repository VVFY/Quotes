package com.vvfy.coreui

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentViewBindingDelegate<B : ViewBinding>(
    val fragment: Fragment,
    val viewBindingFactory: (View) -> B
) : ReadOnlyProperty<Fragment, B> {
    private var binding: B? = null

    private val viewLifecycleOwnerObserver = Observer<LifecycleOwner?> { owner ->
        if (owner == null) {
            binding = null
        }
    }

    init {
        fragment.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                fragment.viewLifecycleOwnerLiveData.observeForever(viewLifecycleOwnerObserver)
            }

            override fun onDestroy(owner: LifecycleOwner) {
                fragment.viewLifecycleOwnerLiveData.removeObserver(viewLifecycleOwnerObserver)
            }
        })
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): B {
        val binding = binding

        if (binding != null && binding.root === thisRef.view) {
            return binding
        }

        val view = thisRef.view

        @Suppress("FoldInitializerAndIfToElvis")
        if (view == null) {
            throw IllegalStateException("An attempt to get binding was made when the fragment's view is null.")
        }

        return viewBindingFactory(view).also { this.binding = it }
    }
}

fun <B : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> B): FragmentViewBindingDelegate<B> =
    FragmentViewBindingDelegate(this, viewBindingFactory)