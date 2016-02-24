package com.bookislife.jgsk.kotlin.k03_delegate

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by SidneyXu on 2015/12/09.
 */
fun main(args: Array<String>) {
    //  Class Delegation
    val b = BaseImpl("Hello")
    b.echo("World") //  Hello World
    val d = Derived(b)  //  Hello World
    d.echo("World")

    //  Delegated Properties
    val e = Example()
    println(e.msg)  //  msg = Default Message

    e.msg = "New Message"
    println(e.msg)  //  msg = New Message

    //  Observable
    val user = User()
    user.name = "first" //  <init value> -> first
    user.name = "first"
    user.name = "second"    //  first -> second

    // Using vetoable instead of observable() to cancel the change
    user.age = 10   //  0 -> 10
    println(user.age)   //  10
    user.age = 20   //  10 -> 20
    println(user.age)   //  20

    //  Not Null
    val foo = Foo()
    //  Property name should be initialized before get
    //    println(foo.notNullBar)
    foo.notNullBar = "bar"
    println(foo.notNullBar)

    //  Storing Properties in a Map
    val person = Person(mapOf(
            "name" to "John",
            "age" to 25
    ))
    println(person.name)
    println(person.age)

    val mutablePerson = MutablePerson(hashMapOf(
            "name" to "John",
            "age" to 25
    ))
    println(mutablePerson.name)
    println(mutablePerson.age)
}

//  Class Delegation
interface Base {
    fun echo(msg: String)
}

class BaseImpl(val prefix: String) : Base {
    override fun echo(msg: String) {
        println("$prefix $msg")
    }
}

class Derived(b: Base) : Base by b

//  Delegated Properties
class Delegate {

    private var message = "Default Message"

    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "${prop.name} = $message from $thisRef"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        message = value
    }
}

class Example {
    var msg: String by Delegate()
}

//  Observable
class User {
    var name: String by Delegates.observable("<init value>") {
        prop, old, new ->
        if (old != new) {
            println("$old -> $new")
        }
    }

    var age: Int by Delegates.vetoable(0) {
        prop, old, new ->
        println("$old -> $new")
        if (new < 20) true else false
    }
}

//  Not Null
class Foo {
    var notNullBar: String by Delegates.notNull<String>()
    var bar: String? = null
}

//  Map
class Person(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

class MutablePerson(val map: MutableMap<String, Any?>) {
    var name: String by map
    var age: Int     by map
}