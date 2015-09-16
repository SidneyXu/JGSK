package com.bookislife.jgsk.kotlin._05_datatype

import java.math.BigDecimal

/**
 * Created by SidneyXu on 2015/09/16.
 */
fun main(args: Array<String>) {
    //  Everything is Object
    1.toString()

    //  Data Types
    var x: Int = 2
    var y: Float = 0.1f
    var flag: Boolean = false
    var z = 1
    //  Wrong!!
    //    z = false

    //  BigDecimal
    println(BigDecimal("2").subtract(BigDecimal("1.8")));

    //  Type Conversion
    var b: Byte = 1
    //  Wrong!! implicit conversion not supported
    //    val i: Int = b
    //  Wrong!! Char is not a number
    //    val c: Char = 1

    //  Explicit Conversion
    println(99.98.toInt())
    println(99.toChar())
    println("99.12".toDouble())

    //  Type Inference
    val foo = "foo"
    val fooString: String = foo as String
    bar(foo)
}

fun bar(foo: Any) {
    if (foo is String) {
        println(foo.toUpperCase())
    }
}