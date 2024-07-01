package com.example.notesapp.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.ActivityHomeBinding
import com.example.notesapp.dialog.PopUpDialog
import com.example.notesapp.dialog.onClickHandle
import com.example.notesapp.room.DatabaseBuilder
import com.example.notesapp.room.DatabaseHelperImpl
import com.example.notesapp.room.model.NotesModel
import com.example.notesapp.ui.adapter.NotesAdapter
import com.example.notesapp.ui.viewmodel.AddNotesViewModel
import com.example.notesapp.utils.ItemListner
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeActivity : AppCompatActivity(), ItemListner, onClickHandle {

    lateinit var viewModel: AddNotesViewModel
    lateinit var binding: ActivityHomeBinding
    lateinit var dbHelper: DatabaseHelperImpl
    var dialog = PopUpDialog()
    private var list: MutableList<NotesModel> = mutableListOf()
    val adapter = NotesAdapter(list, this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(this))

        viewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(AddNotesViewModel::class.java)


        clickEvent()
    }

    private fun getData() {
        lifecycleScope.launch {
            viewModel.all.observe(this@HomeActivity, Observer {
                Log.d("NotesViewModel", "getData: " + it)

                list.addAll(it)
                list.reverse()


                if (list.isEmpty()) {
                    binding.rv.visibility = View.GONE
                    binding.rlPlaceholder.visibility = View.VISIBLE
                    binding.ivDelete.visibility = View.GONE


                } else {
                    adapterSetup()
                    binding.rv.visibility = View.VISIBLE
                    binding.rlPlaceholder.visibility = View.GONE
                    binding.ivDelete.visibility = View.VISIBLE
                }

                adapter.notifyDataSetChanged()
            })
            viewModel.getAllNotes()

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
//        val itemTouchHelperCallback = object :
//            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
//            override fun onMove(
//                recyclerView: RecyclerView,
//                viewHolder: RecyclerView.ViewHolder,
//                target: RecyclerView.ViewHolder
//            ): Boolean {
//                return false
//            }

//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//
//                val position = viewHolder.position
//                val removedItem = list[position]
//                lifecycleScope.launch {
//                    withContext(Dispatchers.IO) {
//                        dbHelper.delete(removedItem.id)
//                        list.removeAt(position)
//
//                        withContext(Dispatchers.Main) {
//                            adapter.deleteItem(position)
//
//                            Snackbar.make(binding.rv, removedItem.title, Snackbar.LENGTH_LONG)
//                                .setAction("Undo") { view ->
//                                    lifecycleScope.launch {
//                                        withContext(Dispatchers.IO) {
//                                            list.add(position, removedItem)
//                                            dbHelper.insertAll(list)
//
//                                        }
//
//                                        withContext(Dispatchers.Main) {
//                                            list.clear()
////                                            adapter.addItem(position)
////                                            getData()
//                                            getData()
//
//
//                                        }
//
//                                    }
//
//                                }.show()
//                            if (list.isEmpty()) {
//                                binding.rlPlaceholder.visibility = View.VISIBLE
//                                binding.ivDelete.visibility = View.GONE
//                            } else {
//                                adapterSetup()
//                                binding.rlPlaceholder.visibility = View.GONE
//                                binding.ivDelete.visibility = View.VISIBLE
//
//                            }
//
//
//                        }
//
//
//                    }
//
//                }
//
//            }

//        }


//        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
//
//        itemTouchHelper.attachToRecyclerView(binding.rv)
//        adapter.notifyDataSetChanged()

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
                    binding.ivDelete.visibility = View.GONE
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