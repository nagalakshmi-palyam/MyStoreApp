package com.lakshmi.myapplication.DatabaseforProduct

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lakshmi.myapplication.RoomDatabse.ProductViewModel

class MyproductViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyProductViewModel::class.java)) {
            return MyProductViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}