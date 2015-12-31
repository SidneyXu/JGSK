package com.bookislife.jgsk.scala._20_switch_match

/**
  * Created by SidneyXu on 2015/12/31.
  */
object App {

  def main(args: Array[String]) {
    println(matchObject(0)) //  Object equals
    println(matchObject(10)) //  Expression
    println(matchObject(20)) //  Class instance holds 20
    println(matchObject(List(1, 2, 1000, 2000))) //  Match the last element of a list
    println(matchObject(Number(1))) //  Case class holds 1
    println(matchObject(List(3, 2, 1000, 2000))) //  Class structure contains method length

    matchTryCatch
  }

  def matchObject(foo: Any): String = {
    val result = foo match {
      case 0 => "Object equals"
      case i if i == 10 || i == 11 => "Expression"
      case i: Int => s"Class instance holds $i"
      case List(1, 2, _*) => "Match the last element of a list"
      case List(1, _, _) => " A list with three element and the first element is 1"
      case Number(n) => s"Case class holds $n"
      case t: {def length: Int} => "Class structure contains method length"
      case _ => "Default"
    }
    result
  }

  def matchTryCatch: Unit = {
    try {
      throw new NullPointerException
    } catch {
      case e: NullPointerException => println("NullPointerException")
      case e: IndexOutOfBoundsException => print("IndexOutOfBoundsException")
    } finally {
      println("finally")
    }
  }

}
