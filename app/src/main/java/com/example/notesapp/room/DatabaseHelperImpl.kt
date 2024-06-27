package com.example.notesapp.room

import com.example.notesapp.room.database.NotesDatabase
import com.example.notesapp.room.model.NotesModel

class DatabaseHelperImpl(private val appDatabase: NotesDatabase) : DatabaseHelper {

//    override suspend fun getUsers(): List<NotesModel> = appDatabase.userDao().getAll()

    override suspend fun insertAll(users: List<NotesModel>) = appDatabase.userDao().insertall(users)

    override suspend fun getAll(): List<NotesModel> = appDatabase.userDao().getAllNotes()
    override suspend fun deleteAll() = appDatabase.userDao().deleteall()


}