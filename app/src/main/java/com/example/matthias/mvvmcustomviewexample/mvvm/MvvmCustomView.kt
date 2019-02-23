package com.example.matthias.mvvmcustomviewexample.mvvm

import android.arch.lifecycle.LifecycleOwner

interface MvvmCustomView<V: MvvmCustomViewState, T: MvvmCustomViewModel<V>> {
    val viewModel: T

    fun setLifecycleOwner(lifecycleOwner: LifecycleOwner)

    fun getState(): V? = viewModel.state

    fun setState(state: V?) {
        viewModel.state = state
    }
}