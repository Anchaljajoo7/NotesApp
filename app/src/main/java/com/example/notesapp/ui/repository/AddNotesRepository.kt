package com.example.notesapp.ui.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.notesapp.room.DatabaseHelperImpl
import com.example.notesapp.room.model.NotesModel

class AddNotesRepository(private val dbHelper: DatabaseHelperImpl) {
    suspend fun getAllNotes(): List<NotesModel> {
        Log.d("jdfjfffffjfjfhfhfg", "getAllNotes: " +dbHelper)

        return dbHelper.getAll()
    }

    suspend fun insert(list: NotesModel) {

        dbHelper.insertAll(list)
    }

    suspend fun update(id: Int, title: String, content: String) {
        dbHelper.update(id, title, content)


    }
}