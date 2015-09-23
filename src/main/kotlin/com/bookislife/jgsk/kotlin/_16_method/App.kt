package com.bookislife.jgsk.kotlin._16_method

/**
 * Created by SidneyXu on 2015/09/22.
 */
fun main(args: Array<String>) {
    testMethod()
    testClosure()
}

fun testMethod() {
    //  Varargs
    val calculator = Calculator()
    calculator.sum(1, 2, 3)

    //  Default Values
    say("Peter")

    //  Return Values
    println(calculator.add(2, 3))
}


fun testClosure() {
    //  Define
    {(x: Int) -> println("foo") }
}

fun say(name: String, word: String = "Hello") {
    println("$word $name")
}

class Calculator {
    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun sum(vararg n: Int) {
        println(n.sum())
    }

}
