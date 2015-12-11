package com.bookislife.jgsk.kotlin._24_enum

/**
 * Created by SidneyXu on 2015/10/02.
 */
fun main(args: Array<String>) {
    //  Define with a keyword
    val monday = WeekDay.valueOf("Monday")
    println(monday)
    println(monday.name)

    //  Method
    println(WeekDay.Tuesday.isWorkingDay())

    //  Query Ordinal
    println(monday.ordinal)

    //  Define with the Ordinal
    println(WeekDay.values()[0])

}

enum class WeekDay(val abbr: String) {
    Monday("Mon"), Tuesday("Tue"), Wednesday("Wed"), Thursday("Thu"),
    Friday("Fri"), Saturday("Sat"), Sunday("Sun");

    fun isWorkingDay(): Boolean {
        return !(this == Saturday || this == Sunday)
    }

}