package com.example.notesapp.ui.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.room.model.NotesModel
import com.example.notesapp.ui.view.AddNotesActivity
import com.example.notesapp.utils.ItemListner
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NotesAdapter(
    private val notes: MutableList<NotesModel>,
    private val itemlistner: ItemListner,
    private val context: Context
) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_notes, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.noteTitle.text = note.title
        holder.noteContent.text = note.content

//        val inputFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH)
//        val date: Date = inputFormat.parse(note.insertTime.toString())
//
//        val outputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)

        fun formatDateString(dateString: String): String {
            val inputFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH)
            val date: Date = inputFormat.parse(dateString)
            val outputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
            return outputFormat.format(date)
        }


        val insert = note.insertTime.toString()
        val insertString = formatDateString(insert)

        val update = note.updateTime.toString()
        val updateString = formatDateString(update)


        holder.insert_time.text = "Created At" + insertString
        holder.update_time.text = "Updated At" + updateString

        holder.itemView.setOnClickListener {

            val intent = Intent(context, AddNotesActivity::class.java)

            intent.putExtra("title", note.title)
            intent.putExtra("content", note.content)
            intent.putExtra("id", note.id)
            intent.putExtra("type", "update")
            context.startActivity(intent)

        }


    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun deleteItem(position: Int) {
//        notes.removeAt(position)
        notifyItemRemoved(position)

    }

    fun addItem(position: Int) {
        notifyItemInserted(position)
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTitle: TextView = itemView.findViewById(R.id.tv_title)
        val noteContent: TextView = itemView.findViewById(R.id.tv_content)
        val insert_time: TextView = itemView.findViewById(R.id.tv_insert_time)
        val update_time: TextView = itemView.findViewById(R.id.tv_update_time)
    }


}