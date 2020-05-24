package com.leandro1995.kotlinpoo.abstract

abstract class Classroom constructor(
    var name: String,
    var surName: String,
    protected var age: Int,
    protected var year: Int,
    protected var type: String
) {
    abstract fun register()
}