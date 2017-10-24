package org.numisoft.dividertest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.lang.ref.WeakReference

/**
 * Created by mac-200 on 10/23/17.
 */

class MyAdapter(val items: ArrayList<Item>, listener: RecyclerClickListener) : RecyclerView.Adapter<MyViewHolder>() {

    val listener: WeakReference<RecyclerClickListener> = WeakReference(listener)
    val itemsOffset: IntArray = IntArray(items.size)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        listener.get()?.let { holder.bind(items[position], it) }
        holder.swipeLayout.offset = itemsOffset[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onViewDetachedFromWindow(holder: MyViewHolder) {
        if (holder.adapterPosition != RecyclerView.NO_POSITION) {
            itemsOffset[holder.adapterPosition] = holder.swipeLayout.offset
        }
    }

    interface RecyclerClickListener {
        fun onItemClicked(item: Item)
        fun onOrangeClicked(item: Item)
        fun onPurpleClicked(item: Item)
    }

    fun removeItem(item: Item) {
        val index = items.indexOf(item)
        items.removeAt(index)
        notifyItemRemoved(index)
    }

}
