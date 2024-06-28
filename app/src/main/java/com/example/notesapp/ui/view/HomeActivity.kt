package com.example.notesapp.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.databinding.ActivityHomeBinding
import com.example.notesapp.dialog.PopUpDialog
import com.example.notesapp.dialog.onClickHandle
import com.example.notesapp.room.DatabaseBuilder
import com.example.notesapp.room.DatabaseHelperImpl
import com.example.notesapp.room.model.NotesModel
import com.example.notesapp.ui.adapter.NotesAdapter
import com.example.notesapp.utils.ItemListner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeActivity : AppCompatActivity(), ItemListner, onClickHandle {

    lateinit var binding: ActivityHomeBinding
    lateinit var dbHelper: DatabaseHelperImpl

    var dialog = PopUpDialog()
    private var list: MutableList<NotesModel> = mutableListOf()
    val adapter = NotesAdapter(list, this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(this))
        clickEvent()
    }

    private fun getData() {
        lifecycleScope.launch {
            try {
                list.clear()
                val note = withContext(Dispatchers.IO) {
                    dbHelper.getAll()
                }

                list.addAll(note)
                if (list.isEmpty()) {
                    binding.rlPlaceholder.visibility = View.VISIBLE
                } else {
                    adapterSetup()
                    binding.rlPlaceholder.visibility = View.GONE

                }
                Log.d("jkfikrfhgurghjgnjng", "adapterSetup: " + dbHelper.getAll())


            } catch (e: Exception) {

            }
            adapter.notifyDataSetChanged()
        }

    }

    override fun onResume() {
        super.onResume()
        getData()
        deleteSingle()

    }

    private fun adapterSetup() {
        binding.rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        binding.rv.adapter = adapter


    }

    private fun deleteSingle() {
        val itemTouchHelperCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val id = viewHolder.position

                lifecycleScope.launch {
                    withContext(Dispatchers.IO) {
                        dbHelper.delete(list[id].id)
                        list.removeAt(id)

//                        adapter.deleteItem(id)

                    }
                    if (list.isEmpty()) {
                        binding.rlPlaceholder.visibility = View.VISIBLE
                    } else {
                        adapterSetup()
                        binding.rlPlaceholder.visibility = View.GONE

                    }
                    adapter.notifyDataSetChanged()
                }


//                adapter.deleteItem(position)

            }

        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)

        itemTouchHelper.attachToRecyclerView(binding.rv)


    }


    private fun clickEvent() {
        binding.loAdd.setOnClickListener {
            val intent = Intent(this@HomeActivity, AddNotesActivity::class.java)
            intent.putExtra("type", "add")
            startActivity(intent)


        }

        binding.ivDelete.setOnClickListener {
            if (!list.isEmpty()) {
                dialog.showDialog(this, this)

            } else {
                Toast.makeText(this, "No notes available", Toast.LENGTH_SHORT).show()
            }

//            deleteData()
        }


    }


    private fun deleteData() {
        lifecycleScope.launch {
            try {
                val note = withContext(Dispatchers.IO) {
                    dbHelper.deleteAll()
                }
                list.clear()

                if (list.isEmpty()) {
                    binding.rlPlaceholder.visibility = View.VISIBLE
                }
                Log.d("jkfikrfhgurghjgnjng", "adapterSetup: " + dbHelper.getAll())


            } catch (e: Exception) {

            }
        }
        adapter.notifyDataSetChanged()
    }


    override fun onSelectedItemClicks(position: Int, type: String) {
    }

    override fun discardPopup() {
        dialog.dismiss()
    }

    override fun deleteNotes() {
        deleteData()
        dialog.dismiss()
    }
}