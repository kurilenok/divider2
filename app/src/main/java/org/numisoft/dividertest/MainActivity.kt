package org.numisoft.dividertest

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity(), MyAdapter.RecyclerClickListener {

    var myAdapter = MyAdapter(
            object : ArrayList<Item>() {
                init {
                    add(Item("Item", "One"))
                    add(Item("Item", "Two"))
                    add(Item("Item", "Three"))
                    add(Item("Item", "Four"))
                    add(Item("Item", "Five"))
                    add(Item("Item", "Six"))

                }
            }, this)


    var myRVAdapter = RvAdapter(this, object : ArrayList<Item>() {
        init {
            add(Item("Item", "One"))
            add(Item("Item", "Two"))
            add(Item("Item", "Three"))
            add(Item("Item", "Four"))
            add(Item("Item", "Five"))
            add(Item("Item", "Six"))
            add(Item("Item", "One"))
            add(Item("Item", "Two"))
            add(Item("Item", "Three"))
            add(Item("Item", "Four"))
            add(Item("Item", "Five"))
            add(Item("Item", "Six"))
            add(Item("Item", "One"))
            add(Item("Item", "Two"))
            add(Item("Item", "Three"))
            add(Item("Item", "Four"))
            add(Item("Item", "Five"))
            add(Item("Item", "Six"))

        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.recycler) as RecyclerView
        val drawable = ContextCompat.getDrawable(this, R.drawable.divider)
        val myDivider = MyDivider(drawable)

        recyclerView.adapter = myRVAdapter
        recyclerView.addItemDecoration(myDivider)

    }

    override fun onItemClicked(item: Item) {
//        myAdapter.removeItem(item)
    }

    override fun onOrangeClicked(item: Item) {
        Toast.makeText(this, "Orange " + item.title, Toast.LENGTH_LONG).show()
    }

    override fun onPurpleClicked(item: Item) {
        Toast.makeText(this, "Purple " + item.title, Toast.LENGTH_LONG).show()
    }
}
