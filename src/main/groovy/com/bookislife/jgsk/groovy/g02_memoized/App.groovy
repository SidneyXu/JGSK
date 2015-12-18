package com.bookislife.jgsk.groovy.g02_memoized

import groovy.transform.Memoized

/**
 * Created by SidneyXu on 2015/12/18.
 */
class App {

    public static void main(String[] args) {
        def closure1 = { Integer x ->
            println "Closure argument $x"
            x
        }.memoize()
        println(closure1(3))
        println(closure1(3))
        println(closure1(4))
        println(closure1(4))

        long start = System.currentTimeMillis()
        fibonacci(5)
        println("fibonacci one cost ${System.currentTimeMillis() - start}")

        start = System.currentTimeMillis()
        fibonacci(5)
        println("fibonacci two cost ${System.currentTimeMillis() - start}")

        start = System.currentTimeMillis()
        memoFibonacci(5)
        println("memoFibonacci one cost ${System.currentTimeMillis() - start}")

        start = System.currentTimeMillis()
        memoFibonacci(5)
        println("memoFibonacci two cost ${System.currentTimeMillis() - start}")


        memoFibonacci(4)
        memoFibonacci(4)
        memoFibonacci(4)
        memoFibonacci(3)

    }

    static int fibonacci(int n) {
        println("fibonacci for $n")
        if (n == 0 || n == 1) return n
        return fibonacci(n - 1) + fibonacci(n - 2)
    }

    @Memoized
    static def memoFibonacci(int n) {
        println("fibonacci for $n")
        if (n == 0 || n == 1) return n
        return memoFibonacci(n - 1) + memoFibonacci(n - 2)
    }

    @Memoized(maxCacheSize = 3)
    static def memoFibonacci2(int n) {
        println("fibonacci for $n")
        if (n == 0 || n == 1) return n
        return memoFibonacci2(n - 1) + memoFibonacci2(n - 2)
    }
}
