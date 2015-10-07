package com.bookislife.jgsk.scala._23_trait

/**
 * Created by SidneyXu on 2015/10/04.
 */
object App {

    def main(args: Array[String]) {
        //  Simple Usages
        val handler = new DefaultMessageHandler
        handler.show("foo")

        //  Implementing multiple traits at once
        val logger = new BasicLogger with OutputLogger
        logger.log("hello world")

        //  Diamond Problems
        //  Wrong!! Inherits conflicting members
        //        val c1 = new C with A with B

        //  Chain
        val loggerX = new BasicLogger with OutputLogger with TimeStampLogger with ShortLogger
        loggerX.log("hello world loggerX") //   Mon Feb 16 11:46:06 CST 2015 hello world ...
        val loggerY = new BasicLogger with OutputLogger with ShortLogger with TimeStampLogger
        loggerY.log("hello world loggerY") //   Mon Feb 16 1...
    }
}

class BasicLogger {
}

trait A {
    def echo(): Unit = {
        println("A")
    }
}

trait B {
    def echo(): Unit = {
        println("B")
    }
}

class C {
}
