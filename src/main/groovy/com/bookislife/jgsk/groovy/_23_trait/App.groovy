package com.bookislife.jgsk.groovy._23_trait

/**
 * Created by SidneyXu on 2015/10/05.
 */
class App {
    public static void main(String[] args) {
        //  Simple Usages
        def handler = new DefaultMessageHandler()
        handler.show("foo")

        //  Implementing multiple traits at once
        def logger = new BasicLogger().withTraits(OutputLogger)
        logger.log("hello world")

        //  Diamond Problems
        def c1 = new C().withTraits(A, B)
        c1.echo()   //  B
        def c2 = new C().withTraits(B, A)
        c2.echo()   //  A

        //  Chain
        def loggerX = new BasicLogger().withTraits(OutputLogger, TimeStampLogger, ShortLogger)
        loggerX.log("hello world loggerX")  //  Mon Oct 05 12:01:49 CST 2015 hello world ...

        def loggerY = new BasicLogger().withTraits(OutputLogger, ShortLogger, TimeStampLogger)
        loggerY.log("hello world loggerY")  //  Mon Oct 05 1...

    }
}


trait A {
    void echo() {
        println("A")
    }
}

trait B {
    void echo() {
        println("B")
    }
}

class C {}















