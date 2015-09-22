package com.bookislife.jgsk.groovy._16_method

/**
 * Created by SidneyXu on 2015/09/22.
 */
class App {

    public static void main(String[] args) {
        //  Method
        //  Static Method
        say("Peter", "Goodbye")

        //  Default Values
        say("Peter")

        //  Return Values
        def calculator = new Calculator();
        println(calculator.add(2, 3))

        //  Closure
        def langs = ["Java", "Groovy", "Scala", "Kotlin"]
        langs.each {
            println it
        }
        langs.each { l ->
            println l
        }
        def map = [name: "Peter", age: 20]
        map.each { key, value ->
            println("$key=$value")
        }

        //  Function Literal
        def excite = { word ->
            "$word!!"
        }
        println(excite("Java"))
        println(excite.call("Groovy"))
    }

    def static say(name, word = "Hello") {
        println("$word $name")
    }

    def static max(int[] arr, Closure<Boolean> closure){

    }

}

class Calculator {

    def add(x, y) {
        x + y
    }
}