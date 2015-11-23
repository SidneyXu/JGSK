package com.bookislife.jgsk.groovy._32_shell

/**
 * Created by SidneyXu on 2015/11/23.
 */
class App {

    public static void main(String[] args) {
        def p = "ls -al ..".execute()
        def exitValue = p.waitFor()
        if (exitValue != 0) {
            println("exit with $exitValue")
            return
        }
        println "${p.text}"
    }
}
