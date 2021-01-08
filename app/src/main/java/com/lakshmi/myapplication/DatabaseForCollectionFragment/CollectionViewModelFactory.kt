package com.lakshmi.myapplication.DatabaseForCollectionFragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lakshmi.myapplication.RoomDatabse.ProductViewModel

class CollectionViewModelFactory(private val context: Context): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CollectionViewModel::class.java)) {
            return CollectionViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}