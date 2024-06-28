package com.example.notesapp.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import com.example.notesapp.databinding.PopupDeleteDialogBinding

class PopUpDialog {

    private var dialog: Dialog? = null
    var context: Context? = null
    lateinit var binding: PopupDeleteDialogBinding
    lateinit var onClick_: onClickHandle

    fun showDialog(context: Context?, onClick: onClickHandle) {
        this.context = context
        dialog = Dialog(context!!)
        onClick_ = onClick
        dialog!!.setCancelable(false)
        dialog!!.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        binding = PopupDeleteDialogBinding.inflate(LayoutInflater.from(context))
        dialog!!.setContentView(binding.getRoot())
        val width = (context.getResources().getDisplayMetrics().widthPixels * 0.85).toInt()
        val height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog!!.getWindow()?.setLayout(width, height);
        dialog!!.show()


        binding.llCancel.setOnClickListener(View.OnClickListener {
            onClick_.discardPopup()


        })

        binding.llYes.setOnClickListener(View.OnClickListener {
            onClick_.deleteNotes()
        })

    }

    fun dismiss() {
        dialog?.dismiss()
    }


}

interface onClickHandle {
    fun discardPopup()

    fun deleteNotes()


}