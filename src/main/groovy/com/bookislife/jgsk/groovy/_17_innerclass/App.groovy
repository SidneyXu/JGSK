package com.bookislife.jgsk.groovy._17_innerclass

/**
 * Created by SidneyXu on 2015/09/28.
 */
class App {

    public static void main(String[] args) {
        //  Static Inner Class
        def staticInner = new Outter.StaticInner()

        //  Anonymous Inner Class
        def thread = new Thread(new Runnable() {
            @Override
            void run() {

            }
        })

        //  Non-Static Inner Class
        def outter1 = new Outter(name: "Outter1")
        //  Wrong!!
        //        def inner1 = new Outter.Inner(outter1, name: "a")
        def inner1 = new Outter.Inner(outter1, "Inner1")

        def outter2 = new Outter(name: "Outter2")
        def inner2 = new Outter.Inner(outter2, "Inner2")

        println("outter1 is ${outter1.getClass()}") //  _innerclass.Outter
        println("outter2 is ${outter2.getClass()}") //  _innerclass.Outter
        println("inner1 is ${inner1.getClass()}")   //  _innerclass.Outter$Inner
        println("inner2 is ${inner2.getClass()}")   //  _innerclass.Outter$Inner

        outter1.foo(inner1) //  Outter1-Inner1
        outter1.foo(inner2) //  Outter2-Inner2
    }
}

class Outter {

    def name

    static class StaticInner {

    }

    class Inner {

        def name

        Inner(def name) {
            this.name = name
        }

        def desc = "${Outter.this.name}-${name}"
    }

    def foo(Inner bar) {
        println(bar.desc)
    }
}
