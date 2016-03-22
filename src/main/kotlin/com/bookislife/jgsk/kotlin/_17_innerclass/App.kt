package com.bookislife.jgsk.kotlin._17_innerclass

/**
 * Created by SidneyXu on 2015/09/28.
 */
fun main(args: Array<String>) {
    //  Anonymous Inner Class
    val thread = Thread(Runnable {

    })
    assertTrue(object : Assertion {
        override fun test(): Boolean {
            return true
        }
    })

    //  Inner Class
    val outter1 = Outter("Outter1")
    val inner1 = outter1.Inner("Inner1")

    val outter2 = Outter("Outter2")
    val inner2 = outter1.Inner("Inner2")

    println("outter1 is ${outter1.javaClass}")  //  _innerclass.Outter
    println("outter2 is ${outter2.javaClass}")  //  _innerclass.Outter
    println("inner1 is ${inner1.javaClass}")    //  _innerclass.Outter$Inner
    println("inner2 is ${inner2.javaClass}")    //  _innerclass.Outter$Inner

    outter1.foo(inner1) //  Outter1-Inner1
    outter1.foo(inner2) //  Outter1-Inner2

    val nested1 = Outter.Nested("Nested1")
    val nested2 = Outter.Nested("Nested2")

    println("nested1 is ${nested1.javaClass}")    //  _innerclass.Outter$Nested
    println("nested2 is ${nested2.javaClass}")    //  _innerclass.Outter$Nested

    outter1.bar(nested1) //  nested1
    outter1.bar(nested2) //  nested2
}

fun assertTrue(assert: Assertion): Boolean = assert.test()

interface Assertion {
    fun test(): Boolean
}

class Outter(val name: String) {

    inner class Inner(private val name: String) {
        fun desc() = "${this@Outter.name}-$name"
    }

    class Nested(private val name: String) {
        fun desc() = "$name"
    }

    fun foo(obj: Inner) {
        println(obj.desc())
    }

    fun bar(obj: Nested) {
        println(obj.desc())
    }
}