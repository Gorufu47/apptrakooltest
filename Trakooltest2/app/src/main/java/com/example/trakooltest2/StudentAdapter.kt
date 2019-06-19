package com.example.trakooltest2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.listview_row.view.*


class StudentAdapter(private val studentAll: StudentAll): RecyclerView.Adapter<StudentHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.listview_row, parent, false)
        return StudentHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return studentAll.student.count()
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        val student = studentAll.student[position]

        holder.itemView.tag = student.ID
        holder.itemView.tvSid.text = student.NameTH
        holder.itemView.tvNameTH.text = student.StudentID
        holder.itemView.tvMajor.text = student.Major

        holder.items = student
    }
}
class StudentHolder(view: View, var items: Student? = null): RecyclerView.ViewHolder(view)
