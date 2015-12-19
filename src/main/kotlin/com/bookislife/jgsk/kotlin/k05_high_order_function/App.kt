package com.bookislife.jgsk.kotlin.k05_high_order_function

import java.util.concurrent.locks.Lock

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

    //  Closure
    var sum3 = 0
    val ints = intArrayOf(1, 2, 3)
    ints.filter { it > 0 }.forEach {
        sum3 += it
    }
    println(sum3) //  6

    //  Curry
    val scale20 = scale(0.2)
    println(scale20(5.0))
    println(scale(0.3)(5.0))

    //  Extension Function Expressions
    val sum4 = fun Int.(other: Int): Int = this + other
    println(1.sum4(2))  //  3
    1.sum4(2)

    //  Function Literals with Receiver
    val a=accept{x->
        x+10
    }
    println(a)
}

fun add10(f: (Int) -> Int) = f(10)

fun scale(factor: Double) = { x: Double -> x * factor }

//  Function Types
fun <T> max(collection: Collection<T>, less: (T, T) -> Boolean): T? {
    var max: T? = null
    for (it in collection)
        if (max == null || less(max, it))
            max = it
    return max
}

//  Inline Function
inline fun <T> inlineLock(lock: Lock, body: () -> T,
                          noinline notInlined: () -> T): T {
    lock.lock()
    try {
        return body()
    } finally {
        lock.unlock()
    }
}

//  Function Literals with Receiver
fun accept(dec: Int.(other: Int) -> Int): Int {
    val i = 100
    return i.dec(10)
}
