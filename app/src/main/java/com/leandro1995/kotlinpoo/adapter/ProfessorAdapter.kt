package com.leandro1995.kotlinpoo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.kotlinpoo.R
import com.leandro1995.kotlinpoo.model.Professor
import kotlinx.android.synthetic.main.item_professor.view.*
import kotlinx.android.synthetic.main.item_professor.view.nameText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

        GlobalScope.launch(Dispatchers.Main) {
            professorList[position].categoryValidity().let {
                holder.itemView.categoryText.text = it
            }
        }
    }

    class ProfessorHolder constructor(view: View) : RecyclerView.ViewHolder(view)
}