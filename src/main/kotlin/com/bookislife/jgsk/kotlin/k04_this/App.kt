package com.bookislife.jgsk.kotlin.k04_this

/**
 * Created by SidneyXu on 2015/12/09.
 */
fun main(args: Array<String>) {
    A().B().info()

    val b = BaseImpl()
    val c = C(b)
    c.echo("foo")
}

//  This Expression
//  In a member of a class, this refers to the current object
class A { // implicit label @A
    inner class B { // implicit label @B

        /*
            this refers to the receiver parameter in extension
         */
        fun Int.foo() {
            // implicit label @foo
            //If this has no qualifiers, it refers to the innermost enclosing scope.

            val funLit = { ->
                // funLit's receiver
                println("this of funLit refers to $this")   //  10
            }

            val funLit2 = { s: String ->
                // foo()'s receiver, since enclosing function literal
                // doesn't have any receiver
                println("this of funLit2 refers to $this")  //  10
            }

            // foo()'s receiver, an Int
            println("this refers to ${this}")   //  10
            println("this@foo refers to ${this@foo}")   //  10

            println("this@A refers to ${this@A}")  //  A
            println("this@B refers to ${this@B}")  //  A$B

            funLit()
            funLit2("foo")
        }

        fun info() {
            println("the member refers to $this")    // A$B
            10.foo()
        }
    }
}

interface Base {
    fun echo(msg: String)
}

class BaseImpl : Base {
    override fun echo(msg: String) {
        println("this refers to $this") //  BaseImpl
    }
}

class C(b: Base) : Base by b