package com.example.notesapp.room

import com.example.notesapp.room.model.NotesModel

interface DatabaseHelper {



    suspend fun insertAll(users: List<NotesModel>)

    suspend fun getAll() : List<NotesModel>


    suspend fun deleteAll()
//    suspend fun delete():List<NotesModel>
}