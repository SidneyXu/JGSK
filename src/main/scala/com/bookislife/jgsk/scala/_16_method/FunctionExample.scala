package com.bookislife.jgsk.scala._16_method

/**
 * Created by mrseasons on 2015/05/09.
 */
object FunctionExample {

  def main(args: Array[String]) {
    val plus1: (Int => Int) = (x: Int) => x + 1
    println(plus1(3)) //4

    val plus2: Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(v1: Int): Int = v1 + 2
    }
    println(plus2(5)) //7

    val plus3: (Int) => Int = new ((Int) => Int) {
      override def apply(v1: Int): Int = v1 + 3
    }
    println(plus3(7)) //10


  }

}
