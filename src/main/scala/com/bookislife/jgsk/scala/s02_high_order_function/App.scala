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

        val sum3: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
            override def apply(x: Int, y: Int): Int = x + y
        }

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

        //  PartialFunction
        val isEven: PartialFunction[Int, String] = {
            case x if x != 0 && x % 2 == 0 => x + " is even"
        }
        println(isEven(20))

        println(isEven.isDefinedAt(4)) //  true
        println(isEven.isDefinedAt(3)) //  false

        val isOdd: PartialFunction[Int, String] = {
            case x if x % 2 != 0 => x + " is odd"
        }
        val other: PartialFunction[Int, String] = {
            case _ => "else"
        }
        val partial = isEven orElse isOdd orElse other
        println(partial(3)) //  3 is odd
        println(partial(0)) //  else

        val numbers = 1 to 10
        val evenNumbers = numbers.collect(isEven)
        evenNumbers.foreach(println)

        //  By-Name Parameter
        assert(() => 1 == 2)
        byNameAssert(1 == 2)
        booleanAssert(1 == 2)

        assertionsEnabled = false
        assert(() => 1 / 0 == 0)
        byNameAssert(1 / 0 == 0)
        //    booleanAssert(1 / 0 == 0)

    }

    def multiple(x: Int, y: Int): Int = x * y

    def add10(f: (Int) => Int) = f(10)

    def scale(factor: Double) = (x: Double) => x * factor

    def minus(x: Int, y: Int) = x - y

    def minus2(x: Int)(y: Int) = x - y

    def show(prefix: String, msg: String, postfix: String) = prefix + msg + postfix

    var assertionsEnabled = true

    def assert(predicate: () => Boolean) =
        if (assertionsEnabled && !predicate())
            println("assert failed")

    def byNameAssert(predicate: => Boolean) =
        if (assertionsEnabled && !predicate)
            println("assert failed")

    def booleanAssert(predicate: Boolean) =
        if (assertionsEnabled && !predicate)
            println("assert failed")
}
