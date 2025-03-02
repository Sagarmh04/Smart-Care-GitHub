package com.example.smartcare.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.smartcare.MedicalRecord
import com.example.smartcare.MedicalRecordDAO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MedicalRecordViewModelFactory(private val dao: MedicalRecordDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MedicalRecordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MedicalRecordViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class MedicalRecordViewModel(private val dao: MedicalRecordDAO) : ViewModel() {

    fun getMedicalRecordsForUser(userId: Int): Flow<List<MedicalRecord>> {
        return dao.getMedicalRecordsForUser(userId)
    }

    fun insertMedicalRecord(record: MedicalRecord) {
        viewModelScope.launch {
            dao.insertMedicalRecord(record)
        }
    }

    fun deleteMedicalRecord(record: MedicalRecord) {
        viewModelScope.launch {
            dao.deleteMedicalRecord(record)
        }
    }

    fun updateMedicalRecordNotes(recordId: Int, notes: String) {
        viewModelScope.launch {
            dao.updateMedicalRecordNotes(recordId, notes)
        }
    }
}
