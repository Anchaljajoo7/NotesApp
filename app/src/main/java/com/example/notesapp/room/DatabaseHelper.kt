package com.example.notesapp.room

import com.example.notesapp.room.model.NotesModel

interface DatabaseHelper {
    suspend fun insertAll(users: NotesModel)
    suspend fun getAll() : List<NotesModel>
    suspend fun deleteAll()
    suspend fun delete(id:Int)

    suspend fun update(id: Int, title: String?, content: String?)
}