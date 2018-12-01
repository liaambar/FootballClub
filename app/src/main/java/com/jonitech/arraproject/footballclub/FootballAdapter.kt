package com.jonitech.arraproject.footballclub

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class FootballAdapter(private val context: Context, private val items: List<ClubItem>, private val listener :(ClubItem)->Unit) : RecyclerView.Adapter<FootballAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val clubName = view.findViewById<TextView>(R.id.tv_name_club)
        private val clubImage = view.findViewById<ImageView>(R.id.img_club)
        fun bindItem(items: ClubItem, listener: (ClubItem) -> Unit) {
            clubName.text = items.clubName
            items.image?.let { Picasso.get().load(it).into(clubImage) }
            itemView.setOnClickListener{
                listener(items)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.club_item_list, parent, false))

    override fun getItemCount(): Int = items.size
}