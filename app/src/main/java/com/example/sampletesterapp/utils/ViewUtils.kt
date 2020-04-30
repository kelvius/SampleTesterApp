package com.example.sampletesterapp.utils

import android.content.Context
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ProgressBar.show() {
    visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    visibility = View.GONE
}

fun disableCopyPasteOnEditText(editText: View) {
    val editText: EditText? = null
    editText!!.setCustomSelectionActionModeCallback(object : ActionMode.Callback {
        override fun onCreateActionMode(
            mode: ActionMode,
            menu: Menu
        ): Boolean { //to keep the text selection capability available ( selection cursor)
            return true
        }

        override fun onPrepareActionMode(
            mode: ActionMode,
            menu: Menu
        ): Boolean { //to prevent the menu from appearing
            menu.clear()
            return false
        }

        override fun onActionItemClicked(
            mode: ActionMode,
            item: MenuItem
        ): Boolean {
            return false
        }

        override fun onDestroyActionMode(mode: ActionMode) {}
    })
}