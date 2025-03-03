package com.example.smartcare.viewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.smartcare.City.City
import com.example.smartcare.City.parsedCities
import com.example.smartcare.Hospitals.HospitalsData
import com.example.smartcare.Hospitals.allHospitalData

class SearchViewModel : ViewModel() {
    // Selected City
    private val _selectedCity = MutableLiveData<City?>()
    val selectedCity: LiveData<City?> get() = _selectedCity

    // Cities Data
    private val _allCities = MutableLiveData<List<City>>()
    val allCities: LiveData<List<City>> get() = _allCities


    // Hospital Search
    private val _hospitalSearchQuery = MutableLiveData("")
    val hospitalSearchQuery: LiveData<String> = _hospitalSearchQuery

    private val _selectedSpecialties = MutableLiveData<Set<String>>(emptySet())
    private val _minRating = MutableLiveData(0f)


    // Add filter update functions
    fun updateSpecialtyFilters(specialties: Set<String>) {
        _selectedSpecialties.value = specialties
    }

    fun getHospitalById(hospitalId: String?): LiveData<HospitalsData?> {
        return liveData {
            emit(allHospitalData.find { it.hospitals.get(1).id == hospitalId })
        }
    }

    fun updateRatingFilter(rating: Float) {
        _minRating.value = rating
    }


    // Search State
    var citySearchQuery by mutableStateOf("")
        private set

    // Recent Cities (last 5 unique)
    val recentCities: List<City>?
        get() = _allCities.value
            ?.filter { it in _recentSelections }
            ?.take(5)

    private val _recentSelections = mutableStateListOf<City>()

    init {
        _allCities.value = parsedCities // Ensure parsedCities is defined elsewhere
    }


    fun updateSearchQuery(query: String) {
        citySearchQuery = query
    }
    fun updateHospitalSearchQuery(query: String) {
        citySearchQuery = query
    }

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    fun selectCity(city: City) {
        _selectedCity.value = city
        _recentSelections.remove(city)
        _recentSelections.add(0, city)
        if (_recentSelections.size > 5) _recentSelections.removeLast()
    }
}