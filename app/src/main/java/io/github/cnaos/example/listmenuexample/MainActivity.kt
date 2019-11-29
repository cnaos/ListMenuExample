package io.github.cnaos.example.listmenuexample

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.wada811.databinding.viewBinding
import io.github.cnaos.example.listmenuexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by viewBinding { ActivityMainBinding.inflate(it) }

    val listItems = listOf(
        MyMenuItem("Menu A"),
        MyMenuItem("Menu B")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = ArrayAdapter<MyMenuItem>(this, android.R.layout.simple_list_item_1)
        binding.listView.adapter = adapter
    }
}
