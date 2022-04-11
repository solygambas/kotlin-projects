package com.example.android.marsphotos.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.marsphotos.network.MarsPhoto

class DetailViewModel(marsProperty: MarsPhoto, app: Application) : AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<MarsPhoto>()
    val selectedProperty: LiveData<MarsPhoto>
        get() = _selectedProperty

    init {
        _selectedProperty.value = marsProperty
    }
}