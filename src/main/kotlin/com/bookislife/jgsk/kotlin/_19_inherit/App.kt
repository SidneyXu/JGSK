package com.bookislife.jgsk.kotlin._19_inherit

/**
 * Created by SidneyXu on 2015/09/29.
 */
fun main(args: Array<String>) {
    val openButton = Button("Open", 100, 100)
    println(openButton.getDescription())
}

//  By default, all classes are final classes
open class Person(name: String) {
    open fun foo() {
    }

    open fun bar() {
    }

    fun foo2() {

    }
}

class Employee(name: String) : Person(name) {
    constructor(name: String, age: Int) : this(name) {
    }

    override fun foo() {
        super.foo()
    }

    final override fun bar() {
        super.bar()
    }

    override fun toString(): String {
        return super.toString() + javaClass.name
    }

}

abstract class View(val width: Int, val height: Int) {
    abstract fun getDescription(): String

    open fun onClick() {
        println("Click event of View")
    }
}

//  Interfaces are open by default
interface OnClickListener {

    //  Abstract properties
    val prop: Int

    fun onClick() {
        println("Click event of OnClickListener")
    }

    fun getDescription(): String
}

class Button(val text: String, width: Int, height: Int) : View(width, height), OnClickListener {

    override fun onClick() {
        super<View>.onClick()
        super<OnClickListener>.onClick()
    }

    override val prop: Int
        get() = width * height


    override fun getDescription(): String {
        return text
    }


}
