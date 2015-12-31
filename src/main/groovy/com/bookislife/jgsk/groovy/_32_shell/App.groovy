package com.bookislife.jgsk.groovy._32_shell

/**
 * Created by SidneyXu on 2015/11/23.
 */
class App {

    public static void main(String[] args) {
        def p = "ls -al .. ".execute()
        def exitValue = p.waitFor()
        if (exitValue != 0) {
            println("exit with $exitValue")
            return
        }
        println "${p.text}"

        def p1 = "ls -al ..".execute()
        def p2 = "grep JGSK".execute()
        def p3 = p1.pipeTo(p2)
        exitValue = p3.waitFor()
        if (exitValue != 0) {
            println("exit with $exitValue")
            return
        }
        println "${p3.text}"

        //  Console Input
        def scanner = new Scanner(System.in)
        println(scanner.nextLine())
    }
}
