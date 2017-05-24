package com.bookislife.jgsk.groovy._12_loop

/**
 * Created by SidneyXu on 2015/09/19.
 */
class App {

    static void main(String[] args) {
        testFor()
        testWhile()
        testRange()
        testBreakAndContinue()
    }

    private static void testFor() {
        for (def i = 0; i < 3; i++) {
            println "Repeat For ${i}"
        }

        def arr = [1, 2, 3]
        for (def a : arr) {
            println("Repeat For-Each ${a}")
        }
    }

    private static void testWhile() {
        def arr = [1, 2, 3]
        def i = 0
        while (i < arr.size()) {
            println("Repeat While ${arr[i++]}")
        }
    }

    private static void testRange() {
        for (a in 0..3) {
            println "Repeat Range ${a}"
        }
        println("=====================")

        for (a in 3..0) {
            println "Repeat Reverse-Range ${a}"
        }
        println("=====================")

        for (a in 0..<3) {
            println "Repeat Range ${a}"
        }
        println("=====================")
    }

    private static void testBreakAndContinue() {
        for (i in 1..5) {
            if (i == 3) continue
            println("Continue $i")
        }
        for (i in 1..5) {
            if (i == 3) break
            println("Break $i")
        }
    }
}
