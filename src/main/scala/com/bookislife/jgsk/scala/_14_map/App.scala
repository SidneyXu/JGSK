package com.bookislife.jgsk.scala._14_map

import scala.collection.mutable

/**
 * Created by SidneyXu on 2015/09/21.
 */
object App {

  def main(args: Array[String]) {
    //  Immutable Map
    //  Define
    val immutableMap = Map("name" -> "Peter", "age" -> 12, "national" -> "USA")
    println(immutableMap.getClass)

    //  EmptyMap
    val empty = Map()
    println(empty == Nil)

    //  Get
    println(immutableMap.get("name"))
    println(immutableMap.getOrElse("height", 170))

    println(immutableMap)

    //  Mutable Map
    //  Define
    val mutableMap = mutable.HashMap("name" -> "Peter", "age" -> 12, "national" -> "USA")

    //  Put
    mutableMap.put("name", "Jane")
    mutableMap("age") = 20
    mutableMap("sex") = "Female"
    mutableMap + ("id" -> 10)

    //  Get
    println(mutableMap.get("name"))
    println(mutableMap.getOrElse("height", 170))

    println(mutableMap)
  }

}
