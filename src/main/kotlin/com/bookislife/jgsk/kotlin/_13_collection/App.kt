package com.bookislife.jgsk.kotlin._13_collection

/**
 * Created by SidneyXu on 2015/09/20.
 */
fun main(args: Array<String>) {
    testArray()
    testList()
    testRange()
}

fun testArray() {
    //  Define
    val arr = arrayOfNulls<Int>(3)
    val arr2 = arrayOf(1, 2, 3)
    val empty = arrayOf<Int>()

    //  Length
    println(arr.size)

    //  Modify Elements
    arr[0] = 10

    //  Access Elements
    println(arr[0])

    //  Traverse
    for (a in arr2) {
        println("Traverse $a")
    }
}

fun testList() {
    //  Immutable List
    //  Define
    val list = listOf("Groovy", "Java", "Scala")

    //  Empty List
    val empty = emptyList<Int>()

    //  Access Elements
    println(list[0])

    //  MutableList
    val mList = mutableListOf("Groovy", "Java", "Scala")
    mList.add("Ruby")
    mList.remove("Java")
    println(mList)  //  [a, b, c, d]

    //  Traversing a List
    val names = listOf("Mike", "Peter", "Jane", "Mary")
    names.filter {
        it.startsWith("M")
    }.sortedBy {
        it
    }.map {
        it.toUpperCase()
    }.forEach { print("${it},") }
    println()   //  MARY,MIKE,

    //  Length
    println(list.size)

    //  Traverse
    for (lang in list) {
        println("Traverse $lang")
    }
}

fun testRange() {
    val rng1 = 1..3
    println(rng1)   //  1..3

    val rng2 = 1.rangeTo(3)
    println(rng2)   //  1..3

    val rng3 = (1..5).step(2)
    println(rng3)   //  1..5 step 2

    val rng4 = 'a'..'c'
    println(rng4)   //  a..c

}