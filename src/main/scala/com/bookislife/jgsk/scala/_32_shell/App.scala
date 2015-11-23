package com.bookislife.jgsk.scala._32_shell

import java.io.File

import scala.sys.process._

/**
 * Created by SidneyXu on 2015/11/23.
 */
object App {

  def main(args: Array[String]) {
    "ls -al" !
    val result= "ls -al .." !!

    "ls -al .." #| "grep JGSK" !

    "ls -al .." #>> new File("shell.txt") !

    "ls -al .." #> new File("shell.txt") !
  }
}
