package com.bookislife.jgsk.scala._09_null

/**
  * Created by SidneyXu on 2015/09/17.
  */
object App {

    def main(args: Array[String]) {
        //  Null
        val x = null
        println(x == null)

        //  NullPointerException
        //  Option
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
