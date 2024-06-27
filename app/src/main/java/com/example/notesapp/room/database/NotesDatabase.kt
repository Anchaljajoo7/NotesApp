package com.example.notesapp.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesapp.room.dao.NotesInterface
import com.example.notesapp.room.model.NotesModel

@Database(entities = [NotesModel::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun userDao(): NotesInterface


}