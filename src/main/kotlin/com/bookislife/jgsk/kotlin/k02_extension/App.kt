package com.bookislife.jgsk.kotlin.k02_extension

/**
 * Created by SidneyXu on 2015/12/08.
 */
fun main(args: Array<String>) {
    //  Extension Function
    var n: Num = Num(10)
    n.add(4)
    n.add(1, 3)
    println(n.x)    //  18

    //  A member always win an extension
    n.foo()         //  foo in Num

    //  Nullable Receiver
    var n2: Num? = null
    println(n2.toString())  //  a null num

    //  Extension Properties
    val l: List<Int> = listOf(1, 2, 3)
    println(l.second)  //  2

    //  Companion Object Extensions
    MyClass.foo()   //  foo in companion object

}

class Num(var x: Int) {
    fun add(y: Int) {
        x += y
    }

    fun foo() {
        println("foo in Num")
    }
}

fun Num.add(a: Int, b: Int) {
    this.x += a + b
}

fun Num.foo() {
    println("foo in extension")
}

//  Nullable Receiver
fun Num?.toString(): String {
    if (this == null) return "a null num"
    return toString()
}


//  Extension Properties
//  Their behavior can only be defined by explicitly providing getters/setters
val <T> List<T>.second: T
    get() = get(1)

//  Companion Object Extensions
class MyClass {
    companion object {}
}

fun MyClass.Companion.foo() {
    println("foo in companion object")
}