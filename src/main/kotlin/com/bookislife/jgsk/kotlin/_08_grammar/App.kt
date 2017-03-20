package com.bookislife.jgsk.kotlin._08_grammar

import java.util.*

/**
 * Created by SidneyXu on 2015/09/17.
 */

fun main(args: Array<String>) {
    //  Operators
    var i: Int = 1
    i++
    i += 3

    //  Elvis Operator
    val agentStatus = "Active"
    val statusElvis = agentStatus ?: "Inactive"

    //  Call Methods
    add(1, 2)

    //  Equals
    val x: Date = Date(100)
    val y: Date = Date(100)

    println("x==y: " + (x == y)) //  true
    println("x.equals(y): " + x.equals(y)) //  true
    println("x===y: " + (x === y)) //  false
}

fun add(x: Int, y: Int): Int {
    return x + y
}