package com.leandro1995.kotlinpoo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.kotlinpoo.R
import com.leandro1995.kotlinpoo.model.Professor
import com.leandro1995.kotlinpoo.model.Student
import kotlinx.android.synthetic.main.item_professor.view.*

class ProfessorAdapter constructor(private val professorList: MutableList<Professor>) :
    RecyclerView.Adapter<ProfessorAdapter.ProfessorHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessorHolder {
        return ProfessorHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_professor, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return professorList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProfessorHolder, position: Int) {
        holder.itemView.nameText.text =
            "${professorList[position].name} ${professorList[position].surName}"
        holder.itemView.courseText.text = professorList[position].course
    }

    class ProfessorHolder constructor(view: View) : RecyclerView.ViewHolder(view)
}