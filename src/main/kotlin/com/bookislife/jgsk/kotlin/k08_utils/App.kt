package com.bookislife.jgsk.kotlin.k08_utils

import kotlin.system.measureTimeMillis

/**
 * Created by SidneyXu on 2015/12/19.
 */
fun main(args: Array<String>) {
    //  Preconditions
    var msg = "foobar"

    if (msg.isEmpty()) {
        throw IllegalArgumentException("Message is empty!")
    }

    require(msg.isNotEmpty()) {
        "Message is empty!"
    }

    val result = requireNotNull(msg) {
        "Object is null!"
    }
    println(result)

    //  Todo
    var error = NotImplementedError("not implemented")
    error = TODO("Not implemented in current version")

    //  Measure
    val duration = measureTimeMillis {
        var counter = 0
        repeat(100000000) {
            counter++
        }
    }
    println("duration is $duration")
}