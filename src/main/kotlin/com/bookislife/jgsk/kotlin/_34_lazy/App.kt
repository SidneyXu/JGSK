package com.bookislife.jgsk.kotlin._34_lazy

/**
 * Created by SidneyXu on 2015/12/07.
 */

fun main(args: Array<String>) {
    println("Before is ${System.currentTimeMillis()}")
    val a = A()
    println("After is ${System.currentTimeMillis()}")
    println("Hello 1, ${a.fooField}")
    println("Hello 2, ${a.fooField}")
}

class A {
    val fooField: Long by lazy {
        println("Compute...")
        Thread.sleep(3000)
        System.currentTimeMillis()
    }
}