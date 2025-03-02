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
import androidx.lifecycle.asFlow
import androidx.lifecycle.liveData
import com.example.smartcare.City.City
import com.example.smartcare.City.parsedCities
import com.example.smartcare.Hospitals.Hospital
import com.example.smartcare.Hospitals.HospitalData
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce

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

    val filteredHospitals: LiveData<List<Hospital>> = liveData {
        combine(
            _selectedCity.asFlow(),
            _hospitalSearchQuery.asFlow() // Removed debounce
        ) { city, query ->
            filterHospitals(city, query)
        }.collect { hospitals ->
            emit(hospitals)
        }
    }

    private fun filterHospitals(
        city: City?,
        query: String,
        specialties: Set<String>,
        minRating: Float
    ): List<Hospital> {
        return HospitalData.hospitals.filter { hospital ->
            (city == null || hospital.cityId == city.id) &&
                    (query.isEmpty() || hospital.name.contains(query, true)) &&
                    (specialties.isEmpty() || specialties.any { it in hospital.specialties }) &&
                    hospital.rating >= minRating
        }
    }

    // Add filter update functions
    fun updateSpecialtyFilters(specialties: Set<String>) {
        _selectedSpecialties.value = specialties
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

    private fun filterHospitals(city: City?, query: String): List<Hospital> {
        return HospitalData.hospitals.filter { hospital ->
            (city == null || hospital.cityId == city.id) &&
                    (query.isEmpty() || hospital.name.contains(query, true))
        }
    }

    fun updateSearchQuery(query: String) {
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