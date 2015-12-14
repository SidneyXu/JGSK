package com.bookislife.jgsk.groovy._16_method
/**
 * Created by SidneyXu on 2015/09/22.
 */
class App {

    public static void main(String[] args) {
        testMethod()
        testClosure()
    }

    static def testMethod() {
        //  Static Method
        say("Peter", "Goodbye")

        //  Varargs
        def calculator = new Calculator()
        calculator.sum(1, 2, 3)

        //  Default Values
        say("Peter")

        //  Return Values
        println(calculator.add(2, 3))
    }

    static def testClosure() {
        //  Define
        { -> println("foo") };

        { int x, int y ->
            println "$x plus $y is ${x + y}"
        }(1, 3)

        //  Ambiguous
        //        { println("foo") }

        //  Closure as an Object
        def excite = { word ->
            "$word!!"
        }

        //  Calling a closure
        println(excite("Java"))
        println(excite.call("Groovy"))

        //  Parameters
        def plus = { int x, int y = 1 ->
            println "$x plus $y is ${x + y}"
        }

        // Implicit Parameter
        def greeting = { "Hello, $it!" }
        println(greeting("Peter"))

        //  Varargs
        def contact = { String... args -> args.join(',') }
        println(contact("Java", "Groovy", "Scala", "Kotlin"))

        //  Closure as Parameter
        def maxValue = max([3, 10, 2, 1, 40]) {
            def list = it as List<Integer>
            list.max()
        }
        assert maxValue == 40
    }

    static def say(name, word = "Hello") {
        println("$word $name")
    }

    static def max(numbers, cls) {
        cls(numbers)
    }


}

class Calculator {

    def add(x, y) {
        x + y
    }

    def sum(int ... n) {
        println(n.sum())
    }
}