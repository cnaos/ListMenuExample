package io.github.cnaos.example.listmenuexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import io.github.cnaos.example.listmenuexample.databinding.MenuListItemBinding


class MyMenuListAdapter(
    context: Context,
    menuList: List<MyMenuItem>,
    private val onClickListener: ((View, MyMenuItem) -> Unit)? = null
) : ArrayAdapter<MyMenuItem>(context, 0, menuList) {

    private val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding =
            if (convertView == null) {
                val tmpBinding: MenuListItemBinding = DataBindingUtil.inflate(
                    inflater,
                    R.layout.menu_list_item,
                    parent,
                    false
                )
                tmpBinding.root.tag = tmpBinding
                tmpBinding
            } else {
                convertView.tag as MenuListItemBinding
            }

        binding.menuItem = getItem(position)

        return binding.root
    }
}