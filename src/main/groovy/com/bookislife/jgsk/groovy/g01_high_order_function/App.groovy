package com.bookislife.jgsk.groovy.g01_high_order_function

/**
 * Created by SidneyXu on 2015/12/15.
 */
class App {

    public static void main(String[] args) {
        //  Function Literal Syntax
        //  Parameters Type Inference
        def sum = { x, y -> x + y }

        //  High Order Function
        //  Functions as Parameters
        add10({ i -> i + 2 })
        println(add10 { it + 2 })

        //  Curry
        println(show2("(")("foobar")(")"))

        //  Partial Application
        def show = { String prefix, String msg, String postfix ->
            prefix + msg + postfix
        }
        def applyPrefix = show.curry("(")
        println(applyPrefix("foo", ")"))    //  (foo)

        def applyPostfix = show.rcurry(")")
        println(applyPostfix("(", "bar"))   //  (bar)

        def applyIndex = show.ncurry(1, "foobar", ")")
        println(applyIndex("("))    //  (foobar)
    }

    static def add10(Closure closure) {
        closure(10)
    }

    //  Functions as Return Value
    static def scale(factor) {
        { x ->
            x * factor
        }
    }

    static def show2(String prefix) {
        return { String msg ->
            return { String postfix ->
                return prefix + msg + postfix
            }
        }
    }
}
