package com.bookislife.jgsk.kotlin._29_java

import java.io.IOException

/**
 * Created by SidneyXu on 2015/10/20.
 */

class KotlinBean(val name: String) {

    fun calc(x: Int, y: Int): Int {
        return x + y
    }

    companion object {
        @JvmStatic fun hello(bean: KotlinBean) {
            println("Hello, this is ${bean.name}")
        }

        fun echo(msg: String, bean: KotlinBean) {
            println("$msg, this is ${bean.name}")
        }
    }
}

object KotlinUtils {
    @JvmStatic fun foo() {
        println("Foo...")
    }

    fun bar() {
        println("Bar...")
    }
}

fun foobar() {
    println("A function without class.")
}

fun throwAnException() {
    throw IOException()
}

@Throws(IOException::class) fun declaredThrowAnException() {
    throw IOException()
}

@JvmOverloads fun f(a: String, b: Int = 0, c: String = "c") {
    println("a=$a b=$b c=$c")
}