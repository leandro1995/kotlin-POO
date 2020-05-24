package com.leandro1995.kotlinpoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandro1995.kotlinpoo.adapter.ProfessorAdapter
import com.leandro1995.kotlinpoo.model.Professor
import com.leandro1995.kotlinpoo.model.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var studentList = mutableListOf<Student>()
    private var professorList = mutableListOf<Professor>()

    private lateinit var professorAdapter: ProfessorAdapter
    private lateinit var professorLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register()
        classroomList()
    }

    private fun register() {
        professorList.add(
            Professor(
                name = "Leandro",
                surName = "Castillo",
                age = 25,
                year = 1995,
                type = "Profesor",
                course = "Matematica"
            )
        )

        studentList.add(
            Student(
                name = "Maria",
                surName = "Diaz",
                age = 16,
                year = 2004,
                type = "Alumno",
                shortHair = false
            )
        )

        studentList.add(
            Student(
                name = "David",
                surName = "Ruiz",
                age = 15,
                year = 2005,
                type = "Alumno",
                shortHair = true
            )
        )

        studentList.add(
            Student(
                name = "Melody",
                surName = "Navarro",
                age = 17,
                year = 2003,
                type = "Alumno",
                shortHair = false
            )
        )

        studentList.add(
            Student(
                name = "Leonardo",
                surName = "Medina",
                age = 17,
                year = 2003,
                type = "Alumno",
                shortHair = true
            )
        )
    }

    private fun classroomList() {
        professorLayoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        professorAdapter = ProfessorAdapter(professorList = professorList)

        professorRecycler.apply {
            layoutManager = professorLayoutManager
            adapter = professorAdapter
        }

        professorAdapter.notifyDataSetChanged()
    }
}