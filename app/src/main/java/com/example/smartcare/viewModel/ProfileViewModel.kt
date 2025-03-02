package com.example.smartcare.viewModel

import androidx.lifecycle.*
import com.example.smartcare.ProfileDAO
import com.example.smartcare.ProfileData
import kotlinx.coroutines.Dispatchers
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

    val profile: LiveData<ProfileData> = dao.getProfile()
    val isLoggedIn: LiveData<Boolean> = dao.checkLoginStatus()

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
            dao.insertOrUpdate(ProfileData(isLoggedIn = false))
        }
    }


    fun ensureProfileExists() {
        viewModelScope.launch(Dispatchers.IO) {
            val profile = dao.getProfileSync() // ✅ Synchronously fetch profile
            if (profile == null) {
                dao.insertOrUpdate(ProfileData(isLoggedIn = false)) // ✅ Insert default profile
            }
        }
    }

}
