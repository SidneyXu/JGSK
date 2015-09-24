package com.bookislife.jgsk.kotlin._20_switch_match

import java.util.Date

/**
 * Created by SidneyXu on 2015/09/24.
 */
fun main(args: Array<String>) {
    assert("Object equals" == test(0))
    assert("Or" == test(3))
    assert("Range contains" == test(11))
    assert("Range not contain" == test(33))
    assert("Class instance" == test(Date()))

    //  As a replacement for an if-else if chain
    val x = 10
    val y = 20
    when {
        x + y == 5 -> println("x + y = 5")
        x + y == 10 -> println("x + y = 10")
        else -> println("x + y != 5 or 10")
    }

}

private fun test(foo: Any): String {
    var result = when (foo) {
        0 -> "Object equals"
        3, 10 -> "Or"
        in 11..20 -> "Range contains"
        is Date -> "Class instance"
        !in 4..30 -> "Range not contain"
        else -> "Default"
    }
    return result
}
