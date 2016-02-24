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

    var fos = source.outputStream();
    fos.write("hello kotlin".toByteArray())
    fos.close()

    source.outputStream().use {
        it.write("hello kotlin".toByteArray())
    }

    val lines = source.readLines(Charsets.UTF_8)
    for (l in lines) {
        println(l)
    }

    val contents = source.readText(Charsets.UTF_8)
    println(contents)

    var target = File(filepath + ".copy")
    source.copyRecursively(target) { file, e ->
        OnErrorAction.SKIP
    }
    println(target.absoluteFile.extension)
    println(target.absoluteFile.nameWithoutExtension)

    source.bufferedReader().use {
        it.lineSequence()
                .filter(String::isNotBlank)
                .forEach { println(it) }
    }
    source.bufferedReader().useLines {
        it.filter(String::isNotBlank).toList()
    }

}
