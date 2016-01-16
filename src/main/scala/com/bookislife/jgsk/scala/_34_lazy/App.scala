package com.bookislife.jgsk.scala._34_lazy

import scala.util.Random

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

        println()

        a.init(1000000)

        println(s"val=${a.valValue}") //  96
        println(s"var=${a.varValue}") //  9
        println(s"lazy val=${a.lazyValValue}") //  117261
        println(s"def=${a.defValue}") //  798062

        println(s"val=${a.valValue}") //  96
        println(s"var=${a.varValue}") //  9
        println(s"lazy val=${a.lazyValValue}") //  117261
        println(s"def=${a.defValue}") //  937263
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

    var max = 100

    def init(m: Int) = max = m

    val valValue = Random.nextInt(max)

    var varValue = Random.nextInt(max)

    lazy val lazyValValue = Random.nextInt(max)

    def defValue = Random.nextInt(max)
}