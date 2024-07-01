package com.example.notesapp.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notesapp.room.model.NotesModel

@Dao
interface NotesInterface {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertall(notes: NotesModel)


    @Query("UPDATE notes SET title = :title, content= :content WHERE id = :id")
    suspend fun updateItemById(id: Int, title: String?, content: String?)


    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<NotesModel>

    @Query("DELETE FROM notes")
    suspend fun deleteall()

    @Query("DELETE FROM notes WHERE id=:item")
    suspend fun delete(item: Int)


}