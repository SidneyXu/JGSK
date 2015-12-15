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
  }

  def multiple(x: Int, y: Int): Int = x * y

  def add10(f: (Int) => Int) = f(10)

  def scale(factor: Double) = (x: Double) => x * factor

  def scale2(factor: Double)(x: Double) = x * factor

  def show(prefix: String, msg: String, postfix: String) = prefix + msg + postfix
}
