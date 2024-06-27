package com.example.notesapp.ui.view

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.notesapp.databinding.ActivityAddNotesBinding
import com.example.notesapp.room.DatabaseBuilder
import com.example.notesapp.room.DatabaseHelperImpl
import com.example.notesapp.room.model.NotesModel
import kotlinx.coroutines.launch
import kotlin.math.log


class AddNotesActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddNotesBinding
    lateinit var dbHelper: DatabaseHelperImpl

    private var list: MutableList<NotesModel> = mutableListOf()
//   private var list:ArrayList<NotesModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(this))

        clickEvent()


    }


    private fun clickEvent() {
        binding.ivBack.setOnClickListener {
            finish()
        }


        binding.ivSave.setOnClickListener {
            checkText()


        }
    }


    private fun checkText() {

        val title: String = binding.ettitle.getText().toString().trim()
        val content: String = binding.etContent.getText().toString().trim()

        val model = NotesModel(title = title, content = content)


        if (title.isEmpty() || content.isEmpty()) {
            Toast.makeText(this@AddNotesActivity, "Text cannot be empty", Toast.LENGTH_SHORT).show()
        } else {
            list.add(model)
            Toast.makeText(this@AddNotesActivity, "Saved", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch {
                try {
                    dbHelper.insertAll(list)

                    Log.d("hdfujhbdhfbgfdhbf", "insert: " + list)
                    binding.ettitle.text.clear()
                    binding.etContent.text.clear()
                    finish()

                } catch (e: Exception) {

                }
            }

        }

    }
}