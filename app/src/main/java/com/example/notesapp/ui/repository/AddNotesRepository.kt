package com.example.notesapp.ui.repository

import com.example.notesapp.room.DatabaseHelperImpl
import com.example.notesapp.room.model.NotesModel

class AddNotesRepository(private val dbHelper: DatabaseHelperImpl) {


    suspend fun insert(list: NotesModel) {

        dbHelper.insertAll(list)
    }
}