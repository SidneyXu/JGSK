package com.bookislife.jgsk.scala._07_string

/**
  * Created by SidneyXu on 2015/09/17.
  */
object App {

    def main(args: Array[String]) {
        //  Literals
        val s = "Hello World"

        //  Iterator
        for (c <- s) {
            println(c)
        }

        //  Multiple Lines
        val text =
            """    1, 2, 3
  one, two, three
  "x, "y", "z""""
        println(text)

        //  Template
        //  The s String Interpolator
        val name = "Peter"
        val str = s"name=$name, ${if (name.length() > 10) 10 else name.length}"
        println(str) //  name=Peter, 5

        //  The f String Interpolator
        val salary = 100.1
        println(f"$name%s has $salary%.5f") //  Peter has 100.10000

        //  Methods
        println(s.charAt(2)) //  l
        println(s.substring(6, 9)) //  Wor

        //  StringBuilder
        val content = new StringBuilder
        content append "hello"
        content += ','
        content ++= "\nworld"
        content ++= "!" ++= "!"
        println(content)
    }
}
