package com.example.mynote.feature_note.presentaion.extensions

import android.app.Activity
import android.view.Window

/**
 * This extension is used for change the status bar color to a specific color
 * It used inside the onCreate method in the activity that you want to change  it's status bar color
 */
fun Activity.changeStatusBarColor(
    color: Int
) {
    val window: Window = this.window
    window.statusBarColor = color
}