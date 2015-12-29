package com.bookislife.jgsk.kotlin._25_regex

/**
 * Created by SidneyXu on 2015/10/10.
 */
fun main(args: Array<String>) {
    val input = "99 bottles, 98 bottles"

    //  Regex
    val pattern = """[0-9]+\W""".toRegex()

    //  Matching
    if ("Hello".matches("[A-Z][a-z]+".toRegex())) {
        println("ok")
    }

    //  Searching
    for (matchResult in pattern.findAll(input)) {
        println("find all ${matchResult.value}")    //  99  98
    }

    //  group
    """(\d{4})-(\d{2})""".toRegex().findAll("2015-10").forEach {
        println(it.groups.size)
        for (rs in it.groups) {
            println(rs?.value)  //  [2015-10, 2015, 10]
        }
    }

    //  Replacing
    val result = pattern.replaceFirst(input, "xxx")
    println(result)
}