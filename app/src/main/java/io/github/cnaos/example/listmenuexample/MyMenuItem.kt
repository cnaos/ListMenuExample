package io.github.cnaos.example.listmenuexample

import android.app.Activity

class MyMenuItem(
    // リスト項目に表示されるラベル
    val label: String,

    // リスト項目をタップしたときに実行される処理
    val executeBlock: ((activity: Activity) -> Unit?)? = null
)