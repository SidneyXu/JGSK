package com.bookislife.jgsk.kotlin._16_method

/**
 * Created by SidneyXu on 2015/09/22.
 */
fun main(args: Array<String>) {
    testMethod()
    testClosure()
}

fun testMethod() {
    //  Static Method

    //  Varargs

    //  Default Values
}


fun testClosure() {
    //  Define
//    { (x:Int) => println("foo") }
}

fun say(name: String, word: String = "Hello") {
    println("$word $name")
}

class Calculator {
    fun add(x: Int, y: Int) {
        x + y
    }

    fun sum() {

    }
}
