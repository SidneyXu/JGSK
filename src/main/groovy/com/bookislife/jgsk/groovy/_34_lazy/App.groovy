package com.bookislife.jgsk.groovy._34_lazy

/**
 * Created by SidneyXu on 2015/12/07.
 */
class App {

    public static void main(String[] args) {
        println("Before is ${System.currentTimeMillis()}")
        def a = new A()
        println("After is ${System.currentTimeMillis()}")
        println("Hello 1, ${a.fooField}")
        println("Hello 2, ${a.fooField}")

        println("Hello 1, ${a.lazyField}")
        println("Hello 2, ${a.lazyField}")
    }
}

class A {
    def fooField = {
        println("Compute...")
        Thread.sleep(3000)
        System.currentTimeMillis()
    }()

    @Lazy
    def lazyField = {
        println("Compute...")
        Thread.sleep(3000)
        System.currentTimeMillis()
    }()
}