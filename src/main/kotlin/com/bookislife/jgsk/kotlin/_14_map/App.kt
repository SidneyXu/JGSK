package com.bookislife.jgsk.kotlin._14_map

/**
 * Created by SidneyXu on 2015/09/21.
 */
fun main(args: Array<String>) {
    //  Immutable Map
    //  Define
    val immutableMap = mapOf("name" to "Peter", "age" to 12, "national" to "USA")
    println(immutableMap.javaClass)

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

    //  Put
    mutableMap.put("name", "Jane")
    mutableMap["age"] = 20
    
    //    var height = immutableMap.getOrElse("Height", 170.toInt())
    //    println(height)
    //
    //    println(immutableMap)
}