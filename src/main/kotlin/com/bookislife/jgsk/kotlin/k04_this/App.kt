package com.bookislife.jgsk.kotlin.k04_this

/**
 * Created by SidneyXu on 2015/12/09.
 */
fun main(args: Array<String>) {
    A().B().info()
}

//  This Expression
//  In a member of a class, this refers to the current object of that class
class A { // implicit label @A
    inner class B { // implicit label @B

        /*
            In an extension function or an extension function literal, t
            his denotes the receiver parameter that is passed on the lefthand
            side of a dot.
         */
        fun Int.foo() {
            // implicit label @foo
            val a = this@A // A's this
            val b = this@B // B's this

            //If this has no qualifiers, it refers to the innermost enclosing scope.
            val c = this // foo()'s receiver, an Int
            val c1 = this@foo // foo()'s receiver, an Int

            val funLit = { ->
                val d = this // funLit's receiver
            }

            val funLit2 = { s: String ->
                // foo()'s receiver, since enclosing function literal
                // doesn't have any receiver
                val d1 = this
            }

            println("a= " + a)  //  A@41629346
            println("b= " + b)  //  A$B@4dd8dc3
            println("c= " + c)  //  10
            println("c1= " + c1)    //  10
            println("funLit= " + funLit)    //  Function0<kotlin.Unit>
            println("funLit2= " + funLit2)  //  Function1<java.lang.String, kotlin.Unit>
        }

        fun info() {
            println("info= " + this)    //B.s this
            10.foo()
        }
    }
}