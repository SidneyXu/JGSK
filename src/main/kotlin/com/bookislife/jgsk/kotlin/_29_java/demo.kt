package org.mrseasons.coffeetime.kotlin._23_java

import java.io.IOException
import kotlin.platform.platformStatic

/**
 * Created by mrseasons on 2015/06/29.
 */
class KotlinBean(val name: String) {
    fun hello() {
        println("hello,my name is " + name)
    }

    companion object {
        platformStatic fun foo() {
            println("companion foo")
        }

        fun bar() {
            println("companion bar")
        }
    }
}

object Obj {
    platformStatic fun foo() {
        println("object foo")
    }

    fun bar() {
        println("object bar")
    }
}

fun bar() {
    println("bar")
}

//for java overload
jvmOverloads fun f(a: String, b: Int = 0, c: String = "abc") {
}

fun f2(a: String, b: Int = 0, c: String = "abc") {
}

//check exception
@throws(IOException::class) fun e() {
    throw IOException()
}

fun e2() {
    throw IOException()
}