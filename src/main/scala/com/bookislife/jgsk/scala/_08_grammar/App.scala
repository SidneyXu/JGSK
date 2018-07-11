package com.bookislife.jgsk.scala._08_grammar

import java.util.Date

/**
  * Created by SidneyXu on 2015/09/17.
  */
object App {

    def main(args: Array[String]) {
        //  Operators
        var i: Int = 1
        //  Wrong!! ++/-- not supported
        //    i ++
        i += 3
        i + 3
        i.+(3)

        //  Call Methods
        add(1, 2)

        //  Equals
        val x: Date = new Date(100)
        val y: Date = new Date(100)

        println(null == 10) //  false
        println("x==y: " + (x == y)) //  true
        println("x.equals(y): " + x.equals(y)) //  true
        println("x.eq(y): " + x.eq(y)) //  false
    }

    def add(x: Int, y: Int): Int = {
        x + y
    }
}
