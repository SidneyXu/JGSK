package com.bookislife.jgsk.scala._12_loop

import scala.util.control.Breaks

/**
  * Created by SidneyXu on 2015/09/19.
  */
object App {

  def main(args: Array[String]) {
    testFor()
    testWhile()
    testPowerFor()
    testBreakAndContinue()
  }

  def testFor(): Unit = {
    val arr = Array(1, 2, 3)
    for (a <- arr) {
      println(s"Repeat For-Each $a")
    }

    for (i <- arr.indices) {
      println(s"Repeat For-Each ${arr(i)}")
    }
  }

  def testWhile(): Unit = {
    val arr = Array(1, 2, 3)
    var i = 0
    while (i < arr.length) {
      println(s"Repeat While ${arr(i)}")
      i += 1
    }
    i = 0
    do {
      i += 1
      println(s"Repeat While $i")
    } while (i < 5)
  }

  def testPowerFor(): Unit = {
    for (i <- 0 to 3) {
      println(s"Repeat For $i")
    }

    for (i <- 0 until 3) {
      println(s"Repeat For-Until $i")
    }

    for (i <- 0 to 5 by 2) {
      println(s"Repeat For $i")
    }

    for (i <- 0 to 3; j <- 2 to 4) {
      println(s"Repeat For $i, $j")
    }

    val list = List(1, 2, 3, 4, 5)

    for (i <- list if i != 2; if i > 1) {
      println(s"Repeat with Guard $i")
    }

    val ret = for {i <- list
                   if i != 3
    } yield i
    println(s"Repeat with Yield $ret")
  }

  def testBreakAndContinue(): Unit = {
    for (i <- 1 to 5) {
      Breaks.breakable {
        if (i == 3) Breaks.break()
        println("Continue " + i)
      }
    }

    Breaks.breakable {
      for (i <- 1 to 5) {
        if (i == 3) Breaks.break()
        println("Break " + i)
      }
    }
  }
}
