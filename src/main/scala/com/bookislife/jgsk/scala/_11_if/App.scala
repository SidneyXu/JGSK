package com.bookislife.jgsk.scala._11_if

/**
 * Created by SidenyXu on 2015/09/18.
 */
object App {

  def main(args: Array[String]) {
    //  If
    val i = 0
    if (i != 0) {
      println(true)
    } else {
      println(false)
    }

    val list = List()
    if (list.nonEmpty) println(true) else println(false)
  }

}
