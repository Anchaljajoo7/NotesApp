package com.example.notesapp.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.notesapp.room.model.NotesModel

@Dao
interface NotesInterface {

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<NotesModel>

    @Insert
    suspend fun insertall(notes: List<NotesModel>)


  @Query("DELETE FROM notes")
    suspend fun deleteall()


}