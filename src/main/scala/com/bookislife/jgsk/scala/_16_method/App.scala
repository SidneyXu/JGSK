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
    //  Parameters
    val calculator = new Calculator
    calculator.info()
    calculator.info2

    //  Varargs
    calculator.sum(1, 2, 3)

    //  Sequence as Multiple Parameters
    calculator.sum(1 to 3: _*)

    //  Default Values
    say("Peter")

    //  Return Values
    println(calculator.add(2, 3))

    //  Internal Method
    var x = 1
    def add(y: Int): Int = {
      x + y
    }
    println(add(100))
  }

  def testClosure(): Unit = {
    //  Define
    { () => println("foo") }

    ((x: Int, y: Int) => {
      println(s"$x plus $y is ${x + y}")
    }) (1, 3)

    //  Closure as an Object
    val excite = (word: String) =>
      s"$word!!"

    //  Calling a closure
    println(excite("Java"))
    println(excite.apply("Scala"))

    //  Parameters
    val plus = (x: Int, y: Int) =>
      println(s"$x plus $y is ${x + y}")

    //  Implicit Parameter
    val greeting = "Hello,  " + _
    println(greeting("Peter"))

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

    def info(): Unit = {
      println("This is a class called Calculator.")
    }

    def info2: Unit = {
      println("This is a class called Calculator.")
    }
  }

}