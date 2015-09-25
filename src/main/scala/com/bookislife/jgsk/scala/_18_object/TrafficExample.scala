package com.bookislife.jgsk.scala._18_object

/**
 * Created by mrseasons on 2015/2/13.
 */
object TrafficExample {

  def main(args: Array[String]) {
    //access enum element
    var red = TrafficColor.RED
    println(red)

    //obtain enum by index
    red = TrafficColor(0)
    println(red)

    //obtain enum by name
    red = TrafficColor.withName("stop")
    println(red)

    println(red.toString)
    println(red.id)
  }
}
