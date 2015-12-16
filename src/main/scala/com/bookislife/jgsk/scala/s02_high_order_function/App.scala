package com.bookislife.jgsk.scala.s02_high_order_function

/**
  * Created by SidneyXu on 2015/12/15.
  */
object App {

  def main(args: Array[String]) {
    //  Function Literal Syntax
    //  Type Inference
    val sum = (x: Int, y: Int) => x + y

    val sum2: (Int, Int) => Int = (x, y) => x + y

    val multi = multiple _
    println(multi(3, 4)) //  12

    //  High Order Function
    //  Functions as Parameters
    add10({ i => i + 2 })
    val x = add10(_ + 2)

    //  Curry
    val scale20 = scale(0.2)
    println(scale20(5)) //  1.0
    println(scale(0.3)(5)) //  1.5
    println(scale2(0.3)(5)) //  1.5

    val echo = show _
    println(echo("{", "echo", "}"))
    val echoCurr = (show _).curried
    echoCurr("{")("echoCurr")("}")

    //  Partial Application
    val prefixApply = show("(", _: String, _: String)
    val prefixPostFixApply = prefixApply(_: String, ")")
    println(prefixPostFixApply("foobar")) //  (foobar)

    //  PartialFunction
    val isEven: PartialFunction[Int, String] = {
      case x if x != 0 && x % 2 == 0 => x + " is even"
    }
    println(isEven(20))

    val numbers = 1 to 10
    val evenNumbers = numbers.collect(isEven)
    evenNumbers.foreach(println)

    println(isEven.isDefinedAt(4))
    println(isEven.isDefinedAt(3))

    val isOdd: PartialFunction[Int, String] = {
      case x if x % 2 != 0 => x + " is odd"
    }
    val other: PartialFunction[Int, String] = {
      case _ => "else"
    }
    val partial = isEven orElse isOdd orElse other
    println(partial(3))
    println(partial(0))
  }

  def multiple(x: Int, y: Int): Int = x * y

  def add10(f: (Int) => Int) = f(10)

  def scale(factor: Double) = (x: Double) => x * factor

  def scale2(factor: Double)(x: Double) = x * factor

  def show(prefix: String, msg: String, postfix: String) = prefix + msg + postfix
}
