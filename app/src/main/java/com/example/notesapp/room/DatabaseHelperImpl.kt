package com.example.notesapp.room

import com.example.notesapp.room.database.NotesDatabase
import com.example.notesapp.room.model.NotesModel

class DatabaseHelperImpl(private val appDatabase: NotesDatabase) : DatabaseHelper {

//    override suspend fun getUsers(): List<NotesModel> = appDatabase.userDao().getAll()

    override suspend fun insertAll(users: List<NotesModel>) = appDatabase.userDao().insertall(users)

    override suspend fun getAll(): List<NotesModel> = appDatabase.userDao().getAllNotes()
    override suspend fun deleteAll() = appDatabase.userDao().deleteall()

    override suspend fun delete(id: Int) = appDatabase.userDao().delete(id)

//    override suspend fun delete(users1: List<NotesModel>) = appDatabase.userDao().delete(users1)


}