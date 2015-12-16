package com.bookislife.jgsk.scala.s02_high_order_function

/**
  * Created by SidneyXu on 2015/12/15.
  */
object App {

    def main(args: Array[String]) {
        //  Function Literal Syntax
        //  Parameters Type Inference
        val sum = (x: Int, y: Int) => x + y

        val sum2: (Int, Int) => Int = (x, y) => x + y

        val multi = multiple _
        println(multi(3, 4)) //  12


        //  High Order Function
        //  Functions as Parameters
        add10({ i => i + 2 })
        println(add10(_ + 2))

        //  Curry
        println(minus(5, 3))
        println(minus2(5)(3))

        val minusCurr = (minus _).curried
        println(minusCurr(5)(3))

        //  Partial Application
        val applyPrefix = show("(", _: String, _: String)
        println(applyPrefix("foo", ")")) //  (foo)

        val applyPostfix = show(_: String, _: String, ")")
        println(applyPostfix("(", "bar")) //  (bar)
    }

    def multiple(x: Int, y: Int): Int = x * y

    def add10(f: (Int) => Int) = f(10)

    def scale(factor: Double) = (x: Double) => x * factor

    def minus(x: Int, y: Int) = x - y

    def minus2(x: Int)(y: Int) = x - y

    def show(prefix: String, msg: String, postfix: String) = prefix + msg + postfix
}
