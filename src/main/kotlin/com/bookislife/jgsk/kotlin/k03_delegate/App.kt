package com.bookislife.jgsk.kotlin.k03_delegate

import kotlin.reflect.KProperty

/**
 * Created by SidneyXu on 2015/12/09.
 */
fun main(args: Array<String>) {
    //  Class Delegation
    val b = BaseImpl(19)
    b.println() //  19
    Derived(b).println()    //  19

    //  Delegated Properties
    val e = Example()
    println(e.p)

    e.p = "NEW"
    println(e.p)

    //  Standard Delegates
    //  https://kotlinlang.org/docs/reference/delegated-properties.html
}

//  Class Delegation
interface Base {
    fun println()
}

class BaseImpl(val x: Int) : Base {
    override fun println() {
        println(x)
    }
}

class Derived(b: Base) : Base by b

//  Delegated Properties
class Delegate {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${prop.name}}' to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("$value has been assigned to '${prop.name} in $thisRef.'")
    }
}

class Example {
    var p: String by Delegate()
}
