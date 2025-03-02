package com.example.smartcare.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.smartcare.AppointmentDAO
import com.example.smartcare.AppointmentLists
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AppointmentViewModelFactory(private val dao: AppointmentDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppointmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AppointmentViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class AppointmentViewModel(private val dao: AppointmentDAO) : ViewModel() {

    val allAppointments: Flow<List<AppointmentLists>> = dao.getAllAppointments()

    fun insertAppointment(appointment: AppointmentLists) {
        viewModelScope.launch {
            dao.insertAppointment(appointment)
        }
    }

    fun cancelAppointment(id: Int) {
        viewModelScope.launch {
            dao.cancelAppointment(id)
        }
    }

    fun updateAppointmentStatus(id: Int, isCompleted: Boolean) {
        viewModelScope.launch {
            dao.updateAppointmentStatus(id, isCompleted)
        }
    }
    fun getAppointmentById(id: Int): Flow<AppointmentLists?> {
        return dao.getAppointmentById(id)
    }
    fun getCompletedAppointments(): Flow<List<AppointmentLists>> {
        return dao.getCompletedAppointments()
    }
    fun getPendingAppointments(): Flow<List<AppointmentLists>> {
        return dao.getPendingAppointments()
    }
    fun getAppointmentsByStatus(status: String): Flow<List<AppointmentLists>> {
        return dao.getAppointmentsByStatus(status)
    }
    fun getAppointmentsByStatusFlow(status: String): Flow<List<AppointmentLists>> {
        return dao.getAppointmentsByStatus(status)
    }
}
