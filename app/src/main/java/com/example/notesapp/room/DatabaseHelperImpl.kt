package com.example.notesapp.room

import com.example.notesapp.room.database.NotesDatabase
import com.example.notesapp.room.model.NotesModel

class DatabaseHelperImpl(private val appDatabase: NotesDatabase) : DatabaseHelper {


    //for insert
    override suspend fun insertAll(users: List<NotesModel>) = appDatabase.userDao().insertall(users)

    // for get all
    override suspend fun getAll(): List<NotesModel> = appDatabase.userDao().getAllNotes()

    //for delete all
    override suspend fun deleteAll() = appDatabase.userDao().deleteall()

    //for single delete
    override suspend fun delete(id: Int) = appDatabase.userDao().delete(id)

    //for single update
    override suspend fun update(id: Int, title: String?, content: String?) =
        appDatabase.userDao().updateItemById(id, title, content)


}