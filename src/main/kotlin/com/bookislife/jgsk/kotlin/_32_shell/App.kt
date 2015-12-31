package com.bookislife.jgsk.kotlin._32_shell

/**
 * Created by SidneyXu on 2015/11/23.
 */
fun main(args: Array<String>) {
    val runtime: Runtime = Runtime.getRuntime()
    val process: Process = runtime.exec("ls -al ..")
    val exitValue = process.waitFor()
    if (exitValue != 0) {
        println("exit with $exitValue")
        return
    }

    process.inputStream.bufferedReader().lines().forEach {
        println(it)
    }

    //  Console Input
    println(readLine())
}