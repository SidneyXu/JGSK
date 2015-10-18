package com.bookislife.jgsk.kotlin._28_io

import java.io.File

/**
 * Created by SidneyXu on 2015/10/18.
 */

fun main(args: Array<String>) {
    val filepath = "files/test.txt"

    var source = File(filepath)
    if (!source.exists()) {
        source.createNewFile()
    } else {
        source.delete()
    }
    source.appendBytes("hello world".toByteArray())

    val fos = source.outputStream();
    fos.write("hello kotlin".toByteArray())
    fos.close()

    val lines = source.readLines("UTF-8")
    for (l in lines) {
        println(l)
    }

    val contents = source.readText("UTF-8")
    println(contents)
}