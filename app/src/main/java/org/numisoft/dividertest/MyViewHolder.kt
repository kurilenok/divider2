package org.numisoft.dividertest

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import ru.rambler.libs.swipe_layout.SwipeLayout


/**
 * Created by mac-200 on 10/23/17.
 */

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val tvTitle: TextView = view.findViewById(R.id.tvTitle)
    val swipeLayout: SwipeLayout = view.findViewById(R.id.swipe_layout)
    val orange: View = view.findViewById(R.id.orange)
    val purple: View = view.findViewById(R.id.purple)
    val listItem: View = view.findViewById(R.id.list_item)

    fun bind(item: Item, listener: MyAdapter.RecyclerClickListener) {
        tvTitle.text = item.title

        listItem.setOnClickListener {
            listener.onItemClicked(item)
            swipeLayout.animateReset()
        }

        orange.setOnClickListener {
            listener.onOrangeClicked(item)
            swipeLayout.animateReset()
        }

        purple.setOnClickListener {
            listener.onPurpleClicked(item)
            swipeLayout.animateReset()
        }

    }
}
