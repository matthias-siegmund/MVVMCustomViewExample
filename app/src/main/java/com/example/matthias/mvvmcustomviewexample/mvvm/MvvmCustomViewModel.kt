package com.example.matthias.mvvmcustomviewexample.mvvm

interface MvvmCustomViewModel<T: MvvmCustomViewState> {
    var state: T?
}