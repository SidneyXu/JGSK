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

    //  Internal Method
    var x = 1
    fun add(y: Int): Int {
        return x + y
    }
    println(add(100))
}


fun testClosure() {
    //  Define
    { -> println("foo") }

    { x: Int, y: Int ->
        println("$x plus $y is ${x + y}")
    }(1, 3)

    //  Closure as an Object
    val excite = { word: String ->
        "$word!!"
    }

    //  Calling a closure
    println(excite("Java"))
    println(excite.invoke("Kotlin"))

    //  Parameters
    val plus = { x: Int, y: Int ->
        println("$x plus $y is ${x + y}")
    }

    //  Implicit Parameter
    val ints = arrayOf(1, 2, 3)
    ints.filter {
        it > 3
    }

    //  Closure as Parameter
    val maxValue = max(arrayOf(3, 10, 2, 1, 40)) {
        it.max()!!
    }
    println(maxValue)
}

fun say(name: String, word: String = "Hello") {
    println("$word $name")
}

fun max(numbers: Array<Int>, s: (Array<Int>) -> Int): Int {
    return s.invoke(numbers)
}

class Calculator {
    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun sum(vararg n: Int) {
        println(n.sum())
    }

}
