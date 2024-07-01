package com.example.notesapp.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.notesapp.room.DatabaseBuilder
import com.example.notesapp.room.DatabaseHelperImpl
import com.example.notesapp.room.model.NotesModel
import com.example.notesapp.ui.repository.AddNotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNotesViewModel(application: Application) : AndroidViewModel(application) {
    val dbHelper: DatabaseHelperImpl
    val repository: AddNotesRepository
    private val allNotes = MutableLiveData<List<NotesModel>>()
    val all: LiveData<List<NotesModel>> get() = allNotes


    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData


    init {
        dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(application))
        repository = AddNotesRepository(dbHelper)
    }

    fun getAllNotes() {
        viewModelScope.launch(Dispatchers.IO) {

            try {
                allNotes.postValue(repository.getAllNotes())
                Log.d(
                    "NotesViewModel",
                    "getAllNotes: " + allNotes.postValue(repository.getAllNotes())
                )
            } catch (e: Exception) {
                _errorLiveData.postValue("Failed to fetch notes: ${e.message}")
                Log.e("NotesViewModel", "Error fetching notes", e)
            }

        }
    }

    fun insert(list: NotesModel) {
        viewModelScope.launch {
            repository.insert(list)
        }

    }

    fun update(id: Int, title: String, content: String) {
        viewModelScope.launch {
            repository.update(id, title, content)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }


}
