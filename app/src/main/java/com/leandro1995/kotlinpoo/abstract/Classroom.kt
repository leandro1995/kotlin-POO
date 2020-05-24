package com.leandro1995.kotlinpoo.abstract

import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

abstract class Classroom constructor(
    var name: String,
    var surName: String,
    protected var age: Int,
    protected var year: Int,
    protected var type: String
) {
    abstract fun register()

    suspend fun categoryValidity(): String {
        delay(TimeUnit.SECONDS.toMillis(1))
        return if (age > 18) "Profesor" else "Alumno"
    }
}