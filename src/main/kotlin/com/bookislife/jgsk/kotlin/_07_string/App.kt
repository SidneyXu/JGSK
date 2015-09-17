package com.bookislife.jgsk.kotlin._07_string

/**
 * Created by SidneyXu on 2015/09/17.
 */

fun main(args: Array<String>) {
    //  Literals
    val s = "Hello World"

    //  Iterator
    for (c in s) {
        println(c)
    }

    //  Multiple Lines
    val text =
            """     1, 2, 3
    one, two, three
    "x, "y", "z""""
    println(text)

    //  Template
    val name = "Peter";
    val str = "name=${name}, ${if (name.length() > 10) 10 else name.length()}";
    println(str)    //  name=Peter, 5

    //  Methods
    println(s[2])
    println(s.substring(5, 8))
}
