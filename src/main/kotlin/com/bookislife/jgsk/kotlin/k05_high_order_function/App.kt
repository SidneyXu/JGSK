package com.bookislife.jgsk.kotlin.k05_high_order_function

import java.util.concurrent.locks.Lock

/**
 * Created by SidneyXu on 2015/12/11.
 */
fun main(args: Array<String>) {
    //  Function Literal Syntax
    val sum = { x: Int, y: Int -> x + y }
    val sum2: (Int, Int) -> Int = { x, y -> x + y }

    //  Functions as Parameters
    val x = add({ Int -> 2 })
    println(x) //   2

    //  Closure
    var sum3 = 0
    val ints = intArrayOf(1, 2, 3)
    ints.filter { it > 0 }.forEach {
        sum3 += it
    }
    println(sum3) //  6

    //  Extension Function Expressions
    val sum4 = fun Int.(other: Int): Int = this + other
    println(1.sum4(2))  //  3
    1.sum4(2)
}

fun add(f: (Int) -> Int) = f(10)

//  Functions as Parameters
fun <T> lock(lock: Lock, body: () -> T): T {
    lock.lock()
    try {
        return body()
    } finally {
        lock.unlock()
    }
}

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
