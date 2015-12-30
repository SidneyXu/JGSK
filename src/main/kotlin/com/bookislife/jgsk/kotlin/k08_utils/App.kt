package com.bookislife.jgsk.kotlin.k08_utils

import kotlin.util.measureTimeMillis

/**
 * Created by SidneyXu on 2015/12/19.
 */
fun main(args: Array<String>) {
    //  Repeat
    repeat(3) {
        println(it)
    }

    //  Preconditions
    var msg = ""
    //    require(msg.isNotEmpty()) {
    //        "Message is empty!"
    //    }
    //
    //    requireNotNull(msg) {
    //        "Object is null!"
    //    }

    val result = checkNotNull(msg) {
        "Object is null!"
    }
    println(result)

    var error = NotImplementedError("not implemented")
    error = TODO("todo")
    val duration = measureTimeMillis {
        var counter = 0
        repeat(100000000) {
            counter++
        }
    }
    println("duration is $duration")
}