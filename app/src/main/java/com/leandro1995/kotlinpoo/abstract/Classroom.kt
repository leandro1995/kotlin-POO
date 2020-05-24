package com.leandro1995.kotlinpoo.abstract

abstract class Classroom constructor(
    protected var name: String,
    protected var surName: String,
    protected var age: Int,
    protected var year: Int,
    protected var type: String
) {
    abstract fun register()
}