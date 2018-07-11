package com.bookislife.jgsk.groovy._07_string

/**
 * Created by SidneyXu on 2015/09/17.
 */
class App {

    static void main(String[] args) {
        //  Literals
        def s = "Hello World"

        //  Iterator
        for (c in s) {
            println(c)
        }

        //  Multiple Lines
        def text =
                """    1, 2, 3
    one, two, three
    "x, "y", "z\""""
        println(text)

        //  Template
        def name = "Peter"
        def str = "name=${name}, ${if (name.length() > 10) 10 else name.length()}"
        println(str)    //  name=Peter, 5

        //  Single Quote String
        def singleQuote = 'name=${name}, ${name.length()}'
        println(singleQuote)

        //  Methods
        println(s[2])   //  l
        println(s[6..9])    //  Worl
        println(s[6..<9])   //  Wor
        println(s - "l" - "World")  //  Helo

        //  StringBuilder
        def content = new StringBuilder()
        content.append "hello"
        content << ","
        content << "\nworld"
        content << "!" << "!"
    }
}
