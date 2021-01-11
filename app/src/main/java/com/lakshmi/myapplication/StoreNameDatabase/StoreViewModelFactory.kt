package com.lakshmi.myapplication.StoreNameDatabase

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
class StoreViewModelFactory (private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StoreViewModel::class.java)) {
            return StoreViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}