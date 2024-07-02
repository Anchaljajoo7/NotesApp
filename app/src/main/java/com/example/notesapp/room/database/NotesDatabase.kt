package com.example.notesapp.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.notesapp.converter.Converters
import com.example.notesapp.room.dao.NotesInterface
import com.example.notesapp.room.model.NotesModel

@Database(entities = [NotesModel::class], version = 2)
@TypeConverters(Converters::class)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun userDao(): NotesInterface


}