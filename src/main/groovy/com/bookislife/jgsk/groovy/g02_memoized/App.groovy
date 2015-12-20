package com.bookislife.jgsk.groovy.g02_memoized

import groovy.transform.Memoized

/**
 * Created by SidneyXu on 2015/12/18.
 */
class App {

    public static void main(String[] args) {
        //  Closure
        def closure1 = { Integer x ->
            println "Closure argument $x"
            x
        }.memoize()
        closure1(3)
        closure1(3)
        closure1(3)
        closure1(4)
        closure1(4)
        closure1(4)

        //  Method
        fibonacci(5)
        println("---end 5---")
        fibonacci(4)
        println("---end 4---")

        memoFibonacci(5)
        println("---end 5---")
        memoFibonacci(4)
        println("---end 4---")

        memoFibonacci2(5)
        println("---end 5---")
        memoFibonacci2(5)
        println("---end 4---")

    }

    static int fibonacci(int n) {
        println("fibonacci for $n")
        if (n == 0 || n == 1) return n
        return fibonacci(n - 1) + fibonacci(n - 2)
    }

    @Memoized
    static def memoFibonacci(int n) {
        println("memoFibonacci for $n")
        if (n == 0 || n == 1) return n
        return memoFibonacci(n - 1) + memoFibonacci(n - 2)
    }

    @Memoized(maxCacheSize = 3)
    static def memoFibonacci2(int n) {
        println("memoFibonacci for $n")
        if (n == 0 || n == 1) return n
        return memoFibonacci2(n - 1) + memoFibonacci2(n - 2)
    }
}
