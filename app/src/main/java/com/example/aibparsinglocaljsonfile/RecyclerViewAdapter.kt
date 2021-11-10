package com.example.aibparsinglocaljsonfile

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aibparsinglocaljsonfile.assets.DataItem
import kotlinx.android.synthetic.main.item_row.view.*
import kotlin.collections.ArrayList

class RecyclerViewAdapter (private val details: ArrayList<DataItem>, val context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = details[position]
        holder.itemView.apply {
            Glide.with(context)
                .load(data.url)
                .into(ivImage)


        }
    }

    override fun getItemCount() = details.size

}