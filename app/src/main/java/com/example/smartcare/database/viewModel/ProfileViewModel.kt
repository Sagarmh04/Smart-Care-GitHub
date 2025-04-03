package com.example.smartcare.database.viewModel

import androidx.lifecycle.*
import com.example.smartcare.database.dao.ProfileDAO
import com.example.smartcare.database.entity.ProfileData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModelFactory(private val dao: ProfileDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfileViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class ProfileViewModel(private val dao: ProfileDAO) : ViewModel() {

    // ✅ Using StateFlow to avoid LiveData issues
    private var _profile = dao.getProfile()
    val profile: Flow<ProfileData?> = _profile

    private val _isLoggedIn = dao.checkLoginStatus()
    val isLoggedIn: Flow<Boolean> = _isLoggedIn

    fun insertOrUpdateProfile(profileData: ProfileData) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertOrUpdate(profileData)
        }
    }

    fun updateLoginState(isLoggedIn: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.updateLoginState(isLoggedIn)
        }
    }

    fun deleteProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteProfile()
            dao.insertOrUpdate(ProfileData(isLoggedIn = false)) // ✅ Safe default profile
        }
    }

    fun ensureProfileExists() {
        viewModelScope.launch(Dispatchers.IO) {
            val profile = dao.getProfileSync()
            if (profile == null) {
                dao.insertOrUpdate(ProfileData(isLoggedIn = false))
            }
        }
    }

    fun updateId(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.updateId(id)
        }
    }
}

