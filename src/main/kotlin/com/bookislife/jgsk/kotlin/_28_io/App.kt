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

    using {
        fos = source.outputStream().autoClose()
        fos.write("hello kotlin".toByteArray())
    }

    val lines = source.readLines("UTF-8")
    for (l in lines) {
        println(l)
    }

    val contents = source.readText("UTF-8")
    println(contents)

}

class ResourceHolder : AutoCloseable {
    val resources = arrayListOf<AutoCloseable>()

    fun <T : AutoCloseable> T.autoClose(): T {
        resources.add(this)
        return this
    }

    override fun close() {
        resources.reverse().forEach { it.close() }
    }
}

fun <R> using(block: ResourceHolder.() -> R): R {
    val holder = ResourceHolder()
    try {
        return holder.block()
    } finally {
        holder.close()
    }
}