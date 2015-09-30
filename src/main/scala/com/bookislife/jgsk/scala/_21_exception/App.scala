package com.bookislife.jgsk.scala._21_exception

/**
 * Created by SidneyXu on 2015/09/30.
 */
object App {

  def main(args: Array[String]) {
    try {
      throw new NullPointerException
    } catch {
      case e: NullPointerException => println("null object")
      case e: IndexOutOfBoundsException => print("index out of bound")
    } finally {
      println("finish")
    }
  }

  @throws[Exception](classOf[Exception])
   def preStart(): Unit = {
    println("preStart")
  }
}
