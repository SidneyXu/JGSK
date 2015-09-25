package com.bookislife.jgsk.scala._18_object

/**
 * Created by mrseasons on 2015/2/13.
 */
//app object
object Hello extends App {

  println("Hello World")

  if (args.length > 0) {
    println("args:" + args(0))
  } else {
    println("no args")
  }
}
