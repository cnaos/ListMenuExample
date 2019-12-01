package io.github.cnaos.example.listmenuexample

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wada811.databinding.viewBinding
import io.github.cnaos.example.listmenuexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by viewBinding { ActivityMainBinding.inflate(it) }

    companion object{
        val listItems = listOf(
            MyMenuItem("Toast表示"){
                Toast.makeText(it ,"Toast Test",Toast.LENGTH_LONG).show()
            },
            MyMenuItem("何もしない"),

            MyMenuItem("アプリ終了"){
                it.finish()
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = MyMenuListAdapter(this, listItems)
        binding.listView.adapter = adapter
        binding.listView.setOnItemClickListener {
                parent, view, position, id ->
            val menuItem = listItems[position]

            // menuItemにセットされているブロックを実行する
            menuItem.executeBlock?.invoke(this)
        }
    }
}
