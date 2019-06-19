package com.example.trakooltest2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.trakooltest2.R
import com.example.trakooltest2.adapter.MemberListener
import com.example.trakooltest2.model.Member
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_info.view.*

class MemberAdapter(private val items: ArrayList<com.example.trakooltest2.model.Member>,
                    private val listener: MemberListener
): RecyclerView.Adapter<MemberAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_info, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener { listener.onItemClick() }
    }

    class ViewHolder(itemsView: View): RecyclerView.ViewHolder(itemsView) {
        fun bind(member: Member) {
            itemView.apply {
                val fullname = member.slug
                slug.text = fullname
            }
        }
    }
}