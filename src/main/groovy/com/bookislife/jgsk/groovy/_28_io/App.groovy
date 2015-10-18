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

        def fos = new FileOutputStream(file, true)
        fos.write("hello groovy".getBytes())
        fos.close()

        def fis = new FileInputStream(file)
        fis.eachLine { line ->
            println(line)
        }

        def content = file.text
        println(content)
        file.text = "$content\n end writer"
    }
}
