package com.bookislife.jgsk.scala._16_method

/**
 * Created by SidneyXu on 2015/09/22.
 */
object App {

  def main(args: Array[String]) {
    testMethod()
    testClosure()
  }

  def testMethod(): Unit = {
    //  Varargs
    val calculator = new Calculator
    calculator.sum(1, 2, 3)

    //  Default Values
    say("Peter")

    //  Return Values
    println(calculator.add(2, 3))
  }

  def testClosure(): Unit = {
    //  Define
    { () => println("foo") }

    //  Closure as an Object
    def excite = { word: String =>
      s"$word!!"
    }

    //  Calling a closure
    println(excite("Java"))

    //  Parameters
    def plus = { (x: Int, y: Int) =>
      println(s"$x plus $y is ${x + y}")
    }

    //  Implicit Parameter
    //  Wrong!!
    //    def greeting = s"Hello, $_ !"
    def greeting = (_: String) => "Hello, " + _ + " !"
    greeting("Peter")

    //  Varargs
    //  Wrong!! Not supported
    //    def contact = { (args: String*) =>
    //      args
    //    }

    //  Closure as Parameter
    var maxValue = max(Array(3, 10, 2, 1, 40), (numbers) => {
      numbers.max
    })

    maxValue = max2(Array(3, 10, 2, 1, 40)) { numbers =>
      numbers.max
    }
    println(maxValue)
  }

  def say(name: String, word: String = "Hello"): Unit = {
    println(s"$word $name")
  }

  def max(numbers: Array[Int], s: (Array[Int]) => Int): Unit = {
    s.apply(numbers)
  }

  def max2(numbers: Array[Int])(s: (Array[Int]) => Int): Unit = {
    s.apply(numbers)
  }


  class Calculator {

    def add(x: Int, y: Int): Int = {
      x + y
    }

    def sum(n: Int*) {
      println(n.sum)
    }
  }

}