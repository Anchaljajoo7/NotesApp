package com.example.notesapp.room

import android.content.Context
import androidx.room.Room
import com.example.notesapp.room.database.NotesDatabase

object DatabaseBuilder {

    private var INSTANCE: NotesDatabase? = null

    fun getInstance(context: Context): NotesDatabase {
        if (INSTANCE == null) {
            synchronized(NotesDatabase::class) {
                if (INSTANCE == null) {
                    INSTANCE = buildRoomDB(context)
                }
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            NotesDatabase::class.java,
            "notes"
        ).build()
}