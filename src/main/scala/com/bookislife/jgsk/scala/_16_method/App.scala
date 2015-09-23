package com.bookislife.jgsk.scala._16_method

/**
 * Created by SidneyXu on 2015/09/22.
 */
object App {

  def main(args: Array[String]) {
    testMethod()
    testClosure()
  }

  def testMethod(): Unit = {
    //  Default Values
    say("Peter")

    //  Return Values
    val calculator = new Calculator
    println(calculator.add(2, 3))
  }

  def testClosure(): Unit = {
    val langs = List("Java", "Groovy", "Scala", "Kotlin")
    langs.foreach(s => println(s))
    langs.foreach(println)

  }

  def say(name: String, word: String = "Hello"): Unit = {
    println(s"$word $name")
  }
}

class Calculator {

  def add(x: Int, y: Int): Int = {
    x + y
  }
}