package com.bookislife.jgsk.scala._14_map

import scala.collection.mutable

/**
  * Created by SidneyXu on 2015/09/21.
  */
object App {

    def main(args: Array[String]) {
        testMap()
        testTuple()
    }

    def testMap(): Unit = {
        //  Immutable Map
        //  Define
        val immutableMap = Map("name" -> "Peter", "age" -> 12, "national" -> "USA")
        println(immutableMap.getClass)

        //  EmptyMap
        val empty = Map()

        //  Get
        println(immutableMap.get("name").get)
        println(immutableMap.getOrElse("height", 170))

        println(immutableMap)

        //  Mutable Map
        //  Define
        val emptyMutableMap = mutable.HashMap()
        val mutableMap = mutable.HashMap("name" -> "Peter", "age" -> 12, "national" -> "USA")

        //  Put
        mutableMap.put("name", "Jane")
        mutableMap("age") = 20
        mutableMap("sex") = "Female"

        mutableMap += ("id" -> 10)

        //  Delete
        mutableMap.remove("age")

        //  Get
        println(mutableMap.get("name").get)
        println(mutableMap.getOrElse("height", 170))

        println(mutableMap)

        //  Length
        println(mutableMap.size)

        //  Traverse
        for ((k, v) <- mutableMap) {
            println(s"Traverse $k is $v")
        }
    }

    def testTuple(): Unit = {
        //  Define
        val t1 = ()
        val t2 = (1, 2, 3)
        val t3 = (1, "abc", List(10, 20, 30), Map("name" -> "Peter", "age" -> 12))

        //  Get
        println(t3._1)
        println(t3._2)
    }
}
