package com.bookislife.jgsk.kotlin._25_regex

/**
 * Created by SidneyXu on 2015/10/10.
 */
fun main(args: Array<String>) {
    val input = "99 bottles, 98 bottles"

    //  Pattern
    val pattern = """[0-9]+\W""".toRegex()

    //  Matching
    if ("Hello".matches("[A-Z][a-z]+".toRegex())) {
        println("ok")
    }

    //  Searching
    for ( matchString in pattern.matchAll(input)) {
        println("find all $matchString")
    }

    //  group

    //  Replacing
    val result = pattern.replaceFirst(input, "xxx")
    println(result)
}