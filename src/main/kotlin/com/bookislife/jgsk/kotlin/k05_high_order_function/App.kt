package com.bookislife.jgsk.kotlin.k05_high_order_function

/**
 * Created by SidneyXu on 2015/12/11.
 */
fun main(args: Array<String>) {
    //  Function Literal Syntax
    //  Type Inference
    val sum = { x: Int, y: Int -> x + y }

    val sum2: (Int, Int) -> Int = { x, y -> x + y }
    val triple: (Int) -> Int = { x -> 3 * x }

    //  High Order Function
    //  Functions as Parameters
    add10({ it + 2 })
    val x = add10 { it + 2 }
    println(x) //   12

    //  Curry
    println(show2("(")("foobar")(")"))

    //  Partial Application
    val show = { prefix: String, msg: String, postfix: String ->
        prefix + msg + postfix
    }

    //  Function Literals with Receiver
    val a = accept { x ->
        this + x
    }
    println(a)  //  110

    val b = accept2 { x ->
        x + 10
    }
    println(b)  //  20
}

fun add10(f: (Int) -> Int) = f(10)

fun scale(factor: Double) = { x: Double -> x * factor }

fun show2(prefix: String) = { msg: String ->
    { postfix: String ->
        prefix + msg + postfix
    }

}

//  Function Literals with Receiver
fun accept(dec: Int.(other: Int) -> Int): Int {
    //  Receiver
    val i = 100
    return i.dec(10)
}

fun accept2(f: (Int) -> Int): Int {
    return f(10)
}