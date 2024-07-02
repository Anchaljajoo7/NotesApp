package com.example.notesapp.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.notesapp.databinding.ActivityAddNotesBinding
import com.example.notesapp.room.DatabaseBuilder
import com.example.notesapp.room.DatabaseHelperImpl
import com.example.notesapp.room.model.NotesModel
import com.example.notesapp.ui.viewmodel.AddNotesViewModel
import kotlinx.coroutines.launch
import java.util.Date


class AddNotesActivity : AppCompatActivity() {

    lateinit var viewModel: AddNotesViewModel

    lateinit var binding: ActivityAddNotesBinding
    lateinit var dbHelper: DatabaseHelperImpl
    private var type: String? = null
    private var text: String? = null
    private var content: String? = null


    var id: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(this))

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(AddNotesViewModel::class.java)
        checking()
        clickEvent()
    }

    private fun checking() {
        type = intent.getStringExtra("type")
        text = intent.getStringExtra("title")
        content = intent.getStringExtra("content")
        if (type.equals("add")) {
            binding.ettitle.text.clear()
            binding.etContent.text.clear()
            binding.ivShare.visibility = View.GONE
        } else {
            binding.ettitle.setText(text)
            binding.etContent.setText(content)
            binding.ivShare.visibility = View.VISIBLE
        }


    }


    private fun clickEvent() {
        binding.ivBack.setOnClickListener {
            finish()
        }


        binding.ivSave.setOnClickListener {
            checkText()
        }

        binding.ivShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "${binding.ettitle.text}\n\n${binding.etContent.text}")

                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, "Note")
            startActivity(shareIntent)
        }


    }


    private fun checkText() {
        id = intent.getIntExtra("id", 0)
        val title: String = binding.ettitle.getText().toString().trim()
        val content: String = binding.etContent.getText().toString().trim()


        val model = NotesModel(title = title, content = content, insertTime = Date(), updateTime = Date())

        if (title.isEmpty() || content.isEmpty()) {
            Toast.makeText(this@AddNotesActivity, "Text cannot be empty", Toast.LENGTH_SHORT)
                .show()
        } else {
            if (type.equals("add")) {

                viewModel.insert(model)
                finish()
            } else {

                viewModel.update(id, title = title, content = content)
                finish()

            }
        }
    }


}
