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

    // Margin Prefix
    val textWithMargin =
            """
            |Tell me and I forget.
    |Teach me and I remember.
|Involve me and I learn.
    |(Benjamin Franklin)
            """.trimMargin()
    println(textWithMargin)

    //  Template
    val name = "Peter";
    val str = "name=$name, ${if (name.length > 10) 10 else name.length}"
    println(str)    //  name=Peter, 5

    // Escaped String
    println("name=${'$'}{name}")

    //  Methods
    println(s[2])
    println(s.substring(5, 8))

    //  StringBuilder
    val content = buildString {
        append("hello")
        appendln(',')
        append("world")
        append("!", "!")
    }
    println(content)
}
