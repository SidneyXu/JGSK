package com.bookislife.jgsk.groovy._11_if

/**
 * Created by SidneyXu on 2015/09/18.
 */
class App {

    static void main(String[] args) {
        //  If
        def x = 1
        def y = 2
        if (x + y == 3) {
            println "x+y=3"
        } else {
            println "x+y!=3"
        }

        if (x + y == 3)
            println "x+y=3"
        else
            println "x+y!=3"
    }
}
