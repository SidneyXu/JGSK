package com.bookislife.jgsk.kotlin._14_map

/**
 * Created by SidneyXu on 2015/09/21.
 */
fun main(args: Array<String>) {
    testMap()
    testTuple()
}

fun testMap() {
    //  Immutable Map
    //  Define
    val immutableMap = mapOf("name" to "Peter", "age" to 12, "national" to "USA")
    println(immutableMap.javaClass) //  java.util.LinkedHashMap

    //  EmptyMap
    val empty = emptyMap<String, String>()

    //  Get
    println(immutableMap.get("name"))
    println(immutableMap["name"])
    println(immutableMap.getOrElse("height") { 170 })

    println(immutableMap)

    //  Mutable Map
    //  Define
    val mutableMap = hashMapOf("name" to "Peter", "age" to 12, "national" to "USA")
    println(mutableMap.javaClass)   //  java.util.HashMap

    //  Put
    mutableMap.put("name", "Jane")
    mutableMap["age"] = 20

    //  Delete
    mutableMap.remove("age")

    //  Get
    println(mutableMap.get("name"))
    println(mutableMap["name"])
    println(mutableMap.getOrElse("height") { 170 })

    println(mutableMap)

    //  Length
    println(mutableMap.size)

    //  Traverse
    for ((k, v) in mutableMap) {
        println("Traverse $k is $v")
    }

}

fun testTuple() {
    //  Pair
    val pair = Pair(1, "abc")
    println(pair.first)

    //  Triple
    val triple = Triple(1, "abc", 2)
    println(triple.second)
}