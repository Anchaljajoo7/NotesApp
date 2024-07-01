package com.example.notesapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.notesapp.room.DatabaseBuilder
import com.example.notesapp.room.DatabaseHelperImpl
import com.example.notesapp.room.model.NotesModel
import com.example.notesapp.ui.repository.AddNotesRepository
import kotlinx.coroutines.launch

class AddNotesViewModel(application: Application) : AndroidViewModel(application) {
    val dbHelper: DatabaseHelperImpl
    lateinit var allNotes: LiveData<NotesModel>
    val repository: AddNotesRepository


    init {
        dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(application))
        repository = AddNotesRepository(dbHelper)
    }

    fun insert(list: NotesModel) {
        viewModelScope.launch {
            repository.insert(list)
        }

    }
}