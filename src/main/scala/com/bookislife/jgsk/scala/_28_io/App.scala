package com.bookislife.jgsk.scala._28_io

import java.io.{File, FileWriter}

import scala.io.Source

/**
 * Created by SidneyXu on 2015/10/18.
 */
object App {

    def main(args: Array[String]) {
        val filepath = "files/test.txt"

        val file = new File(filepath)
        if (!file.exists()) {
            file.createNewFile()
        } else {
            file.delete()
        }

        val writer = new FileWriter(file)
        writer.write("hello world")
        writer.close()

        var source = Source.fromFile(file)
        val lineIterator = source.getLines()
        for (l <- lineIterator) {
            println(l)
        }
        source.close()

        source = Source.fromFile(file, "UTF-8")
        val contents = source.mkString
        println(contents)
        source.close()
    }

}
