package com.bookislife.jgsk.scala.s03_ducktype

/**
  * Created by SidneyXu on 2015/12/15.
  */
object App {

    def main(args: Array[String]) {
        val peter = new Person("Peter")
        show(peter) //  name is Peter

        val dollar = new Currency("Dollar")
        show(dollar) //  name is Dollar

        val jane = new Person("Jane")
        show2(peter, jane) //  Peter and Jane are friends.
        //  Type mismatch
        //    show2(dollar, jane)

        show(new {
            val name = "foobar"
        })
    }

    def show(obj: {val name: String}): Unit = {
        println(s"name is ${obj.name}")
    }

    def show2(obj: {def makeFriend(p: Person)}, p: Person): Unit = {
        obj.makeFriend(p)
    }
}

class Person(val name: String) {
    def makeFriend(p: Person): Unit = {
        println(s"$name and ${p.name} are friends.")
    }
}

class Currency(val name: String)
