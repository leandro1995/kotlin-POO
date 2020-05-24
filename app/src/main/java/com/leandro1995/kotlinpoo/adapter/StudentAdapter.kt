package com.leandro1995.kotlinpoo.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.kotlinpoo.R
import com.leandro1995.kotlinpoo.model.Student
import kotlinx.android.synthetic.main.item_student.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class StudentAdapter constructor(private val studentList: MutableList<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        return StudentHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        holder.itemView.nameText.text =
            "${studentList[position].name} ${studentList[position].surName}"

        GlobalScope.launch(Dispatchers.Main) {
            studentList[position].categoryValidity().let {
                holder.itemView.categoryText.text = it
            }
        }
    }

    class StudentHolder constructor(view: View) : RecyclerView.ViewHolder(view)
}