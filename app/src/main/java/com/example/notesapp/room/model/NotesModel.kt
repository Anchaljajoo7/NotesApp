package com.example.notesapp.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.notesapp.converter.Converters
import java.util.Date

@Entity(tableName = "notes")
data class NotesModel(

    @PrimaryKey(autoGenerate = true) var id: Int=0,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "content") var content: String,
    @TypeConverters(Converters::class) val insertTime: Date,
    @TypeConverters(Converters::class) var updateTime: Date

)
