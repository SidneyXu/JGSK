package com.bookislife.jgsk.groovy._11_if

/**
 * Created by SidneyXu on 2015/09/18.
 */
class App {

    public static void main(String[] args) {
        //  If
        def i = 0
        if (i) {
            println true
        } else {
            println false
        }

        def list = []
        if (list) println true else println false
    }
}
