package com.bookislife.jgsk.kotlin._19_inherit

/**
 * Created by SidneyXu on 2015/09/29.
 */
//  By default, all classes are final classes
//  parent has primary constructor
open class Person(name: String) {
    open fun idf() {
    }

    open fun idf2() {
    }
}

class Employee(name: String) : Person(name) {
    constructor(name: String, age: Int) : this(name) {

    }

    // override method is not final method
    override fun idf() {
        super.idf()
    }

    final override fun idf2() {
        super.idf2()
    }

    override fun toString(): String {
        return super.toString() + javaClass.getName()
    }
}

//  parent has no primary constructor
open class View {
    constructor(size: Int)

    open fun onClick() {
        println("click view")
    }
}

//  interface is similar to java 8
//  contains methods and abstract properties
interface A {
    val prop: Int

    fun foo() {
    }

    fun bar()
}

class B : A {
    override fun bar() {
        throw UnsupportedOperationException()
    }

    override val prop: Int
        get() = throw UnsupportedOperationException()
}

interface OnClickListener {
    //  interface are open by default
    fun onClick() {
        println("on click")
    }
}

open class TextView : View, OnClickListener {

    constructor(size: Int) : super(size)

    // onClick must be overridden
    override fun onClick() {
        // angle brackets is used to denote the supertype from which the inherited implementation is taken
        super<View>.onClick()   //  call to View.onClick()
        super<OnClickListener>.onClick()
    }
}

//  Abstract class
abstract class Shape {
    abstract fun onClick()
}

class Rectangle : Shape(), OnClickListener {
    // not required to override onClick
}

//  override a non-abstract member with abstract one
abstract class SuperTextView(size: Int) : TextView(size) {
    abstract override fun onClick()
}

fun main(args: Array<String>) {
    val rect = Rectangle()
    rect.onClick()
}