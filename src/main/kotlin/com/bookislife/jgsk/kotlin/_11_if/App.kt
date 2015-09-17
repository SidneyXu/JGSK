package com.bookislife.jgsk.kotlin._11_if

/**
* Created by SidenyXu on 2015/09/18.
*/
fun main(args: Array<String>) {
    //  If
    val i = 0
    if (i != 0) {
        println(true)
    } else {
        println(false)
    }

    val list = emptyList<Int>()
    if (list.isNotEmpty()) println(true) else println(false)
}