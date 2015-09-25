package com.bookislife.jgsk.scala._18_object

/**
 * Created by mrseasons on 2015/2/13.
 */
object Singleton {
  private var num = 0

  def sequence() = {
    num += 1
    num
  }

  def main(args: Array[String]) {
    println(Singleton.sequence())
    println(Singleton.sequence())
    println(Singleton.sequence())
  }

}
