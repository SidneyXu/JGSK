package com.bookislife.jgsk.scala._21_exception

import java.io.FileNotFoundException

/**
 * Created by SidneyXu on 2015/09/30.
 */
object App {

  def main(args: Array[String]) {
    //  Try..Catch..Finally
    try {
      throw new FileNotFoundException("File not found.")
    } catch {
      case e: FileNotFoundException => println("Catch block")
    } finally {
      println("Finally block")
    }

    //  Exception in Callbacks
    val bean = new MyBean
    try {
      bean.test()

      bean.when(() => {
        throw new FileNotFoundException("File not found.")
      })
    } catch {
      case _: Exception => println("Some errors occur.")
    } finally {}


    //  Exception value
    val n = 4
    val half =
      if (n % 2 == 0)
        n / 2
      else
        throw new RuntimeException("n must be even")
    println(half) //  2

    //  Return value in finally
    val m = try {
      "99".toInt
    } catch {
      case e: Exception => -99
    }
    println(m)

    def f(): Int = try {
      return 1
    } finally {
      return 2
    }

    def g(): Int = try {
      1
    } finally {
      2
    }

    def q(): Int = try {
      return 1
    } finally {
    }

    println(f()) //  2
    println(g()) //  1
    println(q()) //  1


  }

  def uncheckedException(): Unit = {
    val i = 5 / 0
  }

  def checkedException(): Unit = {
    new MyBean().test()
    throw new FileNotFoundException("File not found.")
  }
}

class MyBean {

  @throws(classOf[MyException])
  def test(): Unit = {

  }

  def when(callback: () => Unit): Unit = {
    try {
      callback()
    } catch {
      case e: FileNotFoundException => println("Some errors occur in closure.")
      case e: MyException => println("Some errors occur in closure.")
    }
  }
}

class MyException extends Exception {

}