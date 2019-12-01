package io.github.cnaos.example.listmenuexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wada811.databinding.viewBinding
import io.github.cnaos.example.listmenuexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // wada811さんのDataBinding-ktxを使っています。
    // DataBinding-ktxを使うとonCreaete内のbindingの初期化コードが不要になります。
    //
    // https://github.com/wada811/DataBinding-ktx
    //
    // private lateinit var binding: ActivityMainBinding

    private val binding by viewBinding { ActivityMainBinding.inflate(it) }

    companion object {
        // メニュー画面のリストに表示するラベルと
        // タップされたときに実行する処理の定義
        val listItems = listOf(
            MyMenuItem("Toast表示") { activity->
                Toast.makeText(activity, "Toast Test", Toast.LENGTH_LONG).show()
            },

            MyMenuItem("何もしない"),

            MyMenuItem("アプリ終了") { activity->
                activity.finish()
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//        binding.lifecycleOwner = this

        val adapter = MyMenuListAdapter(this, listItems)
        binding.listView.adapter = adapter

        // リスト項目がタップされたときの処理
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val menuItem = listItems[position]

            // menuItemにセットされている関数オブジェクトを実行する
            menuItem.executeBlock?.invoke(this)
        }
    }
}
