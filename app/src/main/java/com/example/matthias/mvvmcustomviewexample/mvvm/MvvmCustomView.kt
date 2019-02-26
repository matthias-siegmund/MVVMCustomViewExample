package com.example.matthias.mvvmcustomviewexample.mvvm

import android.arch.lifecycle.LifecycleOwner

interface MvvmCustomView<V: MvvmCustomViewState, T: MvvmCustomViewModel<V>> {
    val viewModel: T

    fun onLifecycleOwnerAttached(lifecycleOwner: LifecycleOwner)
}