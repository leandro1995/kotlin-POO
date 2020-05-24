package com.leandro1995.kotlinpoo.model

import com.leandro1995.kotlinpoo.abstract.Classroom

class Student constructor(
    name: String,
    surName: String,
    age: Int,
    year: Int,
    type: String,
    var shortHair: Boolean
) : Classroom(name = name, surName = surName, age = age, year = year, type = type)