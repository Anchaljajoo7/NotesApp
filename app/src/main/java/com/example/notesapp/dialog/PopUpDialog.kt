package com.example.notesapp.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.notesapp.databinding.PopupDeleteDialogBinding

class PopUpDialog {

    private var dialog: Dialog? = null
    var context: Context? = null
    lateinit var binding: PopupDeleteDialogBinding

    fun showDialog(context: Context?) {


        this.context = context
        dialog = Dialog(context!!)

        dialog!!.setCancelable(false)
        dialog!!.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        binding = PopupDeleteDialogBinding.inflate(LayoutInflater.from(context))
        dialog!!.setContentView(binding.getRoot())
        val width = (context.getResources().getDisplayMetrics().widthPixels * 0.85).toInt()
        val height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog!!.getWindow()?.setLayout(width, height);
        dialog!!.show()
    }

}