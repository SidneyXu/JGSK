package com.bookislife.jgsk.kotlin._27_generics

/**
 * Created by SidneyXu on 2015/10/09.
 */
fun main(args: Array<String>) {
    //  Without Generics
    val integerObjectCapture = ObjectCapture(10)
    val int10: Int = integerObjectCapture.obj as Int

    //  Simple Usages
    val integerCapture = Capture(10)
    val nint10 = integerCapture.t
    val stringCapture = Capture("Hi")
    val str = stringCapture.t

    println(nint10.javaClass)
    println(str.javaClass)

    //  Covariant
    var strHolder = Holder("a")
    var anyHolder = Holder<Any>("b")
    //  Wrong!!
    //    anyHolder = strHolder

    var strCo: CovariantHolder<String> = CovariantHolder("a")
    var anyCo: CovariantHolder<Any> = CovariantHolder<Any>("b")
    //  Wrong!!
    //    strCo = anyCo
    anyCo = strCo

    //   Contravarint
    var strDCo = ContravarintHolder("a")
    var anyDCo = ContravarintHolder<Any>("b")
    //  Wrong!!
    //    anyCo = strDCo
    strDCo = anyDCo


    //  Wildcard
    val capture = Capture("foo")
    //  Wrong!!
    //    foo(capture)
    foo2(capture)

}

fun foo(capture: Capture<Any>) {

}

fun foo2(capture: Capture<*>) {
}

fun foo3(list: MutableList<out Num>) {
    val num: Num = list.get(0)
    println(num)
}

fun foo4(list: MutableList<in Num>) {
    list.add(Num(4))
    val num: Any? = list.get(0)
    println(num)
}

class ObjectCapture(val obj: Any)

class Capture<T>(val t: T)

class Num(val n: Number)

class Holder<A>(a: A)

class CovariantHolder<out A>(val a: A) {
    fun foo(): A {
        return a
    }
}

class ContravarintHolder<in A>(a: A) {
    fun foo(a: A) {
    }
}