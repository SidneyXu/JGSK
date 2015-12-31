package com.bookislife.jgsk.scala._32_shell

import java.io.File

import scala.io.StdIn
import scala.sys.process._

/**
  * Created by SidneyXu on 2015/11/23.
  */
object App {

  def main(args: Array[String]) {
    val exitValue = "ls -al .." !

    println(s"\nexit with $exitValue\n")

    val result = "ls -al .." !!

    println(result)

    "ls -al .." #| "grep JGSK" !

    "ls -al .." #> new File("shell.txt") !

    "ls -al .." #>> new File("shell.txt") !

    //  Console Input
    println(StdIn.readLine())
  }
}
