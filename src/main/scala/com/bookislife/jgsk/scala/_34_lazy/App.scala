package com.bookislife.jgsk.scala._34_lazy

/**
 * Created by SidneyXu on 2015/12/07.
 */
object App {

  def main(args: Array[String]) {
    println(s"Before is ${System.currentTimeMillis()}")
    val a = new A()
    println(s"After is ${System.currentTimeMillis()}")
    println(s"Hello 1, ${a.fooField}")
    println(s"Hello 2, ${a.fooField}")

    println(s"Hello 1, ${a.lazyField}")
    println(s"Hello 2, ${a.lazyField}")
  }
}

class A {
  val fooField = {
    println("Compute...")
    Thread.sleep(3000)
    System.currentTimeMillis()
  }

  lazy val lazyField = {
    println("Compute...")
    Thread.sleep(3000)
    System.currentTimeMillis()
  }
}