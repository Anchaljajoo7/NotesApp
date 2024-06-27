package com.example.notesapp.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.databinding.ActivityHomeBinding
import com.example.notesapp.room.DatabaseBuilder
import com.example.notesapp.room.DatabaseHelperImpl
import com.example.notesapp.room.model.NotesModel
import com.example.notesapp.ui.adapter.NotesAdapter
import com.example.notesapp.utils.ItemListner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeActivity : AppCompatActivity(), ItemListner {

    lateinit var binding: ActivityHomeBinding
    lateinit var dbHelper: DatabaseHelperImpl

    private var list: MutableList<NotesModel> = mutableListOf()
    val adapter = NotesAdapter(list, this)

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


    }

    private fun adapterSetup() {
        binding.rv.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        binding.rv.adapter = adapter
    }

    private fun clickEvent() {
        binding.loAdd.setOnClickListener {

            startActivity(Intent(this@HomeActivity, AddNotesActivity::class.java))

        }

        binding.ivDelete.setOnClickListener {
            deleteData()
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
}