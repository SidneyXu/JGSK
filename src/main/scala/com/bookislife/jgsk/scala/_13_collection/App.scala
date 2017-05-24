package com.bookislife.jgsk.scala._13_collection

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
  * Created by SidneyXu on 2015/09/20.
  */
object App {

    def main(args: Array[String]) {
        testArray()
        testList()
        testSet()
        testRange()
    }

    def testArray(): Unit = {
        //  Array
        //  Define
        val arr = new Array[Int](3)
        val arr2 = Array(1, 2, 3)

        //  Modify Elements
        arr(0) = 10

        //  Access Elements
        println(arr(0))

        //  Pretty Print
        println(arr2.mkString(","))

        //  ArrayBuffer
        val abuffer = ArrayBuffer[Int]()
        abuffer += 10
        abuffer ++= arr2
        abuffer -= 3
        println(abuffer)

        //  Array to ArrayBuffer
        val buffer = arr.toBuffer

        //  ArrayBuffer to Array
        val arr4 = abuffer.toArray

        //  Length
        println(arr2.length)

        //  Traverse
        for (a <- arr2) {
            println(s"Traverse $a")
        }
    }

    def testList(): Unit = {
        //  Immutable List
        //  Define
        val list = List("Groovy", "Java", "Scala")

        //  Empty List
        val empty = List()
        println(empty == Nil) //true

        //  List Constructors
        //  A :: B :: C is interpreted as A :: (B :: C)
        val newList = "Ruby" :: list
        println(list) //  List(Groovy, Java, Scala)
        println(newList) // List(Ruby, Groovy, Java, Scala)
        //error
        //    val newList2 = list :: "Ruby"

        val days = "Sunday" :: "Monday" :: "Tuesday" :: "Wednesday" :: "Thursday" :: "Friday" :: "Saturday" :: Nil
        val all = list ::: days
        println(all)

        //  Basic Operations
        println(list.head) // Groovy
        println(list.tail) // List(Java, Scala)
        println(list.tail.head) //  Java

        //  Access Elements
        println(list(2)) // Scala

        //  MutableList
        //  Works internally with LinkedList
        var mutableList = new mutable.MutableList[Int]
        mutableList += 1
        mutableList += (2, 3, 5)
        println(s"mutableList(1) is ${mutableList(1)}") //  2
        println(mutableList) //  (1, 2, 3, 5)

        //  ListBuffer
        //  Uses internally Nil and :: to build an immutable List
        var listBuffer = new ListBuffer[Int]
        listBuffer += 1
        listBuffer += (2, 3, 5)
        println(s"listBuffer(1) is ${listBuffer(1)}") //  2
        println(listBuffer) //  (1, 2, 3, 5)
        listBuffer -= 2
        println(listBuffer) //  (1, 3, 5)

        //  ListBuffer to List
        listBuffer.toList
        //  List to ListBuffer
        list.toBuffer


        //  Other Methods
        //zip
        var resultList = list.zip(listBuffer)
        println(resultList, resultList.getClass) //  (MutableList((2,2), (3,3), (5,5)),class scala.collection.mutable.MutableList)

        //flatten
        var list2 = List(List(1, 2), List(3, 4))
        var result = list2.flatten
        println(result, result.getClass) //  (List(1, 2, 3, 4),class scala.collection.immutable.$colon$colon)


        //  Length
        println(list.length)

        //  Traverse
        for (lang <- list) {
            println(s"Traverse $lang")
        }
    }

    def testSet(): Unit = {
        var set = mutable.HashSet(1, 2, 3)
        set += (3, 4, 5)
        println(set) //  Set(1, 5, 2, 3, 4)
    }

    def testRange(): Unit = {
        val rng1 = 1 to 3
        println(rng1) //  Range(1, 2, 3)

        val rng2 = 1 until 3
        println(rng2) //  Range(1, 2)

        val rng3 = 1 to 5 by 2
        println(rng3) //  Range(1, 3, 5)

        val rng4 = 'a' to 'c'
        println(rng4) //  NumericRange(a, b, c)

        val rng5 = Range(1, 3)
        println(rng5) //  Range(1, 2)

        val rng6 = Range(1, 5, 2)
        println(rng6) //  Range(1, 3)

    }

}


