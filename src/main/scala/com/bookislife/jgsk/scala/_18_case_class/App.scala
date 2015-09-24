package com.bookislife.jgsk.scala._18_case_class

/**
 * Created by SidneyXu on 2015/09/24.
 */
object App {

  def main(args: Array[String]) {
    //  Using constructor implicitly
    val n = Number(1)

    //  toString
    println(n.toString) //  Number(1)

    //  equals
    val result1 = Sum(Number(10), Number(20))
    result1.comment = "result1"
    val result2 = Sum(Number(10), Number(20))
    result2.comment = "result2"
    println(result1 == result2) //  true
  }
}
