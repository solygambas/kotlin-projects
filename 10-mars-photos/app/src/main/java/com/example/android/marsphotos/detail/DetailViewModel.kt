package com.example.android.marsphotos.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.android.marsphotos.R
import com.example.android.marsphotos.network.MarsPhoto

class DetailViewModel(marsProperty: MarsPhoto, app: Application) : AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<MarsPhoto>()
    val selectedProperty: LiveData<MarsPhoto>
        get() = _selectedProperty

    init {
        _selectedProperty.value = marsProperty
    }

    val displayPropertyPrice = Transformations.map(selectedProperty) {
        app.applicationContext.getString(
            when (it.isRental) {
                true -> R.string.display_price_monthly_rental
                false -> R.string.display_price
            }, it.price
        )
    }

    val displayPropertyType = Transformations.map(selectedProperty) {
        app.applicationContext.getString(R.string.display_type,
        app.applicationContext.getString(
                when (it.isRental) {
                    true -> R.string.type_rent
                    false -> R.string.type_sale
                }))
    }
}