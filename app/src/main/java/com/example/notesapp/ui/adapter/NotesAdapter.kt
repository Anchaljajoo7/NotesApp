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

        holder.itemView.setOnClickListener {

            val intent = Intent(context, AddNotesActivity::class.java)
            intent.putExtra("title", note.title)
            intent.putExtra("content", note.content)
            context.startActivity(intent)

        }


    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun deleteItem(position: Int) {
        notes.removeAt(position)
        notifyItemRemoved(position)

    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTitle: TextView = itemView.findViewById(R.id.tv_title)
        val noteContent: TextView = itemView.findViewById(R.id.tv_content)
    }


}