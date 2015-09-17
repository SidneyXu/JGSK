package com.bookislife.jgsk.scala._09_null

/**
 * Created by SidneyXu on 2015/09/17.
 */
object App {

  def main(args: Array[String]) {
    //  Null
    var result = 0
    val x = null
    println(x == null)
    //  Wrong!! value + is not a member of Null
    //    result = x + 3

    //  Safe Operator
    val persons: List[Option[Person]] = List(None, Option(new Person("Peter")))
    for (p <- persons) {
      if (p isDefined) {
        println(p.get.name)
      }
    }
  }

  class Person(val name: String) {

  }

}
