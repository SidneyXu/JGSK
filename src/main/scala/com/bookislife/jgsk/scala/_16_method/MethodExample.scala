package com.bookislife.jgsk.scala._16_method

/**
 * Created by mrseasons on 2015/4/7.
 */
object MethodExample {

  def main(args: Array[String]) {
    //Method and Function
    val c = new C
    println(c.methodInc) //()
    println(c.acc) //1

    println(c.functionInc) //<function0>
    println(c.acc) //1

    println(c.functionInc()) //()
    println(c.acc) //2

    println(c.mehodInn)
    println(c.acc)
  }

  class C {
    var acc = 0

    // a method
    def methodInc = {
      acc += 1
    }

    // a function, return value is a function
    def functionInc = { () => acc += 1 }

    val mehodInn = { () =>
      acc += 1
    }
  }

}
