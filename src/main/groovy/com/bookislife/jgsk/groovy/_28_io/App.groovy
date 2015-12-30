package com.bookislife.jgsk.groovy._28_io

/**
 * Created by SidneyXu on 2015/10/18.
 */
class App {

    public static void main(String[] args) {
        def filepath = "files/test.txt"

        def file = new File(filepath)
        if (!file.exists()) {
            file.createNewFile()
        } else {
            file.delete()
        }
        //  FileWriter
        file.append("hello world\n")

        def content = file.text
        println(content)
        file.text = "$content\nend writer"

        new FileOutputStream(file, true).withStream {
            it.write("hello groovy".getBytes())
        }

        new FileInputStream(file).withStream {
            it.eachLine { line ->
                println(line)
            }
        }

    }
}
