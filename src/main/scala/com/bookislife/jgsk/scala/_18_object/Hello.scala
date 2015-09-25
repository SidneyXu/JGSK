package com.bookislife.jgsk.scala._18_object

/**
 * Created by SidneyXu on 2015/09/25.
 */
object Hello extends App {

  println("Hello World")

  if (args.length > 0) {
    println("The passed arguments are " + args)
  } else {
    println("There is no argument passed.")
  }
}
