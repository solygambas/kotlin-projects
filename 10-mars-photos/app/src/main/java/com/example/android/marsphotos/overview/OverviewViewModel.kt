/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.marsphotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.network.MarsApi
import com.example.android.marsphotos.network.MarsApiFilter
import com.example.android.marsphotos.network.MarsPhoto
import kotlinx.coroutines.launch

enum class MarsApiStatus { LOADING, ERROR, DONE }

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<MarsApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<MarsApiStatus>
        get() = _status

    // LiveData for a single MarsProperty object
    /*private val _property = MutableLiveData<MarsPhoto>()
    val property: LiveData<MarsPhoto>
        get() = _property*/

    // LiveData for a list of images
    private val _properties = MutableLiveData<List<MarsPhoto>>()
    val properties: LiveData<List<MarsPhoto>>
        get() = _properties

    // LiveData for detail page
    private val _navigateToSelectedProperty = MutableLiveData<MarsPhoto>()
    val navigateToSelectedProperty: LiveData<MarsPhoto>
        get() = _navigateToSelectedProperty

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos(MarsApiFilter.SHOW_ALL)
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getMarsPhotos(filter: MarsApiFilter) {
        viewModelScope.launch {
            _status.value = MarsApiStatus.LOADING
            try {
//                val listResult = MarsApi.retrofitService.getPhotos()
//                _status.value = "Success: ${listResult.size} Mars photos retrieved"
                /*if (listResult.isNotEmpty()) {
                    //_property.value = listResult[0]
                }*/
                _properties.value = MarsApi.retrofitService.getPhotos(filter.value)
                _status.value = MarsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MarsApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    // filter
    fun updateFilter(filter: MarsApiFilter) {
        getMarsPhotos(filter)
    }

    // display details
    fun displayPropertyDetails(marsProperty : MarsPhoto) {
        _navigateToSelectedProperty.value = marsProperty
    }

    // reset navigation
    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}
