package io.github.cnaos.example.listmenuexample

import android.app.Activity
import androidx.fragment.app.Fragment

class MyMenuItem(
    val label: String,
    val executeBlock: ((activity: Activity) -> Unit?)? = null
)